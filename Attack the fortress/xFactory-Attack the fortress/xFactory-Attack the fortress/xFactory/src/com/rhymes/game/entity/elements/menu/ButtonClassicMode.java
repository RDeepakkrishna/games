package com.rhymes.game.entity.elements.menu;

import java.util.Random;

import com.rhymes.game.entity.elements.ui.Button;
import com.rhymes.game.stage.levels.XLevel;
import com.rhymes.game.stage.menus.GameMenuInfo;
import com.rhymes.game.stage.result.ResultBTRClassic;
import com.rhymes.game.stage.result.ResultBTRTime;
import com.rhymes.ge.core.data.GlobalVars;
import com.rhymes.ge.core.renderer.Point;
import com.rhymes.helpers.Helper;

public class ButtonClassicMode extends Button{

	Random rand = new Random();
	public ButtonClassicMode(float x, float y, float width, float height,
			int zIndex, String imagePath) {
		super(x, y, width, height, zIndex, imagePath);
	}

	@Override
	public void onEvent(Point p) {
//		Helper.println("Checking hitpoint...");
		if(this.checkHit(p)){
			Helper.println("classic game...");
			GlobalVars.ge.loadStage(new XLevel( rand.nextInt(GameMenuInfo.num_of_total_level-1) , new ResultBTRClassic()));
		}
	}

	public ButtonClassicMode(float x, float y, float width, float height, int zIndex) {
		super(x, y, width, height, zIndex);
	}
}
