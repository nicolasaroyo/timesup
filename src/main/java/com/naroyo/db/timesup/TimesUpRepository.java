package com.naroyo.db.timesup;

import java.util.List;

import com.google.common.collect.Lists;
import com.naroyo.rest.timesup.Mot;
import com.naroyo.rest.timesup.Tag;

public class TimesUpRepository {

	public List<Mot> findAll() {
		final Mot mot1 = new Mot("La belle et la bête", Lists.newArrayList(Tag.DISNEY, Tag.FILM));
		final Mot mot2 = new Mot("Rambo", Lists.newArrayList(Tag.FILM));
		final Mot mot3 = new Mot("Soprano", Lists.newArrayList(Tag.MUSIQUE));
		return Lists.newArrayList(mot1, mot2, mot3);
	}
}
