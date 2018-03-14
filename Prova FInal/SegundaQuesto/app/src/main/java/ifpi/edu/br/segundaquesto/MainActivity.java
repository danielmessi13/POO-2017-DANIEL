package ifpi.edu.br.segundaquesto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome = findViewById(R.id.nome_user);

    }

    public void continuar(View view) {

        String nome = editNome.getText().toString();
        if (!nome.trim().isEmpty()){
            SharedPreferences sharedPref = getSharedPreferences("app", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", nome);
            editor.commit();

            startActivity(new Intent(this,InfoActivity.class));
        }else{
            Toast.makeText(this, "Insira um nome!!", Toast.LENGTH_SHORT).show();
        }


    }
}
