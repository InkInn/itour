package com.itour.api.dao;

import java.util.List;

import com.itour.api.model.Note;

public interface NoteDao {
	
	public List<Note> batchSelectNotes(String proCode, String cityCode);

}
