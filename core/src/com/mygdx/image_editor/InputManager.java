package com.mygdx.image_editor;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class InputManager implements InputProcessor {
    static InputManager Instance;
    public InputManager() {
        Instance = this;
    }
    public Array<Button> Buttons =  new Array<Button>();

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        Button collision = CollisionManager.Instance.getCollision(
                new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1)
        );
        if (collision != null) {collision.OnPressed();}
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return true;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
