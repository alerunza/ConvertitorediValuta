package com.example.convertitoredivaluta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View v){
        EditText inp_1 = (EditText) findViewById(R.id.input_1);
        TextView out = (TextView) findViewById(R.id.txt_out);

        double eur, conv;
        eur = Double.parseDouble(inp_1.getText().toString());

        conv = Math.round(eur * 1.07);

        out.setText("$ " + String.valueOf(conv));
    }
}