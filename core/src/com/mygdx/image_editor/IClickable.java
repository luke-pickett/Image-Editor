package com.mygdx.image_editor;

import com.badlogic.gdx.math.Vector2;

public interface IClickable {
    public void onClickUp(Vector2 clickPosition);
    public void onClickDown(Vector2 clickPosition);
    public void onClickDragged(Vector2 clickPosition);
}
