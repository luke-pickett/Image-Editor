package com.mygdx.image_editor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class ImageEditor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imageTwo;
	Pixmap rectangleMap;
	Pixmap otherRectangleMap;
	Rec2D rectangle;
	private Vector2 _screenSize;
	Random random;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		_screenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		rectangle =  new Rec2D(
				new Vector2(200, 100),
				new Vector2(200, 200),
				new Vector2(5, 5),
				Color.RED
		);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(rectangle.RecTexture, rectangle.Position.x, rectangle.Position.y);
		if (rectangle.Position.x >= _screenSize.x || rectangle.Position.x <= 0) {
			rectangle.Veloicty.x *= -1;
			random = new Random();
			rectangle.changeColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));
		}
		if (rectangle.Position.y >= _screenSize.y || rectangle.Position.y <= 0) {
			rectangle.Veloicty.y *= -1;
			random = new Random();
			rectangle.changeColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1));
		}
		rectangle.Position.add(rectangle.Veloicty);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
