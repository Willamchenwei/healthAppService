package com.health.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadStream {
	public static String readStream (InputStream in) {
		StringBuffer sb = new StringBuffer();
		BufferedReader read = null;
		try {
			read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String str;
			while ((str = read.readLine()) != null)
				sb.append(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
