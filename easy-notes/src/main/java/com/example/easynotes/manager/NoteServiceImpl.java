package com.example.easynotes.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteDaoImpl;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDaoImpl noteDao;
	
	@Override
	public Note createNote(Note note) {
		noteDao.save(note);
		return note;
	}

	@Override
	public Note getNoteById(Long noteId) {
		return noteDao.getNoteById(noteId);
	}

	@Override
	public List<Note> getNotes() {
		return noteDao.getAllNotes();
	}

	@Override
	public void deleteNote(Long noteId) {
		Note note = getNoteById(noteId);
		noteDao.delete(note);
	}
	
	@Override
	public Note updateNote(Long oldNoteId, Note newNote) {
		Note note = getNoteById(oldNoteId);//.orElseThrow(()->new ResourceNotFoundException("Note", "id", noteId));
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());
		return noteDao.updateNote(note);
	}

}
