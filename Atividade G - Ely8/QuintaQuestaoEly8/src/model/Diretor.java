package model;

/**
 * Created by aluno on 14/12/17.
 */
public class Diretor extends Funcionario {

    @Override
    public void getBonificacao(double taxa) {
        super.salario += super.salario * taxa * 0.001;
    }
}
