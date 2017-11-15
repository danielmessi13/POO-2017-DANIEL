/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap4fixando;

/**
 *
 * @author Daniel
 */
public class FixandoConhecimento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crie uma pessoa, coloque seu nome e idade iniciais, 
        //faça alguns aniversários (aumentando a idade) e imprima
        //seu nome e sua idade
        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Daniel";
        pessoa1.idade = 18;
        pessoa1.mostrar();
        pessoa1.fazAniversario();
        pessoa1.mostrar();
        System.out.println("");
        
        //Crie uma porta, abra e feche a mesma, pinte-a de diversas cores, 
        //altere suas dimensões e use o método esta
        //Aberta para verificar se ela está aberta.
        Porta porta1 = new Porta();
        porta1.abre();
        porta1.fecha();
        porta1.pinta("vermelho");
        porta1.dimensaoX = 10;
        porta1.dimensaoY = 10;
        porta1.dimensaoZ = 10;
        System.out.println(porta1.estaAberta());
        
        
        
        // Crie uma casa e pinte-a. Crie três portas e coloque-as na casa; 
        // abra e feche as mesmas como desejar. Utilize o método quantasPortas
        // EstaoAbertas para imprimir o número de portas abertas.
        
        Casa casa1 = new Casa();
        casa1.porta1 = true;
        System.out.println(casa1.quantasEstaoAbertas());

    }
    
}
