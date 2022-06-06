import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:getx_todo_demo/controller/TodoController.dart';
import 'package:getx_todo_demo/screens/TodoScreenPage.dart';

class HomeScreenPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final TodoController todoController = Get.put(TodoController());
    return Scaffold(
      appBar: AppBar(
        title: const Text("GetX Todo List"),
      ),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          Get.to(TodoScreenPage());
        },
      ),
      body: Container(
        child: Obx(
          () => ListView.separated(
            itemBuilder: (ctx, index) => Dismissible(
              key: UniqueKey(),
              onDismissed: (direction) {
                var removed = todoController.todos[index];
                todoController.todos.removeAt(index);
              },
              child: ListTile(
                title: Text(
                  todoController.todos[index].text,
                  style: todoController.todos[index].done
                      ? const TextStyle(
                          color: Colors.red,
                          decoration: TextDecoration.lineThrough)
                      : TextStyle(
                          color: Theme.of(ctx).textTheme.bodyText1?.color),
                ),
                onTap: () {
                  Get.to(TodoScreenPage(
                    index: index,
                  ));
                },
                leading: Checkbox(
                  value: todoController.todos[index].done,
                  onChanged: (v) {
                    var changed = todoController.todos[index];
                    changed.done = v ?? false;
                    todoController.todos[index] = changed;
                  },
                ),
              ),
            ),
            separatorBuilder: (ctx, index) => const Divider(
              color: Colors.green,
            ),
            itemCount: todoController.todos.length,
          ),
        ),
      ),
    );
  }
}
