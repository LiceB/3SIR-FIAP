import 'package:expense_tracker/pages/home_page.dart';
import 'package:expense_tracker/pages/transacao_cadastro_page.dart';
import 'package:expense_tracker/pages/transacao_detalhe_page.dart';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Expense Tracker',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      routes: {
        "/": (context) => const HomePage(),
        "/transacao-detalhes": (context) => const TransacaoDetalhePage(),
        "/transacao-cadastro": (context) => const TransacaoCadastroPage(),
      },
      initialRoute: "/",
    );
  }
}
