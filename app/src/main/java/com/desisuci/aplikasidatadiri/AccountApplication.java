package com.desisuci.aplikasidatadiri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

import android.widget.Toast;
import android.app.DatePickerDialog;
import android.app.Dialog;

import java.util.Calendar;

public class AccountApplication extends AppCompatActivity {
    private RadioGroup radioGroupJK;
    private RadioButton radioButtonJK;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_application);

        dateView = (TextView) findViewById(R.id.txt_tglLahir);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void ActivityDua(View view){
        EditText ubah = (EditText) findViewById(R.id.txt_nama);
        String pesan = ubah.getText().toString();
        Intent intent = new Intent (this, LoginActivity.class);
        intent.setData(Uri.parse(pesan));
        startActivity(intent);
    }

    public void sendExtras(View view) {
        EditText nm = (EditText) findViewById(R.id.txt_nama);
        String nama = nm.getText().toString();
        EditText eml = (EditText) findViewById(R.id.txt_email);
        String email = eml.getText().toString();
        EditText pass = (EditText) findViewById(R.id.txt_password);
        String password = pass.getText().toString();
        Intent intent = new Intent(this, LoginActivity.class);

        intent.putExtra("Desi", nama);
        intent.putExtra("Gmail", email);
        intent.putExtra("Pass", password);

    }

    public void sendExtrasBundle(View view){
        EditText nm = (EditText) findViewById(R.id.txt_nama);
        String nama = nm.getText().toString();
        EditText eml = (EditText) findViewById(R.id.txt_email);
        String email = eml.getText().toString();
        EditText pass = (EditText) findViewById(R.id.txt_password);
        String password = pass.getText().toString();
        EditText almt = (EditText) findViewById(R.id.txt_address);
        String alamat = almt.getText().toString();
        radioGroupJK = (RadioGroup) findViewById(R.id.radioGroupJenisKelamin);
        int selectId = radioGroupJK.getCheckedRadioButtonId();
        radioButtonJK = (RadioButton)findViewById(selectId);
        String JK = radioButtonJK.getText().toString();
        EditText tl = (EditText) findViewById(R.id.txt_tempatLahir);
        String tempat = tl.getText().toString();
        EditText tgl = (EditText) findViewById(R.id.txt_tglLahir);
        String tanggal = tgl.getText().toString();
        Intent intent = new Intent(this, LoginActivity.class);

        Bundle data = new Bundle();
        intent.putExtra("Desi", nama);
        intent.putExtra("Gmail", email);
        intent.putExtra("Pass", password);
        intent.putExtra("Jenis Kelamin", JK);
        intent.putExtra("Tempat Lahir", tempat);
        intent.putExtra("Tanggal Lahir", tanggal);
        intent.putExtra("Alamat",alamat);

        // intent.putExtra(data);
        startActivity(intent);
    }
}
