package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNuevo;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos las variables para poder dar funcionalidad a los botones de la Actividad
        btnNuevo = findViewById(R.id.btnNuevo);
        btnSalir = findViewById(R.id.btnSalir);

        //Hacemos que cuando se pulse "Nuevo", abrir la Actividad correspondiente para crear un nuevo contacto
        btnNuevo.setOnClickListener(view -> {
            Intent intent = new Intent(this, NuevoContactoActivity.class);
            startActivity(intent);
        });

        //Hacemos que cuando se pulse "Salir" se cierre la aplicación
        btnSalir.setOnClickListener(view -> {
            this.finish();
        });

    }
}