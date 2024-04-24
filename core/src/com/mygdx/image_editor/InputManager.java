package com.mygdx.image_editor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.io.IOException;
import java.util.ArrayList;

public class InputManager implements InputProcessor {
    public ArrayList<IClickable> clickables = new ArrayList<>();
    public ArrayList<IHoverable> hoverables = new ArrayList<>();
    static InputManager Instance;
    private IClickable _currentlyClicked;
    private IHoverable _currentlyHovered;
    private boolean _controlPressed;
    public InputManager() {
        Instance = this;
    }

    @Override
    public boolean keyDown(int i) {
        if (_controlPressed && i == Input.Keys.S) {
            try {
                ImageInputOutput.Instance.saveImage("C:\\Users\\engoo\\Desktop\\test\\output.bmp");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (i == Input.Keys.CONTROL_LEFT) _controlPressed = true;
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        if (i == Input.Keys.CONTROL_LEFT) _controlPressed = false;
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        IClickable collision = CollisionManager.Instance.getClicked(
                new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1)
        );
        if (collision != null) {
            collision.onClickDown(new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1));
            _currentlyClicked = collision;
        }
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        IClickable collision = CollisionManager.Instance.getClicked(
                new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1)
        );
        if (collision != null) {
            collision.onClickUp(new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1));
            _currentlyClicked.onClickUp(new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1));
        }
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        mouseMoved(i, i1);
        if (_currentlyClicked != null) {
            _currentlyClicked.onClickDragged(new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1));
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        IHoverable collision = CollisionManager.Instance.getHovered(
                new Vector2(i, ImageEditor.Instance.ScreenSize.y - i1)
        );
        if (_currentlyHovered != null && _currentlyHovered != collision)
        {
            _currentlyHovered.onHoverExit();
        }
        if (collision != null) {
            _currentlyHovered = collision;
            collision.onHovered();
        }
        return true;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
