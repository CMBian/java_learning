package algorithm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class creditcardApi {

	public static void main(String[] args) {

	    int perPage = 12;
	    List<String> input = new ArrayList<String>();

	    input.add("host_id,listing_id,score,city");

	     input.add("1,28,300.1,San Francisco");

	     input.add("4,5,209.1,San Francisco");

	     input.add("20,7,208.1,San Francisco");

	     input.add("23,8,207.1,San Francisco");

	     input.add("16,10,206.1,Oakland");

	      input.add("1,16,205.1,San Francisco");

	    input.add("1,31,204.6,San Francisco");

	     input.add("6,29,204.1,San Francisco");

	     input.add("7,20,203.1,San Francisco");

	     input.add("8,21,202.1,San Francisco");

	     input.add("2,18,201.1,San Francisco");

	      input.add("2,30,200.1,San Francisco");   

	     input.add("15,27,109.1,Oakland");
	     input.add("15,27,109.1,Oakland");

	     input.add("10,13,108.1,Oakland");

	     input.add("11,26,107.1,Oakland");

	     input.add("12,9,106.1,Oakland");

	   

	      input.add("13,1,105.1,Oakland");

	      input.add("22,17,104.1,Oakland");

	    input.add("1,2,103.1,Oakland");

	      input.add("28,24,102.1,Oakland");

	      input.add("18,14,11.1,San Jose");

	    input.add("6,25,10.1,Oakland");

	    input.add("19,15,9.1,San Jose");

	    input.add("3,19,8.1,San Jose");

	    input.add("3,11,7.1,Oakland");   

	    input.add("27,12,6.1,Oakland");

	    input.add("1,3,5.1,Oakland");

	    input.add("25,4,4.1,San Jose");

	    input.add("5,6,3.1,San Jose");

	    input.add("29,22,2.1,San Jose");

	    input.add("30,23,1.1,San Jose");

	 
	      long startTime = System.nanoTime();
	    List<String> lst = reorderInPage(input, 12);
	    long endTime = System.nanoTime();
	    System.out.println("cost time:" + (endTime - startTime));
	    startTime = System.nanoTime();
	    List<String> lst1 = reorderInPage(input, 12);
	    endTime = System.nanoTime();
	    
	    //List<String> lst = splitByPage(input, 12);
	   System.out.println("cost time:" + (endTime - startTime));
	   System.out.println(lst.size() - 1);
//	   for (String string : lst) {
//		   
//	     System.out.println(string);
//
//	    }
//	    
//	    List<String> lst = new ArrayList<String>();
//	    lst.add("1");
//	    lst.add("2");
//	    lst.add("3");
//	    int i = 0;
//	    while(lst.size() != 0) {
//	    	lst.remove(i);
//	    	i ++;
//	    }
	  }

	  private static List<String> splitByPage(List<String> input, int eleInPage){

	    if(input == null || input.size() <= eleInPage){
	    	
	      return input;

	    }
	    //existing hostid in samepage
	    HashSet<String> existHostSet = new HashSet<String>();
	    //final result
	    List<String> result = new ArrayList<String>();
	    int counter = 0;
	    //remove the header of input
	    input.remove(0);
	    //end flag
	    boolean EndFlg = false;
	    while(!EndFlg){//loop until no enough element in input,
	    	//keep the index have been trated
		    List<Integer> indexs = new ArrayList<Integer>();
	      for(int i =0; i < input.size(); i++){
	         String[] strs = input.get(i).split(",");
	          if(existHostSet.add(strs[0])){
	            //if not exist add it to result
	            result.add(input.get(i));
	            //remove the element from input list
	            indexs.add(i);
	            //keep the ccounter
	            counter = counter + 1;
	            if(counter == eleInPage){
		            //if page is full, reset go to next round loop;
		            result.add("############Page Break##########");
		            counter = 0;
		            if(input.size() - eleInPage <= eleInPage)
		            	//the rest shold be on last page, it should be finshed
		              EndFlg = true;
		            
		            break;
		          }
	          }
	          
	      }
	      //reset the input and existing check
	      //TODO: reset the existing check will cause the duplicate hostid in another round
	      //but it depends on the requirement
	      existHostSet.clear();
	      //revmove the element already be in result list
	      List<String> strNewList = new ArrayList<String>();
	      for(int i = 0; i < input.size(); i++){
	    	  if(!indexs.contains(i))
	    		  strNewList.add(input.get(i));
	      }
	      input = strNewList;
	    }
	    //add the rest input to result list
	    if(input.size() != 0 ){
	      for(int i = 0; i < input.size(); i++){
	        result.add(input.get(i));
	      }
	    }
	    return result;

	  }
	  
	  private static List<String> reorderInPage(List<String> input, int eleInPage){
		  List<String> resultLst = new ArrayList<String>();
		  if(input == null || input.size() <= eleInPage){
		      return input;
		  }
		  input.remove(0);
		  Iterator<String> it = input.iterator();
		  
		  HashSet<String> existingHost = new HashSet<String>();
		  int counter = 0;
		  while(it.hasNext()) {
			  String strCurrentEle = it.next();
			  String hostId = strCurrentEle.split(",")[0];
			  if(existingHost.add(hostId)){
	            //if not exist add it to result
			  	resultLst.add(strCurrentEle);
			  	it.remove();
			  	//TODO:biz requirement dependends
			  	counter = counter + 1;
	            //if(existingHost.size() == eleInPage) {
			  	if(counter == eleInPage) {
	            	resultLst.add("########Page Break################");
	            	existingHost.clear();
	            	counter = 0;
	            	if(input.size() <= eleInPage) {
		        		  resultLst.addAll(input);
		        		  break;
		        	}
	            }
	            it = input.iterator();
	          } else if(!it.hasNext()) {//to the end of list
	        	//we need clear the existing host otherwise it will be a dead loop
	        	  //TODO: if we clean it, it may have duplcate hostid in list, it depends on 
	        	  //biz requirement, 
	        	  //option 1: if we can break page no more than 12, we can add break here.
	        	  //option 2: allow the duplicate host id in same page.
	        	  existingHost.clear();
	        	  it = input.iterator();
			  }
		  }
		  
		  return resultLst;
	  }
	  private static List<String> reorderInPage2(List<String> input, int eleInPage){
		  List<String> resultLst = new ArrayList<String>();
		  if(input == null || input.size() <= eleInPage){
		      return input;
		  }
		  input.remove(0);
		  Iterator<String> it = input.iterator();
		  
		  HashSet<String> existingHost = new HashSet<String>();
		  //int counter = 0;
		  while(it.hasNext()) {
			  String strCurrentEle = it.next();
			  String hostId = strCurrentEle.split(",")[0];
			  if(existingHost.add(hostId)){
	            //if not exist add it to result
			  	resultLst.add(strCurrentEle);
			  	it.remove();
			  	//TODO:biz requirement dependends
			  //	counter = counter + 1;
	            if(existingHost.size() == eleInPage) {
			  	//if(counter == eleInPage) {
	            	resultLst.add("########Page Break################");
	            	existingHost.clear();
	            	//counter = 0;
	            	if(input.size() <= eleInPage) {
		        		  resultLst.addAll(input);
		        		  break;
		        	}
	            }
	            it = input.iterator();
	          } else if(!it.hasNext()) {//to the end of list
	        	//we need clear the existing host otherwise it will be a dead loop
	        	  //TODO: if we clean it, it may have duplcate hostid in list, it depends on 
	        	  //biz requirement, 
	        	  //option 1: if we can break page no more than 12, we can add break here.
	        	  //option 2: allow the duplicate host id in same page.
	        	  resultLst.add("########Page Break################");
            	if(input.size() <= eleInPage) {
	        		  resultLst.addAll(input);
	        	}
			  }
		  }
		  
		  return resultLst;
	  }


}
