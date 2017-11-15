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
public class Casa {
    String cor;
    boolean porta1 = false;
    boolean porta2 = false;
    boolean porta3 = false;
    
int quantasEstaoAbertas(){
    int cont = 0;
    if (this.porta1){
        cont++;
    }
    if (this.porta2){
        cont++;
    }
    if (this.porta3){
        cont++;
    }
        return cont;
}
    
}
