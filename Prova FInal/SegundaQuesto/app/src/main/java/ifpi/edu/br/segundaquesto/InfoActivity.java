package ifpi.edu.br.segundaquesto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class InfoActivity extends AppCompatActivity {

    public static final int MEDIA = 1;
    private EditText nota1;
    private EditText nota2;
    private TextView txt_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nota1 = findViewById(R.id.nota_um);
        nota2 = findViewById(R.id.nota_dois);
        txt_media = findViewById(R.id.txt_media);

    }

    public void calcularMedia(View view) {



        try{
            float notaUm = Float.parseFloat(nota1.getText().toString());
            float notaDois = Float.parseFloat(nota2.getText().toString());
            Intent i = new Intent(this, CalculaActivity.class);
            i.putExtra("notaUm", notaUm);
            i.putExtra("notaDois", notaDois);
            startActivityForResult(i, MEDIA);
        }catch (Exception e){
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MEDIA){
            if (resultCode == RESULT_OK){
                float media = data.getFloatExtra("mediaPonderada", -1);
                txt_media.setText(setTexto(media));
                limpar();
            }else{
                limpar();
                txt_media.setText("");
                Toast.makeText(this, "Calculo não foi feito com sucesso", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void limpar() {
        nota1.setText("");
        nota2.setText("");
    }

    private String setTexto(float media){
        SharedPreferences sharedPref = getSharedPreferences("app", MODE_PRIVATE);
        String nome = sharedPref.getString("name", "");
        String texto;
        if (media >= 7){
            texto = "Parabéns " + nome + ", vôce foi aprovado com média " + media;
        }else if (media < 4){
            texto = "Sinto muito " + nome + ", vc ficou reprovado. Sua média " + media;
        }else {
            texto = nome + " cuidado, vc ficou em prova final. Sua média foi " + media +
                    " e você precisa obter " + (12 - media) + " para obter aprovação";
        }
        return texto;
    }
}
