package snakeplusplus;

import java.util.Timer;
import java.util.TimerTask;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Generates and checks for the cube, portal button, and portals.             *
 ********************************************************************************************/

public class Portal extends TimerTask{
    public static boolean portal = false;
    public static boolean portalP = false;
    public static Timer portalT;
    public static int denB;
    public static int cubes = 0;
    public static int cube_x;
    public static int cube_y;
    public static int buttonPortal_x;
    public static int buttonPortal_y;
    public static int portalBlue_x;
    public static int portalBlue_y;
    public static int portalOrange_x;
    public static int portalOrange_y;
    
    @Override
    public void run() {
        portalP = false;
        System.out.println("Portal Pause Disabled.");
        portalT.cancel();
    }
    
    public static void checkCube() {
        if ((Snake.x[0] == cube_x) && (Snake.y[0] == cube_y)) {
            if (Snake.up == 1) {
                cube_y = cube_y - Snake.dotSize;
            }
            if (Snake.down == 1) {
                cube_y = cube_y + Snake.dotSize;
            }
            if (Snake.left == 1) {
                cube_x = cube_x - Snake.dotSize;
            }
            if (Snake.right == 1) {
                cube_x = cube_x + Snake.dotSize;
            }
        }
        
        if (cube_y > Snake.height) {
            cube_y = Snake.dotSize;
        }
        if (cube_y < 0) {
            cube_y = Snake.height - Snake.dotSize;
        }
        if (cube_x > Snake.width) {
            cube_x = Snake.dotSize;
        }
        if (cube_x < 0) {
            cube_x = Snake.width - Snake.dotSize;
        }
        
        if (Spike.spikes == true) {
        if ((cube_x == Spike.spike_x[0]) && (cube_y == Spike.spike_y[0])
         || (cube_x == Spike.spike_x[1]) && (cube_y == Spike.spike_y[1])
         || (cube_x == Spike.spike_x[2]) && (cube_y == Spike.spike_y[2])
         || (cube_x == Spike.spike_x[3]) && (cube_y == Spike.spike_y[3])
         || (cube_x == Spike.spike_x[4]) && (cube_y == Spike.spike_y[4])
         || (cube_x == Spike.spike_x[5]) && (cube_y == Spike.spike_y[5])
         || (cube_x == Spike.spike_x[6]) && (cube_y == Spike.spike_y[6])
         || (cube_x == Spike.spike_x[7]) && (cube_y == Spike.spike_y[7])
         || (cube_x == Spike.spike_x[8]) && (cube_y == Spike.spike_y[8])
         || (cube_x == Spike.spike_x[9]) && (cube_y == Spike.spike_y[9])
         || (cube_x == Spike.spike_x[10]) && (cube_y == Spike.spike_y[10])
         || (cube_x == Spike.spike_x[11]) && (cube_y == Spike.spike_y[11])
         || (cube_x == Spike.spike_x[12]) && (cube_y == Spike.spike_y[12])
         || (cube_x == Spike.spike_x[13]) && (cube_y == Spike.spike_y[13])
         || (cube_x == Spike.spike_x[14]) && (cube_y == Spike.spike_y[14])
         || (cube_x == Spike.spike_x[15]) && (cube_y == Spike.spike_y[15])
         || (cube_x == Spike.spike_x[16]) && (cube_y == Spike.spike_y[16])
         || (cube_x == Spike.spike_x[17]) && (cube_y == Spike.spike_y[17])
         || (cube_x == Spike.spike_x[18]) && (cube_y == Spike.spike_y[18])
         || (cube_x == Spike.spike_x[19]) && (cube_y == Spike.spike_y[19])) {
            genCube();
            Sound.BREAK.play();
            System.err.println("Cube got pushed into a Spike. Regenerating...");
        }
        }
    }
    
    public static void checkButtonPortal() {
        if ((cube_x == (buttonPortal_x + 3)) && (cube_y == (buttonPortal_y + 3))) {
            Sound.PICKUP.play();
            cubes++;
            Snake.dots = Snake.dots + 3;
            genCube();
            genButtonPortal();
            genPortalBlue();
            genPortalOrange();
        }
    }
    
    public static void checkPortalBlue() {
        if ((Snake.x[0] == (portalBlue_x + 3)) && (Snake.y[0] == (portalBlue_y + 3))) {
            if (portalP == false) {
                Sound.PORTAL.play();
                Snake.x[0] = portalOrange_x + 3;
                Snake.y[0] = portalOrange_y + 3;
                portalT = new Timer();
                portalT.schedule(new Portal(), 250);
                System.out.println("Portal Pause Enabled.");
            }
            portalP = true; 
        }
        if ((cube_x == (portalBlue_x + 3)) && (cube_y == (portalBlue_y + 3))) {
            if (Snake.up == 1) {
                cube_x = portalOrange_x + 3;
                cube_y = (portalOrange_y + 3) - Snake.dotSize;
            }
            if (Snake.down == 1) {
                cube_x = portalOrange_x + 3;
                cube_y = (portalOrange_y + 3) + Snake.dotSize;
            }
            if (Snake.left == 1) {
                cube_x = (portalOrange_x + 3) - Snake.dotSize;
                cube_y = portalOrange_y + 3;
            }
            if (Snake.right == 1) {
                cube_x = (portalOrange_x + 3) + Snake.dotSize;
                cube_y = portalOrange_y + 3;
            }
        }
    }
    
