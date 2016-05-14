package com.stm.guitarApi.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.stm.guitarApi.model.Classification;
import com.stm.guitarApi.model.Guitar;
import com.stm.guitarApi.model.Manufacturer;

@Configuration
@PropertySource(value = "classpath:properties/data.properties", ignoreResourceNotFound = false)
public class DataConfig {
	
	@Value("${data.imageBase64}")
	private String imageBase64;
	
	@Value("${data.manufacturerId1}")
	private String manufacturerId1;
	
	@Value("${data.guitarId1}")
	private String guitarId1;
	
	
	@Bean
	public Map<String, Manufacturer> manufacturersMap() {
		Map<String, Manufacturer> manufacturers = new HashMap<String, Manufacturer>();
		
		Manufacturer manufacturer1 = getManufacturer1();
		manufacturers.put(manufacturerId1, manufacturer1);
				
		Manufacturer manufacturer2 = getManufacturer2();
		manufacturers.put(manufacturer2.getId(), manufacturer2);
		
		return manufacturers;
	}

	private Manufacturer getManufacturer1() {
		Manufacturer manufacturer1 = Manufacturer.newInstance(
				"Fender",
				"Fender Electric Instrument Manufacturing Company",
				1946,
				"Fullerton, California, U.S.",
				"Clarence Leonidas Fender",
				"Scottsdale, Arizona, USA",
				"Worldwide",
				"fender.com",
				imageBase64);
		
		manufacturer1.setId(manufacturerId1);
		return manufacturer1;
	}

	private Manufacturer getManufacturer2() {
		Manufacturer manufacturer2 = Manufacturer.newInstance(
				"Gibson",
				"Gibson Guitar Corporation",
				1902,
				"Kalamazoo, Michigan",
				"Orville Gibson",
				"Nashville, Tennessee, USA",
				"Worldwide",
				"gibson.com",
				imageBase64);
		
		String manufacturerId2 = UUID.randomUUID().toString();
		manufacturer2.setId(manufacturerId2);
		return manufacturer2;
	}
	
	@Bean
	public Map<String, Guitar> guitarsMap() {
		Map<String, Guitar> guitars = new HashMap<String, Guitar>();
		
		Guitar guitar1 = getGuitar1();
		guitar1.setId(guitarId1);
		guitars.put(guitarId1, guitar1);
		
		String guitarId2 = UUID.randomUUID().toString();
		Guitar guitar2 = getGuitar2();
		guitar2.setId(guitarId2);
		guitars.put(guitarId2, guitar2);
		
		String guitarId3 = UUID.randomUUID().toString();
		Guitar guitar3 = getGuitar3();
		guitar3.setId(guitarId3);
		guitars.put(guitarId3, guitar3);
		
		return guitars;
	}

	private Guitar getGuitar1() {
		return Guitar.newInstance(
				"Fender Stratocaster",
				1954,
				Classification.ELECTRIC,
				getManufacturer1(),
				"Solid",
				"Bolt-on",
				648,
				"Alder, Ash, Poplar, Basswood",
				"Maple",
				"Maple, Rosewood, Ebony, Pao Ferro",
				"Usually proprietary Tremolo Hardtail",
				"Usually 3 Single-coils or 2 Single-coils with Hot Bridge Humbucker on certain models",
				imageBase64);
	}

	private Guitar getGuitar2() {
		return Guitar.newInstance(
				"Fender Telecaster",
				1950,
				Classification.ELECTRIC,
				getManufacturer1(),
				"Solid",
				"Bolt-on",
				650,
				"Alder, Ash, Poplar, Pine, Basswood",
				"Maple",
				"Maple, Rosewood",
				"Proprietary 'Ashtray' or modern style with string through or top load strings.",
				"Traditionally two single-coils. Combinations with 1 to 3 pickups, including humbuckers have been produced",
				imageBase64);
	}

	private Guitar getGuitar3() {
		return Guitar.newInstance(
				"Gibson Les Paul",
				1952,
				Classification.ELECTRIC,
				getManufacturer2(),
				"Solid, hollow, semi-hollow",
				"Set neck",
				650,
				"Mahogany (often with a maple top), Swamp ash (rare)",
				"Usually mahogany, Maple",
				"Usually Rosewood, Ebony, Maple, Richlite",
				"Usually Tune-O-Matic",
				"Usually 2 humbuckers, 2 P-90s, 3 humbuckers",
				imageBase64);
	}
	
}