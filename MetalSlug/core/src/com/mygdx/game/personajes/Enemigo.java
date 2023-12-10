package com.mygdx.game.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utiles.Render;

public class Enemigo {
    private float x, y;
    private float speed;
    private Texture img;
    private TextureRegion [] regionsMovimiento;
    private Animation animacion;
    private TextureRegion frameActual;
    private float tiempo;

    public Enemigo(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 100.0f; // Ajusta la velocidad según tus necesidades
        this.img = new Texture("Enemigo-movimiento-izquierda.png"); // Ajusta el nombre del archivo según tu textura de enemigo
    }

    public void render(SpriteBatch batch) {
         tiempo += Gdx.graphics.getDeltaTime(); //el tiempo que pasa desde el ultimo render
         frameActual = (TextureRegion) animacion.getKeyFrame(tiempo, true);
         Render.batch.draw(frameActual, x, y);
    }

    public void actualizar() {
        // Implementa la lógica de actualización del enemigo, por ejemplo, movimiento, colisiones, etc.
        y -= speed * Gdx.graphics.getDeltaTime(); // Mueve el enemigo hacia arriba para que se acerque al jugador
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return img.getHeight();
    }

    public void dispose() {
        // Libera los recursos de la textura cuando ya no se necesiten
        img.dispose();
    }
    
    public void animaciones() {
    	   img = new Texture(Gdx.files.internal("Enemigo-movimiento-izquierda.png"));
        TextureRegion [][] tmp = TextureRegion.split(img, img.getWidth()/12, img.getHeight());
        regionsMovimiento = new TextureRegion[12];
        for (int i=0; i<12 ; i++) {
        	regionsMovimiento[i] = tmp[0][i];
        	}
        animacion = new Animation(1/9f,regionsMovimiento);
        
    }
}