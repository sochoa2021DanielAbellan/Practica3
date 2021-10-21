package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroducirDatosActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DATO = "IntroducirDatosActivity.EXTRA_DATO";
    public static final String EXTRA_DATO_RESULTADO = "IntroducirDatosActivity.EXTRA_DATO_RESULTADO";
    private EditText etDato;
    private Button btnOkDatos;
    private Button btnCancelarDatos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_datos);

        etDato = findViewById(R.id.etDato);
        btnOkDatos = findViewById(R.id.btnOkDatos);
        btnCancelarDatos = findViewById(R.id.btnCancelarDatos);

        etDato.setText(getIntent().getStringExtra(EXTRA_DATO));
        btnOkDatos.setOnClickListener(this);
        btnCancelarDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOkDatos:
                if(etDato.getText().length()!=0) {
                    Intent intentRetorno = new Intent(this, NuevoContactoActivity.class);
                    intentRetorno.putExtra(EXTRA_DATO_RESULTADO,etDato.getText().toString());
                    setResult(RESULT_OK,intentRetorno);
                    finish();
                }
                else{

                }
                break;
            case R.id.btnCancelarDatos:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}