package com.currency;


import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class XMLMainActivity extends ListActivity {
	
	private static final String URL_ADDRESS = "http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listactivity);
		
		
		JDOMParser parser = new JDOMParser();
		List<CurrencyModel> currModels = parser.parseXML();
		ArrayAdapter<CurrencyModel> adapter = new ArrayAdapter<CurrencyModel>(this, 
				android.R.layout.simple_list_item_1, currModels);
				
			
			setListAdapter(adapter);
		
	}
	public void onUpdate(View view){
		new DownloadFileFromURL().execute(URL_ADDRESS);
	}
	public void onRead(View view){
		Intent refresh = new Intent(this, XMLMainActivity.class);
		startActivity(refresh);
		this.finish();
	
	}

}