    public static void checkPortalOrange() {
        if ((Snake.x[0] == (portalOrange_x + 3)) && (Snake.y[0] == (portalOrange_y + 3))) {
            if (portalP == false) {
                Sound.PORTAL.play();
                Snake.x[0] = portalBlue_x + 3;
                Snake.y[0] = portalBlue_y + 3;
                portalT = new Timer();
                portalT.schedule(new Portal(), 250);
                System.out.println("Portal Pause Enabled.");
            }
            portalP = true;
        }
        if ((cube_x == (portalOrange_x + 3)) && (cube_y == (portalOrange_y + 3))) {
            if (Snake.up == 1) {
                cube_x = portalBlue_x + 3;
                cube_y = (portalBlue_y + 3) - Snake.dotSize;
            }
            if (Snake.down == 1) {
                cube_x = portalBlue_x + 3;
                cube_y = (portalBlue_y + 3) + Snake.dotSize;
            }
            if (Snake.left == 1) {
                cube_x = (portalBlue_x + 3) - Snake.dotSize;
                cube_y = portalBlue_y + 3;
            }
            if (Snake.right == 1) {
                cube_x = (portalBlue_x + 3) + Snake.dotSize;
                cube_y = portalBlue_y + 3;
            }
        }
    }
    
    public static void genCube() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genCube();
            System.err.println("Cube attemped to generate out of the square. Regenerating...");
        } else if ((rX2 == Spike.spike_x[0]) && (rY2 == Spike.spike_y[0])
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
         || (rX2 == Spike.spike_x[19]) && (rY2 == Spike.spike_y[19])) {
            genCube();
            System.err.println("Cube attemped to generate in a spike. Regenerating...");
        } else {
            cube_x = rX2;
            cube_y = rY2;
        }
        
        if ((Coin.powerGM_x == -10) && (Coin.powerGM_y == -10)) {
            int ran = (int)(Math.random() * 20);
            if (ran == 9) {
                Coin.genPowerGM();
            }
        }
    }
    
    public static void genButtonPortal() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genButtonPortal();
            System.err.println("ButtonPortal attemped to generate out of the square. Regenerating...");
        } else if ((rX2 == Spike.spike_x[0]) && (rY2 == Spike.spike_y[0])
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
         || (rX2 == Spike.spike_x[19]) && (rY2 == Spike.spike_y[19])) {
            genButtonPortal();
            System.err.println("ButtonPortal attemped to generate in a spike. Regenerating...");
        } else {
            buttonPortal_x = rX2 - 3;
            buttonPortal_y = rY2 - 3;
        }
    }
    
    public static void genPortalBlue() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genPortalBlue();
            System.err.println("PortalBlue attemped to generate out of the square. Regenerating...");
        } else if ((cube_x == Spike.spike_x[0]) && (cube_y == Spike.spike_y[0])
         || (cube_x == Spike.spike_x[1]) && (cube_y == Spike.spike_y[1])
         || (cube_x == Spike.spike_x[2]) && (cube_y == Spike.spike_y[2])
         || (cube_x == Spike.spike_x[3]) && (cube_y == Spike.spike_y[3])
         || (cube_x == Spike.spike_x[4]) && (cube_y == Spike.spike_y[4])
         || (cube_x == Spike.spike_x[5]) && (cube_y == Spike.spike_y[5])
         || (cube_x == Spike.spike_x[6]) && (cube_y == Spike.spike_y[6])
         || (cube_x == Spike.spike_x[7]) && (cube_y == Spike.spike_y[7])
         || (cube_x == Spike.spike_x[8]) && (cube_y == Spike.spike_y[8])
         || (cube_x == Spike.spike_x[9]) && (cube_y == Spike.spike_y[9])
         || (cube_x == Spike.spike_x[10]) && (cube_y == Spike.spike_y[10])
         || (cube_x == Spike.spike_x[11]) && (cube_y == Spike.spike_y[11])
         || (cube_x == Spike.spike_x[12]) && (cube_y == Spike.spike_y[12])
         || (cube_x == Spike.spike_x[13]) && (cube_y == Spike.spike_y[13])
         || (cube_x == Spike.spike_x[14]) && (cube_y == Spike.spike_y[14])
         || (cube_x == Spike.spike_x[15]) && (cube_y == Spike.spike_y[15])
         || (cube_x == Spike.spike_x[16]) && (cube_y == Spike.spike_y[16])
         || (cube_x == Spike.spike_x[17]) && (cube_y == Spike.spike_y[17])
         || (cube_x == Spike.spike_x[18]) && (cube_y == Spike.spike_y[18])
         || (cube_x == Spike.spike_x[19]) && (cube_y == Spike.spike_y[19])) {
            genPortalBlue();
            System.err.println("PortalBlue attemped to generate in a spike. Regenerating...");
        } else {
            portalBlue_x = rX2 - 3;
            portalBlue_y = rY2 - 3;
        }
    }
    
    public static void genPortalOrange() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genPortalOrange();
            System.err.println("PortalOrange attemped to generate out of the square. Regenerating...");
        } else if ((rX2 == Spike.spike_x[0]) && (rY2 == Spike.spike_y[0])
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
         || (rX2 == Spike.spike_x[19]) && (rY2 == Spike.spike_y[19])) {
            genPortalOrange();
            System.err.println("PortalOrange attemped to generate in a spike. Regenerating...");
        } else {
            portalOrange_x = rX2 - 3;
            portalOrange_y = rY2 - 3;
        }
    }
}