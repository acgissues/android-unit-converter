package com.albertocg.conversor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DistanceFragment extends Fragment {
    // 0 = centrimetros - pulgadas
    // 1 = metros - pies
    // 2 = kilometros - millas
    private int unidad = 0;
    private DistanceConverter distanceConverter = new DistanceConverter();

    public DistanceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final TextView result = (TextView) view.findViewById(R.id.lblResult);
        final EditText distance = (EditText) view.findViewById(R.id.txtDistance);
        Spinner spDistance = (Spinner) view.findViewById(R.id.spDistance);

        final Button firstUnit = (Button) view.findViewById(R.id.unitOne);
        final Button secondUnit = (Button) view.findViewById(R.id.unitTwo);
        Button clear = (Button) view.findViewById(R.id.btnClear);

        clear.setOnClickListener(new View.OnClickListener() { // Limpieza de los campos
            @Override
            public void onClick(View v) {
                result.setText("0.00");
                distance.getText().clear();
                Toast.makeText(getActivity(), "Campos limpiados", Toast.LENGTH_SHORT).show();
            }
        });

        firstUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Acciones del boton izquierdo
                if(!distance.getText().toString().matches("")){
                    switch(unidad) {
                        case 0: // Centrímetros a pulgadas
                            distanceConverter.setCm(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getInch()) + "\"");
                            break;
                        case 1: // Metros a pies
                            distanceConverter.setM(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getFeet()) + "ft");
                            break;
                        case 2: // Kilómetros a millas
                            distanceConverter.setKm(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getMile()) + "mi");
                            break;
                    }
                }
            }
        });

        secondUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Acciones del botón derecho
                if(!distance.getText().toString().matches("")){
                    switch(unidad) {
                        case 0: // Pulgadas a Centímetros
                            distanceConverter.setInch(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getCm()) + "cm");
                            break;
                        case 1: // Pies a Metros
                            distanceConverter.setFeet(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getM()) + "m");
                            break;
                        case 2: // Millas a kilómetros
                            distanceConverter.setMile(Double.parseDouble(distance.getText().toString()));
                            result.setText(String.valueOf(distanceConverter.getKm()) + "Km");
                            break;
                    }
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.distance_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDistance.setAdapter(adapter);

        // Se actualizan los textos de los botones
        spDistance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unidad = position;
                result.setText("");
                switch(position) {
                    case 0:
                        firstUnit.setText("cm -> pulgadas");
                        secondUnit.setText("pulgadas -> cm");
                        break;
                    case 1:
                        firstUnit.setText("m -> pies");
                        secondUnit.setText("pies -> m");
                        break;
                    case 2:
                        firstUnit.setText("km -> millas");
                        secondUnit.setText("millas -> km");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }


}
