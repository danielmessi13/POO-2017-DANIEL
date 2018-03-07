package com.example.wesleybrandolee.bibliotech.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.App;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario_;

import java.util.List;

import io.objectbox.Box;

public class CadastroActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1234;
    private ImageView imgBtn;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editComfirmarSenha;
    private EditText editApelido;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        setupViews();

        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
    }

    private void setupViews() {
        imgBtn = findViewById(R.id.img);
        editEmail = findViewById(R.id.email_cadastro);
        editSenha = findViewById(R.id.senha_cadastro);
        editComfirmarSenha = findViewById(R.id.comfirmar_senha_cadastro);
        editApelido = findViewById(R.id.apelido_cadastro);
    }


    public void mudar_foto(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(i, "Selecione uma gerenciador de imagens"), PICK_IMAGE);


    }



    public void efetuar_cadastro(View view) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        String senha2 = editComfirmarSenha.getText().toString();
        String apelido = editApelido.getText().toString();

        List<Usuario> result = usuarioBox.query()
                .equal(Usuario_.email,email)
                .build()
                .find();

        if (!senha.equals(senha2)) {
            setError(editComfirmarSenha);
            Snackbar.make(view, "Senhas não coincidem", Snackbar.LENGTH_SHORT).show();
        } else if (email.equals("")
                ||senha.equals("")
                || apelido.equals("")){

            Snackbar.make(view, "Preencha todos os dados!", Snackbar.LENGTH_SHORT).show();

        } else if(result.size() > 0){
            Snackbar.make(view, "Email já cadastrado!", Snackbar.LENGTH_SHORT).show();
        }

        else{
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setApelido(apelido);


            usuarioBox.put(usuario);

            logar(usuario);
            Toast.makeText(this, "Cadastro feio com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    private void setError(EditText edit) {
        edit.setText("");
        edit.setHintTextColor(getResources().getColor(R.color.vermelho));
        edit.setFocusable(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != CadastroActivity.RESULT_CANCELED){
            if(requestCode == PICK_IMAGE){
                Uri selectedImage = data.getData();
                imgBtn.setImageURI(selectedImage);
            }
        }
    }

    private void logar(Usuario usuario) {

        SharedPreferences preferences = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());
        editor.putBoolean("firstRun", false);

        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }


}
