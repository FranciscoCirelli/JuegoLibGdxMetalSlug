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
import com.badlogic.gdx.utils.ScreenUtils;


public class Mijuego extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    private OrthographicCamera camara; 
    private jugador jugador;
    int x;

    @Override
    public void create () {
        batch = new SpriteBatch();
        camara = new OrthographicCamera();
        camara.setToOrtho(false,800,480);  // Hace que el eje Y siga hacia arriba, 800 es el alto y 400 el ancho de la camara
        camara.update(); // actualiza la camara por cada frame 

        jugador = new jugador(200,100);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camara.update();
        batch.setProjectionMatrix(camara.combined);
        
        batch.begin();
        jugador.render(batch);
        jugador.movimiento(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
