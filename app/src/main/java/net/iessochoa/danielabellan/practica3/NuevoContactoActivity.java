package net.iessochoa.danielabellan.practica3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class NuevoContactoActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int OPTION_REQUEST_NOMBRE = 0;
    public final static int OPTION_REQUEST_APELLIDOS = 1;
    public final static int OPTION_REQUEST_NOMBRE_EMPRESA = 2;
    public final static String EXTRA_RESULTADO_CONTACTO = "NuevoContactoActivity.EXTRA_RESULTADO_CONTACTO";

    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvNombreEmpresa;
    private EditText etTelefono;
    private RadioGroup rgTipoTelefono;
    private RadioGroup rgSexo;
    private Switch swFavorito;
    private CheckBox ckbRecordarLlamar;
    private ImageView ivTipoTelefono;
    private ImageView ivSexo;
    private ImageView ivFavoritos;
    private ImageView ivRecordarLlamar;
    private TextView tvNumeroEdad;
    private SeekBar skbNumeroEdad;
    private Button btnOk;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        tvNombre = findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellidos);
        tvNombreEmpresa = findViewById(R.id.tvNombreEmpresa);
        etTelefono = findViewById(R.id.etTelefono);
        rgTipoTelefono = findViewById(R.id.rgTipoTelefono);
        rgSexo = findViewById(R.id.rgSexo);
        swFavorito = findViewById(R.id.swFavorito);
        ckbRecordarLlamar = findViewById(R.id.ckbRecordarLlamar);
        ivTipoTelefono = findViewById(R.id.ivTipoTelefono);
        ivSexo = findViewById(R.id.ivSexo);
        ivFavoritos = findViewById(R.id.ivFavoritos);
        ivRecordarLlamar = findViewById(R.id.ivRecordarLlamar);
        tvNumeroEdad = findViewById(R.id.tvNumeroEdad);
        tvNumeroEdad.setText("Edad : " + getResources().getInteger(R.integer.edadMaxima)/2);
        skbNumeroEdad = findViewById(R.id.skbNumeroEdad);
        skbNumeroEdad.setMax(getResources().getInteger(R.integer.edadMaxima));
        skbNumeroEdad.setProgress(getResources().getInteger(R.integer.edadMaxima)/2);
        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);

        tvNombre.setOnClickListener(this);
        tvApellidos.setOnClickListener(this);
        tvNombreEmpresa.setOnClickListener(this);
        //TODO: Cambio de icono segun el tipo de empresa
        rgTipoTelefono.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbParticular:
                        ivTipoTelefono.setImageResource(R.drawable.ic_particular);
                        break;
                    case R.id.rbEmpresa:
                        ivTipoTelefono.setImageResource(R.drawable.ic_empresa);
                        break;
                }
            }
        });
        //TODO: Cambio de icono segun el sexo del contacto
        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rbMujer:
                        ivSexo.setImageResource(R.drawable.ic_mujer);
                        break;
                    case R.id.rbHombre:
                        ivSexo.setImageResource(R.drawable.ic_hombre);
                        break;
                }
            }
        });
        swFavorito.setOnClickListener(this);
        skbNumeroEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvNumeroEdad.setText("Edad: " + skbNumeroEdad.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Nothing
            }
        });
        ckbRecordarLlamar.setOnClickListener(this);
        btnOk.setOnClickListener(this);
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
            case R.id.swFavorito:
                if(swFavorito.isChecked()){
                    ivFavoritos.setVisibility(View.VISIBLE);
                }
                else{
                    ivFavoritos.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ckbRecordarLlamar:
                if(ckbRecordarLlamar.isChecked()){
                    ivRecordarLlamar.setVisibility(View.VISIBLE);
                }
                else{
                    ivRecordarLlamar.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btnOk:
                if(tvNombre.getText().length() > 0 && tvApellidos.getText().length() > 0 && etTelefono.getText().length() > 0){
                    Intent intentContacto = new Intent(this, MainActivity.class);
                    intentContacto.putExtra(EXTRA_RESULTADO_CONTACTO,tvNombre.getText().toString() + " " + tvApellidos.getText().toString() + " - " + etTelefono.getText().toString());
                    setResult(RESULT_OK,intentContacto);
                    this.finish();
                    break;
                }
                break;
            case R.id.btnCancelar:
                setResult(RESULT_CANCELED);
                this.finish();
                break;
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