package com.itour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.api.model.Attraction;
import com.itour.api.model.Province;
import com.itour.api.service.AttractionService;
import com.itour.dto.JsonResultHaveObj;

@Controller
@RequestMapping(value = "/itour/attraction")
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@RequestMapping(value="/getAttractions",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<List<Attraction>>getAttractions(String proCode, String cityCode, HttpServletRequest request){
		JsonResultHaveObj<List<Attraction>> ret=JsonResultHaveObj.getSuccessInstance();
		List<Attraction> proList = attractionService.batchSelectAtt(proCode, cityCode);
		ret.setResult(proList);
		return ret;
	}

}
