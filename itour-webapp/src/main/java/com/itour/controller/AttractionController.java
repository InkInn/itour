package com.itour.controller;

import java.util.List;
import java.util.UUID;

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
	
	@RequestMapping(value="/addAttraction",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>addAttraction(String name,String introduc,String attType,String proCode, String cityCode, HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		Attraction attraction = new Attraction();
		attraction.setName(name);
		attraction.setAttCode(UUID.randomUUID().toString());
		attraction.setIntroduc(introduc);
		attraction.setAttType(attType);
		attraction.setProCode(proCode);
		attraction.setCityCode(cityCode);
		attractionService.addAtt(attraction);
		return ret;
	}
	
	@RequestMapping(value="/updateAttraction",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>updateAttraction(String name,String introduc,String attType, String attCode, HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		Attraction attraction = new Attraction();
		attraction.setName(name);
		attraction.setAttCode(attCode);
		attraction.setIntroduc(introduc);
		attraction.setAttType(attType);
		attractionService.updateAtt(attraction);
		return ret;
	}
	
	@RequestMapping(value="/delAttraction",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<String>delAttraction(String attCode, HttpServletRequest request){
		JsonResultHaveObj<String> ret=JsonResultHaveObj.getSuccessInstance();
		attractionService.delAtt(attCode);
		return ret;
	}

}
