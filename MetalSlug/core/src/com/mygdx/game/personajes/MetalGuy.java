package com.mygdx.game.personajes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utiles.Render;

public class MetalGuy extends jugador {
	
	private SpriteBatch b = Render.batch;
	
	public MetalGuy(float x, float y) {
		super(x, y);
		animaciones();
		b.begin();
		render(b);
		b.end();
	}

}
