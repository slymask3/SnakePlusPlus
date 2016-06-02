package snakeplusplus;
import java.util.TimerTask;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Attempt to make movement less laggy and more smooth.                       *
 ********************************************************************************************/

public class MoveTimer extends TimerTask {
    @Override
    public void run() {
        if (Snake.right == 2) {
            Snake.right = 0;
            System.out.println("Right set to 0.");
            Keys.rightT.cancel();
        }
        if (Snake.left == 2) {
            Snake.left = 0;
            System.out.println("Left set to 0.");
            Keys.leftT.cancel();
        }
        if (Snake.down == 2) {
            Snake.down = 0;
            System.out.println("Down set to 0.");
            Keys.downT.cancel();
        }
        if (Snake.up == 2) {
            Snake.up = 0;
            System.out.println("Up set to 0.");
            Keys.upT.cancel();
        }
    }
}
