package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NuevoContactoActivity extends AppCompatActivity {

    public final static int OPTION_REQUEST_NOMBRE = 0;
    public final static int OPTION_REQUEST_APELLIDOS = 1;
    public final static int OPTION_REQUEST_NOMBRE_EMPRESA = 2;

    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvNombreEmpresa;
    private Button btnOk;
    private Button btnCancelar;

    //TODO: AÑADIR LO DE LOS ICONOS, QUE AUN NO LOS HE PUESTO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        tvNombre = findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellidos);
        tvNombreEmpresa = findViewById(R.id.tvNombreEmpresa);
        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);

        tvNombre.setOnClickListener(view -> {
            Intent intent = new Intent(this, IntroducirDatosActivity.class);
            startActivity(intent);
        });

        tvApellidos.setOnClickListener(view -> {
            Intent intent = new Intent(this, IntroducirDatosActivity.class);
            startActivity(intent);
        });

        tvNombreEmpresa.setOnClickListener(view -> {
            Intent intent = new Intent(this, IntroducirDatosActivity.class);
            startActivity(intent);
        });

        btnCancelar.setOnClickListener(view -> {
            this.finish();
        });
    }
}