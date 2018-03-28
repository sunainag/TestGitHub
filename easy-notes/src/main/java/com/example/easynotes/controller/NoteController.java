package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;

@RestController
@RequestMapping("api")
public class NoteController {
	
	@Autowired
	NoteRepository noteRepository;

	 // Get All Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
    // Create a new Note
	@PostMapping(value="/notes", consumes={"text/plain", "application/*"})
	//@JsonRequestMapping
	public ResponseEntity<?> createNote(@RequestBody Note note) {
		return new ResponseEntity<Note>(noteRepository.save(note), HttpStatus.ACCEPTED);
	}
	
    // Get a Single Note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value="id") Long noteId) {
		return noteRepository.findOne(noteId);//.orElseThrow(()->new ResourceNotFoundException("Note","id",noteId));
	}
	
    // Update a Note
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable("id") Long noteId, @RequestBody Note newNote) {
		
		Note note = noteRepository.findOne(noteId);//.orElseThrow(()->new ResourceNotFoundException("Note", "id", noteId));
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());
		
		return noteRepository.save(note);
	}
	
    // Delete a Note
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable("id") Long noteId) {
		Note note = noteRepository.findOne(noteId);//.orElseThrow(()->new ResourceNotFoundException("Note", "id", noteId));
		noteRepository.delete(note);
	}
}
