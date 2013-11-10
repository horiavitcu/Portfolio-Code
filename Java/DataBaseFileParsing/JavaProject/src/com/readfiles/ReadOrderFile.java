package com.readfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.simpleobjects.OrderObject;

public class ReadOrderFile {
	
	private final static String FILE_NAME = "/Order.txt";
	
	public List<OrderObject> readLines() throws IOException {
		
		
		InputStream input = ReadOrderFile.class.getResourceAsStream(FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(input, "UTF-8")));
        
        List<String> lines = new ArrayList<String>();
        
        List<OrderObject> orders = new ArrayList<OrderObject>();
        
        String line = null;
        
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        
        String barSeparated = lines.toString().replace("|", ",").replace(" ", "").
        		replace("[", "").replace("]", "");
        
        
        ArrayList<String> fullBarList = 
        		new  ArrayList<String>(Arrays.asList(barSeparated.split("\\s*,\\s*")));
        

        	int iterator = 0;
        	while (iterator < fullBarList.size()) {
				
        		OrderObject order = new OrderObject();
        		
        		order.setOrderId(parseInt(fullBarList.get(iterator)));
        		order.setOrderNumber(parseInt(fullBarList.get(iterator + 1)));
        		order.setPersonId(parseInt(fullBarList.get(iterator + 2)));
        		orders.add(order);
        		iterator += 3;
        		
			}
        	
        	
        bufferedReader.close();
        input.close();
        return orders;
    }
	public Integer parseInt(String data) {
		  Integer val = null;
		  try {
		    val = Integer.parseInt(data);
		  } catch (NumberFormatException nfe) { }
		  return val;
		}
}
	
	
