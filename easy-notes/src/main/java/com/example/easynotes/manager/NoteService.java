package com.example.easynotes.manager;

import java.util.List;
import com.example.easynotes.model.Note;

public interface NoteService {

	Note createNote(Note note);

	Note getNoteById(Long noteId);

	void deleteNote(Long noteId);

	List<Note> getNotes();
	
	Note updateNote(Long oldNoteId, Note newNote);
}
