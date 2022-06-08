import 'package:flutter/material.dart';

class ConstraintsTestPage extends StatefulWidget {
  const ConstraintsTestPage({Key? key}) : super(key: key);

  @override
  _ConstraintsTestPageState createState() => _ConstraintsTestPageState();
}

class _ConstraintsTestPageState extends State<ConstraintsTestPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Constraints"),
      ),
      body: Center(
        child: Container(
          color: Colors.red,
        ),
      ),
    );
  }
}
