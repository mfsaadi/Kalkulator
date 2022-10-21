package com.example.kalkulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class segitigaFragment extends Fragment {
    private EditText txt_alas, txt_tinggi;
    private Button btnHasil;
    private TextView luas;
    private TextView keliling;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_segitiga, container, false);
        txt_alas = v.findViewById(R.id.txt_alas);
        txt_tinggi = v.findViewById(R.id.txt_tinggi);
        btnHasil = v.findViewById(R.id.btnHasil);
        luas = v.findViewById(R.id.luas);
        keliling = v.findViewById(R.id.keliling);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = txt_alas.getText().toString();
                String nilai2 = txt_tinggi.getText().toString();

                if(nilai1.isEmpty()){
                    txt_alas.setError("Data tidak boleh kosong");
                    txt_alas.requestFocus();
                }
                else if(nilai2.isEmpty()){
                    txt_tinggi.setError("Data tidak boleh kosong");
                    txt_tinggi.requestFocus();
                }
                else{
                    Double alas = Double.parseDouble(nilai1);
                    Double tinggi = Double.parseDouble(nilai2);

                    Double l = alas * tinggi * 0.5;
                    Double c = Math.sqrt(Math.pow(0.5*alas,2)+Math.pow(tinggi,2));
                    Double k = alas+(2 * c);
                    luas.setText(String.valueOf(l));
                    keliling.setText(String.valueOf(k));
                }
            }
        });

        return v;
    }
}