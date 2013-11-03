package com.example.currencyparser.main;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.example.currencyparser.parser.AutoClassObject;
import com.example.currencyparser.parser.JDomparserClass;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		JDomparserClass parser = new JDomparserClass();
		List<AutoClassObject> currList = parser.parseXML(this);
		
		ArrayAdapter<AutoClassObject> adapter = new ArrayAdapter<AutoClassObject>(this, 
				android.R.layout.simple_list_item_1, currList);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
