/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quartaquestao;

/**
 *
 * @author aluno
 */
public class ArCondicionado {
    String tipo = "split";
    double preco;
    boolean funcionamento;
    String status = "Ligado";
    int temperatura = 30;
    String velocidade = "fraco";
    String modo = "frio";

    public ArCondicionado(double preco, boolean funcionamento, int temperatura) {
        this.preco = preco;
        this.funcionamento = funcionamento;
        this.temperatura = temperatura;
    }


 
void mostrar(){
    
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Preço: " + this.preco);
    System.out.println("Funcionando? " + this.funcionamento);
    System.out.println("Status: " + this.status);
    System.out.println("Temperatura: " + this.temperatura);
    System.out.println("Velocidade: " + this.velocidade);
    System.out.println("Modo: " + this.modo);
    
}
void botaoLigarDesligar(){
    if (this.status == "Ligado"){
        this.status = "Desligado";
        this.temperatura = 0;
        this.velocidade = null;
        this.modo = null;
    } else{
        this.status = "Ligado";
        this.temperatura = 30;
        this.velocidade = "fraco";
        this.modo = "frio";
        
    }
    
}



    
}
