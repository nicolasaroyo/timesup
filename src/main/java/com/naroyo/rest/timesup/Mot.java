package com.naroyo.rest.timesup;

import java.util.List;

public class Mot {
	private String mot;
	private List<Tag> tags;

	public Mot() {

	}

	public Mot(final String mot, final List<Tag> tags) {
		this.mot = mot;
		this.tags = tags;
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

	public void setTags(final List<Tag> tags) {
		this.tags = tags;
	}
}
