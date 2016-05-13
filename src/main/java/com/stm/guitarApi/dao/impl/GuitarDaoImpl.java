package com.stm.guitarApi.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
		
		String guitarId2 = UUID.randomUUID().toString();
		guitars.put(guitarId2, Guitar.newInstance(
				guitarId2, 
				"Fender Telecaster",
				1950,
				Classification.ELECTRIC,
				manufacturer1,
				"Solid",
				"Bolt-on",
				650,
				"Alder, Ash, Poplar, Pine, Basswood",
				"Maple",
				"Maple, Rosewood",
				"Proprietary 'Ashtray' or modern style with string through or top load strings.",
				"Traditionally two single-coils. Combinations with 1 to 3 pickups, including humbuckers have been produced",
				"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="));
		
		String guitarId3 = UUID.randomUUID().toString();
		Manufacturer manufacturer2 = Manufacturer.newInstance(
				UUID.randomUUID().toString(),
				"Gibson",
				"Gibson Guitar Corporation",
				1902,
				"Kalamazoo, Michigan",
				"Orville Gibson",
				"Nashville, Tennessee, USA",
				"Worldwide",
				"gibson.com",
				"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q==");
		
		guitars.put(guitarId3, Guitar.newInstance(
				guitarId3, 
				"Gibson Les Paul",
				1952,
				Classification.ELECTRIC,
				manufacturer2,
				"Solid, hollow, semi-hollow",
				"Set neck",
				650,
				"Mahogany (often with a maple top), Swamp ash (rare)",
				"Usually mahogany, Maple",
				"Usually Rosewood, Ebony, Maple, Richlite",
				"Usually Tune-O-Matic",
				"Usually 2 humbuckers, 2 P-90s, 3 humbuckers",
				"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="));
	}

	@Override
	public List<Guitar> list() {
		return new ArrayList<Guitar>(guitars.values());
	}

	@Override
	public int count() {
		return guitars.size();
	}

}
