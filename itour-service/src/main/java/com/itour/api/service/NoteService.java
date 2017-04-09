package com.itour.api.service;

import java.util.List;

import com.itour.api.model.Note;

public interface NoteService {

	public List<Note> batchSelectNotes(String proCode, String cityCode);
}
