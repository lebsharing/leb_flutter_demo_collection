import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

///实现类似PopupWindow的弹窗效果
class PopupDialogPage extends StatefulWidget {
  const PopupDialogPage({Key? key}) : super(key: key);

  @override
  _PopupDialogPageState createState() {
    return _PopupDialogPageState();
  }
}

class _PopupDialogPageState extends State<PopupDialogPage> {
  final GlobalKey nameKey = GlobalKey();
  final TextEditingController _controller = TextEditingController();
  final FocusNode _focusNode = FocusNode();
  OverlayEntry? _overlayEntry;
  final LayerLink _layerLink = LayerLink();
  // FollowerLayer followerLayer = FollowerLayer(link: _layerLink);

  @override
  void initState() {
    super.initState();
    _focusNode.addListener(() {
      if (_focusNode.hasFocus) {
        showOverlay(context);
      } else {
        dismissOverlay();
      }
    });
  }

  @override
  void dispose() {
    // _focusNode.removeListener(() { })
    super.dispose();
    _controller.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Overlay"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              height: 60,
              color: Colors.orange,
            ),
            Container(
              height: 40,
              color: Colors.yellow,
              child: const Text("在输入框下显示可以输入的用户名"),
            ),
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 30),
              child: CompositedTransformTarget(
                // link: LayerLink(),
                link: _layerLink,
                child: TextField(
                  key: nameKey,
                  focusNode: _focusNode,
                  controller: _controller,
                  decoration: InputDecoration(
                    label: const Text("输入用户名"),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                  ),
                ),
              ),
            ),
            Container(
              height: 100,
              color: Colors.green,
            ),
          ],
        ),
      ),
    );
  }

  void showOverlay(BuildContext context) {
    final overlay = Overlay.of(context);
    _overlayEntry = OverlayEntry(builder: (ctx) {
      final renderBox =
          nameKey?.currentContext?.findRenderObject() as RenderBox;
      final size = renderBox.size;
      final offset = renderBox.localToGlobal(Offset.zero);

      ///如果使用了CompositedTransformFollower,就不在在对Positioned 设置left,top
      return Positioned(
        // left: offset.dx,
        // top: offset.dy + size.height,
        width: size.width,
        child: CompositedTransformFollower(
          link: _layerLink,
          showWhenUnlinked: false,
          offset: Offset(0, size.height + 8),
          child: Material(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                ListTile(
                  title: Text("ZhangSan"),
                  subtitle: Text("CFO"),
                  onTap: () {
                    _controller.text = "ZhangSan";
                    dismissOverlay();
                    _focusNode.unfocus();
                  },
                ),
                ListTile(
                  title: Text("HuShuo"),
                  subtitle: Text("CEO"),
                  onTap: () {
                    _controller.text = "HuShuo";
                    dismissOverlay();
                    _focusNode.unfocus();
                  },
                ),
                ListTile(
                  title: Text("LiMing"),
                  subtitle: Text("Common"),
                  onTap: () {
                    _controller.text = "LiMing";
                    dismissOverlay();
                    _focusNode.unfocus();
                  },
                ),
              ],
            ),
          ),
        ),
      );
    });
    overlay?.insert(_overlayEntry!);
  }

  void dismissOverlay() {
    if (_overlayEntry != null) {
      _overlayEntry?.remove();
      _overlayEntry = null;
    }
  }
}
