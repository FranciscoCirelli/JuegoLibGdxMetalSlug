package com.mygdx.game.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemigo {
    private float x, y;
    private float speed;
    private Texture texture;

    public Enemigo(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 100.0f; // Ajusta la velocidad según tus necesidades
        this.texture = new Texture("Enemigo-movimiento-izquierda.png"); // Ajusta el nombre del archivo según tu textura de enemigo
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void actualizar() {
        // Implementa la lógica de actualización del enemigo, por ejemplo, movimiento, colisiones, etc.
        y -= speed * Gdx.graphics.getDeltaTime(); // Mueve el enemigo hacia abajo (ajusta según tus necesidades)
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return texture.getHeight();
    }

    public void dispose() {
        // Libera los recursos de la textura cuando ya no se necesiten
        texture.dispose();
    }
}