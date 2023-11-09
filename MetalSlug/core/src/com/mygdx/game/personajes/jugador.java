package com.mygdx.game.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.utiles.Render;



public class jugador {

      public float x, y;
      private Animation animacion;
      private float tiempo;
      private TextureRegion [] regionsMovimiento;
      private Texture img;
      private TextureRegion frameActual;
      private TextureRegion [] regionsMovimientoDerecha;
      private Texture imgDerecha;
      private Animation animacionDerecha;
      private TextureRegion [] regionsMovimientoIzquierda;
      private Texture imgIzquierda;
      private Animation animacionIzquierda;
      private float velocidadY;
      private boolean enElAire;
      private static float GRAVEDAD = -1500f;
      private static float ALTURA_DEL_SUELO = 100.0f; // Ajusta este valor según tus necesidades
      private static float VELOCIDAD_INICIAL_DE_SALTO = 450f;
      



    public jugador(float x, float y) {
        this.x = x;
        this.y = y;
        //cargar imagen

        tiempo = 0f;

        
    }

    public void render(final SpriteBatch batch) {
    	 animaciones();
        tiempo += Gdx.graphics.getDeltaTime(); //el tiempo que pasa desde el ultimo render
        frameActual = (TextureRegion) animacion.getKeyFrame(tiempo, true);
        
        
    }
    
  
    public void movimiento(final SpriteBatch batch) {
    	if ((Gdx.input.isKeyPressed(Input.Keys.D))) { 
    		
    		x += 3;
    		frameActual = (TextureRegion) animacionDerecha.getKeyFrame(tiempo, true);
    		
    		Render.batch.draw(frameActual, x, y);
    		
    	
    	} else if ((Gdx.input.isKeyPressed(Input.Keys.A))) {
    		
    		x -= 3; 
    		frameActual = (TextureRegion) animacionIzquierda.getKeyFrame(tiempo, true);
    		
    		Render.batch.draw(frameActual, x, y);
    		
    	} else if (!(Gdx.input.isKeyPressed(Input.Keys.D)) || !(Gdx.input.isKeyPressed(Input.Keys.A))){
    		
    		frameActual = (TextureRegion) animacion.getKeyFrame(tiempo, true);
    		
    		Render.batch.draw(frameActual, x, y);
    	
    		
    	} if (Gdx.input.isKeyPressed(Input.Keys.W) && !enElAire) {
            // Salto
    		 
    		velocidadY = VELOCIDAD_INICIAL_DE_SALTO;
            enElAire = true;
            
            
        }

        if (enElAire) {
            // Aplicar gravedad y actualizar la posición vertical
            velocidadY += GRAVEDAD * Gdx.graphics.getDeltaTime();
            y += velocidadY * Gdx.graphics.getDeltaTime();

            // Comprobar si ha aterrizado en el suelo
            if (y <= ALTURA_DEL_SUELO ) {
                y = ALTURA_DEL_SUELO;
                enElAire = false;
                velocidadY = 0;
            }
        }

        // Dibuja el frame actual en la posición actual
        Render.batch.draw(frameActual, x, y);
    }
    	
    

     public void animaciones() {
    	 img = new Texture(Gdx.files.internal("Sprite-Quieto.png"));
         TextureRegion [][] tmp = TextureRegion.split(img, img.getWidth()/3, img.getHeight());
         regionsMovimiento = new TextureRegion[3];
         for (int i=0; i<3 ; i++) {
         	regionsMovimiento[i] = tmp[0][i];
         	}
         animacion = new Animation(1/6f,regionsMovimiento);
         
         imgDerecha = new Texture(Gdx.files.internal("sprite-movimiento-derecha.png"));
         TextureRegion [][] tmpDerecha = TextureRegion.split(imgDerecha, imgDerecha.getWidth()/9, imgDerecha.getHeight());
         regionsMovimientoDerecha = new TextureRegion[9];
         for (int i=0; i<9 ; i++) {
         	regionsMovimientoDerecha[i] = tmpDerecha[0][i];
         	}
         animacionDerecha = new Animation(1/13f,regionsMovimientoDerecha);
         
         imgIzquierda = new Texture(Gdx.files.internal("sprite-movimiento-izquierda.png"));
         TextureRegion [][] tmpIzquierda = TextureRegion.split(imgIzquierda, imgIzquierda.getWidth()/9, imgIzquierda.getHeight());
         regionsMovimientoIzquierda = new TextureRegion[9];
         for (int i=0; i<9 ; i++) {
        	 regionsMovimientoIzquierda[i] = tmpIzquierda[0][i];
         	}
         animacionIzquierda = new Animation(1/13f,regionsMovimientoIzquierda);
    	}
     
     


}