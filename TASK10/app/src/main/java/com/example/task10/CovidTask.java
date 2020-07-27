package com.example.task10;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class CovidTask extends AsyncTask<String,Void,String> {


    String myUrl = "https://api.covid19api.com/dayone/country/IN";

    Context context;

    RecyclerView result;
    ArrayList<CovidModel> models;

    public CovidTask(MainActivity mainActivity, RecyclerView rv, ArrayList<CovidModel> covidModels) {
        context = mainActivity;
        result = rv;
        models = covidModels;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            // for getting Url
            URL url= new URL(myUrl);

            // For Checking Internet
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

            //  for getting  Input
            InputStream inputStream= urlConnection.getInputStream();

            // for Reading Input
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("aa");
            if (scanner.hasNext()){
                return scanner.next();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

        try {
            JSONArray jsonArray = new JSONArray(s);
            for(int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String date = jsonObject.getString("Date");
                String active = jsonObject.getString("Active");
                String recovered = jsonObject.getString("Recovered");
                String deaths = jsonObject.getString("Deaths");
                String confirmed = jsonObject.getString("Confirmed");

                CovidModel covidModel = new CovidModel(date, active, recovered, deaths, confirmed);
                models.add(covidModel);
            }
            result.setLayoutManager(new LinearLayoutManager(context));
            result.setAdapter(new CovidAdapter((MainActivity) context,models));

            //Toast.makeText(context, date+"\n"+active+"\n"+recovered+"\n"+deaths+"\n"+confirmed, Toast.LENGTH_SHORT).show();
            //result.setText(date+"\n"+active+"\n"+recovered+"\n"+deaths+"\n"+confirmed);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
