package com.mygdx.image_editor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Button extends Rec2D {
    private static int _buttonCount;
    private int _buttonNumber;
    public Button(Vector2 scale, Vector2 position, Color recColor) {
        super (scale, position, recColor);
        _buttonCount += 1;
        _buttonNumber = _buttonCount;
        InputManager.Instance.Buttons.add(this);
    }

    public void OnPressed() {
        System.out.println("Button: " + _buttonNumber);
    }
}
