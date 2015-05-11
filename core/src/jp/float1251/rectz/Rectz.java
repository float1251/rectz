package jp.float1251.rectz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jp.float1251.rectz.screen.TitleScreen;
import jp.float1251.rectz.screen.TransitionScreen;

public class Rectz extends Game {
	public SpriteBatch batch;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		setScreen(new TitleScreen(this));
	}

	public void switchScreen(Screen next){
		if(this.getScreen() instanceof  TransitionScreen){
			return;
		}
		TransitionScreen transitionScreen = new TransitionScreen(getScreen(), next, this);
		setScreen(transitionScreen);
	}
}
