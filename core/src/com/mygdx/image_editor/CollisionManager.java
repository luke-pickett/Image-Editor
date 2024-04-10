package com.mygdx.image_editor;

import com.badlogic.gdx.math.Vector2;

public class CollisionManager {
    public static CollisionManager Instance;
    private Rec2D _recOne, _recTwo;

    public CollisionManager() {
        Instance = this;
    }

    public IHoverable getHovered(Vector2 position) {
        Rec2D hovered;
        for (int i = 0; i < InputManager.Instance.hoverables.size(); i++) {
            hovered = (Rec2D) InputManager.Instance.hoverables.get(i);
            if (position.x > hovered.Position.x && position.x < hovered.Position.x + hovered.Scale.x) {
                if (position.y > hovered.Position.y && position.y < hovered.Position.y + hovered.Scale.y) {
                    return (IHoverable) hovered;
                }
            }
        }
        return null;
    }

    public IClickable getClicked(Vector2 position) {
        Rec2D clicked;
        for (int i = 0; i < InputManager.Instance.clickables.size(); i++) {
            clicked = (Rec2D) InputManager.Instance.clickables.get(i);
            if (position.x > clicked.Position.x && position.x < clicked.Position.x + clicked.Scale.x) {
                if (position.y > clicked.Position.y && position.y < clicked.Position.y + clicked.Scale.y) {
                    return (IClickable) clicked;
                }
            }
        }
        return null;
    }
}
