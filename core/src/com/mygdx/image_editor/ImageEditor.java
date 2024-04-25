package com.mygdx.image_editor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class ImageEditor extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public Vector2 ScreenSize;
	public static ImageEditor Instance;
	private EditWindow _editWindow;
	public ArrayList<Rec2D> Rectangles = new ArrayList<Rec2D>();
	public Button goldButton;
	public Button redButton;
	public Button blueButton;
	public Button greenButton;
	public Button whiteButton;
	public Button grayButton;
	public Button navyButton;
	public Button blackButton;
	public Button brownButton;
	public Button purpleButton;
	public Button orangeButton;
	public Button scarletButton;

	public ImageEditor() {
		Instance = this;
	}

	public void filesImported(String[] filePaths) {
		Pixmap map = ImageInputOutput.Instance.loadImage(filePaths[0]);
		if (map == null) return;
		_editWindow.RecTexture = new Texture(map);
	}
	
	@Override
	public void create () {
		initializeUtilityClasses();
		createGraphicalElements();
    }
	private BitmapFont _font;
	private void initializeUtilityClasses() {
		new CollisionManager();
		new ImageInputOutput();
		InputManager inputManager = new InputManager();
		Gdx.input.setInputProcessor(inputManager);
		_font = new BitmapFont();
	}
	private void createGraphicalElements() {
		ScreenSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Vector2 editWindowSize = new Vector2(500, ScreenSize.y - 25);

		new SaveButton(new Vector2(75, 25), new Vector2(0, ScreenSize.y - 25), Color.SLATE);
		new ExitButton(new Vector2(75, 25), new Vector2(75, ScreenSize.y - 25), Color.SLATE);
		new ClearDoodleButton(new Vector2(75, 25), new Vector2(150, ScreenSize.y - 25), Color.SLATE);

		goldButton = new ColorButton(new Vector2(50, 50), Vector2.Zero, Color.GOLD);
		redButton = new ColorButton(new Vector2(50, 50), new Vector2(42,0), Color.RED);
		blueButton = new ColorButton(new Vector2(50, 50), new Vector2(0,42), Color.BLUE);
		greenButton = new ColorButton(new Vector2(50, 50), new Vector2(42,42), Color.GREEN);
		whiteButton = new ColorButton(new Vector2(50, 50), new Vector2(0,84), Color.WHITE);
		grayButton = new ColorButton(new Vector2(50, 50), new Vector2(42,84), Color.GRAY);
		navyButton = new ColorButton(new Vector2(50, 50), new Vector2(0,126), Color.NAVY);
		blackButton = new ColorButton(new Vector2(50, 50), new Vector2(42,126), Color.BLACK);
		brownButton = new ColorButton(new Vector2(50, 50), new Vector2(0,168), Color.BROWN);
		purpleButton = new ColorButton(new Vector2(50, 50), new Vector2(42,168), Color.PURPLE);
		orangeButton = new ColorButton(new Vector2(50, 50), new Vector2(0,210), Color.ORANGE);
		scarletButton = new ColorButton(new Vector2(50, 50), new Vector2(42,210), Color.SCARLET);
		batch = new SpriteBatch();
		_editWindow = new EditWindow(editWindowSize, new Vector2(ScreenSize.x - editWindowSize.x, 0));
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
		for (int i = 0; i < Rectangles.size(); i++) {
			rec = Rectangles.get(i);
			if (rec instanceof Button) {
				Button button = (Button) rec;
				if (button.ButtonText == null) continue;
				_font.draw(batch, button.ButtonText, button.Position.x, button.Position.y + button.Scale.y * 0.75f,
						button.Scale.x, Align.center, false);
			}
		}
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
