/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letraA;

/**
 *
 * @author aluno
 */
public class Montadora {
    
    String cnpj;
    String endereco;
    String nome;
    int carros;
    int vendas;

    public Montadora(String cnpj, String endereco, String nome, int carros, int vendas) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nome = nome;
        this.carros = carros;
        this.vendas = vendas;
    }
    

void produzir(int quantidade){
    this.carros += quantidade;
}

void vender(int quantidade, int preco){
    this.carros -= quantidade;
    this.vendas += preco;
}



    
}


