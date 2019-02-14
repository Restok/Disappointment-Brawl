package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public boolean spacePressed = false;
    public boolean spaceReleased = true;
    public static boolean APressed = false;
    public static boolean AReleased = true;
    public boolean SPressed = false;
    public boolean SReleased = true;
    public static boolean DPressed = false;
    public static boolean DReleased = true;
    public static boolean WPressed = false;
    public boolean WReleased = true;
    public static boolean leftPressed = false;
    public static boolean leftReleased = true;
    public static boolean DownPressed = false;
    public boolean DownReleased = true;
    public static boolean rightPressed = false;
    public static boolean rightReleased = true;
    public static boolean upPressed = false;
    public boolean upReleased = true;
    public static boolean jPressed = false;
    public static boolean jReleased = true;
    public static boolean commaPressed;


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == keyEvent.VK_A){
            APressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_S){
            SPressed = true;
        }

        if(keyEvent.getKeyCode() == keyEvent.VK_W){
            WPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_D){
            DPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_DOWN){
            DownPressed = true;
        }

        if(keyEvent.getKeyCode() == keyEvent.VK_UP){
            upPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_J)
            jPressed = true;
        if(keyEvent.getKeyCode() == keyEvent.VK_COMMA)
            commaPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == keyEvent.VK_A)
            APressed = false;
        if(keyEvent.getKeyCode() == keyEvent.VK_D)
            DPressed =false;
        if(keyEvent.getKeyCode() == keyEvent.VK_COMMA)
            commaPressed = false;
        if(keyEvent.getKeyCode() == keyEvent.VK_S){
            SPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_W){
            WPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_DOWN){
            DownPressed = false;
        }

        if(keyEvent.getKeyCode() == keyEvent.VK_UP){
            upPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_J)
            jPressed = false;

    }
}