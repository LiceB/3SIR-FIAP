import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:listview_demo/contatos.dart';

class ListaContatos extends StatefulWidget {
  const ListaContatos({Key? key}) : super(key: key);

  @override
  State<ListaContatos> createState() => _ListaContatosState();
}

class _ListaContatosState extends State<ListaContatos> {
  final List<Contato> contato = [
    Contato('Bruno', 'bruno@gmail.com'),
    Contato('Renan', 'renan@gmail.com'),
    Contato('Ester', 'ester@gmail.com'),
    Contato('Guilherme', 'gui@gmail.com'),
    Contato('Alice', 'alice@gmail.com'),
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Contatos'),
      ),
      body: ListView.builder(
          itemCount: contato.length,
          itemBuilder: (context, index) {
            return ListTile(
              leading: CircleAvatar(
                child: Text(contato[index].nome[0]),
              ),
              title: Text(contato[index].nome),
              subtitle: Text(contato[index].email),
            );
          }),
    );
  }
}
