package pkgfinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jornalista extends Pessoa {
    
    private List<Noticia> pendentes = new ArrayList<>();
    private List<Noticia> aprovadas = new ArrayList<>();

    public Jornalista(String nome) {
        this.nome = nome;
    }
 
    boolean criarNoticia(String nome, String area, String resumo, String corpo){
        
        if (resumo.length() > 140){
            return false;
        }

        Noticia noticia = new Noticia(this.getNome(), nome, area, resumo, corpo);
        if (nome.equals("Esportes")){
            noticia.setCor("Verde");
        }else if (nome.equals("Entreterimento")){
            noticia.setCor("Laranja");
        }else if (nome.equals("Politica") || nome.equals("Economia")){
            noticia.setCor("Vermelho");
        }

        Date data = new Date();
        String date = String.valueOf(data.getDay());
        noticia.addMovimentacao("Data: " + date + "Criada por: " + this.getNome());

        this.pendentes.add(noticia);
        return true;
    }

    
    boolean proporNoticia(Editor editor){
        int pos = this.pendentes.size()-1;
        if (this.pendentes.size() > 0){
            Date data = new Date();
            String date = String.valueOf(data.getDay());
            pendentes.get(pos).setEstado("Pronta pra revisão");
            pendentes.get(pos).addMovimentacao("Data: " + date + "Pronta para revisão por: " + this.getNome());

            if (editor.aprovarNoticia(pendentes.get(pos))){
                aprovadas.add(pendentes.get(pos));
                pendentes.remove(pendentes.get(pos));
                return true;
            }
        }return false;
    }
}
