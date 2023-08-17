import 'package:expense_tracker/models/tipo_transacao.dart';
import 'package:expense_tracker/models/transacao.dart';
import 'package:expense_tracker/repository/transacoes_repository.dart';
import 'package:flutter/material.dart';

import '../components/transacao_item.dart';

class TransacoesPage extends StatefulWidget {
  const TransacoesPage({super.key});

  @override
  State<TransacoesPage> createState() => _TransacoesPageState();
}

class _TransacoesPageState extends State<TransacoesPage> {
  final transacoesRepo = TransacoesReepository();
  late List<Transacao> transacoes;

  @override
  void initState() {
    transacoes = transacoesRepo.listarTransacoes();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Transacões'),
          actions: [
            PopupMenuButton(itemBuilder: (context) {
              return [
                PopupMenuItem(
                  child: const Text('Todas'),
                  onTap: () {
                    setState(() {
                      transacoes = transacoesRepo.listarTransacoes();
                    });
                  },
                ),
                PopupMenuItem(
                  child: const Text('Receitas'),
                  onTap: () {
                    setState(() {
                      transacoes = transacoesRepo
                          .listarTransacoes()
                          .where((transacao) =>
                              transacao.tipoTransacao == TipoTransacao.receita)
                          .toList();
                    });
                  },
                ),
                PopupMenuItem(
                  child: const Text('Despesas'),
                  onTap: () {
                    setState(() {
                      transacoes = transacoesRepo
                          .listarTransacoes()
                          .where((transacao) =>
                              transacao.tipoTransacao == TipoTransacao.despesa)
                          .toList();
                    });
                  },
                ),
              ];
            })
          ],
        ),
        body: ListView.separated(
          itemCount: transacoes.length,
          itemBuilder: (context, index) {
            final transacao = transacoes[index];
            return TransacaoItem(
              transacao: transacao,
              onTap: () {
                Navigator.pushNamed(context, '/transacao-detalhe',
                    arguments: transacao);
              },
            );
          },
          separatorBuilder: (context, index) {
            return const Divider();
          },
        ));
  }
}
