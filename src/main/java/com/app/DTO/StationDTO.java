package com.app.DTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDTO {
	@NotEmpty(message = "station code must not be empty")
	private String stationCode;
	@NotEmpty(message = "station name must not be empty")
	private String stationName;
	@Digits(integer = 2,fraction = 0,message = "invalid digit for the platform")
	private int noOfPlatforms;
	private Long rid;
}
