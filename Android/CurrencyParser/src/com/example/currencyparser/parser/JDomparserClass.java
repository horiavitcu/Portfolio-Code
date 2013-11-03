package com.example.currencyparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import android.content.Context;
import android.util.Log;

import com.example.currencyparser.main.R;
public class JDomparserClass {

	private static final String LOGTAG = "CURRENCYPARSER";
//	private static final String CUBE = "Cube";
	
	private static final String AUTOMOBIL = "automobil";
	private static final String ENGLISH = "english";
	private static final String POLISH = "polish";
	
	public List<AutoClassObject> parseXML(Context context) {

		InputStream stream = context.getResources().openRawResource(R.raw.tours);
		SAXBuilder builder = new SAXBuilder();
		List<AutoClassObject> autoOBJList = new ArrayList<AutoClassObject>();

		try {

			Document document = (Document) builder.build(stream);
			org.jdom2.Element rootNode = document.getRootElement();
			List<org.jdom2.Element> list = rootNode.getChildren(AUTOMOBIL);

			for (Element node : list) {
				AutoClassObject autoObject = new AutoClassObject();
				autoObject.setEnglish(node.getChildText(ENGLISH));
				autoObject.setEnglish(node.getChildText(POLISH));
				
				autoOBJList.add(autoObject);
			}

		} catch (IOException e) {
			Log.i(LOGTAG, e.getMessage());
		} catch (JDOMException e) {
			Log.i(LOGTAG, e.getMessage());
		}
		return autoOBJList;
	}
	
}
