package io.github.kubaue.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.github.kubaue.RaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Super racer 9000";
		config.width = 1920;
		config.height = 1080;

		new LwjglApplication(new RaceGame(), config);
	}
}
