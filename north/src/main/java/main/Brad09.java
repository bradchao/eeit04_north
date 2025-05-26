package main;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Brad09 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("gender", true);
		person.put("age", 18);
		
		try {
			String json = mapper.writeValueAsString(person);
			
			System.out.println(json);
			
			System.out.println("----");
			HashMap<String, Object> brad;
			
			brad = mapper.readValue(json, 
				new TypeReference<HashMap<String, Object>>() {});
			
			System.out.println(brad.get("name"));
			System.out.println(brad.get("gender"));
			System.out.println(brad.get("age"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
	}

}
