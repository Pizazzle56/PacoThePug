package com.icraftgames.pacothepug;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Coin {

	public int coinX;
	public int coinY;
	
	public int coinScale;
	
	public Texture coinImage;
	
	public void init() {
		coinImage = new Texture("Coin.png");
		
		Random r = new Random();
		
		coinScale = 32;
		coinX = r.nextInt(Gdx.graphics.getWidth() - coinScale);
		coinY = r.nextInt(Gdx.graphics.getHeight() - coinScale);
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(coinImage, coinX, coinY, coinScale, coinScale);
	}
	
}
