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

import com.example.easynotes.manager.NoteService;
import com.example.easynotes.manager.NoteServiceImpl;
import com.example.easynotes.model.Note;

@RestController
@RequestMapping("api")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	 // Get All Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteService.getNotes();
	}
	
    // Create a new Note
	@PostMapping(value="/notes", produces="application/json", consumes="application/json")
	//@JsonRequestMapping
	public ResponseEntity<?> createNote(@RequestBody Note note) {
		return new ResponseEntity<Note>(noteService.createNote(note), HttpStatus.ACCEPTED);
	}
	
    // Get a Single Note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value="id") Long noteId) {
		return noteService.getNoteById(noteId);//.orElseThrow(()->new ResourceNotFoundException("Note","id",noteId));
	}
	
    // Update a Note
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable("id") Long noteId, @RequestBody Note newNote) {
		return noteService.updateNote(noteId, newNote);
	}
	
    // Delete a Note
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable("id") Long noteId) {
		noteService.deleteNote(noteId);
	}
}
