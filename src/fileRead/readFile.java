package fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class readFile {
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> lstMap = new HashMap<String, ArrayList<String>>();
		try {
			File lstFile = new File("");
			if(lstFile.isDirectory()) {
				//
			} else if(lstFile.isFile()) {
				BufferedReader isr1 = new BufferedReader(new FileReader(lstFile.getAbsolutePath()));
			}
			
			InputStream is = new FileInputStream("/home/ubuntu/project/fil1.txt");
			BufferedReader isr = new BufferedReader(new InputStreamReader(is));
			while(true) {
				String strLine = isr.readLine();
				//break the loop if the end of file
				if (strLine == null) break;
				//otherwise store the information in map
				if(!strLine.equals("")) {
					//it has correct format, otherwise do nothing
					if((strLine.split(",")).length > 1) {
						//get the first part as the key in Map
						String strKey = strLine.substring(0, strLine.indexOf(","));
						//get the other parst as the value in map
						String strValue = strLine.substring(strLine.indexOf(",") + 1);
						//store it in Map
						//save it in map if it not exist
						if(!lstMap.containsKey(strKey)) {
							ArrayList lstValue = new ArrayList(Arrays.asList(strValue.split(",")));
							lstMap.put(strKey, lstValue);
						} else {
							//reorganize the value in map if it alread exist
							ArrayList lstValue = lstMap.get(strKey);
							lstValue.addAll(new ArrayList(Arrays.asList(strValue.split(","))));
						}
						
					}
				}
			}
			lstMap.entrySet().forEach(item->System.out.println(item.getKey()+"::" +item.getValue().toString()));
			for(Map.Entry<String, ArrayList<String>> entry : lstMap.entrySet()){
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
