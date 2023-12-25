package com.app.DTO;

import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.app.pojos.RailType;

import lombok.*;

@Getter
@Setter
public class RailwayDTO {
	@NotEmpty(message = "rail name must not be null")
	private String name;
	private RailType railType;
	private String startTime;
	private String endTime;
	private String src;
	private String dst;
}
