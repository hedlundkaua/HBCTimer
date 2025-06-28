package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.dto.matter.MatterProfileDTO;
import com.HBCTimerAPI.dto.matter.MatterResponseDTO;
import com.HBCTimerAPI.model.entities.Matter;
import com.HBCTimerAPI.model.entities.User;
import com.HBCTimerAPI.services.MatterService;
import com.HBCTimerAPI.services.UserService;

@RestController
@RequestMapping(value = "/subjects")
public class MatterController {

	@Autowired
	private MatterService service;
	
	@Autowired
	private UserService userService;
	
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
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Matter> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<MatterResponseDTO> insert(@RequestBody MatterProfileDTO matterDTO){
		User user = userService.findById(matterDTO.getUserId());
		Matter matter = service.insert(matterDTO.criaObjeto(user));
		return ResponseEntity.ok().body(MatterResponseDTO.transformaMatterEmDTO(matter));
	}
}