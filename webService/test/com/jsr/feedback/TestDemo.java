package com.jsr.feedback;

import com.jsr.pushclient.PushManager;


public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PushManager.getInstance().sendMessage("demo", "00000000", "到撒打算得到撒旦");
	}

}
