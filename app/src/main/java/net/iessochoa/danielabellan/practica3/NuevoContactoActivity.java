package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NuevoContactoActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int OPTION_REQUEST_NOMBRE = 0;
    public final static int OPTION_REQUEST_APELLIDOS = 1;
    public final static int OPTION_REQUEST_NOMBRE_EMPRESA = 2;

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

        tvNombre.setOnClickListener(this);
        tvApellidos.setOnClickListener(this);
        tvNombreEmpresa.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent = new Intent(this, IntroducirDatosActivity.class);

        switch(view.getId()){
            case R.id.tvNombre:
                intent.putExtra(IntroducirDatosActivity.EXTRA_DATO, tvNombre.getText().toString());
                startActivityForResult(intent, OPTION_REQUEST_NOMBRE);
                break;
            case R.id.tvApellidos:
                intent.putExtra(IntroducirDatosActivity.EXTRA_DATO, tvApellidos.getText().toString());
                startActivityForResult(intent, OPTION_REQUEST_APELLIDOS);
                break;
            case R.id.tvNombreEmpresa:
                intent.putExtra(IntroducirDatosActivity.EXTRA_DATO, tvNombreEmpresa.getText().toString());
                startActivityForResult(intent, OPTION_REQUEST_NOMBRE_EMPRESA);
                break;
            case R.id.btnCancelar:
                this.finish();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode != RESULT_CANCELED){
            String datoResultado = intent.getStringExtra(IntroducirDatosActivity.EXTRA_DATO_RESULTADO);
            switch(requestCode){
                case OPTION_REQUEST_NOMBRE:
                    tvNombre.setText(datoResultado);
                    break;
                case OPTION_REQUEST_APELLIDOS:
                    tvApellidos.setText(datoResultado);
                    break;
                case OPTION_REQUEST_NOMBRE_EMPRESA:
                    tvNombreEmpresa.setText(datoResultado);
                    break;
            }
        }
    }
}