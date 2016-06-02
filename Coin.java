package snakeplusplus;

import java.util.Timer;
import java.util.TimerTask;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Generates and checks for coins and god mode powerup.                       *
 ********************************************************************************************/

public class Coin extends TimerTask {
    public static int coin_x;
    public static int coin_y;
    public static int powerGM_x = -10;
    public static int powerGM_y = -10;
    
    public static int coins;
    public static int coinsTotal;
    public static boolean god = false;
    
    @Override
    public void run() {
        if (Snake.pause == true) {
            Keys.godT = new Timer();
            Keys.godT.schedule(new Coin(), 5000);
            System.out.println("Game is Paused. Restarting Timer...");
        } else {
            god = false;
            System.out.println("God Mode Disabled.");
            Keys.godT.cancel();
        }
    }
    
    public static void checkCoin() {
        if ((Snake.x[0] == coin_x) && (Snake.y[0] == coin_y)) {
            Sound.PICKUP.play();
            coins++;
            coinsTotal++;
            genCoin();
        }
    }
    
    public static void checkPowerGM() {
        if ((Snake.x[0] == powerGM_x) && (Snake.y[0] == powerGM_y)) {
            Sound.POWERUP.play();
            god = true;
            System.out.println("God Mode Enabled.");
            Keys.godT = new Timer();
            Keys.godT.schedule(new Coin(), 10000);
            powerGM_x = -10;
            powerGM_y = -10;
        }
    }
    
    public static void genCoin() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genCoin();
            System.err.println("Coin attemped to generate out of the square. Regenerating...");
        } else if ((rX2 == Spike.spike_x[0]) && (rY2 == Spike.spike_y[0]
                || (rX2 == Spike.spike_x[1]) && (rY2 == Spike.spike_y[1])
                || (rX2 == Spike.spike_x[2]) && (rY2 == Spike.spike_y[2])
                || (rX2 == Spike.spike_x[3]) && (rY2 == Spike.spike_y[3])
                || (rX2 == Spike.spike_x[4]) && (rY2 == Spike.spike_y[4])
                || (rX2 == Spike.spike_x[5]) && (rY2 == Spike.spike_y[5])
                || (rX2 == Spike.spike_x[6]) && (rY2 == Spike.spike_y[6])
                || (rX2 == Spike.spike_x[7]) && (rY2 == Spike.spike_y[7])
                || (rX2 == Spike.spike_x[8]) && (rY2 == Spike.spike_y[8])
                || (rX2 == Spike.spike_x[9]) && (rY2 == Spike.spike_y[9])
                || (rX2 == Spike.spike_x[10]) && (rY2 == Spike.spike_y[10])
                || (rX2 == Spike.spike_x[11]) && (rY2 == Spike.spike_y[11])
                || (rX2 == Spike.spike_x[12]) && (rY2 == Spike.spike_y[12])
                || (rX2 == Spike.spike_x[13]) && (rY2 == Spike.spike_y[13])
                || (rX2 == Spike.spike_x[14]) && (rY2 == Spike.spike_y[14])
                || (rX2 == Spike.spike_x[15]) && (rY2 == Spike.spike_y[15])
                || (rX2 == Spike.spike_x[16]) && (rY2 == Spike.spike_y[16])
                || (rX2 == Spike.spike_x[17]) && (rY2 == Spike.spike_y[17])
                || (rX2 == Spike.spike_x[18]) && (rY2 == Spike.spike_y[18])
                || (rX2 == Spike.spike_x[19]) && (rY2 == Spike.spike_y[19]))) { 
            genCoin();
            System.err.println("Coin attemped to generate in a spike. Regenerating...");
        } else if ((rX2 == Food.foodC_x) && (rY2 == Food.foodC_y)
                || (rX2 == Food.foodY_x) && (rY2 == Food.foodY_y)
                || (rX2 == Food.foodP_x) && (rY2 == Food.foodP_y)) {
            genCoin();
            System.err.println("Coin attemped to generate in a food. Regenerating...");
        } else {
            coin_x = rX2;
            coin_y = rY2;
        }
        
        if ((powerGM_x == -10) && (powerGM_y == -10)) {
            int ran = (int)(Math.random() * 20);
            if (ran == 9) {
                genPowerGM();
            }
        }
    }
    
    public static void genPowerGM() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genPowerGM();
            System.err.println("PowerGM attemped to generate out of the square. Regenerating...");
        } else if ((rX2 == Spike.spike_x[0]) && (rY2 == Spike.spike_y[0]
                || (rX2 == Spike.spike_x[1]) && (rY2 == Spike.spike_y[1])
                || (rX2 == Spike.spike_x[2]) && (rY2 == Spike.spike_y[2])
                || (rX2 == Spike.spike_x[3]) && (rY2 == Spike.spike_y[3])
                || (rX2 == Spike.spike_x[4]) && (rY2 == Spike.spike_y[4])
                || (rX2 == Spike.spike_x[5]) && (rY2 == Spike.spike_y[5])
                || (rX2 == Spike.spike_x[6]) && (rY2 == Spike.spike_y[6])
                || (rX2 == Spike.spike_x[7]) && (rY2 == Spike.spike_y[7])
                || (rX2 == Spike.spike_x[8]) && (rY2 == Spike.spike_y[8])
                || (rX2 == Spike.spike_x[9]) && (rY2 == Spike.spike_y[9])
                || (rX2 == Spike.spike_x[10]) && (rY2 == Spike.spike_y[10])
                || (rX2 == Spike.spike_x[11]) && (rY2 == Spike.spike_y[11])
                || (rX2 == Spike.spike_x[12]) && (rY2 == Spike.spike_y[12])
                || (rX2 == Spike.spike_x[13]) && (rY2 == Spike.spike_y[13])
                || (rX2 == Spike.spike_x[14]) && (rY2 == Spike.spike_y[14])
                || (rX2 == Spike.spike_x[15]) && (rY2 == Spike.spike_y[15])
                || (rX2 == Spike.spike_x[16]) && (rY2 == Spike.spike_y[16])
                || (rX2 == Spike.spike_x[17]) && (rY2 == Spike.spike_y[17])
                || (rX2 == Spike.spike_x[18]) && (rY2 == Spike.spike_y[18])
                || (rX2 == Spike.spike_x[19]) && (rY2 == Spike.spike_y[19]))) { 
            genCoin();
            System.err.println("PowerGM attemped to generate in a spike. Regenerating...");
        } else if ((rX2 == Food.foodC_x) && (rY2 == Food.foodC_y)
                || (rX2 == Food.foodY_x) && (rY2 == Food.foodY_y)
                || (rX2 == Food.foodP_x) && (rY2 == Food.foodP_y)) {
            genCoin();
            System.err.println("PowerGM attemped to generate in a food. Regenerating...");
        } else {
            powerGM_x = rX2;
            powerGM_y = rY2;
        }
    }
}