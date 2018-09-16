package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelManager {
	
	public static int level;
	
	private BitmapFont font;
	
	public void init() {
		level = 1;
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
	}
	
	public void render(SpriteBatch batch) {
		
		font.setColor(Color.WHITE);
		
		String levelString = "Level: " + Integer.toString(level);
		
		GlyphLayout glyphLayout = new GlyphLayout(font, levelString);
		
		font.getData().setScale(0.75f);
		font.draw(batch, levelString, 0 + 18, 0 + Gdx.graphics.getHeight() / 4);
		
	}

}
