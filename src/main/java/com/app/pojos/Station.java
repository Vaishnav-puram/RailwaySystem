package com.app.pojos;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="station")
@Getter
@Setter
public class Station extends BaseEntity{
	private String stationCode;
	private String stationName;
	private int noOfPlatforms;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rid",nullable = false)
	private Railway railway;
	public Station() {
		// TODO Auto-generated constructor stub
	}
	public Station(String stationCode, String stationName, int noOfPlatforms) {
		super();
		this.stationCode = stationCode;
		this.stationName = stationName;
		this.noOfPlatforms = noOfPlatforms;
	}
	
	
}
