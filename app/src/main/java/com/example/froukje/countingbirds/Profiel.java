package com.example.froukje.countingbirds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Profiel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiel);

        //Bundle b = getIntent().getExtras();
        //String naam = b.getString("Input");

        EditText naamVrijw = (EditText) findViewById(R.id.naamVrijw);
        EditText postcodeVrijw = (EditText) findViewById(R.id.postcodeVrijw);
        EditText huisnummerVrijw = (EditText) findViewById(R.id.huisnummerVrijw);
        EditText emailVrijw = (EditText) findViewById(R.id.emailVrijw);
        EditText telVrijw = (EditText) findViewById(R.id.telVrijw);

        /*switch (naam) {
            case "Joey Sparidaans":
                naamVrijw.setText("Joey Sparidaans");
                postcodeVrijw.setText("5941 JP");
                huisnummerVrijw.setText("51");
                emailVrijw.setText("jsparidaans@gmail.com");
                telVrijw.setText("0653498844");
                break;

            case "Thierry Janson":
                naamVrijw.setText("Thierry Janson");
                postcodeVrijw.setText("5941 JP");
                huisnummerVrijw.setText("51");
                emailVrijw.setText("jsparidaans@gmail.com");
                telVrijw.setText("0653498844");
                break;

            case "Froukje Zeldenrust":
                naamVrijw.setText("Froukje Zeldenrust");
                postcodeVrijw.setText("5941 JP");
                huisnummerVrijw.setText("51");
                emailVrijw.setText("jsparidaans@gmail.com");
                telVrijw.setText("0653498844");
                break;

            case "Mark Schevers":
                naamVrijw.setText("Mark Schevers");
                postcodeVrijw.setText("5941 JP");
                huisnummerVrijw.setText("51");
                emailVrijw.setText("jsparidaans@gmail.com");
                telVrijw.setText("0653498844");
                break;

        }*/

    }
}
