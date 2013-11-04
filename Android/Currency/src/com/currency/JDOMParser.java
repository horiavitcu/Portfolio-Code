package com.currency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import android.os.Environment;
import android.util.Log;

public class JDOMParser {
	
	
	private static final String LOGTAG = "CurrParser";
	
	private static final String URL_ADDRESS = "http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml";
	
	private static final String RATE = "rate";
	
	private static final String CURRENCY = "currency";
	
	private String filePath;
	
	public List<CurrencyModel> parseXML() {
		List<CurrencyModel> currModels = new ArrayList<CurrencyModel>();
		

		try {
			
			File data = Environment.getExternalStorageDirectory();
			File inputFile = new File(data, "tbutton.xml");
		    InputStream input = new FileInputStream(inputFile);
//			InputStream inputStream = new URL(URL_ADDRESS).openStream();
			
			
//			StringReader str = new StringReader(new ReadWebpageAsyncTask().execute(URL_ADDRESS).toString());
//			InputSource is = new InputSource(str);
		    SAXBuilder builder = new SAXBuilder();
			
		    Document document = builder.build(input);
            
		    org.jdom2.Element rootNode = document.getRootElement();
		    
			Namespace ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
			
			List<org.jdom2.Element> list = rootNode.getChildren("Cube", ns);
			
			for (int i=0; i<list.size(); i++) {
				
						Element node = list.get(i);
						List<org.jdom2.Element> children = node.getChildren();
						
						for (int j=0; j<children.size(); j++) {
							
							Element child = children.get(j);
							List<org.jdom2.Element> childrensChildren = child.getChildren();
						
						for (int k=0; k<childrensChildren.size(); k++) {
							
							CurrencyModel currModel = new CurrencyModel();
							Element child0 = childrensChildren.get(k);
								
								currModel.setField_symbol(child0.getAttributeValue(RATE));
								currModel.setField_name(child0.getAttributeValue(CURRENCY));
								
								currModels.add(currModel);
						}
			}
			}
		} catch (IOException e) {
			Log.i(LOGTAG, e.getMessage());
		} catch (JDOMException e) {
			Log.i(LOGTAG, e.getMessage());
		}
		return currModels;
	}
}
