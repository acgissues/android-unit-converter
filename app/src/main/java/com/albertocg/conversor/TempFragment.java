package com.albertocg.conversor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TempFragment extends Fragment {

    private TemperatureConverter tempConverter = new TemperatureConverter();

    public TempFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstaceState) {
        final EditText txtTemp = (EditText) view.findViewById(R.id.txtTemp);
        final Button btnToCelsius = (Button) view.findViewById(R.id.toCelsius);
        Button btnToFahren = (Button) view.findViewById(R.id.toFahrenheit);
        final TextView result = (TextView) view.findViewById(R.id.lblResult);
        Button clear = (Button) view.findViewById(R.id.btnClear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTemp.getText().clear();
            }
        });

        btnToFahren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtTemp.getText().toString().matches("")){
                    tempConverter.setCelsius(Float.parseFloat(txtTemp.getText().toString()));
                    result.setText(String.valueOf(tempConverter.getFahrenheit()) + "F");
                }else{
                    Toast.makeText(getActivity(), "Introduce un valor válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtTemp.getText().toString().matches("")){
                    tempConverter.setFahrenheit(Float.parseFloat(txtTemp.getText().toString()));
                    result.setText(String.valueOf(tempConverter.getCelsius()) + "C°");
                }else{
                    Toast.makeText(getActivity(), "Introduce un valor válido", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temp, container, false);
    }

}
