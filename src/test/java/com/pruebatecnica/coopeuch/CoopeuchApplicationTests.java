package com.pruebatecnica.coopeuch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebatecnica.coopeuch.controller.TareaController;

@SpringBootTest
class CoopeuchApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void test() {
		TareaController tareaController = new TareaController();
	}

}
