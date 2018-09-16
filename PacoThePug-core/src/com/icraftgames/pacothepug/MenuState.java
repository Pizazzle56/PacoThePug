package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState implements Screen {

	BitmapFont font;
	
	String title;
	String about;
	
	Texture pug;
	
	SpriteBatch batch;
	
	float growthScale, growthSpeed;
	
	public boolean startGame, isCurrent;
	
	float red,blue,green;
	
	@Override
	public void show() {
		
		startGame = false;
		isCurrent = false;
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		title = "Paco the Pug!";
		about = "Press Enter to Start!";
		
		
		pug = new Texture("Player.png");
		
		batch = new SpriteBatch();
		
		growthScale = 1;
		growthSpeed = .01f;
		
		red = 255;
		blue = 0;
		green = 0;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.77f, .77f, .77f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		font.setColor(Color.BLACK);
		
		GlyphLayout glyphLayout = new GlyphLayout(font, title);
		font.draw(batch, title, Gdx.graphics.getWidth() / 2 - glyphLayout.width / 2, Gdx.graphics.getHeight() - 100);
		glyphLayout = new GlyphLayout(font, about);
		font.draw(batch, about, Gdx.graphics.getWidth() / 2 - glyphLayout.width / 2, Gdx.graphics.getHeight() - 200);
		
		
		batch.setColor(Color.argb8888(red, blue, green, 0));
		batch.draw(pug, Gdx.graphics.getWidth() / 2 - pug.getWidth() / 2, Gdx.graphics.getHeight() / 8);
		
		if(isCurrent)
			colorizePug();
		
		batch.end();
		
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			startGame = true;
		}
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
	
	public void colorizePug() {
		if(red > 0) 
			red -= growthSpeed;
		if(blue < 255)
			blue += growthSpeed;
		if(green < 255)
			green += growthSpeed / 2;
	}
	

	@Override
	public void dispose() {
		pug.dispose();
		batch.dispose();
	}

}
