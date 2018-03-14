package ifpi.edu.br.segundaquesto;

public class Bimestre {

    private float nota1;
    private float nota2;
    private int peso1;
    private int peso2;
    private float mediaPonderada;

    public boolean calcularMedia(){
        if (peso1 == 0 && peso2 == 0){
            return false;
        }else{
            //TODO : Ver qual o erro que esta dando
            mediaPonderada = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);
            return true;
        }
    }

    public float getMediaPonderada() {
        return mediaPonderada;
    }

    public void setMediaPonderada(float mediaPonderada) {
        this.mediaPonderada = mediaPonderada;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public int getPeso1() {
        return peso1;
    }

    public void setPeso1(int peso1) {
        this.peso1 = peso1;
    }

    public int getPeso2() {
        return peso2;
    }

    public void setPeso2(int peso2) {
        this.peso2 = peso2;
    }
}
