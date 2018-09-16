package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements Screen {

	BitmapFont font;
	SpriteBatch batch;
	
	public boolean isGameStarted = false;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		font.setColor(Color.WHITE);
		String gameOverText = "Game Over!";
		
		GlyphLayout glyphLayout = new GlyphLayout(font, gameOverText);
		batch.begin();
		font.draw(batch, "Game Over!", Gdx.graphics.getWidth() / 2 - glyphLayout.width / 2, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 4);
		
		String scoreString = "You scored: " + Integer.toString(ScoreManager.score) + " points!";
		glyphLayout = new GlyphLayout(font, scoreString);
		
		font.draw(batch, scoreString, Gdx.graphics.getWidth() / 2 - glyphLayout.width / 2, 0 + Gdx.graphics.getHeight() / 2);
		
		String enterToRetry= "Press Enter to Retry!";
		
		glyphLayout = new GlyphLayout(font, enterToRetry);
		font.draw(batch, enterToRetry, Gdx.graphics.getWidth() / 2 - glyphLayout.width / 2, 0 + Gdx.graphics.getHeight() / 4);
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) 
			isGameStarted = true;
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			Gdx.app.exit();
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
