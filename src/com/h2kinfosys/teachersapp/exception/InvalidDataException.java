package com.h2kinfosys.teachersapp.exception;

public class InvalidDataException extends Exception{

	public InvalidDataException() {
		super();
	}

	public InvalidDataException(Exception ex) {
		super(ex);
	}

	public InvalidDataException(String message) {
		super(message);
	}
}
