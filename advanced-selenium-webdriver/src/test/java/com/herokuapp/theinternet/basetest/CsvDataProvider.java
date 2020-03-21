package com.herokuapp.theinternet.basetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CsvDataProvider {
	
	@DataProvider(name="csvReader")
	public static Iterator<Object[]> csvReader(Method method){
		List<Object[]> list = new ArrayList<Object[]>();
//		String filePath = "src"+File.separator + "test"+File.separator+"resources"+File.separator+
//							"dataproviders"+File.separator+"negativelogin"+File.separator+method.getDeclaringClass()+".csv";
		String filePath = "src"+File.separator + "test"+File.separator+"resources"+File.separator+
				"dataproviders"+File.separator+"negativelogin"+File.separator+"loginTest"+".csv";
		File file = new File(filePath);
		
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if(keys != null) {
				String[] data = reader.readNext();
				while(data !=null) {
					String[] dataset = new String[keys.length];
					for(int i =0; i< keys.length;i++) {
						dataset[i]=data[i];
					}
					list.add(dataset);
					data = reader.readNext();
				}
			}
			reader.close();
		}catch(FileNotFoundException e) {
			throw new RuntimeException("File"+filePath+"was not found.");
			
		}catch(IOException e) {
			throw new RuntimeException("could not read "+filePath+"file.");
			
		}
		
		return list.iterator();
	}

}
