package ifpi.edu.br.terceiraquestao;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import io.objectbox.Box;

public class FormularioActivity extends AppCompatActivity {
    EditText editTitulo;
    EditText editDescricao;
    Box<Tarefa> tarefaBox;
    Box<Usuario> usuarioBox;
    Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setupViews();
        tarefaBox =  ((App) getApplication()).getBoxStore().boxFor(Tarefa.class);
        usuarioBox =  ((App) getApplication()).getBoxStore().boxFor(Usuario.class);

        usuarioLogado = obterUsuarioLogado();
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }


    private void setupViews() {
        editTitulo = findViewById(R.id.titulo);
        editDescricao = findViewById(R.id.descricao);
    }

    public void aFazer(View view) {
        adicionar("A fazer");
    }

    public void iniciar(View view) {
        adicionar("Iniciada");
    }

    public void fazendo(View view) {
        adicionar("Fazendo");
    }


    private void adicionar(String estado){

        Tarefa tarefa = new Tarefa();

        Date date = new Date();
        String dia = String.valueOf(date.getDay());

        tarefa.setTitulo(editTitulo.getText().toString());
        tarefa.setDescricao(editDescricao.getText().toString());
        tarefa.setEstado(estado);
        tarefa.setData(dia);
        tarefa.getDono().setTarget(usuarioLogado);

        tarefaBox.put(tarefa);
        finish();


    }
}
