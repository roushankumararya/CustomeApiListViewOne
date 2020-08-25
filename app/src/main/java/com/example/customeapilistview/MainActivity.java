package com.example.customeapilistview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.customeapilistview.model.MyPojo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private static final String tag = MainActivity.class.getSimpleName();
    String URL="https://jsonplaceholder.typicode.com/users";
    private MyPojo[] list ;
    private ListView listView;
    private com.example.customeapilistview.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);



        JsonArrayRequest jsonreq = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            String srt=response.toString(4);
                            MyPojo[] customapilistview=(MyPojo[]) new Gson().fromJson(srt,MyPojo[].class);
                            adapter=new Adapter(MainActivity.this,customapilistview);
                            // adapter = new Adapter(this, list);
                            listView.setAdapter((ListAdapter) adapter);
                            Log.e("ttttt",""+customapilistview);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyData();
                       // adapter.notify();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder add = new AlertDialog.Builder(MainActivity.this);
                add.setMessage(error.getMessage()).setCancelable(true);
                AlertDialog alert = add.create();
                alert.setTitle("Error!!!");
                alert.show();
            }
        });
      //
        Controller.getPermission().addToRequestQueue(jsonreq);
    }

//        customlistviewapiresponse();

    }
