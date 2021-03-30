package com.desisuci.aplikasidatadiri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //get intent
        Intent intent = getIntent();

        //get extra with bundle
        Bundle data = intent.getExtras();
        String nama = data.getString("Desi");
        String email = data.getString("Gmail");
        String password = data.getString("Pass");
        String alamat = data.getString("Alamat");
        String JK = data.getString("Jenis Kelamin");
        String tempat = data.getString("Tempat Lahir");
        String tanggal = data.getString("Tanggal Lahir");


        //give data to name
        TextView nm = (TextView) findViewById(R.id.labelNama);
        nm.setText(nama);
        TextView eml = (TextView) findViewById(R.id.labelEmail);
        eml.setText(email);
        TextView pass = (TextView) findViewById(R.id.labelPass);
        pass.setText(password);
        TextView jk = (TextView) findViewById(R.id.labelJenisKelamin);
        jk.setText(JK);
        TextView tl = (TextView) findViewById(R.id.labelTempatLahir);
        tl.setText(tempat);
        TextView tgl = (TextView) findViewById(R.id.labelTanggalLahir);
        tgl.setText(tanggal);
        TextView almt = (TextView) findViewById(R.id.labelAlamat);
        almt.setText(alamat);

    }
}
