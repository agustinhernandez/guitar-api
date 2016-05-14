package com.stm.guitarApi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${data.manufacturerId1}")
	private String manufacturerId1;

	
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
	
	@Test
	public void shouldEditManufacturer() {
		ManufacturerRequest manufacturerRequest = new ManufacturerRequest();
		manufacturerRequest.setName("testder");
		
		ManufacturerDto manufacturer1 = manufacturerService.get(manufacturerId1);
		manufacturerService.edit(manufacturerRequest, manufacturerId1);
		ManufacturerDto currentManufacturer1 = manufacturerService.get(manufacturerId1);
		assertNotEquals(manufacturer1.getName(), currentManufacturer1.getName());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldEditManufacturerThrowApiExceptionIfRequestHasErrors() {
		ManufacturerRequest manufacturerRequest = new ManufacturerRequest();
		
		manufacturerService.edit(manufacturerRequest, manufacturerId1);
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldEditManufacturerThrowApiExceptionIfManufacturerIdNotExists() {
		ManufacturerRequest manufacturerRequest = new ManufacturerRequest();
		manufacturerRequest.setName("testder");
		
		manufacturerService.edit(manufacturerRequest, "asdf");
	}
	
	@Test
	public void shouldGetManufacturer() {
		assertEquals(manufacturerId1, manufacturerService.get(manufacturerId1).getId());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldGetManufacturerThrowApiExceptionIfManufacturerIdNotExists() {
		manufacturerService.get("asdf");
	}

}
