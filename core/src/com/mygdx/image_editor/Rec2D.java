package com.mygdx.image_editor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Rec2D {
    public Vector2 Scale;
    public Vector2 Position;
    public Vector2 Veloicty;
    public Texture RecTexture;
    private Pixmap _pixilMap;
    private Color _recColor;
    public int Width;
    public int Height;
    public int XPosition;
    public int YPosition;

    Rec2D (Vector2 scale, Vector2 pos, Vector2 velocity, Color color)
    {
        Scale = scale;
        Position = pos;
        Veloicty = velocity;
        _recColor = color;
        generateTexture();
    }

    private void generateTexture() {
        Pixmap rectangleMap = new Pixmap((int) Scale.x, (int) Scale.y, Pixmap.Format.RGBA8888);
        rectangleMap.setColor(_recColor);
        for (int x = 0; x < rectangleMap.getWidth(); x++) {
            for (int y = 0; y < rectangleMap.getHeight(); y++) {
                rectangleMap.drawPixel(x, y);
            }
        }
        RecTexture = new Texture(rectangleMap);
    }

    public void changeColor(Color newColor) {
        _recColor = newColor;
        generateTexture();
    }
}