package com.springboot.model;

import java.io.Serializable;


public record Student (String id, String firstName, String lastName, String age) {}