package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.RailwayDTO;
import com.app.DTO.RailwayResponseDTO;
import com.app.pojos.RailType;
import com.app.pojos.Railway;
import com.app.service.RailService;



@RestController
@RequestMapping("/rails")
public class RailController {
	@Autowired
	RailService railService;
	
	@PostMapping("/addRail")
	public ResponseEntity<String> addRail(@Valid @RequestBody RailwayDTO railway,BindingResult result) {
		if(result.hasErrors()) {
			List<String> errors=result.getAllErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors.toString());
		}
		railService.addRail(railway);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
	}
	
	@GetMapping(value="/getRail/{category}", produces = "application/json")
	public ResponseEntity<List<RailwayResponseDTO>> getRail(@PathVariable String category) {
		System.out.println("inside rail controller getRail ");
		return ResponseEntity.ok(railService.getRail(RailType.valueOf(category)));
	}
	@DeleteMapping("/delRail/{id}")
	public String deleteRail(@PathVariable Long id) {
		return railService.deleteRail(id);
	}
}
