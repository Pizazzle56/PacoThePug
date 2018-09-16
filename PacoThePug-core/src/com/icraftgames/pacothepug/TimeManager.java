package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class TimeManager {

	int Countdown = 10;
	
	BitmapFont font;
	
	public static boolean isGameOver;
	
	private int timerLevel;
	
	private Timer timer;
	
	public void init() {
		timerLevel = LevelManager.level;
		
		isGameOver = false;
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		
		timer = new Timer();
		
		timer.start();
	if(timerLevel == LevelManager.level) {
		timer.scheduleTask(new Task() {
			@Override
			public void run() {
				Countdown--;
			}
		}, 1.0f, 1.0f);
	} 
	}
	
	public void render(SpriteBatch batch) {
		font.setColor(Color.WHITE);
		
		String countdownText = "Countdown: " + Integer.toString(Countdown);
		
		GlyphLayout glyphLayout = new GlyphLayout(font, countdownText);
		
		
		font.getData().setScale(0.75f);
		font.draw(batch, countdownText, Gdx.graphics.getWidth() - glyphLayout.width - 18, 0 + Gdx.graphics.getHeight() / 4);
		
		
		if(Countdown == 0) {
			isGameOver = true;
		}
		
		if(timerLevel != LevelManager.level && LevelManager.level < 5) {
			timerLevel = LevelManager.level;
			Countdown = 10;
		}
		else if(timerLevel != LevelManager.level && LevelManager.level >= 5 && LevelManager.level < 10) {
			timerLevel = LevelManager.level;
			Countdown = 9;
		}
	}
	
}
