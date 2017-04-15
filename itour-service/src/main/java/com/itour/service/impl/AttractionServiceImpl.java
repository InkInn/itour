package com.itour.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itour.api.dao.AttractionDao;
import com.itour.api.model.Attraction;
import com.itour.api.service.AttractionService;

@Service("attractionService")
public class AttractionServiceImpl implements AttractionService {
	
	@Resource
	private AttractionDao attractionDao;

	public List<Attraction> batchSelectAtt(String proCode, String cityCode) {
		List<Attraction> list = attractionDao.batchSelectAtt(proCode, cityCode);
		return list;
	}

	public void addAtt(Attraction attraction) {
		attractionDao.addAtt(attraction);
	}

	public void updateAtt(Attraction attraction) {
		attractionDao.updateAtt(attraction);
		
	}

	public void delAtt(String attCode) {
		attractionDao.delAtt(attCode);
	}

}
