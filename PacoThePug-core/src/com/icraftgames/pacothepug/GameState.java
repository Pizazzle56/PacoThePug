package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState implements Screen {

	SpriteBatch batch;
	Texture img;
	
	boolean isCurrent;
	
	public Sound music = Gdx.audio.newSound(Gdx.files.internal("Song.mp3"));
	
	Player player;
	CoinManager coinManager;
	GameWorldManager gameWorldManager;
	
	@Override
	public void show () {
		isCurrent = true;
		batch = new SpriteBatch();
		img = new Texture("Player.png");
		
		player = new Player();
		player.init();
		
		coinManager = new CoinManager();
		coinManager.init();
		
		gameWorldManager = new GameWorldManager();
		gameWorldManager.init();
		
		music.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(isCurrent){
			batch.begin();
			Texture background = new Texture("Background.png");
			batch.draw(background, 0, 0, 800, 800);
			player.render(batch);
			gameWorldManager.render(batch);
			coinManager.render(batch);
			batch.end();
		
			player.update();
		
			gameWorldManager.checkOverlaps(player, coinManager);
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.M)) {
			music.stop();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
		img.dispose();
		music.dispose();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

}
