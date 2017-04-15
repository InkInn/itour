package com.itour.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itour.api.dao.NoteDao;
import com.itour.api.model.Note;


@Repository("noteDao")
public class NoteDaoImpl implements NoteDao {
	
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplatetea;

	public List<Note> batchSelectNotes(String proCode, String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = (" SELECT title, outline,authorName FROM itour_note WHERE proCode = :proCode AND cityCode = :cityCode");
		params.put("proCode", proCode);
		params.put("cityCode", cityCode);
		List<Note> list =  npJdbcTemplatetea.query(sql,params,
				new BeanPropertyRowMapper<Note>(
						Note.class));
		return list;
	}

	public void addNote(Note note) {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = (" INSERT INTO itour_note (title,outline,attCode,proCode,cityCode,authorName) VALUES (:title,:outline,:attCode,:proCode,:cityCode,:authorName)");
		
		params.put("title", note.getTitle());
		params.put("outline", note.getOutline());
		params.put("attCode", note.getAttCode());
		params.put("proCode", note.getProCode());
		params.put("cityCode", note.getCityCode());
		params.put("authorName", note.getAuthorName());

		npJdbcTemplatetea.update(sql, params);
	}

}
