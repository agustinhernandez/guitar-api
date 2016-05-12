package com.stm.guitarApi.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.stm.guitarApi.dao.GuitarDao;
import com.stm.guitarApi.model.Classification;
import com.stm.guitarApi.model.Guitar;
import com.stm.guitarApi.model.Manufacturer;

@Component
public class GuitarDaoImpl implements GuitarDao {
	
	private Map<String, Guitar> guitars;
	
	@PostConstruct
	private void init() {
		guitars = new HashMap<String, Guitar>();
		String guitarId1 = "550e8400-e29b-41d4-a716-446655440000";
		Manufacturer manufacturer1 = Manufacturer.newInstance(
				"38400000-8cf0-11bd-b23e-10b96e4ef00d",
				"Fender",
				"Fender Electric Instrument Manufacturing Company",
				1946,
				"Fullerton, California, U.S.",
				"Clarence Leonidas Fender",
				"Scottsdale, Arizona, USA",
				"Worldwide",
				"fender.com",
				"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q==");
				
		guitars.put(guitarId1, Guitar.newInstance(
				guitarId1, 
				"Fender Stratocaster",
				1954,
				Classification.ELECTRIC,
				manufacturer1,
				"Solid",
				"Bolt-on",
				648,
				"Alder, Ash, Poplar, Basswood",
				"Maple",
				"Maple, Rosewood, Ebony, Pao Ferro",
				"Usually proprietary Tremolo Hardtail",
				"Usually 3 Single-coils or 2 Single-coils with Hot Bridge Humbucker on certain models",
				"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="));
	}

	@Override
	public List<Guitar> list() {
		return new ArrayList<Guitar>(guitars.values());
	}

}
