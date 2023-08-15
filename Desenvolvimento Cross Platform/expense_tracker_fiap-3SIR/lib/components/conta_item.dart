import 'package:expense_tracker/models/banco.dart';
import 'package:expense_tracker/models/conta.dart';
import 'package:expense_tracker/pages/home_page.dart';
import 'package:flutter/material.dart';

class ContaItem extends StatelessWidget {
  final Conta conta;
  const ContaItem({super.key, required this.conta});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => HomePage(),
          ),
        );
      },
      leading: CircleAvatar(
        backgroundImage: AssetImage('images/${bancosMap[conta.bancoId]?.logo}'),
      ),
      title: Text(
        conta.descricao,
      ),
      subtitle: Text('${bancosMap[conta.bancoId]?.nome}'),
      trailing: Text(
        tipoConta(conta),
        style: TextStyle(
          fontSize: 14,
        ),
      ),
    );
  }
}

String tipoConta(Conta conta) {
  if (conta.tipoConta == TipoConta.contaCorrente) {
    return 'Conta corrente';
  } else if (conta.tipoConta == TipoConta.contaPoupanca) {
    return 'Conta poupança';
  } else {
    return 'Conta investimento';
  }
}
