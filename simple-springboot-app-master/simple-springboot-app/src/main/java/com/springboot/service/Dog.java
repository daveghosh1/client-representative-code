package com.springboot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("dog")
public class Dog implements Animal {

	@Override
	public String characteristics() {
		// TODO Auto-generated method stub
		return "Bark";
	}
}
