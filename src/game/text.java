package game;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class text extends component{
    public String field;
    public String value;
    public ArrayList<Player> dataSource = new ArrayList<>();

    public text(float x, float y, int width, int height, Color color, BufferedImage normalState, BufferedImage action, String type) {
        super(x, y, width, height, color, normalState, action, type);
    }

    @Override
    public void update(Input input) {
        if(field.equals("Player 1 X"))
            value = String.valueOf(dataSource.get(0).getX());
        else if(field.equals("Player 2 X"))
            value = String.valueOf(dataSource.get(1).getX());
        else if(field.equals("Player 1 Y"))
            value = String.valueOf(dataSource.get(0).getY());
        else if(field.equals("Player 2 Y"))
            value = String.valueOf(dataSource.get(1).getY());
        else if(field.equals("Player 1 X-Velocity"))
            value = String.valueOf(dataSource.get(0).getSpeedX());
        else if(field.equals("Player 2 X-Velocity"))
            value = String.valueOf(dataSource.get(1).getSpeedX());
        else if(field.equals("Player 1 Y-Velocity"))
            value = String.valueOf(dataSource.get(0).getSpeedY());
        else if(field.equals("Player 2 Y-Velocity"))
            value = String.valueOf(dataSource.get(1).getSpeedY());

    }

    @Override
    public void render(Graphics2D g, float interpolation) {
        g.setFont(new Font("SanSerif", Font.BOLD, 20));
        g.drawString(this.field + ": "+this.value,this.getX(), this.getY());
    }
}
