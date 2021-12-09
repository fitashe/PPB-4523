package com.example.mysqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listdata);

        tampilkanDataBarang("http://192.168.43.140/service_data.php");
    }

    private void tampilkanDataBarang(final String s) {
        class tampilkanbarang extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    bacaDataKeList(s);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            protected String doInBackground(Void... voids) {
                try{
                    URL url = new URL(s);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));

                    OutputStream os = urlConnection.getOutputStream();
                    String json;
                    while((json = bufferedReader.readLine()) != null)
                    {
                        sb.append(json+"\n");
                    }
                    return sb.toString().trim();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        tampilkanbarang tampil = new tampilkanbarang();
        tampil.execute();

    }

    private void bacaDataKeList(String json)throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String stock[] = new String[jsonArray.length()];
        for (int i=0; i< jsonArray.length(); i++)
        {
            JSONObject obj = jsonArray.getJSONObject(i);
            stock[i]=obj.getString("kode")+ " "+
                    obj.getString("nama_barang")+" "+
                    obj.getString("harga");

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, stock);
        listView.setAdapter(arrayAdapter);
    }
}