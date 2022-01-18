package com.pruebatecnica.coopeuch.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebatecnica.coopeuch.repository.TareaRepository;


import com.pruebatecnica.coopeuch.entity.Tarea;



@Service
public class TareaService {
	
	@Autowired
	TareaRepository tareaRepository;
	
	public List<Tarea> getTareas() {
		List<Tarea> tareas = tareaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return tareas;
	}
	
	public String saveOrUpdateTarea(Tarea tarea) {
		LocalDateTime now = LocalDateTime.now().withNano(0);
		tarea.setCreationDate(now);
		String res = "";
		System.out.println(tarea.getCreationDate());
		
		try {
			Boolean newTarea = tarea.getId() == null;		
			
			tareaRepository.save(tarea);
			
			if(newTarea) {
				res = "Tarea agregada exitosamente";
				return res;
			}else {
				res = "Tarea editada exitosamente";
				return res;
			}
			
		}catch(Exception e) {
			return(e.toString());
		}
		
		
	}
	
	public String deleteTarea(Long id) {
		String res = "";
		try {
			
			tareaRepository.deleteById(id);;
			res = "Tarea eliminada";
			return res;
		}catch(Exception e) {
			return(e.toString());
		}
	}
	

}
