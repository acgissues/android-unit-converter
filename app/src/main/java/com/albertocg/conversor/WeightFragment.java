package com.albertocg.conversor;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class WeightFragment extends Fragment {

    // 0 = Gramos
    // 1 = Kilogramos
    // 2 = Onzas
    // 3 = Libras
    private int unidad = 0;
    private WeightConverter weightConverter = new WeightConverter();

    public WeightFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Spinner spWeight = (Spinner) view.findViewById(R.id.spWeight);
        final EditText txtWeight = (EditText) view.findViewById(R.id.txtWeight);
        final TextView grams = (TextView) view.findViewById(R.id.lblGrams);
        final TextView kgrams = (TextView) view.findViewById(R.id.lblKGrams);
        final TextView ounces = (TextView) view.findViewById(R.id.lblOunces);
        final TextView pounds = (TextView) view.findViewById(R.id.lblPounds);

        Button clear = (Button) view.findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtWeight.getText().clear();
                grams.setText("Gramos: 0.00");
                kgrams.setText("Kilogramos: 0.00");
                ounces.setText("Onzas: 0.00");
                pounds.setText("Libras: 0.00");
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.weights_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeight.setAdapter(adapter);
        spWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unidad = position;
                if(!txtWeight.getText().toString().matches("")) {
                    switch (position) {
                        case 0: // Gramos
                            weightConverter.setGrams(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                        case 1: // Kilogramos
                            weightConverter.setGrams(Double.parseDouble(txtWeight.getText().toString()) * 1000);
                            break;
                        case 2: // Onzas
                            weightConverter.setOunces(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                        case 3: // Libras
                            weightConverter.setPounds(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                    }
                    grams.setText("Gramos: " + String.valueOf(weightConverter.getGrams()) + "g");
                    kgrams.setText("Kilogramos: " + String.valueOf(weightConverter.getKgrams()) + "Kg");
                    ounces.setText("Onzas: " + String.valueOf(weightConverter.getOunces()) + "oz");
                    pounds.setText("Libras: " + String.valueOf(weightConverter.getPounds()) + "lb");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtWeight.getText().toString().matches("")){
                    switch(unidad) {
                        case 0:
                            weightConverter.setGrams(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                        case 1:
                            weightConverter.setGrams(Double.parseDouble(txtWeight.getText().toString()) * 1000);
                            break;
                        case 2:
                            weightConverter.setOunces(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                        case 3:
                            weightConverter.setPounds(Double.parseDouble(txtWeight.getText().toString()));
                            break;
                        }
                    grams.setText("Gramos: " + String.valueOf(weightConverter.getGrams()) + "g");
                    kgrams.setText("Kilogramos: " + String.valueOf(weightConverter.getKgrams()) + "Kg");
                    ounces.setText("Onzas: " + String.valueOf(weightConverter.getOunces()) + "oz");
                    pounds.setText("Libras: " + String.valueOf(weightConverter.getPounds()) + "lb");
                }else{
                        Toast.makeText(getActivity(), "Campos limpiados", Toast.LENGTH_SHORT).show();
                    }
                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weight, container, false);
    }

}
