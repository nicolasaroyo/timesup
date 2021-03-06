package com.naroyo.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.naroyo.rest.timesup.TimesUpRestService;

public class RestApplication extends Application {

	private Set<Object> singletons = new HashSet<>();

	public RestApplication() {
		this.singletons.add(new TimesUpRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
