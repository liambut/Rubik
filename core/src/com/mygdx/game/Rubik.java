package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.IntSet;
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
	Cube Rubix;
	TextureAtlas buttonAtlas;
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
		batch = new SpriteBatch();
		Rubix = new Cube();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 576, 768);
	}
	private final IntSet downKeys = new IntSet(20);

	private InputAdapter inputAdapter = new InputAdapter(){
		public boolean keyDown (int keycode) {
			downKeys.add(keycode);
			if (downKeys.size >= 2){
				onMultipleKeysDown();
			}else{
				setMove();
			}

			return true;
		}

		public boolean keyUp (int keycode) {
			downKeys.remove(keycode);
			return true;
		}
	};

	private void onMultipleKeysDown (){
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.L)){
			if (downKeys.size == 2){
				makeMove("LI", Rubix);
			}
		}
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.R)){
			if (downKeys.size == 2){
				makeMove("RI", Rubix);
			}
		}
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.U)){
			if (downKeys.size == 2){
				makeMove("UI", Rubix);
			}
		}
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.B)){
			if (downKeys.size == 2){
				makeMove("BI", Rubix);
			}
		}
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.D)){
			if (downKeys.size == 2){
				makeMove("DI", Rubix);
			}
		}
		if (downKeys.contains(Input.Keys.SHIFT_LEFT) && downKeys.contains(Input.Keys.F)){
			if (downKeys.size == 2){
				makeMove("FI", Rubix);
			}
		}
	}
	@Override
	public void render () {
		Gdx.input.setInputProcessor(inputAdapter);
		ScreenUtils.clear(0, 0, 0, 1);
		renderCube(Rubix);
		shapeRenderer.end();
	}
	public void setMove(){
		if(downKeys.contains(Input.Keys.F)){
		makeMove("F", Rubix);
		}
		if(downKeys.contains(Input.Keys.SPACE)){
			Cube tempCube = new Cube();
			Moves.setCube(Rubix, tempCube);
		}
		if(downKeys.contains(Input.Keys.R)){
			makeMove("R", Rubix);
		}
		if(downKeys.contains(Input.Keys.U)){
			makeMove("U", Rubix);
		}
		if(downKeys.contains(Input.Keys.L)){
			makeMove("L", Rubix);
		}
		if(downKeys.contains(Input.Keys.B)){
			makeMove("B", Rubix);
		}
		if(downKeys.contains(Input.Keys.D)){
			makeMove("D", Rubix);
		}
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
