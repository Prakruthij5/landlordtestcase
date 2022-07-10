package com.cg.ofr.testdto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.dto.LandlordDto;

@SpringBootTest
class LandlordDtoTest {

	static LandlordDto landlordDto;
	
	@BeforeAll
	static void setUp() {
		landlordDto=new LandlordDto();
		landlordDto.setLandlordId(1);
		landlordDto.setLandlordName("raj");
		landlordDto.setLandlordAge(40);
		
	}

	@Test
	 void testGetters() {
	assertEquals(1,landlordDto.getLandlordId());
	assertEquals("raj",landlordDto.getLandlordName());
	assertEquals(40,landlordDto.getLandlordAge());
	}

}
