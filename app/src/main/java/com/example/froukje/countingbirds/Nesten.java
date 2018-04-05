package com.example.froukje.countingbirds;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class Nesten extends NavigationDrawer {

    DataReader dr = new DataReader();
    String planId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nesten);
        buildMenu();

        Button ZoekButton = (Button) findViewById(R.id.buttonZoek);
        ZoekButton.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    EditText et = (EditText) findViewById(R.id.planIdZoek);
                    planId = et.getText().toString();
                    getDataSearch(dr.getStrIp());
            }
            });


        getData(dr.getStrIp());

    }

    private void getData(String strIp) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = strIp +"/weidevogelsBE/webresources/appweidevogels.nestelegsel" ;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        uitLezen(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        queue.add(stringRequest);


        //String response is het resultaat van de query (in xml format)

    }

    private void getDataSearch(String strIp) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = strIp +"/weidevogelsBE/webresources/appweidevogels.nestelegsel/planid=" + planId ;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        uitLezen(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        queue.add(stringRequest);


    }

    private void uitLezen(String response) {

        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList legsels = doc.getElementsByTagName("nestelegsels");
            NodeList alLegsels = (legsels.item(0)).getChildNodes();
            ArrayList<String> theLegsel = new ArrayList<>();
            for (int i = 0; i < alLegsels.getLength(); i++) {
                Node n = alLegsels.item(i);
                Node ei = n.getChildNodes().item(1);
                Node legselNr = n.getChildNodes().item(3).getChildNodes().item(0);
                Node soort = n.getChildNodes().item(4).getChildNodes().item(0);

                String strResult = "NestNr. " + legselNr.getTextContent() +": " + soort.getTextContent() +" ("+ ei.getTextContent() +")";
                theLegsel.add(strResult);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theLegsel);
            ListView lv = (ListView) findViewById(R.id.lvNest);
            lv.setAdapter(adapter);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
