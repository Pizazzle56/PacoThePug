package com.icraftgames.pacothepug;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacoThePug extends Game {

	GameState gameState;
	MenuState menuState;
	GameOverState gameOverState;
	
	@Override
	public void create() {
		
		gameState = new GameState();
		menuState = new MenuState();
		gameOverState = new GameOverState();
		
		setScreen(menuState);
		menuState.isCurrent = true;
	}
	
	@Override
	public void render() {
		super.render();
		
		if(TimeManager.isGameOver == true) {
			gameState.music.stop();
			gameState.isCurrent = false;
			setScreen(gameOverState);
		}
		
		if(menuState.startGame) {
			setScreen(gameState);
			menuState.startGame = false;
			menuState.isCurrent = false;
		}
		if(gameOverState.isGameStarted) {
			setScreen(gameState);
			gameOverState.isGameStarted = false;
			gameState.isCurrent = true;
		}
	}
	
	
}
