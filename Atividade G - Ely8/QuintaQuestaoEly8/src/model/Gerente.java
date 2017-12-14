package model;

/**
 * Created by aluno on 14/12/17.
 */
public class Gerente extends Funcionario {

    private double porcentagemParticipacao;

    @Override
    public void getBonificacao(double taxa) {
        super.salario += super.salario * taxa * this.porcentagemParticipacao;
    }
}
