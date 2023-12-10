//alt + shift + R para cambiar todas las variables del mismo nombre
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.pantallas.Mapa;
import com.mygdx.game.personajes.Enemigo;
import com.mygdx.game.personajes.MetalGuy;
import com.mygdx.game.personajes.Soldado;
import com.mygdx.game.personajes.jugador;
import com.mygdx.game.utiles.Render;


public class Mijuego extends Game{
    Texture img;

    private OrthographicCamera camara; 
   
    private Enemigo enemigo;
    int x;
    private Array<Soldado> enemigos;
    private long lastEnemySpawnTime;
    private int enemigoX = 400;
    private int enemigoY = 100;
    private jugador MetalGuy;
    private TmxMapLoader mapLoader;
	private TiledMap mapa;
	private OrthogonalTiledMapRenderer renderer;


  
	// En tu método spawnEnemigos()
	private void spawnEnemigos() {
	    float spawnInterval = 2.0f;

	    // Genera un nuevo enemigo cada cierto intervalo
	    if (TimeUtils.nanoTime() - lastEnemySpawnTime > spawnInterval * 1000000000 && enemigos.size<1) {
	        Soldado nuevoEnemigo = new Soldado(enemigoX, enemigoY); // Establece las coordenadas iniciales X e Y
	        enemigos.add(nuevoEnemigo);
	        lastEnemySpawnTime = TimeUtils.nanoTime();
	    }
	    }
	
	 
	    public void create () {
	        Render.batch = new SpriteBatch();
	        setScreen(new Mapa(this));
	        camara = new OrthographicCamera();
	        camara.setToOrtho(false,800,400);  // Hace que el eje Y siga hacia arriba, 800 es el alto y 400 el ancho de la camara
	        camara.update(); // actualiza la camara por cada frame 
	         // Ajusta las coordenadas iniciales del jugador
	        enemigo = new Enemigo(400, 50);
	        enemigos = new Array<>();
	        lastEnemySpawnTime = TimeUtils.nanoTime();
	        MetalGuy = new MetalGuy(100,28);
	        mapLoader = new TmxMapLoader();
			mapa = mapLoader.load("Mapa/MAPA ONE.tmx");
			renderer = new OrthogonalTiledMapRenderer(mapa);
	       
	    }




	public void show() {
		
		
	}




	@Override
	public void render() {
		 Render.limpiarPantalla();
	        Render.batch.setProjectionMatrix(camara.combined);
	        Render.batch.begin();
			//jugador
	        MetalGuy.render(Render.batch);
	        camara.position.set(MetalGuy.getX()+130, MetalGuy.getY()+90, 0);
	        camara.update();
	        renderer.setView(camara);
	        renderer.render();
	     // Dibuja y actualiza enemigos existentes
	        for (Enemigo enemigo : enemigos) {
	            enemigo.render(Render.batch);
	        }
	        // Genera enemigos continuamente
	        spawnEnemigos();
	        Render.batch.end();
	        
	        
		
	}




	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void dispose() {
		enemigo.dispose();
    	MetalGuy.dispose();
        Render.batch.dispose();
        for (Enemigo enemigo : enemigos) {
            enemigo.dispose();
        }
    }
		
	}
	    
	    
	


