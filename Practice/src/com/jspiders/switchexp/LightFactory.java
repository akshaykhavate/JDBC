package com.jspiders.switchexp;

public class LightFactory {
	public static ISwitch getlight(String typeOflight) {
		if(typeOflight.equalsIgnoreCase("led")){
		return new LEDLightimpl();
		}
		if(typeOflight.equalsIgnoreCase("solar")){
			return new SolarLightimpl();
		}
		else
			return new MercuryLightimpl();
	}
}
