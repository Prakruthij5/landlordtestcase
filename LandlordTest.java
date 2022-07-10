package com.cg.ofr.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.dto.LandlordDto;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.serviceimpl.LandlordService;

@SpringBootTest
class LandlordTest {
	@Mock
	ILandlordRepository landlordRepository;


	@InjectMocks
	LandlordService landlordService=new LandlordService();

	static Landlord landlord=new Landlord();
	static LandlordDto landlordDto;
	static List<Landlord> landlordList;
	static List<Landlord> landlordList1;

	static List<LandlordDto> landlordDtoList;


		@BeforeAll
		public static void setUp() {
		 Landlord landlord=new Landlord();
		 
		landlordList1=new ArrayList<>();
		landlordDtoList=new ArrayList<>();
		
		landlordDto=new LandlordDto();
		landlordDto.setLandlordId(1);
		landlord.setLandlordName("Raj");
		landlord.setLandlordAge(40);
		landlordList1.add(landlord);
		BeanUtils.copyProperties(landlord, landlordDto);
		
		}

		@Test
		 void testAddLandlord() {
		Mockito.when(landlordRepository.saveAndFlush(landlord)).thenReturn(landlord);
		assertNotNull(landlordService.addLandlord(landlordDto));
		}


		

		@Test
		void testViewAllLandlord() throws LandlordNotFoundException{
			Mockito.when(landlordRepository.findAll()).thenReturn(landlordList);
				
		}
			
		@Test
		void testViewLandlord() {
			Mockito.when(landlordRepository.findAll()).thenReturn(landlordList);
				
		}
		
	}