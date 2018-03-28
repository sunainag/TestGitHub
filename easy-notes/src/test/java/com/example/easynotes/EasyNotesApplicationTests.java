package com.example.easynotes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.easynotes.model.Note;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyNotesApplicationTests {
	
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGet() {
		// Get Plain JSON
		String resourceUrl = "http://localhost:8080/api/notes";
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		System.out.println(response.getBody());
		System.out.println("Response reeived is :" + response.getStatusCode());

		// get for object
		Note note = restTemplate.getForObject(resourceUrl, Note.class);
		System.out.println("Note from Get request is: "+note.getTitle());
	}

	@Test
	public void testPost() {
		// The postForObject API
		String resourceUrl = "http://localhost:8080/api/notes";
		HttpEntity<Note> request = new HttpEntity<>(new Note("My first Note","Spring is awesome"));
		Note note = restTemplate.postForObject(resourceUrl, request, Note.class);
		System.out.println("Note from Post request is: "+note.getTitle());
	}

}
