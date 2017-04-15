package com.itour.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itour.api.dao.NoteDao;
import com.itour.api.model.Note;
import com.itour.api.service.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao noteDao;

	public List<Note> batchSelectNotes(String proCode, String cityCode) {
		List<Note> list = noteDao.batchSelectNotes(proCode, cityCode);
		return list;
	}

	public void addNote(Note note) {
		noteDao.addNote(note);
	}

}
