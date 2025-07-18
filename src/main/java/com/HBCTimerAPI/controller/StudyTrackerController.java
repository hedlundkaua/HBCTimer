package com.HBCTimerAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class StudyTrackerController{

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
	public ResponseEntity<StudyTrackerResponseDTO> createStudyTracker(@RequestBody StudyTrackerRequestDTO dto){
			StudyTracker tracker = trackerService.createStudyTracker(dto);
			return ResponseEntity.ok(StudyTrackerMapper.toDTO(tracker));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyTrackerResponseDTO> findById(@PathVariable Long id){
		StudyTracker tracker = trackerService.findById(id);
		return ResponseEntity.ok().body(StudyTrackerMapper.toDTO(tracker));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<StudyTrackerResponseDTO> deleteById(@PathVariable Long id){
		trackerService.deleteById(id);
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<StudyTrackerResponseDTO> update(@PathVariable Long id, @RequestBody StudyTracker obj){
		StudyTracker tracker = trackerService.update(id, obj);
		return ResponseEntity.ok().body(StudyTrackerMapper.toDTO(tracker));
	}
	
}
