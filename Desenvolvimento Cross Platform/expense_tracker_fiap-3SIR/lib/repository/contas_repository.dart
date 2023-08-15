import 'package:expense_tracker/models/conta.dart';

class ContasRepository {
  List<Conta> listarContas() {
    return [
      Conta(
        id: '1',
        bancoId: 'bb',
        descricao: 'Conta Pessoal',
        tipoConta: TipoConta.contaCorrente,
      ),
      Conta(
        id: '2',
        bancoId: 'c6bank',
        descricao: 'Conta Juridica',
        tipoConta: TipoConta.contaInvestimento,
      ),
      Conta(
        id: '3',
        bancoId: 'nubank',
        descricao: 'Conta Proficional',
        tipoConta: TipoConta.contaPoupanca,
      ),
    ];
  }
}
