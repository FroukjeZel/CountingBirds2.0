package com.example.froukje.countingbirds;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Vrijwilliger extends NavigationDrawer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrijwilliger);
        buildMenu();


        String[] vrijw = new String[]{"Joey Sparidaans", "Thierry Janson", "Froukje Zeldenrust",
                "Mark Schevers"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vrijw);
        final ListView listView = (ListView) findViewById(R.id.lijst);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String user = (String)parent.getItemAtPosition(position);
                System.out.println("Output: "+user);

                Intent intent = new Intent(Vrijwilliger.this, Profiel.class);
                startActivity(intent);

                /*if (position == 0) {
                    String input = "Joey Sparidaans";
                    Intent intent = new Intent(Vrijwilliger.this, Profiel.class);
                    intent.putExtra("Input", input);
                    startActivity(intent);
                }

                if (position == 1) {
                    String input = "Thierry Janson";
                    Intent intent = new Intent(Vrijwilliger.this, Profiel.class);
                    intent.putExtra("Input", input);
                    startActivity(intent);
                }

                if (position == 2) {
                    String input = "Froukje Zeldenrust";
                    Intent intent = new Intent(Vrijwilliger.this, Profiel.class);
                    intent.putExtra("Input", input);
                    startActivity(intent);
                }

                if (position == 3) {
                    String input = "Mark Schevers";
                    Intent intent = new Intent(Vrijwilliger.this, Profiel.class);
                    intent.putExtra("Input", input);
                    startActivity(intent);
                }*/

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vrijwilliger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_calendar) {
            Intent intent = new Intent(this, Kalender.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
