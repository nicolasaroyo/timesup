package com.naroyo.controller.timesup;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.naroyo.db.timesup.TimesUpRepository;
import com.naroyo.rest.timesup.Mot;
import com.naroyo.rest.timesup.Tag;

public class TimesUpController {

	private final TimesUpRepository repository = new TimesUpRepository();

	public List<Mot> recupererListeMots(final List<Tag> includes, final List<Tag> excludes, final int nbMax) {
		final List<Mot> mots = this.repository.findAll();

		// @formatter:off
		return mots.stream()
			.filter(mot -> !Collections.disjoint(mot.getTags(), includes))
			.filter(mot -> Collections.disjoint(mot.getTags(), excludes))
			.limit(nbMax)
			.collect(Collectors.toList());
		// @formatter:on		
	}

	public List<Mot> recupererTousLesMots() {
		return this.repository.findAll();
	}

	public boolean ajouterMot(final Mot mot) {
		return this.repository.addMot(mot);
	}

}
