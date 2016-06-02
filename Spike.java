package snakeplusplus;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Generates and checks all the spikes.                                       *
 ********************************************************************************************/

public class Spike {
    public static int[] spike_x = new int[20];
    public static int[] spike_y = new int[20];
    public static boolean spikes = true;
    
    public static int genSpike() {
        int r = (((int) (Math.random() * Snake.randPos)) * Snake.dotSize);

        while (r <= 10 || r == 50) {
            r = (((int) (Math.random() * Snake.randPos)) * Snake.dotSize);
            System.out.println("Spike failed. Regenerating...");
        }
        
        return r;
    }
    
    public static void checkSpikes() {
        if ((Death.die == false) && (Coin.god == false) && (Spike.spikes == true)) {
            for (int i = 0; i < 20; i++) {
                if ((Snake.x[0] == spike_x[i]) && (Snake.y[0] == spike_y[i])) {
                    Death.die();
                }
            }
        }
    }
}