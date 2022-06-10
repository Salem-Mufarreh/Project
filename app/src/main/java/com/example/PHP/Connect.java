package com.example.PHP;

import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connect extends AsyncTask{



    @Override
    protected Object doInBackground(Object[] objects) {
        String connt = "http://127.0.0.1:800/config.php";
        System.out.println("here");
        try {
            URL url = new URL(connt);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
