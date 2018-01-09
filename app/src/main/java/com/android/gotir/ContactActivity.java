package com.android.gotir;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    private EditText smsBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        smsBody = (EditText) findViewById(R.id.smsme);
    }
    public void call(View view) {
        Uri number = Uri.parse("tel:085709027216");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void sms(View view) {
        String phone_number = "085709027216";
        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone_number));
        smsSIntent.putExtra("sms_body", smsBody.getText().toString());
        try {
            startActivity(smsSIntent);
        } catch (Exception ex) {
            Toast.makeText(ContactActivity.this, "Pengiriman SMS Gagal", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
    public void lokasi(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = getString(R.string.lokasitext);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

