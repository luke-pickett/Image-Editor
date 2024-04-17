package com.mygdx.image_editor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class ImageEditor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public Vector2 ScreenSize;
	public static ImageEditor Instance;
	private EditWindow _editWindow;
	public ArrayList<Rec2D> Rectangles = new ArrayList<Rec2D>();
	public Button button;

	public ImageEditor() {
		Instance = this;
	}
	
	@Override
	public void create () {
		new ImageInputOutput();
		Pixmap editMap = ImageInputOutput.Instance.loadImage("blackbuck.bmp");
		batch = new SpriteBatch();
		ScreenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		InputManager inputManager = new InputManager();
		Gdx.input.setInputProcessor(inputManager);
		Vector2 rectangleScale = new Vector2(100, 50);
		Vector2 editWindowSize = new Vector2(500, ScreenSize.y - 50);
		_editWindow = new EditWindow(
				editWindowSize, new Vector2(ScreenSize.x - editWindowSize.x, 0), Color.GRAY
		);
		_editWindow.DoodleTexture = new Texture(editMap);
		button = new Button(rectangleScale, new Vector2(0,0), Color.YELLOW);
		CollisionManager.Instance = new CollisionManager();

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		Rec2D rec;
		for (int i = 0; i < Rectangles.size(); i++) {
			rec = Rectangles.get(i);
			batch.draw(rec.RecTexture, rec.XPosition, rec.YPosition, rec.Scale.x, rec.Scale.y);
		}
		batch.draw(_editWindow.DoodleTexture, _editWindow.XPosition,
				_editWindow.YPosition, _editWindow.Scale.x, _editWindow.Scale.y
				);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
