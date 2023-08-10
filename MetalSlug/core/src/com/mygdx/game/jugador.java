package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class jugador {

      public float x, y;
      private Animation animacion;
      private float tiempo;
      private TextureRegion [] regionsMovimiento;
      private Texture img;
      private TextureRegion frameActual;



    public jugador(float x, float y) {
        this.x = x;
        this.y = y;
        //cargar imagen
        img = new Texture(Gdx.files.internal("Sprite-Quieto.png"));
        TextureRegion [][] tmp = TextureRegion.split(img, img.getWidth()/3, img.getHeight());
        regionsMovimiento = new TextureRegion[3];
        for (int i=0; i<3 ; i++) {
        	regionsMovimiento[i] = tmp[0][i];
        }
       
        animacion = new Animation(1/6f,regionsMovimiento);
        tiempo = 0f;

        
    }

    public void render(final SpriteBatch batch) {
        tiempo += Gdx.graphics.getDeltaTime(); //el tiempo que pasa desde el ultimo render
        frameActual = (TextureRegion) animacion.getKeyFrame(tiempo, true);
        batch.draw(frameActual, x, y);
    }
    
  
    public void movimiento( ) {
    	
    	if ((Gdx.input.isKeyPressed(Input.Keys.D))) { x += 1; } 
    	else if ((Gdx.input.isKeyPressed(Input.Keys.A))) { x -= 1; }
    }




}