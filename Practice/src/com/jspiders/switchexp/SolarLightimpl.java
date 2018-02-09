package com.jspiders;

public class SolarLightimpl implements ISwitch {

	@Override
	public void switchOn() {
		System.out.println("Solarlight light on");
	}

	@Override
	public void switchOff() {
		System.out.println("Solarlight light off");
	}

}
