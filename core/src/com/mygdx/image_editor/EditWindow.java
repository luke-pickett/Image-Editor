package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EditWindow extends Rec2D implements IClickable{
    public Texture DoodleTexture;
    private Pixmap _doodleMap;

    public EditWindow(Vector2 scale, Vector2 position, Color recColor) {
        super(scale, position, recColor);
        _doodleMap = new Pixmap((int) scale.x, (int) scale.y, Pixmap.Format.RGBA8888);
        _doodleMap.setColor(Color.ORANGE);
        DoodleTexture = new Texture(_doodleMap);
        InputManager.Instance.clickables.add(this);
    }
    public void OnClickDown(Vector2 clickPosition) {
        _doodleMap.drawPixel((int) (clickPosition.x - XPosition), Height - (int) clickPosition.y);
        DoodleTexture = new Texture(_doodleMap);
    }

    private void paintAtPosition(Vector2 worldPosition) {
        _doodleMap.drawPixel((int) (worldPosition.x - XPosition), (int) (Scale.y - worldPosition.y));
        DoodleTexture = new Texture(_doodleMap);
    }

    @Override
    public void onClickUp(Vector2 clickPosition) {

    }

    @Override
    public void onClickDown(Vector2 clickPosition) {
        paintAtPosition(Position);
    }

    @Override
    public void onClickDragged(Vector2 clickPosition) {
        paintAtPosition(clickPosition);
    }
}
