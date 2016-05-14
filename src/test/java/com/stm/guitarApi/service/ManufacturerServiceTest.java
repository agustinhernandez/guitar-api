package com.stm.guitarApi.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stm.guitarApi.config.TestApplicationConfig;
import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.exception.ServiceGuitarApiException;
import com.stm.guitarApi.request.ManufacturerRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestApplicationConfig.class)
public class ManufacturerServiceTest {
	
	@Autowired
	protected ManufacturerService manufacturerService;

	
	private List<ManufacturerDto> manufacturers;
	private int manufacturersSize;

	
	@Before
	public void init() {
		this.manufacturers = manufacturerService.list();
		this.manufacturersSize = manufacturers.size();
	}
	
	@Test
	public void shouldListManufacturers() {
		assertTrue(!manufacturerService.list().isEmpty());
	}
	
	@Test
	public void shouldCreateManufacturer() {
		ManufacturerRequest manufacturerRequest = new ManufacturerRequest();
		manufacturerRequest.setName("testder");
		
		manufacturerService.create(manufacturerRequest);
		assertTrue(manufacturersSize < manufacturerService.list().size());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldCreateManufacturerThrowApiExceptionIfRequestHasErrors() {
		ManufacturerRequest manufacturerRequest = new ManufacturerRequest();
		
		manufacturerService.create(manufacturerRequest);
	}

}
