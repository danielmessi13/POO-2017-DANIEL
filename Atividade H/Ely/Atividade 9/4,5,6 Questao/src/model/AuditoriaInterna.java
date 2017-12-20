/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class AuditoriaInterna {
    Tributavel tributaveis [];
    int ultimo = 0;

    public AuditoriaInterna(int tamanho) {
        this.tributaveis = new Tributavel [tamanho];
    }
    
    public void adicionar(Tributavel tributavel){
        this.tributaveis[ultimo++] = tributavel;
    }
    
    public double calcularTributos(){
        double soma = 0;
        for (int i = 0; i < ultimo; i++){
            soma += this.tributaveis[i].calculaTributos();
        }
        return soma;
    }
}
