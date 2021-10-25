package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static int OPTION_REQUEST_CONTACTO = 0;
    private TextView tvAgenda;
    private Button btnNuevo;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos las variables para poder dar funcionalidad a los botones de la Actividad
        tvAgenda = findViewById(R.id.tvAgenda);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnSalir = findViewById(R.id.btnSalir);

        //Hacemos que cuando se pulse "Nuevo", abrir la Actividad correspondiente para crear un nuevo contacto
        btnNuevo.setOnClickListener(this);

        //Hacemos que cuando se pulse "Salir" se cierre la aplicación
        btnSalir.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNuevo:
                Intent intent = new Intent(this, NuevoContactoActivity.class);
                startActivityForResult(intent, OPTION_REQUEST_CONTACTO);
                break;
            case R.id.btnSalir:
                this.finish();
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode != RESULT_CANCELED && requestCode == OPTION_REQUEST_CONTACTO){
            String contactoResultado = intent.getStringExtra(NuevoContactoActivity.EXTRA_RESULTADO_CONTACTO);
            if(tvAgenda.getText().length() == 0) {
                tvAgenda.setText(contactoResultado);
            }
            else{
                tvAgenda.append("\n" + contactoResultado);
            }
        }
    }
}
