package com.itour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itour.api.model.City;
import com.itour.api.model.Province;
import com.itour.api.service.AreaService;
import com.itour.dto.JsonResultHaveObj;

@Controller
@RequestMapping(value = "/itour/area")
public class AreaController {
	
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/getProvinces",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<List<Province>>getProvinces(HttpServletRequest request){
		JsonResultHaveObj<List<Province>> ret=JsonResultHaveObj.getSuccessInstance();
		List<Province> proList = areaService.selectPros();
		ret.setResult(proList);
		return ret;
	}
	
	@RequestMapping(value="/getCitys",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	JsonResultHaveObj<Province>getCitys(String proCode, HttpServletRequest request){
		JsonResultHaveObj<Province> ret=JsonResultHaveObj.getSuccessInstance();
		List<City> cityList = areaService.selcetCitys(proCode);
		Province province = areaService.selectProInfo(proCode);
		province.setCityList(cityList);
		ret.setResult(province);
		return ret;
	}
}
