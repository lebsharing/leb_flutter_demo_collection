import 'package:flutter/material.dart';

class CompositeTransformPage extends StatelessWidget {
  const CompositeTransformPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    _CompositedOverlyEx two = _CompositedOverlyEx();
    return Scaffold(
      appBar: AppBar(
        title: const Text("CompositedTransformTarget"),
        leading: BackButton(
          onPressed: () {
            two.dismiss();
            Navigator.pop(context);
          },
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            ///用例1
            _CompositeExOne(),

            ///
            two,
          ],
        ),
      ),
    );
  }
}

class _CompositeExOne extends StatelessWidget {
  final LayerLink _layerLink = LayerLink();

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        CompositedTransformTarget(
          link: _layerLink,
          child: Container(
            height: 100,
            color: Colors.green,
            child: const Text("Flutter logo 将会根据该空间位置的变化而变化"),
          ),
        ),
        CompositedTransformFollower(
          link: _layerLink,
          offset: const Offset(20, 20),
          child: Container(
            color: Colors.orange,
            child: const FlutterLogo(),
          ),
        )
      ],
    );
  }
}

class _CompositedOverlyEx extends StatelessWidget {
  final LayerLink _layerLink = LayerLink();
  OverlayEntry? _overlayEntry;

  @override
  Widget build(BuildContext context) {
    return Container(
      child: CompositedTransformTarget(
        link: _layerLink,
        child: GestureDetector(
          onTap: () {
            showOverlay(context);
          },
          child: const FlutterLogo(
            size: 100,
          ),
        ),
      ),
    );
  }

  void showOverlay(BuildContext context) {
    if (_overlayEntry != null) {
      _overlayEntry?.remove();
      _overlayEntry = null;
      return;
    }
    OverlayState? overlayState = Overlay.of(context);
    _overlayEntry = OverlayEntry(builder: (ctx) {
      return CompositedTransformFollower(
        link: _layerLink,
        targetAnchor: Alignment.centerRight,
        // followerAnchor: Alignment.bottomLeft,
        child: GestureDetector(
            onTap: () {
              if (_overlayEntry != null) {
                _overlayEntry?.remove();
                _overlayEntry = null;
                return;
              }
            },
            child: const Text(
              "Hello Flutter Logo.",
              style: TextStyle(fontSize: 16),
            )),
      );
    });
    _overlayEntry?.addListener(() {
      print("-----${_overlayEntry}");
      // dismiss();
    });
    overlayState?.insert(_overlayEntry!);
  }

  dismiss() {
    if (_overlayEntry != null) {
      _overlayEntry?.remove();
      _overlayEntry = null;
      return;
    }
  }
}
