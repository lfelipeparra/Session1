package com.parra.lfelipe.session1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText eNombre, eApellido, eCorreo, eCelular;
    private TextView tInfo;
    private Button bRegistrar;
    private String nombre, apellido, sexo="Masculino", hobbies="", celular, correo, cuidad;
    private CheckBox cCine, cComer, cDeporte, cDormir;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);
        tInfo = (TextView) findViewById(R.id.tInfo);
        cCine = (CheckBox) findViewById(R.id.cCine);
        cComer = (CheckBox) findViewById(R.id.cComer);
        cDeporte = (CheckBox) findViewById(R.id.cDeporte);
        cDormir = (CheckBox) findViewById(R.id.cDormir);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        spinner = (Spinner) findViewById(R.id.sCuidad);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cuidad_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cuidad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Registrar(View view) {
        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        celular = eCelular.getText().toString();
        correo = eCorreo.getText().toString();

        hobbies = "";
        if (cCine.isChecked()) {hobbies = hobbies + " " + "Cine";}
        if (cComer.isChecked()) {hobbies = hobbies + " " + "Comer";}
        if (cDeporte.isChecked()) {hobbies = hobbies + " " + "Deporte";}
        if (cDormir.isChecked()) {hobbies = hobbies + " " + "Dormir";}

        tInfo.setText("Nombre: "+nombre+
                      "\nApellido: "+apellido+
                      "\nSexo: "+sexo+
                      "\nHobbies: "+hobbies+
                      "\nCorreo: "+correo+
                      "\nCelular: "+celular+
                      "\nCuidad: "+cuidad);
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();
        if (id == R.id.rMasculino){
            sexo = "Masculino";
        }
        if (id == R.id.rFemenino){
            sexo = "Femenino";
        }
    }
}
