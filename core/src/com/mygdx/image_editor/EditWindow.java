package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EditWindow extends Rec2D implements IClickable{
    public static EditWindow Instance;
    public Texture DoodleTexture;
    public Pixmap DoodleMap;
    private Vector2 _previousPaintPosition;
    public Color DrawColor;

    public EditWindow(Vector2 scale, Vector2 position) {
        super(scale, position, Color.GRAY);
        DoodleMap = new Pixmap((int) scale.x, (int) scale.y, Pixmap.Format.RGBA8888);
        DrawColor = Color.ORANGE;
        DoodleMap.setColor(DrawColor);
        DoodleTexture = new Texture(DoodleMap);
        InputManager.Instance.clickables.add(this);
        Instance = this;
    }



    private void paintAtPosition(Vector2 worldPosition) {
        Vector2 paintPosition = new Vector2(worldPosition.x - XPosition, Scale.y - worldPosition.y);
        int startX = (int) _previousPaintPosition.x;
        int startY = (int) _previousPaintPosition.y;
        int endX = (int) paintPosition.x;
        int endY = (int) paintPosition.y;
        DoodleMap.drawLine(startX, startY, endX, endY);
        DoodleMap.drawLine(startX+1, startY, endX+1,endY);
        DoodleMap.drawLine(startX-1,startY,endX-1, endY);
        _previousPaintPosition = paintPosition;
        DoodleTexture = new Texture(DoodleMap);
    }

    @Override
    public void onClickUp(Vector2 clickPosition) {
        _previousPaintPosition = null;
    }

    @Override
    public void onClickDown(Vector2 clickPosition) {
        if (_previousPaintPosition == null) {
            _previousPaintPosition = new Vector2(clickPosition.x - XPosition, Scale.y - clickPosition.y);
        }
        paintAtPosition(clickPosition);
    }

    @Override
    public void onClickDragged(Vector2 clickPosition) {
        paintAtPosition(clickPosition);
    }
}
