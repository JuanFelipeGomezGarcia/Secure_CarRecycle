package co.edu.unab.secure_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    TextView txt_marca;
    TextView txt_modelo;
    TextView txt_placa;
    TextView txt_color;
    TextView txt_nombre;
    TextView txt_edad;
    TextView txt_genero;
    TextView txt_id;
    Button btn_mapa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        txt_marca=findViewById(R.id.tv_marca2);
        txt_modelo=findViewById(R.id.tv_modelo2);
        txt_placa=findViewById(R.id.tv_placa2);
        txt_color=findViewById(R.id.tv_color2);
        txt_nombre=findViewById(R.id.tv_nombre2);
        txt_edad=findViewById(R.id.tv_edad2);
        txt_genero=findViewById(R.id.tv_genero2);
        txt_id=findViewById(R.id.tv_id2);
        btn_mapa2=findViewById(R.id.btn_mapa2);

        txt_marca.setText(getIntent().getStringExtra("marca"));

        txt_modelo.setText(getIntent().getStringExtra("modelo"));
        txt_placa.setText(getIntent().getStringExtra("placa"));
        txt_color.setText(getIntent().getStringExtra("color"));
        txt_nombre.setText(getIntent().getStringExtra("nombre"));
        txt_edad.setText(getIntent().getStringExtra("edad"));
        txt_genero.setText(getIntent().getStringExtra("genero"));
        txt_id.setText(getIntent().getStringExtra("id"));
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_mapa2:Intent intent = new Intent(MostrarDatos.this,MapsActivity.class);
                startActivity(intent);
                break;
        }

    }
}