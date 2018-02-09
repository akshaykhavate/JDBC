package com.jspiders;

public class LEDLightimpl implements ISwitch {
	@Override
	public void switchOn() {
		System.out.println("LEDLight light on");
	}

	@Override
	public void switchOff() {
		System.out.println("LEDLight light off");
	}
}
