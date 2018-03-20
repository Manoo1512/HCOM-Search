package com.hotels.in.config;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	
	public static String url;
    public static String browser;
    public static String mode;
	
	public static void setProperties(String environment) throws Exception{
		
		Properties p = new Properties();
        p.load((new FileInputStream(System.getProperty("user.dir") + "/configFiles/framework.properties")));
        url = p.getProperty(environment+".URL");
        browser = p.getProperty(environment+".browser").toUpperCase();
        mode = p.getProperty(environment+".mode").toLowerCase();
	}

}
