package ifpi.edu.br.terceiraquestao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    private EditText nome;
    private Box<Usuario> usuarioBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
    }

    private void setupViews() {
        nome = findViewById(R.id.nome_user);
    }

    public void entrar(View view) {

        String name = nome.getText().toString();
        if (!name.trim().isEmpty()) {

            List<Usuario> result = usuarioBox.query()
                    .equal(Usuario_.nome, name)
                    .build()
                    .find();


            if (result.size() > 0) {
                logar(result.get(0));
                Toast.makeText(this, "Voce ja tem uma conta, bem vindo!", Toast.LENGTH_SHORT).show();
            }else{
                cadastrar(name);
            }

        } else {
            Toast.makeText(this, "Insira um nome!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void cadastrar(String name) {

        Usuario usuario = new Usuario();
        usuario.setNome(name);
        usuarioBox.put(usuario);
        logar(usuario);

        Toast.makeText(this, "Voce não tinha uma conta, mas agora tem!", Toast.LENGTH_SHORT).show();
    }

    private void logar(Usuario usuario) {

        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());

        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
    }
}