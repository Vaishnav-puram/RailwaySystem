package com.app.DTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.RailType;
import com.app.pojos.Station;

import lombok.*;

@Getter
@Setter
@ToString
public class RailwayResponseDTO {
	private String name;
	private RailType railType;
	private LocalTime startTime;
	private LocalTime endTime;
	private String src;
	private String dst;
	List<StationResDTO> sts=new ArrayList<>();
	public RailwayResponseDTO() {
		
	}	
	
}
