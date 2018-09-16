package com.icraftgames.pacothepug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	public int playerWidth;
	public int playerHeight;
	
	public int playerX;
	public int playerY;
	
	private boolean movingLeft;
	
	private int playerSpeed;
	
	private Texture playerImage;
	
	public void init() {
		playerWidth = 128;
		playerHeight = 128;
		
		playerX = 0;
		playerY = 0;
		
		playerSpeed = 5;
		
		playerImage = new Texture("Player.png");
	}
	
	public void render(SpriteBatch batch) {
		if(!movingLeft)
			batch.draw(playerImage, playerX, playerY, playerWidth, playerHeight);
		else 
			batch.draw(playerImage, movingLeft ? playerX+playerWidth : playerX, playerY, movingLeft ? -playerWidth : playerWidth, playerHeight);
		
	}
	
	public void update() {
		if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
			playerY+= playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			playerY-= playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			playerX-= playerSpeed;
			movingLeft = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			playerX+= playerSpeed;
			movingLeft = false;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			System.out.println("PlayerX: " + playerX + " PlayerY: " + playerY);
		}
		
		if(playerX > Gdx.graphics.getWidth()) 
			playerX = 0 - playerWidth;
		if(playerX + playerWidth < 0)
			playerX = Gdx.graphics.getWidth();
		if(playerY > Gdx.graphics.getHeight())
			playerY = 0 - playerHeight;
		if(playerY + playerHeight < 0)
			playerY = Gdx.graphics.getHeight();
	}
	
	public void dispose() {
		playerImage.dispose();
	}

}
