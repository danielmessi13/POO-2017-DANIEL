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
public class Quadrado implements Figuravel, Comparavel{
    
    private double lado;

    public Quadrado(double lado) {
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
    public double calcularArea(){
        return this.lado * 2;
    }
    
    @Override
    public double perimetro(){
        return this.lado * 4;
    }
    
    
}
