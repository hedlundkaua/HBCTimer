package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.dto.matter.MatterResponseDTO;
import com.HBCTimerAPI.model.entities.Matter;
import com.HBCTimerAPI.services.MatterService;

@RestController
@RequestMapping(value = "/subjects")
public class MatterController {

	@Autowired
	private MatterService service;
	
	@GetMapping
	public ResponseEntity<List<MatterResponseDTO>> findAll(){
		List<Matter> list = service.findAll();
		return ResponseEntity.ok().body(MatterResponseDTO.transfromaVariosMatterEmDTO(list));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MatterResponseDTO> findById(@PathVariable Long id) {
		Matter obj = service.findById(id);
		return ResponseEntity.ok().body(MatterResponseDTO.transformaMatterEmDTO(obj));
	}
}