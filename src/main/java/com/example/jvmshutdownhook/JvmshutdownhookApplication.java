package com.example.jvmshutdownhook;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JvmshutdownhookApplication {

	static class HookThread extends Thread {
		@Override
		public void run() {
			System.out.println("Hook run");
		}
	}
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new HookThread());

		try {
			System.out.println("Sleep 3");
			Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}

}
