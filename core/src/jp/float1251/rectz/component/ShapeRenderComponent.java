package jp.float1251.rectz.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShapeRenderComponent extends Component{
    public ShapeRenderer.ShapeType type;
    public Color color;
}
