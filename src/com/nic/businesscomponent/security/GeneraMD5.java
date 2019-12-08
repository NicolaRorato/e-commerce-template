package com.nic.businesscomponent.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneraMD5 {
	public static String convertiMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte [] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer sb = new StringBuffer();
			for (int i=0; i<array.length; i++) {
				sb.append(String.format("%02x", array[i]));
			}
			return sb.toString();
		} catch(NoSuchAlgorithmException exc) {
			exc.printStackTrace();
		}
		return null;
	}
}
