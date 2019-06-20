package com.dna.postbook.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3638350423022232408L;

	public UserNotFoundException(String exception) {
	    super(exception);
	  }

}
