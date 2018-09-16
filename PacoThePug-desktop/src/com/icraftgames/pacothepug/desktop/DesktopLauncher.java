package com.icraftgames.pacothepug.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.icraftgames.pacothepug.PacoThePug;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Paco the Pug!";
		config.width = 800;
		config.height = 800;
		new LwjglApplication(new PacoThePug(), config);
	}
}
