package com.jspiders.switchexp;

public class MercuryLightimpl implements ISwitch {

	@Override
	public void switchOn() {
		System.out.println("mercury light on");
	}

	@Override
	public void switchOff() {
		System.out.println("mercury light off");
	}

}
