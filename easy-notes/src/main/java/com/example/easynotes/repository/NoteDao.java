package com.example.easynotes.repository;

import java.util.List;
import com.example.easynotes.model.Note;

public interface NoteDao {

	public List<Note> getAllNotes();

	public Note getNoteById(Long id);

	public void save(Note note);

	public void delete(Note note);

	public void deleteAllNotes();
	
	public Note updateNote(Note note);

}
