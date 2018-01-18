/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.Quadrado;
import model.Triangulo;

/**
 *
 * @author aluno
 */
public class TestaFiguras {
    public static void main(String[] args) {

        Quadrado quadrado = new Quadrado(2);
        System.out.println(quadrado.calcularArea());
        
        Triangulo triangulo = new Triangulo(2, 4, 3);
        System.out.println(triangulo.calcularArea());
        
        System.out.println(triangulo.comparar(quadrado));
        
    }
}
