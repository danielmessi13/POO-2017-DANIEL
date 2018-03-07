package com.example.wesleybrandolee.bibliotech.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.App;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario_;

import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity{
    private Button btn_logar;
    private EditText editEmail;
    private EditText editSenha;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);

    }



    private void setupViews() {
        editEmail = findViewById(R.id.id_email);
        editSenha = findViewById(R.id.id_senha);
        btn_logar = findViewById(R.id.btn_entrar);
        btn_logar.setClickable(false);
        btn_logar.getBackground().setAlpha(60);

        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCampos();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editSenha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCampos();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    private void validaCampos() {
        if(!editEmail.getText().toString().trim().isEmpty() && !editSenha.getText().toString().trim().isEmpty()){
            btn_logar.setClickable(true);
            btn_logar.getBackground().setAlpha(255);
        }else{
            btn_logar.setClickable(false);
            btn_logar.getBackground().setAlpha(60);
        }
    }

    public void entrar(View view) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        
        List<Usuario> result = usuarioBox.query()
                .equal(Usuario_.email, email)
                .equal(Usuario_.senha, senha)
                .build()
                .find();


        if (result.size() > 0) {
            logar(result.get(0));
        }else {
            editSenha.getText().clear();
            Toast.makeText(this, "Email e/ou senha incorreto(s)!", Toast.LENGTH_SHORT).show();
        }


    }



    private void logar(Usuario usuario) {

        SharedPreferences preferences = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());

        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    public void cadastrar(View view) {

        startActivity(new Intent(this,CadastroActivity.class));
    }
}
