/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.AuditoriaInterna;
import model.ContaCorrente;
import model.SeguroDeVida;

/**
 *
 * @author aluno
 */
public class Testa {
    public static void main(String[] args) {
        
        ContaCorrente cc = new ContaCorrente();
        cc.setNome("Daniel");
        cc.setSaldo(100);
        
        ContaCorrente cc1 = new ContaCorrente();
        cc1.setNome("Josiel");
        cc1.setSaldo(100);
        
        SeguroDeVida seg1 = new SeguroDeVida();
        SeguroDeVida seg2 = new SeguroDeVida();
        
        AuditoriaInterna aud = new AuditoriaInterna(10);
        aud.adicionar(cc);
        aud.adicionar(cc1);
        aud.adicionar(seg1);
        aud.adicionar(seg2);
        
        System.out.println(aud.calcularTributos());
        
        
    }
}
