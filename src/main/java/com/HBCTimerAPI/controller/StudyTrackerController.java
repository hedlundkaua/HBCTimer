package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HBCTimerAPI.domain.entities.StudyTracker;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerRequestDTO;
import com.HBCTimerAPI.dto.studyTracker.StudyTrackerResponseDTO;
import com.HBCTimerAPI.mapper.StudyTrackerMapper;
import com.HBCTimerAPI.services.StudyTrackerService;


@RestController
@RequestMapping(value = "/trackers")
public class StudyTrackerController {

	private final StudyTrackerService trackerService;
	
	public StudyTrackerController(StudyTrackerService trackerService) {
		this.trackerService = trackerService;
	}
	
	@GetMapping
	public ResponseEntity<List<StudyTrackerResponseDTO>> findAll(){
		List<StudyTracker> listTracker = trackerService.findAll();
		return ResponseEntity.ok().body(StudyTrackerMapper.toDTOList(listTracker));
	}
	
	@PostMapping
	public ResponseEntity<StudyTrackerResponseDTO> insert(@RequestBody StudyTrackerRequestDTO dto){
			StudyTracker tracker = trackerService.insert(dto);
			return ResponseEntity.ok(StudyTrackerMapper.toDTO(tracker));
	}
	
	
	
	
}
