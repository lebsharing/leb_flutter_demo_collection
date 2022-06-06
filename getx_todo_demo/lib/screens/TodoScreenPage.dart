import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:getx_todo_demo/controller/TodoController.dart';
import 'package:getx_todo_demo/models/todo.dart';

class TodoScreenPage extends StatelessWidget {
  final TodoController todoController = Get.find();
  final int? index;
  TodoScreenPage({Key? key, this.index}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    String text = "";
    if (index != null) {
      text = todoController.todos[index!].text;
    }
    TextEditingController textEditingController =
        TextEditingController(text: text);
    return Scaffold(
      body: Container(
        padding: EdgeInsets.all(20),
        child: Column(
          children: [
            Expanded(
              child: TextField(
                controller: textEditingController,
                autofocus: true,
                decoration: const InputDecoration(
                    hintText: "What do you want to accomplish?",
                    border: InputBorder.none,
                    focusedBorder: InputBorder.none),
                style: TextStyle(fontSize: 30),
                keyboardType: TextInputType.multiline,
                maxLines: 999,
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                TextButton(
                  onPressed: () {
                    Get.back();
                  },
                  child: const Text(
                    "Cancel",
                    style: TextStyle(color: Colors.red),
                  ),
                ),
                TextButton(
                  onPressed: () {
                    if (index == null) {
                      todoController.todos
                          .add(Todo(text: textEditingController.text));
                    } else {
                      var editing = todoController.todos[index!];
                      editing.text = textEditingController.text;
                      todoController.todos[index!] = editing;
                    }
                    Get.back();
                  },
                  child: Text(index != null ? "Edit" : "Add"),
                )
              ],
            )
          ],
        ),
      ),
    );
  }
}
