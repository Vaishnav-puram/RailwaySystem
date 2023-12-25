package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Railway;
import com.app.pojos.Station;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class StaionDaoTest {
	@Autowired
	StationDao stationDao;
	@Autowired
	RailwayDao railwayDao;
	
	
	@Test
	void populateSts() {
		Railway railway=railwayDao.findById(1L).orElseThrow();
		List<Station> stations=List.of(new Station("AF123", "Tirupati", 10),
				new Station("BF123", "Hyderabad", 10),
				new Station("CF123", "Mumbai", 10)
				);
		stations.forEach(s->railway.addStation(s));
		List<Station> stations2=stationDao.saveAll(stations);
		assertEquals(3, stations2.size());
	}
}
