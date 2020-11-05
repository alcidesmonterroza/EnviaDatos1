package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import Clases.Bebida;
import Clases.Hamburguesa;

public class Actividad2 extends AppCompatActivity {
    private TextView logTextView;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        logTextView = findViewById(R.id.textView10);
        scrollView = findViewById(R.id.scrollView);
        Bundle bundle = this.getIntent().getExtras();
        log("Cliente: "+bundle.getString("CLIENTE"));
        log("");
        Hamburguesa mihambur = (Hamburguesa) bundle.get("HAMBURGUESA");
        Bebida mibebida = (Bebida) bundle.get("BEBIDA");
        log("Hamburguesa");
        log("Tipo: "+ mihambur.getTipo());
        if(mihambur.getCebolla()){ log("Con cebolla");}
        else {log("Sin cebolla");}
        log("Cantidad: " + bundle.get("CANT_HAMB"));
        log("");
        log("Bebida");
        log("Tipo: "+ mibebida.getTipo());
        if(mibebida.getHielo()) {log("Con Hielo");}
        else { log("Sin Hielo");}
        log("Cantidad: " + bundle.get("CANT_BEBIDA"));

    }
    private void log(String s){
        logTextView.append("\n"+s);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
              scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

}