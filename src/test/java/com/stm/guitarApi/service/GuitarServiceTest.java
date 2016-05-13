package com.stm.guitarApi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stm.guitarApi.config.TestApplicationConfig;
import com.stm.guitarApi.dto.GuitarDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestApplicationConfig.class)
public class GuitarServiceTest {
	
	@Autowired
	protected GuitarService guitarService;

	
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

}
