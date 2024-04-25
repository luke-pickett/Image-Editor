package com.mygdx.image_editor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Button extends Rec2D implements IClickable, IHoverable {
    public String ButtonText;
    @Override
    public void onHovered() {
        if (_state == ButtonState.Clicked) {
            return;
        }
        _state = ButtonState.Hovered;
        _recColor = _hoveredColor;
        generateTexture();
    }

    @Override
    public void onHoverExit() {
        _state = ButtonState.None;
        _recColor = _startColor;
        generateTexture();
    }

    public enum ButtonState {Clicked, Hovered, None}
    private ButtonState _state;
    protected Color _startColor;
    private Color _hoveredColor;
    public Button(Vector2 scale, Vector2 position, Color recColor) {
        super (scale, position, recColor);
        _recColor = recColor;
        _startColor = recColor;
        _hoveredColor = new Color(_startColor.r / 2f, _startColor.g / 2f, _startColor.b/ 2f, 1);
        _state = ButtonState.None;
        InputManager.Instance.clickables.add(this);
        InputManager.Instance.hoverables.add(this);
    }

    public void OnClickDown(Vector2 clickPosition) {
        _recColor = new Color(_startColor.r / 4f, _startColor.g / 4f, _startColor.b / 4f, 1);
        generateTexture();
        _state = ButtonState.Clicked;
    }

    public void onClickUp(Vector2 clickPosition) {
        _recColor = _hoveredColor;
        generateTexture();
    }

    @Override
    public void onClickDown(Vector2 clickPosition) {
        _recColor = new Color(_startColor.r / 4f, _startColor.g / 4f, _startColor.b / 4f, 1);
        generateTexture();
        _state = ButtonState.Clicked;
    }

    @Override
    public void onClickDragged(Vector2 clickPosition) {

    }

    public void OnHovered() {
        if (_state == ButtonState.Clicked) {
            return;
        }
        _state = ButtonState.Hovered;
        _recColor = _hoveredColor;
        generateTexture();
    }

    public void OnHoverExit() {
        _state = ButtonState.None;
        _recColor = _startColor;
        generateTexture();
    }
}
