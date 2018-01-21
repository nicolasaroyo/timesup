package com.naroyo.rest.timesup;

import java.util.ArrayList;
import java.util.List;

public class Mot {
	private String mot;
	private final List<Tag> tags = new ArrayList<>();

	public Mot(final String mot, final List<Tag> tags) {
		this.mot = mot;
		this.tags.clear();
		this.tags.addAll(tags);
	}

	public String getMot() {
		return this.mot;
	}

	public void setMot(final String mot) {
		this.mot = mot;
	}

	public List<Tag> getTags() {
		return this.tags;
	}
}
