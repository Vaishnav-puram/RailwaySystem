package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.StationDTO;
import com.app.dao.RailwayDao;
import com.app.dao.StationDao;
import com.app.pojos.Railway;
import com.app.pojos.Station;

@Service
public class StationServiceImpl implements StationService {
	
	@Autowired
	RailwayDao railDao;
	@Autowired
	StationDao stationDao;
	@Autowired
	ModelMapper model;
	@Override
	public String addStation(StationDTO s) {
		Railway r=railDao.findById(s.getRid()).orElseThrow();
		System.out.println("-->"+r);
		Station sts=model.map(s,Station.class);
		if(r!=null) {
			r.addStation(sts);
			sts.setRailway(r);
		}
		stationDao.save(sts);
		return "added successfully";
	}

}