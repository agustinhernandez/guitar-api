package com.stm.guitarApi.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

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
	
	private Manufacturer manufacturer1;
	private Manufacturer manufacturer2;
	private Guitar guitar1;
	private Guitar guitar2;
	private Guitar guitar3;
	
	
	@PostConstruct
	private void init() {
		manufacturer1 = getManufacturer1();
		manufacturer2 = getManufacturer2();
		guitar1 = getGuitar1();
		guitar2 = getGuitar2();
		guitar3 = getGuitar3();
	}
	
	
	@Bean
	public Map<String, Manufacturer> manufacturersMap() {
		Map<String, Manufacturer> manufacturers = new HashMap<String, Manufacturer>();
		
		manufacturers.put(manufacturerId1, manufacturer1);
		manufacturers.put(manufacturer2.getId(), manufacturer2);
		
		return manufacturers;
	}

	private Manufacturer getManufacturer1() {
		Manufacturer manufacturer = Manufacturer.newInstance(
				"Fender",
				"Fender Electric Instrument Manufacturing Company",
				1946,
				"Fullerton, California, U.S.",
				"Clarence Leonidas Fender",
				"Scottsdale, Arizona, USA",
				"Worldwide",
				"fender.com",
				imageBase64);
		
		manufacturer.setId(manufacturerId1);
		return manufacturer;
	}

	private Manufacturer getManufacturer2() {
		Manufacturer manufacturer = Manufacturer.newInstance(
				"Gibson",
				"Gibson Guitar Corporation",
				1902,
				"Kalamazoo, Michigan",
				"Orville Gibson",
				"Nashville, Tennessee, USA",
				"Worldwide",
				"gibson.com",
				imageBase64);
		
		manufacturer.setId(UUID.randomUUID().toString());
		return manufacturer;
	}
	
	@Bean
	public Map<String, Guitar> guitarsMap() {
		Map<String, Guitar> guitars = new HashMap<String, Guitar>();
		
		guitars.put(guitarId1, guitar1);
		guitars.put(guitar2.getId(), guitar2);
		guitars.put(guitar3.getId(), guitar3);
		
		return guitars;
	}

	private Guitar getGuitar1() {
		Guitar guitar = Guitar.newInstance(
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
				imageBase64);
		
		guitar.setId(guitarId1);
		return guitar;
	}

	private Guitar getGuitar2() {
		Guitar guitar = Guitar.newInstance(
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
				imageBase64);
		
		guitar.setId(UUID.randomUUID().toString());
		return guitar;
	}

	private Guitar getGuitar3() {
		Guitar guitar = Guitar.newInstance(
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
				imageBase64);
		
		guitar.setId(UUID.randomUUID().toString());
		return guitar;
	}
	
}