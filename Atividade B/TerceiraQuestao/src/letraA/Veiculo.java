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
public class Veiculo {
    String marca;
    String modelo;
    String concessionaria;
    
void Mostrar(){
    
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Concessionaria: " + concessionaria);
    
}

    public Veiculo(String marca, String modelo, String concessionaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.concessionaria = concessionaria;
    }


}

  


