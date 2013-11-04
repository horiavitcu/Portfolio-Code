package com.currency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.os.Environment;
import android.util.Log;

public class DownloadFileEasy {
	private static final String URL_ADDRESS = "http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml";
	
	public String ConnectAndDownload(){
		String destination = null;
		try{
			
			File sdcard = Environment.getExternalStorageDirectory();
			
			File dest_file = new File(sdcard, "sdcard/AA.xml");
			destination = dest_file.toString();
			URL u = new URL(URL_ADDRESS);
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
		return destination;
		
	}
}
