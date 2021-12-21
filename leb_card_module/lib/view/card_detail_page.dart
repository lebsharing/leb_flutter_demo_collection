import 'package:flutter/material.dart';

@immutable
class CardDetailPage extends StatefulWidget {
  final String? fromValue;

  const CardDetailPage({Key? key, this.fromValue}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _CardDetailPageState();
  }
}

class _CardDetailPageState extends State<CardDetailPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Card Detail"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Padding(
              padding: EdgeInsets.only(top: 20),
              child: Text("this card detail page"),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 10),
              child: Text("from:${widget.fromValue ?? ''}",
              style: const TextStyle(
                fontSize: 18,
                color: Colors.black
              ),),
            )
          ],
        ),
      ),
    );
  }
}
