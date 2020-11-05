package ud.example.enviadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Clases.Bebida;
import Clases.Hamburguesa;

public class MainActivity extends AppCompatActivity {

   private EditText cliente, cantidadHamb, cantidadbeb;
   private Spinner lista01,lista02,lista03;
   private CheckBox hielo;
   private Button enviab;
  // private List<String> tipoh,sino; //tipob

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente=findViewById(R.id.edittext);
        cantidadHamb=findViewById(R.id.Edittext1);
        cantidadbeb=findViewById(R.id.Edittext2);
        lista01 = findViewById(R.id.spinner2);
        lista02 = findViewById(R.id.spinner3);
        lista03 = findViewById(R.id.spinner4);
        hielo = findViewById(R.id.checkBox);
        enviab = findViewById(R.id.button2);
        datosinicio();
    }

    private void datosinicio(){
        List<String> tipoh = new ArrayList<String>();
     //   List<String> tipob = new ArrayList<String>();
        List<String> sino = new ArrayList<String>();

        tipoh.add("Carne");tipoh.add("Pollo");tipoh.add("Pescado");
        ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoh);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista01.setAdapter(adaptador);

        sino.add("SI");sino.add("NO");
        ArrayAdapter<String>adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sino);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista02.setAdapter(adaptador2);

    }

    public void llenaractividad(View v){
        boolean cebolla = false;
        if(lista02.getSelectedItem().toString().equals("SI")) cebolla= true;
        Hamburguesa miham = new Hamburguesa(lista01.getSelectedItem().toString(),cebolla);
        boolean hie =this.hielo.isChecked();
        Bebida mibebida = new Bebida(lista03.getSelectedItem().toString(),hie);

        Intent int01 = new Intent(this,Actividad2.class);
        int01.putExtra("CLIENTE", cliente.getText().toString());
        int01.putExtra("HAMBURGUESA", miham);

        int01.putExtra("CANT_HAMB",cantidadHamb.getText().toString());
        int01.putExtra("BEBIDA",mibebida);

        int01.putExtra("CANT_BEBIDA",cantidadbeb.getText().toString());
        if( cliente.getText().toString().isEmpty() || cliente.getText().toString().trim().length()<1){
            Toast.makeText(this, "Falta el nombre del Cliente", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(int01);
        }
    }
}