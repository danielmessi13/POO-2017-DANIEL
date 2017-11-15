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
public class TestaFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        
        f1.dataEntrada.dia = 10;

        f1.nome = "Paulo";
        f1.salario = 100;
        f1.recebeAumento(50);
        f1.mostra();
        
        //Funcionario f2 = f1;
        
        Funcionario f2 = new Funcionario();
        f2.nome = "Danael";
        f2.salario = 99999;
        f2.recebeAumento(1);
        f2.mostra();
        
        
        
        if (f1 == f2){
            System.out.println("São iguais");
        }else{
            System.out.println("São diferentes");
        }
        
        
        System.out.println("Salario atual: " + f1.salario);
        System.out.println("Ganho anual: " + f1.calculaGanhoAnual());
    }
    
}
