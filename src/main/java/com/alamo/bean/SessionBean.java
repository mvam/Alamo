package com.alamo.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Marcos Moreira
 *
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

	Map<String, Object> objectChangeMap = new HashMap<String, Object>();
	
}
