package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "train")
@Getter
@Setter
public class Railway extends BaseEntity {
	private String name;
	@Enumerated(EnumType.STRING)
	private RailType railType;
	private LocalTime startTime;
	private LocalTime endTime;
	private String src;
	private String dst;
	@OneToMany(mappedBy = "railway",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Station> stations=new ArrayList<>();
	
	public void addStation(Station s) {
		this.stations.add(s);
		s.setRailway(this);
	}
	public void removeStation(Station s) {
		this.stations.remove(s);
		s.setRailway(null);
	}
	public Railway() {
		
	}
	public Railway(String name, RailType railType, LocalTime startTime, LocalTime endTime, String src, String dst) {
		super();
		this.name = name;
		this.railType = railType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.src = src;
		this.dst = dst;
	}
	@Override
	public String toString() {
		return "Railway [name=" + name + ", railType=" + railType + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", src=" + src + ", dst=" + dst + ", stations=" + stations + "]";
	}
	
	
}
