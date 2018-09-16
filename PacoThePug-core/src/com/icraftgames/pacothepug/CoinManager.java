package com.icraftgames.pacothepug;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoinManager {
	
	public int numCoins;
	

	
	public ArrayList<Coin> coins;
	
	private int coinScale = 32;
	
	private Texture coinImage;
	
	public void init() {
		numCoins = 10;
		
		coins = new ArrayList<Coin>();
		
		coinImage = new Texture("Coin.png");
		
		for(int i = 0; i < numCoins; i++) {
			Coin c = new Coin();
			c.init();
			coins.add(c);
		}
	}
	
	public void render(SpriteBatch batch) {
		for(Coin c : coins) {
			c.render(batch);
		}
	}
	
	public void regenerateCoins(int numCoins) {
		this.numCoins = numCoins;
		for(int i = 0; i < numCoins; i++) {
			Coin c = new Coin();
			c.init();
			coins.add(c);
		}
	}
	
}
