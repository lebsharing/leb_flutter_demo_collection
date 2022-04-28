import 'package:flutter/material.dart';

///Overlay 简单使用示例
class SimpleOverlayPage extends StatefulWidget {
  const SimpleOverlayPage({Key? key}) : super(key: key);

  @override
  _SimpleOverlayPageState createState() => _SimpleOverlayPageState();
}

class _SimpleOverlayPageState extends State<SimpleOverlayPage> {
  final GlobalKey _noticeKey = GlobalKey();
  OverlayEntry? _overlayEntry;
  Overlay? lay;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Overlay+OverlayEntry"),
        actions: [
          Padding(
            key: _noticeKey,
            padding: const EdgeInsets.all(16),
            child: const Icon(Icons.notifications),
          )
        ],
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Text("该示例在AppBar右上角的图标出显示一个提示信息"),
            TextButton(
              onPressed: () {
                showOverlay(context);
              },
              child: const Text(
                "show icon",
                style: TextStyle(
                  fontSize: 30,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void showOverlay(BuildContext context) async {
    if (_overlayEntry != null) {
      _overlayEntry?.remove();
      _overlayEntry = null;
      return;
    }
    //1、获取OverlayState
    OverlayState? overlayState = Overlay.of(context);
    //2、创建OverlayEntry
    _overlayEntry = OverlayEntry(
      builder: (ctx) {
        //获取_noticeKey Widget的位置，用于设置OverlayEntry将悬浮的位置
        RenderBox? renderBox =
            _noticeKey.currentContext?.findRenderObject() as RenderBox?;
        Size size = renderBox?.size ?? Size.zero;
        Offset offset = renderBox?.localToGlobal(Offset.zero) ?? Offset.zero;
        final double _top = offset.dy + size.height;
        double radius = 20.0;
        double right = offset.dx + size.width / 2 - radius;
        return Positioned(
          top: _top,
          left: right,
          child: CircleAvatar(
            radius: radius,
            backgroundColor: Colors.orange,
            child: const Text("20"),
          ),
        );
      },
      opaque: false,
    );

    //3、将OverlayEntry插入到Overlay中。
    overlayState?.insert(_overlayEntry!);

    ///显示2秒后消失
    // await Future.delayed(const Duration(seconds: 2));
    // _overlayEntry?.remove();
  }
}
