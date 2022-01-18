package com.pruebatecnica.coopeuch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.coopeuch.entity.Tarea;
import com.pruebatecnica.coopeuch.service.TareaService;



@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "${front.url}")
public class TareaController {
	
	@Autowired
	TareaService tareaService;

	@GetMapping("tarea")
	private ResponseEntity<Object> getTareas() {
		
		return new ResponseEntity<>(tareaService.getTareas(), HttpStatus.OK);
	}
	
	@PostMapping("tarea")
	private String saveTarea(@Valid @RequestBody Tarea tarea) {
		
		return tareaService.saveOrUpdateTarea(tarea);
	}
	
	@DeleteMapping("tarea/{id}")
	private String deleteTarea(@PathVariable("id") Long id) {
		
		return tareaService.deleteTarea(id);
	}
}
