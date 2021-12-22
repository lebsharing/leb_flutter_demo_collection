import 'package:flutter/material.dart';

class CardTemplateOneWidget extends StatelessWidget {

  const CardTemplateOneWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Container(
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
            color: Colors.orange[200], borderRadius: BorderRadius.circular(16)),
        child: Column(
          children: const [
            Text.rich(
              TextSpan(
                text: "姓名：",
                children: [
                  TextSpan(
                    text: "张San",
                    style: TextStyle(
                      color: Colors.black,
                      fontSize: 22,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
            Text.rich(
              TextSpan(
                text: "性别：",
                children: [
                  TextSpan(
                    text: "男",
                    style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
            Text.rich(
              TextSpan(
                text: "地址：",
                children: [
                  TextSpan(
                    text: "北京市",
                    style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
