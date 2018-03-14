package ifpi.edu.br.segundaquesto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CalculaActivity extends AppCompatActivity {

    private EditText pesoUm;
    private EditText pesoDois;
    private float notaUm;
    private float notaDois;
    private Bimestre bimestre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula);

        pesoUm = findViewById(R.id.peso_um);
        pesoDois = findViewById(R.id.peso_dois);

        Intent i = getIntent();
        notaUm = i.getFloatExtra("notaUm", -1);
        notaDois = i.getFloatExtra("notaDois", -1);

        bimestre = new Bimestre();
        bimestre.setNota1(notaUm);
        bimestre.setNota2(notaDois);

    }



    public void cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public boolean calcular(View view) {

        Intent volta = new Intent();

        if (!pesoUm.getText().toString().trim().isEmpty() || !pesoDois.getText().toString().trim().isEmpty()){
            int p1 = Integer.parseInt(pesoUm.getText().toString());
            int p2 = Integer.parseInt(pesoDois.getText().toString());
            bimestre.setPeso1(p1);
            bimestre.setPeso2(p2);
            if (!bimestre.calcularMedia()){
                setResult(RESULT_CANCELED);
                finish();
            }else {
                bimestre.calcularMedia();
                volta.putExtra("mediaPonderada", bimestre.getMediaPonderada());
                setResult(RESULT_OK, volta);
                finish();
            }
            return true;

        }else{
            Toast.makeText(this, "Numeros incorretos!", Toast.LENGTH_SHORT).show();
            return false;
        }






    }
}
