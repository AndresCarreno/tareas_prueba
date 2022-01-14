package com.pruebatecnica.coopeuch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.coopeuch.controller.TareaController;
import com.pruebatecnica.coopeuch.entity.Tarea;
import com.pruebatecnica.coopeuch.repository.TareaRepository;
import com.pruebatecnica.coopeuch.service.TareaService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TareaController.class)
@ContextConfiguration(classes = {TareaService.class, TareaRepository.class})
public class TareaTest {
	
	@Autowired
	private MockMvc mvc;
	

		@Test
		public void createTarea() throws Exception 
		{
		  mvc.perform( MockMvcRequestBuilders
		      .post("/tarea")
		      .content(asJsonString(new Tarea(null, "Tarea 1", null, true)))
		      .contentType(MediaType.APPLICATION_JSON)
		      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().isCreated())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		}
		 
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		
		@Test
		public void getAllTareas() throws Exception 
		{
		  mvc.perform( MockMvcRequestBuilders
		      .get("/tarea")
		      .accept(MediaType.APPLICATION_JSON))
		      .andDo(print())
		      .andExpect(status().isOk())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.tarea").exists())
		      .andExpect(MockMvcResultMatchers.jsonPath("$.tarea[*].id").isNotEmpty());
		}
}


