package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Rubik extends ApplicationAdapter {
	private ShapeRenderer shapeRenderer;
	private Rectangle bucket;
	private Texture bucketImage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.rect(240, 360, 64, 64);
		shapeRenderer.rect(320, 360, 64, 64);
		shapeRenderer.rect(400, 360, 64, 64);
		shapeRenderer.rect(240, 280, 64, 64);
		shapeRenderer.rect(320, 280, 64, 64);
		shapeRenderer.rect(400, 280, 64, 64);
		shapeRenderer.rect(240, 200, 64, 64);
		shapeRenderer.rect(320, 200, 64, 64);
		shapeRenderer.rect(400, 200, 64, 64);

		shapeRenderer.end();
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

}
