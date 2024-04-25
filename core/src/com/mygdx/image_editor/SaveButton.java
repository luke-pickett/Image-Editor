package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.io.IOException;

public class SaveButton extends Button {
    public SaveButton(Vector2 scale, Vector2 position, Color recColor) {
        super(scale, position, Color.SLATE);
        ButtonText = "Save";
    }

    @Override
    public void onClickUp(Vector2 clickPosition) {
        super.onClickUp(clickPosition);
        if (ImageInputOutput.Instance.ImageFolderLocation == null) return;
        try {ImageInputOutput.Instance.saveImage(ImageInputOutput.Instance.ImageFolderLocation + "\\output.bmp");}
        catch (IOException e) {e.printStackTrace();}
    }
}
