import 'package:flutter/material.dart';
import 'package:flutter_widget_demo/common/route_manager.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<WidgetInfo> widgetList = List.empty(growable: true);

  @override
  void initState() {
    super.initState();
    initList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Flutter Widget used demo"),
      ),
      body: ListView.builder(
        itemBuilder: (ctx, index) {
          WidgetInfo _info = widgetList[index];
          return ListTile(
            title: Text(_info.name),
            subtitle: Text(_info.desc),
            onTap: () {
              if (_info.routeName.isEmpty) {
                return;
              }
              Navigator.pushNamed(ctx, _info.routeName);
            },
          );
        },
        itemCount: widgetList.length,
      ),
    );
  }

  initList() {
    widgetList.add(
        WidgetInfo("Overlay+OverlayEntry", "", RouteManager.simpleOverlay));
    widgetList.add(WidgetInfo("Overlay popup",
        "CompositedTransformTarget + OverlayEntry", RouteManager.popupOverlay));
  }
}

class WidgetInfo {
  final String name;
  final String desc;
  final String routeName;

  WidgetInfo(this.name, this.desc, this.routeName);

  Map<String, dynamic> toJson() {
    Map<String, dynamic> data = {
      "name": name,
      "desc": desc,
      "routeName": routeName,
    };
    return data;
  }
}
