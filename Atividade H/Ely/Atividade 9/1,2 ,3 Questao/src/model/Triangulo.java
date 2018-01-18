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
public class Triangulo implements Figuravel, Comparavel{
    
    private double base;
    private double altura;
    private double lado;

    public Triangulo(double base, double altura, double lado) {
        this.base = base;
        this.altura = altura;
        this.lado = lado;
    }

    @Override
    public int comparar(Figuravel calculavel) {
        if (this.calcularArea() < calculavel.calcularArea()){
            return -1;
        }else if (this.calcularArea() == calculavel.calcularArea()){
            return 0;
        }else{
            return 1;
        }
    }
    
    @Override
    public double calcularArea() {
        return (this.base * this.altura) / 2;
    }

    @Override
    public double perimetro() {
        return 3 * this.lado;
    }

    
}
