package net.iessochoa.danielabellan.practica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NuevoContactoActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvNombreEmpresa;
    private Button btnOk;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        tvNombre = findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellidos);
        tvNombreEmpresa = findViewById(R.id.tvNombreEmpresa);
        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(view -> {
            this.finish();
        });
    }
}