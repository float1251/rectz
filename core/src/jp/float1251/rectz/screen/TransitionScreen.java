package jp.float1251.rectz.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import jp.float1251.rectz.Rectz;
import jp.float1251.rectz.tween.SpriteTween;

/**
 * Created by takahiro iwatani on 2015/05/11.
 */
public class TransitionScreen implements Screen{

    private int screenHeight = Gdx.graphics.getHeight();
    private int screenWidth = Gdx.graphics.getWidth();

    private final Screen current;
    private final Screen next;
    private final Rectz game;
    private TweenManager manager;
    private TweenCallback backgroundAnimationComplete;
    private Sprite nextScreenSprite;
    private Sprite currentScreenSprite;

    public TransitionScreen(Screen current, Screen next, Rectz rectz) {
        this.current = current;
        this.next = next;
        this.game = rectz;
    }

    @Override
    public void show() {
        manager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteTween());
        backgroundAnimationComplete = new TweenCallback() {

            @Override
            public void onEvent(int type, BaseTween<?> source) {
                game.setScreen(next);
            }
        };
        FrameBuffer nextBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, (int) screenWidth, (int) screenHeight, false);

        nextBuffer.begin();
        next.render(Gdx.graphics.getDeltaTime());
        nextBuffer.end();

        nextScreenSprite = new Sprite(nextBuffer.getColorBufferTexture());
        nextScreenSprite.setPosition(screenWidth, 0);
        nextScreenSprite.flip(false, true);

        FrameBuffer currentBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, (int) screenWidth, (int) screenHeight, false);
        currentBuffer.begin();
        current.render(Gdx.graphics.getDeltaTime());
        currentBuffer.end();

        currentScreenSprite = new Sprite(currentBuffer.getColorBufferTexture());
        currentScreenSprite.setPosition(0, 0);
        currentScreenSprite.flip(false, true);

        Tween.to(nextScreenSprite, SpriteTween.POS_XY, 1.0f)
                .target(0, 0)
                .setCallback(backgroundAnimationComplete)
                .setCallbackTriggers(TweenCallback.COMPLETE)
                .start(manager);
    }

    @Override
    public void render(float delta) {
        manager.update(Gdx.graphics.getDeltaTime());
        game.batch.begin();
        currentScreenSprite.draw(game.batch);
        nextScreenSprite.draw(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
