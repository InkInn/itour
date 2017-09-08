package com.itour.api.service;

import java.util.List;

import com.itour.api.model.Note;


public interface NoteService {

	/**
	 * @param proCode
	 * @param cityCode
	 * @return
	 */
	public List<Note> batchSelectNotes(String proCode, String cityCode);
	
	public void addNote(Note note);
}
