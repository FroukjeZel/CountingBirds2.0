package com.example.froukje.countingbirds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BedrijfActivity extends NavigationDrawer {

    private ListView lvUpper;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedrijf);
        buildMenu();

        lvUpper = (ListView) findViewById(R.id.lvUpper);

        String[] planets = new String[]{"Baalen, C.A van", "Baalen, J.A./H.G van", "Baalen, L.", "Boesterd, W en A den", "Bos, B", "Bosch, P van den", "Bruyn, A.F de ",
                "Gameren, H van ", "Heiningen / SBB, H van ", "Hertog, E den ", "Jongh, C de ", "Kardol, L.H ", "Kock, A ,", "Kool, F ", "Land, T.L van't ", "Laponder, A ", "Noord, T van ",
                "Oort, H van ", "Pippel, H ", "Pippel, T ", "Satter, H ", "Noord, J van ", "Vervoorn, G ", "Vervoorn-Van Ooijen, A ", "Zandwijk, A en H van ", "Zandwijk, H van",
                "Zandwijk, K van "};
        ArrayList<String> bedrijfList = new ArrayList<String>();
        bedrijfList.addAll(Arrays.asList(planets));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bedrijfList);

        lvUpper.setAdapter(listAdapter);


        ListView lv = (ListView) findViewById(R.id.lvUpper);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getBedrijfNaam = adapterView.getAdapter().getItem(i).toString();
            }
        });
    }
}
