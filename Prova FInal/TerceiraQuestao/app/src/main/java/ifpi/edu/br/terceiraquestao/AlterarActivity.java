package ifpi.edu.br.terceiraquestao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class AlterarActivity extends AppCompatActivity {
    private Box<Tarefa> tarefaBox;
    private Box<Usuario> usuarioBox;
    private Tarefa tarefa;
    private TarefasAdapter adapter;
    private long id;
    private Button btn;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        setupViews();

        Intent i = getIntent();
        id = i.getLongExtra("tarefaId",-1);

        BoxStore store = ((App) getApplication()).getBoxStore();

        tarefaBox = store.boxFor(Tarefa.class);
        usuarioBox = store.boxFor(Usuario.class);

        tarefa = tarefaBox.get(id);
        usuarioLogado = usuarioBox.get(tarefa.getId());
        inicializar();
    }

    private void setupViews() {
        btn = findViewById(R.id.btn);
    }

    private void inicializar(){
        String estado = tarefa.getEstado();
        if (estado.equals("Terminada")){

        }else{
            finish();
        }
    }
}
