package com.mygdx.image_editor;

import com.badlogic.gdx.math.Vector2;

public class CollisionManager {
    public static CollisionManager Instance;
    private Rec2D _recOne, _recTwo;

    public CollisionManager() {
        Instance = this;
    }

    public Button getCollision(Vector2 coordinates) {
        Button iteratingButton;
        for (int i = 0; i < InputManager.Instance.Buttons.size; i++) {
            iteratingButton = InputManager.Instance.Buttons.get(i);
            if ((coordinates.x >= iteratingButton.XPosition) && (coordinates.x <= iteratingButton.XPosition + iteratingButton.Width))
            {
                if ((coordinates.y >= iteratingButton.YPosition) && (coordinates.y <= iteratingButton.YPosition + iteratingButton.Height)) {
                    return iteratingButton;
                }
            }
        }
        return null;
    }
}
