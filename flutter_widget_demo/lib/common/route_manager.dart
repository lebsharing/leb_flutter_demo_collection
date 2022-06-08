import 'package:flutter/material.dart';
import 'package:flutter_widget_demo/home/home_page.dart';
import 'package:flutter_widget_demo/widgets/advance/custom_widget/CustomPaintPage.dart';
import 'package:flutter_widget_demo/widgets/composited/composite_transform_page.dart';
import 'package:flutter_widget_demo/widgets/other/constraints_test_page.dart';
import 'package:flutter_widget_demo/widgets/overlay/popup_dialog_page.dart';
import 'package:flutter_widget_demo/widgets/overlay/simple_overlay_page.dart';

class RouteManager {
  static const String home = "/";
  static const String simpleOverlay = "/simpleOverlay";
  static const String popupOverlay = "/popupOverlay";
  static const String compositePage = "/compositePage";
  static const String constraintsTestPage = "/constraintsTestPage";
  static const String customPaintPage = "/customPaintPage";

  static Map<String, WidgetBuilder> routes = {
    home: (context) => const HomePage(),
    simpleOverlay: (context) => const SimpleOverlayPage(),
    popupOverlay: (context) => const PopupDialogPage(),
    compositePage: (context) => const CompositeTransformPage(),
    constraintsTestPage: (context) => const ConstraintsTestPage(),
    customPaintPage: (context) => const PaintChessPage()
  };
}
