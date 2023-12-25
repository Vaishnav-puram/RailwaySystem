package com.app.custExceptions;

import com.app.pojos.RailType;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(Long id) {
		super("Resouce not found for the id : "+id);
	}
	public ResourceNotFoundException(RailType railType) {
		super("Resouce not found for the category : "+railType);
	}
}
