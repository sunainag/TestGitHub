package com.example.easynotes.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Note;

@Repository
public class NoteDaoImpl implements NoteDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(Note note) {
		 getSession().delete(note);
	 }
	 
	 public void deleteAllNotes() {
		for(Note note:getAllNotes()) {
			getSession().delete(note);
		}
	 }
	 
	 public void save(Note note) {
		 getSession().saveOrUpdate(note);
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Note> getAllNotes() {
		 return getSession().createQuery("from com.example.easynotes.model.Note n").list();
	 }
	 
	 public Note getNoteById(Long id) {
		 return getSession().get(Note.class, id);
	 }

	 public Note updateNote(Note note) {
		 getSession().update(note);
		 return note;
	 }

}
