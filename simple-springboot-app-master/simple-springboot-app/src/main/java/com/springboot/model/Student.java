package com.springboot.model;

import java.io.Serializable;

public record Student(String id,
String firstName,
String lastName,
String age) implements Serializable {

	private static final long serialVersionUID = 1L;

}