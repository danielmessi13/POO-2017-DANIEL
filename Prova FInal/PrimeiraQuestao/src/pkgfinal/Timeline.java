package pkgfinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Timeline {

    private Noticia principal;
    private List<String> blocos = new ArrayList<>();
    private List<Noticia> noticias = new ArrayList<>();
    private List<Noticia> destaques = new ArrayList<>();
    private List<Noticia> maisLidas = new ArrayList<>();
    private boolean imagem;
    private int cont;
    
    public boolean configurarTimeline(Editor editor, Noticia noticia){
        boolean bool = editor.isChefe();
        if (bool){
            for (int i = 0; i < destaques.size(); i++){
                destaques.get(i).setCor("Vermelho");
            }

            this.principal = noticia;

            for (Noticia n : editor.getAtivas()){
                if (cont < 5){
                    this.destaques.add(editor.getAtivas().get(cont));
                }
                noticias.add(n);
            }

            this.sort();

            for (int i = 0; i < noticias.size(); i++){
                if (i < 5){
                    maisLidas.add(noticias.get(i));
                }else{
                    break;
                }

            }

            return bool;
        }
        return bool;
    }

    public void sort(){
        Collections.sort(noticias);
    }
    
}
