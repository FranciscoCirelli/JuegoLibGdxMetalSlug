package com.mygdx.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Mijuego;

public class Mapa implements Screen {
	private Mijuego juego;

	private OrthographicCamera camara;
	private Viewport gamePort;
	
	

	public Mapa(Mijuego juego) {
		this.juego = juego;
		camara = new OrthographicCamera();
		gamePort = new FitViewport(1280, 720, camara);
		camara.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
		
		
	}

	@Override
	public void show() { 
		

	}
	
	public void handleInput(float dt) {
		if(Gdx.input.isTouched())
		camara.position.x += 100 * dt;
	}
	
	public void update(float dt) {
		handleInput(dt);
		camara.update();
		
	}

	@Override
	public void render(float delta) {
	  update(delta);
	  
	  
	}

	@Override
	public void resize(int width, int height) {
		camara.viewportWidth = width;
		camara.viewportHeight = height;
		camara.update();
		
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
		
		
	}

	

}
