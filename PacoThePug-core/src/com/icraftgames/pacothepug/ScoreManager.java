package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreManager {
	
	BitmapFont font;
	
	public static int score;
	
	public void init() {
		score = 0;
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
	}
	
	public void render(SpriteBatch batch) {
		font.setColor(Color.WHITE);
		font.draw(batch, "Score: " + score, Gdx.graphics.getWidth() / 2 - 3 * 32, Gdx.graphics.getHeight() - 50);
	}

}
