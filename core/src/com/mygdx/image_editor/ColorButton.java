package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class ColorButton extends Button {
    public ColorButton(Vector2 scale, Vector2 position, Color recColor) {
        super(scale, position, recColor);
    }

    @Override
    public void onClickUp(Vector2 clickPosition) {
        super.onClickUp(clickPosition);
        EditWindow.Instance.DrawColor = _startColor;
        EditWindow.Instance.DoodleMap.setColor(_startColor);
    }
}
