package com.app.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StationResDTO {
	private String stationCode;
	private String stationName;
	private int noOfPlatforms;
	
}
