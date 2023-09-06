import 'package:flutter/material.dart';
import 'package:flutter_masked_text2/flutter_masked_text2.dart';
import 'package:intl/intl.dart';
import 'package:ionicons/ionicons.dart';

class TransacaoCadastroPage extends StatefulWidget {
  const TransacaoCadastroPage({super.key});

  @override
  State<TransacaoCadastroPage> createState() => _TransacaoCadastroPageState();
}

class _TransacaoCadastroPageState extends State<TransacaoCadastroPage> {
  final descricaoControler = TextEditingController();
  final valorController = MoneyMaskedTextController();
  final dataControler = TextEditingController(
  );

  final _key = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Nova Transação'),
      ),
      body: Form(
        autovalidateMode: AutovalidateMode.always,
        key: _key,
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            children: [
              _buildDescricao(),
              SizedBox(height: 20),
              _buildValor(),
              SizedBox(height: 20),
              _buildData(),
              SizedBox(height: 30),
              _buildButton(),
            ],
          ),
        ),
      ),
    );
  }

  TextFormField _buildDescricao() {
    return TextFormField(
      controller: descricaoControler,
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Descrição obrigatória';
        }
        return null;
      },
      decoration: const InputDecoration(
        label: Text('Descrição'),
        prefixIcon: Icon(Ionicons.text_outline),
        border: OutlineInputBorder(),
      ),
    );
  }

  TextFormField _buildData() {
    return TextFormField(
      controller: dataControler,
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Data obrigatória';
        }
        return null;
      },
      onTap: () async {
        DateTime? dataSelecionada = await showDatePicker(
          context: context,
          initialDate: DateTime.now (),
          firstDate: DateTime(2000),
          lastDate: DateTime.now(),
        );

        if(dataSelecionada != null) {
          dataControler.text = DateFormat('dd/MM/yyyy').format(dataSelecionada);
        }
      },
      keyboardType: TextInputType.none,
      decoration: const InputDecoration(
        label: Text('Data'),
        prefixIcon: Icon(Ionicons.calendar_outline),
        border: OutlineInputBorder(),
      ),
    );
  }

  TextFormField _buildValor() {
    return TextFormField(
      controller: valorController,
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Valor obrigatório';
        }
        return null;
      },
      keyboardType: TextInputType.number,
      decoration: const InputDecoration(
        label: Text('Valor'),
        prefixIcon: Icon(Ionicons.cash_outline),
        border: OutlineInputBorder(),
      ),
    );
  }

  Widget _buildButton() {
    return SizedBox(
      width: double.infinity,
      child: ElevatedButton(
        onPressed: () {
          final valido = _key.currentState!.validate();
          if (valido) {
            print(descricaoControler.text);
          }
        },
        child: const Text('Cadastrar Transação'),
      ),
    );
  }
}
