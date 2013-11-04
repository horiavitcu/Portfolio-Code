package com.currency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

public class DownloadFileFromURL extends AsyncTask<String, String, String> {
	
	/**
	 * Downloading file in background thread
	 * */
	
	@Override
	protected String doInBackground(String... f_url) {
        try {
        	
        	File sdcard = Environment.getExternalStorageDirectory();
            
        	File dest_file = new File(sdcard, "tbutton.xml");
        	
            URL u = new URL(f_url[0]);
            URLConnection conn = u.openConnection();
            
            int contentLength = conn.getContentLength();
            DataInputStream stream = new DataInputStream(u.openStream());
            byte[] buffer = new byte[contentLength];
            stream.readFully(buffer);
            stream.close();
            DataOutputStream fos = new DataOutputStream(new FileOutputStream(dest_file));
            fos.write(buffer);
            fos.flush();
            fos.close();
        	
            
        } catch (Exception e) {
        	Log.e("Error: ", e.getMessage());
        }
        
        return null;
        
	}

}