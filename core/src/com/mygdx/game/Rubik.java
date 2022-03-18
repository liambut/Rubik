package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.badlogic.gdx.graphics.Texture;
import java.util.concurrent.TimeUnit;

public class Rubik extends ApplicationAdapter {
	private ShapeRenderer shapeRenderer;
	private Rectangle bucket;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	Stage stage;
	TextButton button;
	TextButtonStyle textButtonStyle;
	BitmapFont font;
	Skin skin;
	TextureAtlas buttonAtlas;
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		Cube Rubix = new Cube();
		makeMove("U", Rubix);
		makeMove("L", Rubix);
		makeMove("BI", Rubix);
		makeMove("U2", Rubix);
		makeMove("RI", Rubix);
		batch.begin();
		renderCube(Rubix);
		shapeRenderer.end();
		batch.end();
	}
	public void makeMove(String moveName, Cube Rubix){
		Moves.Move(moveName, Rubix);
	}
	public void renderCube(Cube Rubix){
		String[] faceNames = {"GREEN","YELLOW", "RED", "WHITE", "BLUE", "ORANGE"};
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for(int faceIndex = 0; faceIndex < 6; faceIndex++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("WHITE")) {
						shapeRenderer.setColor(Color.WHITE);
					} else if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("BLUE")) {
						shapeRenderer.setColor(Color.BLUE);
					} else if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("GREEN")) {
						shapeRenderer.setColor(Color.GREEN);
					} else if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("YELLOW")) {
						shapeRenderer.setColor(Color.YELLOW);
					} else if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("RED")) {
						shapeRenderer.setColor(Color.RED);
					} else if (Rubix.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals("ORANGE")) {
						shapeRenderer.setColor(Color.ORANGE);
					}
					if (faceNames[faceIndex].equals("BLUE")) {
						shapeRenderer.rect( 384 + (j * 64), 576 -((i + 1) * 64), 64, 64);
					} else if (faceNames[faceIndex].equals("YELLOW")) {
						shapeRenderer.rect( 192 + (j * 64), 384 -((i + 1) * 64), 64, 64);
					} else if (faceNames[faceIndex].equals("WHITE")) {
						shapeRenderer.rect( 192 + (j * 64), 768 -((i + 1) * 64), 64, 64);
					} else if (faceNames[faceIndex].equals("GREEN")) {
						shapeRenderer.rect( (j * 64), 576 -((i + 1) * 64), 64, 64);
					} else if (faceNames[faceIndex].equals("RED")) {
						shapeRenderer.rect( 192 + (j * 64), 576 -((i + 1) * 64), 64, 64);
					} else if (faceNames[faceIndex].equals("ORANGE")) {
						shapeRenderer.rect( 192 + (j * 64), 192 -((i + 1) * 64), 64, 64);
					}
				}
			}
		}
	}
	@Override
	public void dispose () {
		batch.dispose();
	}

}
