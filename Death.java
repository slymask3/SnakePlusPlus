package snakeplusplus;
import java.util.Timer;
import java.util.TimerTask;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Creates the death flicker.                                                 *
 ********************************************************************************************/

public class Death extends TimerTask{
    public static Timer deathT;
    public static boolean freeze = false;
    public static boolean die = false;
    public static int remDir2 = 0;
    
    @Override
    public void run() {
        die = false;
        freeze = false;
        Snake.pause = false;
        Snake.game = 0;
        deathT.cancel();
    }
    
    public static void die() {
        die = true;
        freeze = true;
        if (Snake.up == 1) {
            remDir2 = 1;
        } else if (Snake.down == 1) {
            remDir2 = 2;
        } else if (Snake.right == 1) {
            remDir2 = 3;
        } else if (Snake.left == 1) {
            remDir2 = 4;
        } else {
            remDir2 = 0;
        }
        Snake.up = 0;
        Snake.down = 0;
        Snake.left = 0;
        Snake.right = 0;
        Sound.DEATH.play();
        deathT = new java.util.Timer();
        deathT.schedule(new Death(), 1000);
    }
}