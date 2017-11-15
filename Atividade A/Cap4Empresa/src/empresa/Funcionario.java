/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

/**
 *
 * @author Daniel
 */
public class Funcionario {
    String nome;
    String departamento;
    double salario;
    Data dataEntrada = new Data();
    String rg;
    boolean estaNaEmpresa = true;
    
    
void mostra(){
    
    System.out.println("Nome: " + this.nome);
    System.out.println("Departamento: " + this.departamento);
    System.out.println("Salario: " + this.salario);
    System.out.println("Data de entrada: " + this.dataEntrada);
    System.out.println("RG: " + this.rg);
    System.out.println("Está na empresa? : " + this.estaNaEmpresa);
    System.out.println("Data: " + this.dataEntrada.formatada());
    /*System.out.println("Dia: " + this.dataEntrada.dia);
    System.out.println("Mês : " + this.dataEntrada.mes);
    System.out.println("Ano : " + this.dataEntrada.ano);
    */
}

void recebeAumento(double aumento){
    this.salario += aumento;
}

void demite(){
    estaNaEmpresa = false;
}

double calculaGanhoAnual(){
    double salarioAnual = this.salario * 12;
    return salarioAnual;
}
}
