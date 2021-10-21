package net.iessochoa.danielabellan.practica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class IntroducirDatosActivity extends AppCompatActivity {

    private EditText etDato;
    private Button btnOkDatos;
    private Button btnCancelarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_datos);

        etDato = findViewById(R.id.etDato);
        btnOkDatos = findViewById(R.id.btnOkDatos);
        btnCancelarDatos = findViewById(R.id.btnCancelarDatos);

        btnCancelarDatos.setOnClickListener(view -> {
            this.finish();
        });
    }
}