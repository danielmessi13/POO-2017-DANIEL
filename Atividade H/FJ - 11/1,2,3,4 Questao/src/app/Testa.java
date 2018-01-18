/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.*;

/**
 *
 * @author aluno
 */
public class Testa {
    public static void main(String[] args) {
        
        //ContaCorrente cc = new ContaCorrente();
        //cc.deposita(100);
        
        //System.out.println(cc.calculaTributos());
        
        // testando polimorfismo:
        //Tributavel t = cc;
        //System.out.println(t.calculaTributos());
        
        // nao funciona o getSaldo() em T, pois ele agr é um tributavel e nao uma ContaCorrente
        // t.getSaldo();
        
        GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
        
        SeguroDeVida sv = new SeguroDeVida();
        gerenciador.adiciona(sv);
        
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(1000);
        gerenciador.adiciona(cc);
        
        System.out.printf("O saldo é: %.2f\n", cc.getSaldo());
        
        System.out.println(gerenciador.getTotal());
    }
}
