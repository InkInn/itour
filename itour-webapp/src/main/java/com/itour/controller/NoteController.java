package com.itour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.api.model.Note;
import com.itour.api.service.NoteService;
import com.itour.dto.JsonResultHaveObj;

@Controller
@RequestMapping(value = "/itour/note")
public class NoteController {
	
	@Autowired
	private NoteService noteServie;
	
	@RequestMapping(value="/getNotes",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<List<Note>>getNotes(String proCode, String cityCode,HttpServletRequest request){
		JsonResultHaveObj<List<Note>> ret=JsonResultHaveObj.getSuccessInstance();
		List<Note> noteList = noteServie.batchSelectNotes(proCode, cityCode);
		ret.setResult(noteList);
		return ret;
	}
}
