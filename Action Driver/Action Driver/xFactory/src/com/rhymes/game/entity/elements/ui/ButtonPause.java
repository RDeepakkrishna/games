package com.rhymes.game.entity.elements.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rhymes.game.data.AssetConstants;
import com.rhymes.game.interactions.inputs.InteractionTouch;
import com.rhymes.ge.core.data.GlobalVars;
import com.rhymes.ge.core.renderer.Point;
import com.rhymes.ge.core.stage.level.GameState;
import com.rhymes.helpers.Helper;

public class ButtonPause extends Button {

	@Override
	public void render() {
		GlobalVars.ge.getScreen().setColor(1, 1, 1, 0.5f);
		super.render();
		GlobalVars.ge.getScreen().setColor(Color.WHITE);
	}

	String imagePlayPath;
	@Override
	public void init() {
		super.init();
		if(imagePath != null)
			this.imagePlay = Helper.getImageFromAssets(imagePlayPath);
		imagePause = this.image;
	}

	TextureRegion imagePause;
	TextureRegion imagePlay;
	public ButtonPause(float x, float y, float width, float height,
			int zIndex, String imagePath, String imagePlayPath) {
		super(x, y, width, height, zIndex, imagePath);
		this.imagePlayPath = imagePlayPath;
		
		GlobalVars.ge.getCurrentStage().subscribeToControllingInteraction(this, InteractionTouch.class);
	}

	@Override
	public void onEvent(Point p) {
		p.x+=Helper.getCameraX() ;
		
//		Helper.println("Button Pause CheckHit : " + p.toString());
		if(this.checkHit(p)){
//			Helper.println("Button Pause Hit : " + p.toString());
//			Helper.println("Button Pause Hit : Current Game state : " + GlobalVars.ge.getCurrentStage().getGameState());
			if(GlobalVars.ge.getCurrentStage().getGameState() == GameState.PLAYING){
				GlobalVars.ge.getCurrentStage().pause();		
				this.image = imagePlay;
			}
			else if(GlobalVars.ge.getCurrentStage().getGameState() == GameState.PAUSED){
				GlobalVars.ge.getCurrentStage().resume();
				this.image = imagePause;
			}
//			Helper.println("Button Pause Hit : Game state set: " + GlobalVars.ge.getCurrentStage().getGameState());
		}
	}

	public ButtonPause(float x, float y, float width, float height, int zIndex) {
		super(x, y, width, height, zIndex);
	}
}