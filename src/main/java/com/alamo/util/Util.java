package com.alamo.util;

import java.util.Collection;

public class Util {
	public static boolean isEmptyOrNull(Object o) {
		if(o == null) {
			return true;
		} else {
			if(o instanceof String) {
				if(((String) o).isEmpty()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	} 
	
	public static boolean isEmptyOrNull(Collection<Object> list) {
		if(list == null) {
			return true;
		} else {
			if(list.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}
}
