package com.java.multithreading.concepts;

import java.util.Arrays;

public class ImmutableTest {

	public static void main(String[] args) {
		
		ImmutableCheck im = new ImmutableCheck(1,"Ravi",23, Arrays.asList("absc234", "23rfgh"));

		System.out.println(im.toString());
	}

}
