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
		Cube Rubix = new Cube();
		Moves.Move("U", Rubix);
		Moves.Move("L", Rubix);
		Moves.Move("BI", Rubix);
		Moves.Move("U2", Rubix);
		Moves.Move("RI", Rubix);
		String[] faceNames = {"WHITE", "RED", "YELLOW", "ORANGE", "GREEN", "BLUE"};
		int faceIndex = 1;
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for(int i = 0; i<3; i++){
			for(int j=0;j<3;j++){
				if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("WHITE")){
					shapeRenderer.setColor(Color.WHITE);
				}else if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("BLUE")){
					shapeRenderer.setColor(Color.BLUE);
				}else if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("GREEN")){
					shapeRenderer.setColor(Color.GREEN);
				}else if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("YELLOW")){
					shapeRenderer.setColor(Color.YELLOW);
				}else if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("RED")){
					shapeRenderer.setColor(Color.RED);
				}else if(Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("ORANGE")){
					shapeRenderer.setColor(Color.ORANGE);
				}
				shapeRenderer.rect(240+(j*80), 360-(i*80), 64, 64);
			}
		}
		shapeRenderer.end();
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

}
