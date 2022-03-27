package com.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Shahrukh
 * @since 27-Mar-2022
 */
public class CommonUtils {
	
	private static Scanner scanner = null;
	private static SimpleDateFormat sdf = null;
	
	static {
		scanner = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

}
