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
import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.exception.ServiceGuitarApiException;
import com.stm.guitarApi.model.Classification;
import com.stm.guitarApi.request.GuitarRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestApplicationConfig.class)
public class GuitarServiceTest {
	
	@Autowired
	protected GuitarService guitarService;
	
	@Value("${data.manufacturerId1}")
	private String manufacturerId1;
	
	@Value("${data.guitarId1}")
	private String guitarId1;

	
	private List<GuitarDto> guitars;
	private int guitarsSize;

	
	@Before
	public void init() {
		this.guitars = guitarService.list(null, null);
		this.guitarsSize = guitars.size();
	}
	
	
	@Test
	public void shouldListGuitars() {
		assertTrue(!guitars.isEmpty());
	}
	
	@Test
	public void shouldListGuitarsByCount() {
		assertEquals(1, guitarService.list(null, 1).size());
		assertEquals(2, guitarService.list(null, 2).size());
		assertEquals(3, guitarService.list(null, 3).size());
	}
	
	@Test
	public void shouldListAllGuitarsForExceededCount() {
		assertEquals(guitarsSize, guitarService.list(null, guitarsSize + 1).size());
	}
	
	@Test
	public void shouldListEmtpyForNegativeCount() {
		assertTrue(guitarService.list(null, -1).isEmpty());
	}
	
	@Test
	public void shouldListEmptyForZeroCount() {
		assertTrue(guitarService.list(null, 0).isEmpty());
	}
	
	@Test
	public void shouldListGuitarsByPage() {
		assertEquals(guitars.get(0).getId(), guitarService.list(0, 1).get(0).getId());
		assertEquals(guitars.get(1).getId(), guitarService.list(1, 1).get(0).getId());
		assertEquals(guitars.get(2).getId(), guitarService.list(2, 1).get(0).getId());
	}
	
	@Test
	public void shouldListEmptyForExceededPage() {
		assertTrue(guitarService.list(guitarsSize, guitarsSize).isEmpty());
	}
	
	@Test
	public void shouldGetLastPageByCount() {
		assertEquals(guitarsSize - 1, guitarService.getLastPage(1));
		assertEquals(0, guitarService.getLastPage(guitarsSize));
	}
	
	@Test
	public void shouldGetLastPageZeroForExceededCount() {
		assertEquals(0, guitarService.getLastPage(guitarsSize + 1));
	}
	
	@Test
	public void shouldGetLastPageZeroForNegativeCount() {
		assertEquals(0, guitarService.getLastPage(-1));
	}
	
	@Test
	public void shouldGetLastPageZeroForZeroCount() {
		assertEquals(0, guitarService.getLastPage(0));
	}
	
	@Test
	public void shouldListGuitarsOrderByYear() {
		List<GuitarDto> guitarsOrderByYear = guitarService.listOrderByYear(null, null);
		assertTrue(guitarsOrderByYear.get(0).getYear() <= guitarsOrderByYear.get(1).getYear());
		assertTrue(guitarsOrderByYear.get(1).getYear() <= guitarsOrderByYear.get(2).getYear());
	}
	
	@Test
	public void shouldListGuitarsFilterByManufacturer() {
		List<GuitarDto> guitarsFilterByManufacturer = guitarService.listFilterByManufacturer(manufacturerId1, null, null);
		assertEquals(2, guitarsFilterByManufacturer.size());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldListGuitarsFilterByManufacturerThrowApiExceptionIfManufacturerIdNotExists() {
		guitarService.listFilterByManufacturer("asdf", null, null);
	}
	
	@Test
	public void shouldCreateGuitar() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId(manufacturerId1);
		guitarRequest.setClassification(Classification.ELECTRIC.name());
		guitarRequest.setYear(1985);
		
		guitarService.create(guitarRequest);
		assertTrue(guitarsSize < guitarService.list(null, null).size());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldCreateGuitarThrowApiExceptionIfManufacturerIdNotExists() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId("asdf");
		guitarRequest.setClassification(Classification.ELECTRIC.name());
		guitarRequest.setYear(1985);
		
		guitarService.create(guitarRequest);
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldCreateGuitarThrowApiExceptionIfRequestHasErrors() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId(manufacturerId1);
		guitarRequest.setClassification("asdf");
		guitarRequest.setYear(1985);
		
		guitarService.create(guitarRequest);
	}
	
	@Test
	public void shouldEditGuitar() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId(manufacturerId1);
		guitarRequest.setClassification(Classification.ELECTRIC.name());
		guitarRequest.setYear(1985);
		
		GuitarDto guitar1 = guitarService.get(guitarId1);
		guitarService.edit(guitarRequest, guitarId1);
		GuitarDto currentGuitar1 = guitarService.get(guitarId1);
		assertNotEquals(guitar1.getModel(), currentGuitar1.getModel());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldEditGuitarThrowApiExceptionIfManufacturerIdNotExists() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId("asdf");
		guitarRequest.setClassification(Classification.ELECTRIC.name());
		guitarRequest.setYear(1985);
		
		guitarService.edit(guitarRequest, guitarId1);
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldEditGuitarThrowApiExceptionIfRequestHasErrors() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId(manufacturerId1);
		guitarRequest.setClassification("asdf");
		guitarRequest.setYear(1985);
		
		guitarService.edit(guitarRequest, guitarId1);
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldEditGuitarThrowApiExceptionIfGuitarIdNotExists() {
		GuitarRequest guitarRequest = new GuitarRequest();
		guitarRequest.setModel("testcaster");
		guitarRequest.setManufacturerId(manufacturerId1);
		guitarRequest.setClassification(Classification.ELECTRIC.name());
		guitarRequest.setYear(1985);
		
		guitarService.edit(guitarRequest, "asdf");
	}
	
	@Test
	public void shouldGetGuitar() {
		assertEquals(guitarId1, guitarService.get(guitarId1).getId());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldGetGuitarThrowApiExceptionIfGuitarIdNotExists() {
		guitarService.get("asdf");
	}
	
	@Test
	public void shouldDeleteGuitar() {
		guitarService.delete(guitarId1);
		assertTrue(guitarsSize > guitarService.list(null, null).size());
	}
	
	@Test(expected=ServiceGuitarApiException.class)
	public void shouldDeleteGuitarThrowApiExceptionIfGuitarIdNotExists() {
		guitarService.delete("asdf");
	}

}
