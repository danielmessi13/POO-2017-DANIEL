package model;

/**
 * Created by aluno on 14/12/17.
 */
public class ContaCorrente extends Conta {

    @Override
    public void saque(double valor) {
        if (super.saldo >= valor){
            super.saldo -= valor;
        }
    }

}
