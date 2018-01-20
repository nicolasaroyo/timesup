package com.naroyo.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.naroyo.rest.test.MessageRestService;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<>();

	public MessageApplication() {
		this.singletons.add(new MessageRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
