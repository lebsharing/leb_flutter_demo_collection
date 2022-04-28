import 'package:flutter/material.dart';
import 'package:flutter_widget_demo/home/home_page.dart';
import 'package:flutter_widget_demo/widgets/overlay/popup_dialog_page.dart';
import 'package:flutter_widget_demo/widgets/overlay/simple_overlay_page.dart';

class RouteManager {
  static const String home = "/";
  static const String simpleOverlay = "/simpleOverlay";
  static const String popupOverlay = "/popupOverlay";

  static Map<String, WidgetBuilder> routes = {
    home: (context) => const HomePage(),
    simpleOverlay: (context) => const SimpleOverlayPage(),
    popupOverlay: (context) => const PopupDialogPage()
  };
}
