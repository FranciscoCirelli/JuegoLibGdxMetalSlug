//alt + shift + R para cambiar todas las variables del mismo nombre
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.pantallas.PantallaMenu;
import com.mygdx.game.personajes.Enemigo;
import com.mygdx.game.personajes.jugador;
import com.mygdx.game.utiles.Render;


public class Mijuego extends ApplicationAdapter {
    Texture img;
    private OrthographicCamera camara; 
    private jugador jugador;
    private Enemigo enemigo;
    int x;
    private Array<Enemigo> enemigos;
    private long lastEnemySpawnTime;
    
    @Override
    public void create () {
        Render.batch = new SpriteBatch();
        camara = new OrthographicCamera();
        camara.setToOrtho(false,800,480);  // Hace que el eje Y siga hacia arriba, 800 es el alto y 400 el ancho de la camara
        camara.update(); // actualiza la camara por cada frame 

        jugador = new jugador(200,100);
        enemigo = new Enemigo(400, 100);
        enemigos = new Array<>();
        lastEnemySpawnTime = TimeUtils.nanoTime();
        
    }




	@Override
    public void render () {
		//camara
        camara.update();
        Render.limpiarPantalla();
        Render.batch.setProjectionMatrix(camara.combined);
        Render.batch.begin();
        //jugador
        jugador.render(Render.batch);
        jugador.movimiento(Render.batch);
     // Dibuja y actualiza enemigos existentes
        for (Enemigo enemigo : enemigos) {
            enemigo.render(Render.batch);
        }

        // Genera enemigos continuamente
        spawnEnemigos();
        Render.batch.end();
    }
	
	private void spawnEnemigos() {
	    float spawnInterval = 2.0f;

	    // Genera un nuevo enemigo cada cierto intervalo
	    if (TimeUtils.nanoTime() - lastEnemySpawnTime > spawnInterval * 1000000000) {
	        Enemigo nuevoEnemigo = new Enemigo(MathUtils.random(800), 480);
	        enemigos.add(nuevoEnemigo);
	        lastEnemySpawnTime = TimeUtils.nanoTime();
	    }

	    // Elimina enemigos que están fuera de la pantalla
	    Array<Enemigo> enemigosEliminar = new Array<>();
	    for (Enemigo enemigo : enemigos) {
	        enemigo.actualizar();

	        if (enemigo.getY() + enemigo.getHeight() < 0) {
	            enemigosEliminar.add(enemigo);
	        }
	    }

	    // Elimina los enemigos marcados para eliminación
	    enemigos.removeAll(enemigosEliminar, true);
	}

    @Override
    public void dispose () {
        Render.batch.dispose();
    }
}
