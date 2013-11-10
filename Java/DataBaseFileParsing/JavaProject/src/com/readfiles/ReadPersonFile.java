package com.readfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.simpleobjects.PersonObject;

public class ReadPersonFile {
	
	private final static String FILE_NAME = "/Person.txt";
	
	public List<PersonObject> readLines() throws IOException {
		
        InputStream input = ReadPersonFile.class.getResourceAsStream(FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(input, "UTF-8")));
        
        List<String> lines = new ArrayList<String>();
        
        List<PersonObject> persons = new ArrayList<PersonObject>();
        
        String line = null;
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        
        String commaSeparated = lines.toString().replace(" ,", "").
        		replace("[", "").replace("]", "").replace(" ", "");
        ArrayList<String> fullCommaList = 
        		new  ArrayList<String>(Arrays.asList(commaSeparated.split("\\s*,\\s*")));
    
        	int iterator = 0;
        	while (iterator < fullCommaList.size()) {
				
        		PersonObject person = new PersonObject();
        		
        		person.setPersonId(fullCommaList.get(iterator));
        		person.setFirstName(fullCommaList.get(iterator + 1));
        		person.setLastName(fullCommaList.get(iterator + 2));
        		person.setStreet(fullCommaList.get(iterator + 3));
        		person.setCity(fullCommaList.get(iterator + 4));
        		persons.add(person);
        		iterator += 5;
			}
        	
        bufferedReader.close();
        input.close();
        return persons;
    }
	
}
	
	
