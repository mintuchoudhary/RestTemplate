package com.resttemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;




public class RestTemplateCall {
public static void main(String[] args) {
	  RestTemplate restTemplate = new RestTemplate();
	  ObjectMapper mapper = new ObjectMapper();
	  //String url ="https://jsonplaceholder.typicode.com/posts/1";
	  restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("sysadm", "netcracker"));
	  String url="http://devapp277.netcracker.com:6380/rest/usage-service/get-usage-pymt?customer_id=9149954150013226610";
	//    String result = restTemplate.getForObject(url, String.class);
	  /*ResponseEntity<T> response = restTemplate.exchange( url,  HttpMethod.GET, null);*/
	  
	 //   System.out.println(result);
	    String url2="http://devapp277.netcracker.com:6380/rest/usage-service/accStmt?customer_id=9149954150013226610";
	    String result2 = restTemplate.getForObject(url2, String.class);
	    System.out.println(result2);
	    Map<String,String> map = new HashMap<String,String>();
	    try {
	        //convert JSON string to Map
	    	TypeReference<List<Map>> mapType = new TypeReference<List<Map>>() {};
	    	List<Map> jsonToPersonList  = mapper.readValue(result2, mapType);
	    System.out.println("json "+jsonToPersonList);
	    
	    for (Map map2 : jsonToPersonList) {
	    
	    	System.out.println(map2.get("plan_name"));
	    	System.out.println(map2.get("plan_duration"));
	    	System.out.println(map2.get("due_amt"));
	    	System.out.println(map2.get("net_amount"));
	    	System.out.println(map2.get("status"));
		}
	    
	    String url3="http://devapp277.netcracker.com:6380/rest/usage-service/getpymtdetails?customer_id=9149954150013226610";
	    
	    PaymentHistoryEntity[] result3 = restTemplate.getForObject(url3, PaymentHistoryEntity[].class);
	    System.out.println("result3:::"+result3);
	    System.out.println("result3:::"+Arrays.asList(result3));
	    List<PaymentHistoryEntity> listPaymentHistory = Arrays.asList(result3);
	    
	    
	     for (PaymentHistoryEntity paymentHistoryEntity : listPaymentHistory) {
	    	 System.out.println(paymentHistoryEntity.getPymtDate());
	    	 System.out.println(paymentHistoryEntity.getAmount());
	    	 System.out.println(paymentHistoryEntity.getStatus());
	    	 System.out.println(paymentHistoryEntity.getMode());
		}
	    
	    } catch (Exception e) {
	         System.out.println("Exception converting {} to map");
	         e.printStackTrace();
	    }
	    
	    String url3="http://devapp277.netcracker.com:6380/rest/usage-service/accStmt?customer_id=9149954150013226610";
	    List<Map> result3 = restTemplate.getForObject(url2, List.class);
	    System.out.println(result3);
	    
	    for (Map map2 : result3) {
	    	System.out.println("map list="+map2.get("plan_name"));
	    	System.out.println(map.get("plan_duration"));
	    	System.out.println(map.get("due_amt"));
	    	System.out.println(map.get("net_amount"));
	    	System.out.println(map.get("status"));
		}
	   
	    
	 //  System.out.println(result2);
	    
	    /* for (Map<String, String> map : result2) {
	    	System.out.println(map.get("plan_name"));	
	    	System.out.println(map.get("plan_duration"));
	    	System.out.println(map.get("due_amt"));
	    	System.out.println(map.get("net_amount"));
	    	System.out.println(map.get("status"));
		}*/
}

 
}
