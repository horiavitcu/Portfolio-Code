package com.currency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.view.View;

	public class ReadWebpageAsyncTask extends AsyncTask<String, Void, String> {
		
		private static final String URL_ADDRESS = "http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml";
		
    @Override
    protected String doInBackground(String... urls) {
      String response = "";
      for (String url : urls) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
          HttpResponse execute = client.execute(httpGet);
          InputStream content = execute.getEntity().getContent();

          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
          String s = "";
          while ((s = buffer.readLine()) != null) {
            response += s;
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return response;
    }

    @Override
    protected void onPostExecute(String result) {
    }

//  public void onClick(View view) {
//    ReadWebpageAsyncTask task = new ReadWebpageAsyncTask();
////    task.execute(new String[] { "http://www.vogella.de" });
//    task.execute(new String[] { URL_ADDRESS });
//
//  }
} 