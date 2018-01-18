package app;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class TesteErro {
    
    public static void main(String[] args) {
       System.out.println("inicio do main");
       try{
           metodo1();
       }catch (NullPointerException e){
           System.out.println("Erro: " + e);
       }
       System.out.println("fim do main");
   }

   static void metodo1() {
       System.out.println("inicio do metodo1");
       metodo2();
       System.out.println("fim do metodo1");
   }

   static void metodo2() {
       
        System.out.println("inicio do metodo2");
        ContaCorrente cc = new ContaCorrente();
       
        try{
            for (int i = 0; i <= 15; i++) {    
                cc.deposita(i + 1000);
                System.out.println(cc.getSaldo());
                if (i == 5) {
                    cc = null;
                }
            }
        }catch (NullPointerException e){
            System.out.println("Erro: " + e);
        }
        System.out.println("fim do metodo2");
    }
}

