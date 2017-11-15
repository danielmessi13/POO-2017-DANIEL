/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap4fixando;

/**
 *
 * @author Daniel
 */
public class Pessoa {
    String nome;
    int idade;

void fazAniversario(){
    this.idade++;
}

void mostrar(){
    System.out.println("Nome: " + this.nome);
    System.out.println("Idade: " + this.idade);
}

}
