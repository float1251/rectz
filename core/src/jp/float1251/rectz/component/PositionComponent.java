package jp.float1251.rectz.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 */
public class PositionComponent extends Component{
    public Vector2 position = new Vector2();

    public PositionComponent(int x, int y) {
        position.set(x, y);
    }
}
