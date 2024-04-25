package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class ClearDoodleButton extends Button{
    ClearDoodleButton(Vector2 scale, Vector2 position, Color recColor) {
        super(scale, position, recColor);
        ButtonText = "Clear";
    }

    @Override
    public void onClickUp(Vector2 clickPosition) {
        super.onClickUp(clickPosition);
        EditWindow edit = EditWindow.Instance;
        edit.DoodleMap = new Pixmap((int) edit.Scale.x, (int) edit.Scale.y, Pixmap.Format.RGBA8888);
        edit.DoodleMap.setColor(edit.DrawColor);
        edit.DoodleTexture = new Texture(edit.DoodleMap);
    }
}
