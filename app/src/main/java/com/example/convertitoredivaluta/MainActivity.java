package com.example.convertitoredivaluta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String check = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View v){
        EditText inp_1 = (EditText) findViewById(R.id.input_1);
        TextView out = (TextView) findViewById(R.id.txt_out);
        TextView mainText = (TextView) findViewById(R.id.txt_main);

        double eur, usd, conv = 0;
        String currency = "";

        if(inp_1.getText().toString().matches("")){
            Toast.makeText(this, "Scegli la Valuta e/o Immetti un numero", Toast.LENGTH_SHORT).show();
            return;
        }
        if(check.contains("EUR")){
            eur = Double.parseDouble(inp_1.getText().toString());
            conv = Math.round(eur * 1.07);
            currency = "€ ";
        }
        if(check.contains("USD")){
            usd = Double.parseDouble(inp_1.getText().toString());
            conv = Math.round(usd * 0.93);
            currency = "$ ";
        }

        out.setText(currency + String.valueOf(conv));
    }

    public void checkStatus(View v){
        TextView mainText = (TextView) findViewById(R.id.txt_main);
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.rbtn_eur:
                if(checked){
                    check = "EUR";
                    mainText.setText(R.string.txt_eurusd);
                    Log.e("MainActivity", check);
                }
                break;
            case R.id.rbtn_usd:
                if(checked){
                    check = "USD";
                    mainText.setText(R.string.txt_usdeur);
                    Log.e("MainActivity", check);
                }
                break;
        }

        //notifica che appare in basso
        Toast.makeText(getApplicationContext(), check, Toast.LENGTH_SHORT).show();
    }
}