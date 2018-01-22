package com.naroyo.db.timesup;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naroyo.rest.timesup.Mot;

public class TimesUpRepository {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private static final String DATABASE_FILE_NAME = "db.json";

	private ListeMots readFile() {
		final InputStream inputStream = this.getClass().getResourceAsStream(DATABASE_FILE_NAME);
		ListeMots liste = new ListeMots();
		try {
			liste = this.objectMapper.readValue(inputStream, ListeMots.class);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public List<Mot> findAll() {
		return this.readFile().getListe();
	}
}
