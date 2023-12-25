package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.RailType;
import com.app.pojos.Railway;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RailwayDaoTest {
	@Autowired
	private RailwayDao railwayDao;
	@Test
	void populateRails() {
		List<Railway> rails=List.of(
				new Railway("toronto", RailType.EXPRESS, LocalTime.parse("10:20:02"), LocalTime.parse("19:30:17"), "Hyderabad", "Mumbai"),
				new Railway("rayalaseema", RailType.AC, LocalTime.parse("07:20:02"),LocalTime.parse("08:20:02"), "Tirupati", "Hyderbad"),
				new Railway("shatabdi", RailType.SHATABDI,LocalTime.parse("06:20:02"), LocalTime.parse("16:20:02"), "Pune", "Mumbai")	
				);
		List<Railway> railways=railwayDao.saveAll(rails);
		assertEquals(3,railways.size());
	}
}
