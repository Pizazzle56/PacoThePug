package com.icraftgames.pacothepug;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameWorldManager {

	ScoreManager scoreManager;
	TimeManager timeManager;
	LevelManager levelManager;
	
	ArrayList<Coin> coinsToRemove = new ArrayList<Coin>();
	
	public void init() {
		scoreManager = new ScoreManager();
		scoreManager.init();
		
		timeManager = new TimeManager();
		timeManager.init();
		
		levelManager = new LevelManager();
		levelManager.init();
	}
	
	public void checkOverlaps(Player player, CoinManager coinManager) {
		for(int i = 0; i < coinManager.numCoins; i++) {
			if(coinManager.coins.size() != 0) {
			if((player.playerX < coinManager.coins.get(i).coinX + coinManager.coins.get(i).coinScale 
					&& player.playerX + player.playerWidth > coinManager.coins.get(i).coinX + coinManager.coins.get(i).coinScale) 
					&& (player.playerY < coinManager.coins.get(i).coinY + coinManager.coins.get(i).coinScale 
					&& player.playerY + player.playerHeight > coinManager.coins.get(i).coinY + coinManager.coins.get(i).coinScale)) {
				System.out.println("Coin Get! Player: ("+ player.playerX + "," + player.playerY + ") Coin: (" + coinManager.coins.get(i).coinX + "," + coinManager.coins.get(i).coinY + ")");
				coinsToRemove.add(coinManager.coins.get(i));
				scoreManager.score++;
				coinManager.numCoins--;
				
				
			}
		}
		if(coinManager.numCoins == 0) {
			System.out.println("Level Passed!");
			
			LevelManager.level++;
			coinManager.regenerateCoins(10 + 2 * levelManager.level);
			
		}
		
		for(Coin c: coinsToRemove) {
			coinManager.coins.remove(c);
		}
	}
	}
	
	public void render(SpriteBatch batch) {
		scoreManager.render(batch);
		timeManager.render(batch);
		levelManager.render(batch);
	}
	
}
