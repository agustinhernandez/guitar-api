package com.stm.guitarApi.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stm.guitarApi.config.TestApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestApplicationConfig.class)
public class ManufacturerServiceTest {
	
	@Autowired
	protected ManufacturerService manufacturerService;

	@Test
	public void shouldListManufacturers() {
		assertTrue(!manufacturerService.list().isEmpty());
	}

}
