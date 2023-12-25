package com.app.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.*;
import com.app.DTO.RailwayResponseDTO;
import com.app.custExceptions.IllegalDateException;
import com.app.custExceptions.ResourceNotFoundException;
import com.app.dao.RailwayDao;
import com.app.pojos.RailType;
import com.app.pojos.Railway;
import com.app.pojos.Station;

@Service
public class RailServiceImpl implements RailService{
	@Autowired
	RailwayDao railDao;
	@Autowired
	ModelMapper modelmapper;
	@Override
	public Railway addRail(RailwayDTO railway) {
		// TODO Auto-generated method stub
		Railway r=modelmapper.map(railway,Railway.class);
		r.setStartTime(LocalTime.parse(railway.getStartTime()));
		r.setEndTime(LocalTime.parse(railway.getEndTime()));
		if(r.getStartTime().isAfter(r.getEndTime())) {
			throw new IllegalDateException("start time should'nt be after end time !");
		}
		return railDao.save(r);
	}
	@Override
	public List<RailwayResponseDTO> getRail(RailType railType) {
		// TODO Auto-generated method stub
		
		List<RailwayResponseDTO> railResDTOList = new ArrayList<>();
		
		System.out.println("inside rail service getRail()");
		List<Railway> rails= railDao.findByRailType(railType);
		if(rails.isEmpty()) {
			System.out.println("list is empty!");
			throw new ResourceNotFoundException(railType);
		}
		rails.forEach(r->{
			RailwayResponseDTO railResDTO=new RailwayResponseDTO();
			railResDTO.setName(r.getName());
			railResDTO.setRailType(r.getRailType());
			railResDTO.setSrc(r.getSrc());
			railResDTO.setDst(r.getDst());
			railResDTO.setStartTime(r.getStartTime());
			railResDTO.setEndTime(r.getEndTime());
			List<StationResDTO> stationDTOList=new ArrayList<>();
			r.getStations().forEach(station->{
				StationResDTO stationResDTO=new StationResDTO();
				stationResDTO.setStationName(station.getStationName());
				stationResDTO.setStationCode(station.getStationCode());
				stationResDTO.setNoOfPlatforms(station.getNoOfPlatforms());
				System.out.println(r.getName()+"-->"+stationResDTO);
				stationDTOList.add(stationResDTO);
			});
			railResDTO.setSts(stationDTOList);
			railResDTOList.add(railResDTO);
			System.out.println("-->"+railResDTO);
		});
		
		return railResDTOList;
	}
	@Override
	public String deleteRail(Long id) {
		// TODO Auto-generated method stub
		railDao.deleteById(id);
		return "deleted successfully";
	}

}
