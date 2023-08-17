import 'package:expense_tracker/components/conta_item.dart';
import 'package:expense_tracker/models/tipo_transacao.dart';
import 'package:expense_tracker/models/transacao.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class TransacaoDetalhePage extends StatefulWidget {
  const TransacaoDetalhePage({super.key});

  @override
  State<TransacaoDetalhePage> createState() => _TransacaoDetalhePageState();
}

class _TransacaoDetalhePageState extends State<TransacaoDetalhePage> {
  @override
  Widget build(BuildContext context) {
    final transacao = ModalRoute.of(context)!.settings.arguments as Transacao;

    return Scaffold(
      appBar: AppBar(
        backgroundColor: transacao.tipoTransacao == TipoTransacao.despesa
            ? Colors.redAccent
            : Colors.greenAccent,
        title: Text(transacao.descricao),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            ContaItem(conta: transacao.conta),
            ListTile(
              title: const Text('Tipo de Lançamento'),
              subtitle: Text(transacao.tipoTransacao == TipoTransacao.despesa
                  ? 'Dispesa'
                  : 'Receita'),
            ),
            ListTile(
              title: const Text('Valor'),
              subtitle: Text(NumberFormat.simpleCurrency(locale: 'pt_BR')
                  .format(transacao.valor)),
            ),
            ListTile(
              title: const Text('Categoria'),
              subtitle: Text(transacao.categoria.descricao),
            ),
            ListTile(
              title: const Text('Data do Lançamento'),
              subtitle: Text(DateFormat('MM/dd/yyyy').format(transacao.data)),
            ),
            ListTile(
              title: const Text('Observação'),
              subtitle:
                  Text(transacao.detalhes.isEmpty ? '-' : transacao.detalhes),
            ),
          ],
        ),
      ),
    );
  }
}
