package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.StationDTO;
import com.app.service.StationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/stations")
public class StationController {
	
	@Autowired
	StationService stationService;
	
	@GetMapping("/addStation")
	public ResponseEntity<String> addSts(@Valid @RequestBody  StationDTO s,BindingResult result) {
			if(result.hasErrors()){
				List<String> errors=result.getAllErrors().stream()
						.map(DefaultMessageSourceResolvable::getDefaultMessage)
						.collect(Collectors.toList());
				return ResponseEntity.badRequest().body(errors.toString());
			}
		return ResponseEntity.status(HttpStatus.CREATED).body(stationService.addStation(s));
	}
	
}
