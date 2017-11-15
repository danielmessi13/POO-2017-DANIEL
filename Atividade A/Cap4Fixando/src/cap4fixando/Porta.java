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
public class Porta {
    boolean aberta;
    String cor;
    int dimensaoX;
    int dimensaoY;
    int dimensaoZ;
    
void abre(){
    this.aberta = true;
}

void fecha(){
    this.aberta = false;
}

void pinta(String s){
    this.cor = s;
}

boolean estaAberta(){
    return this.aberta;
}
   
}
