package com.example.easynotes.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteDaoImpl;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDaoImpl noteDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Note createNote(Note note) {
		noteDao.save(note);
		return note;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Note getNoteById(Long noteId) {
		return noteDao.getNoteById(noteId);
	}

	@Override
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public List<Note> getNotes() {
		return noteDao.getAllNotes();
	}

	/*
	 * The outer transaction is paused when the inner transaction starts and then
	 * resumes after the inner transaction is concluded. They run independently of
	 * each other so the outer transaction may commit successfully
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteNote(Long noteId) {
		testRequiresNew();
		Note note = getNoteById(noteId);
		noteDao.delete(note);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private void testRequiresNew() {
		throw new RuntimeException("Rollback this transaction!");
	}

	@Override
	@Transactional
	public Note updateNote(Long oldNoteId, Note newNote) {
		Note note = getNoteById(oldNoteId);//.orElseThrow(()->new ResourceNotFoundException("Note", "id", noteId));
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());
		return noteDao.updateNote(note);
	}

}
