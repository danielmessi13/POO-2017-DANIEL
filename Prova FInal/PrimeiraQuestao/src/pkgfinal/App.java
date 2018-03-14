package pkgfinal;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jornalista jornalista = new Jornalista("Daniel");
        Editor editor = new Editor("Micael", "Esporte", true);
        Timeline timeLine = new Timeline();
        
        String resumo = "Resumo resumo resumo resumo resumo resumo resumo"
                + "resumo resumo resumo resumo resumo resumo resumo resumo ";
        
        String corpoNoticia = "Corpo corpo corpo corpo corpo corpo corpo corpo"
                + "corpo corpo corpo corpo corpo corpo corpo corpo corpo corpo "
                + "corpo corpo corpo corpo corpo corpo corpo corpo ";
        
        if (jornalista.criarNoticia("Bafo", "Esporte", resumo, corpoNoticia)){
            System.out.println("Noticia criada com sucesso!");
        }else{
            System.out.println("Resumo muito grande");
        }
        
        if (jornalista.proporNoticia(editor)){
            System.out.println("Noticia aprovada!");
        }else{
            System.out.println("Noticia reprovada!");
        }

        timeLine.configurarTimeline(editor,editor.getPrincipal());
       
    }
    
}
