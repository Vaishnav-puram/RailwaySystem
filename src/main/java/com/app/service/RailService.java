package com.app.service;

import java.util.List;

import com.app.DTO.RailwayDTO;
import com.app.DTO.RailwayResponseDTO;
import com.app.pojos.RailType;
import com.app.pojos.Railway;

public interface RailService {
	Railway addRail(RailwayDTO railway);
	List<RailwayResponseDTO> getRail(RailType railType);
	String deleteRail(Long id);
}
