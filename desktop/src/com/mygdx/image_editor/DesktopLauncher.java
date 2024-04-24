package com.mygdx.image_editor;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowAdapter;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.mygdx.image_editor.ImageEditor;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		ImageEditor editor = new ImageEditor();
		config.setWindowListener(new Lwjgl3WindowAdapter() {
			public void filesDropped (String[] files) {
				editor.filesImported(files);
			}
		});
		config.setForegroundFPS(60);
		config.setTitle("ImageEditor");
		config.setWindowedMode(584, 480);
		System.out.println("Project made by: Luke Pickett");
		new Lwjgl3Application(editor, config);
	}
}
