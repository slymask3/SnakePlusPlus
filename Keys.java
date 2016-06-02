package snakeplusplus;

import java.awt.event.*;
import java.util.Timer;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Key handler for all the controls.                                          *
 ********************************************************************************************/

public class Keys extends KeyAdapter {
    public static Timer godT;
    public static Timer rightT;
    public static Timer leftT;
    public static Timer upT;
    public static Timer downT;
    public static boolean musicStatus = true;
    
    public static int pauseC;
    public static int restartC;
    public static int upC;
    public static int downC;
    public static int leftC;
    public static int rightC;
    public static int quitC;
    public static int godModeC;
    public static int musicC;
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (Death.freeze == false) {
            if ((key == leftC) && (Snake.right == 0)) {
                Snake.left = 1;
                Snake.up = 0;
                Snake.down = 0;
                Snake.pause = false;
                Snake.notMove = false;
            }
            if ((key == rightC) && (Snake.left == 0)) {
                Snake.right = 1;
                Snake.up = 0;
                Snake.down = 0;
                Snake.pause = false;
                Snake.notMove = false;
            }
            if ((key == upC) && (Snake.down == 0)) {
                Snake.up = 1;
                Snake.right = 0;
                Snake.left = 0;
                Snake.pause = false;
                Snake.notMove = false;
            }
            if ((key == downC) && (Snake.up == 0)) {
                Snake.down = 1;
                Snake.right = 0;
                Snake.left = 0;
                Snake.pause = false;
                Snake.notMove = false;
            }
            
            if (key == pauseC) {
                if (Snake.game == 1) {
                    if (Snake.pause == false) {
                        if (Snake.up == 1) {
                            Snake.remDir = 1;
                        } else if (Snake.down == 1) {
                            Snake.remDir = 2;
                        } else if (Snake.right == 1) {
                            Snake.remDir = 3;
                        } else if (Snake.left == 1) {
                            Snake.remDir = 4;
                        } else {
                            Snake.remDir = 0;
                        }
                    
                        Snake.up = 0;
                        Snake.down = 0;
                        Snake.right = 0;
                        Snake.left = 0;
                        Snake.pause = true;
                        Snake.notMove = true;
                        System.err.println("Game Paused.");
                    } else {
                        if (Snake.remDir == 1) {
                            Snake.up = 1;
                            Snake.notMove = false;
                        } else if (Snake.remDir == 2) {
                            Snake.down = 1;
                            Snake.notMove = false;
                        } else if (Snake.remDir == 3) {
                            Snake.right = 1;
                            Snake.notMove = false;
                        } else if (Snake.remDir == 4) {
                            Snake.left = 1;
                            Snake.notMove = false;
                        }
                    
                        Snake.pause = false;
                        System.err.println("Game Resumed.");
                    }
                }
            }
            
            if (key == restartC) {
                if ((Snake.game == 1) || (Snake.game == 0)) {
                    if (Snake.pause == false) {
                        Snake.game = 1;
                        Level.level = 1;
                        Snake.score = 0;
                        Snake.scoreC = 0;
                        Snake.scoreY = 0;
                        Snake.scoreP = 0;
                        Coin.coins = 0;
                        Snake.right = 0;
                        Snake.left = 0;
                        Snake.up = 0;
                        Snake.down = 0;
                        Snake.notMove = true;
                        Level.level1 = true;
                        Level.level2 = false;
                        Level.level3 = false;
                        Level.level4 = false;
                        Level.level5 = false;
                        Level.level6 = false;
                        Level.level7 = false;
                        Level.level8 = false;
                        Level.level9 = false;
                        Level.level10 = false;
                        Coin.god = false;
                        Snake.denC = 1;
                        Snake.denY = 1;
                        Snake.denP = 1;
                        Snake.remDir = 3;
                        Coin.powerGM_x = -10;
                        Coin.powerGM_y = -10;
                        Portal.portal = false;
                        Snake.snake = true;
                        Portal.denB = 1;
                        Portal.cubes = 0;
                        initGame();
                    }
                }
            }
            
            if (key == KeyEvent.VK_ENTER) {
                if (Snake.game == 2) {
                    Snake.game = 1;
                    Snake.up = 0;
                    Snake.down = 0;
                    Snake.right = 0;
                    Snake.left = 0;
                    Snake.notMove = true;
                    initGame();
                }
            }
            
            if (key == quitC) {
                System.err.println("Exiting game...");
                System.exit(0);
            }
            
            if (key == godModeC) {
                if (Coin.coins >= 5) {
                    Coin.coins = Coin.coins - 5;
                    Coin.god = true;
                    System.out.println("God Mode Enabled.");
                    godT = new Timer();
                    godT.schedule(new Coin(), 10000);
                }
            }
            
            if (key == musicC) {
                if (musicStatus == true) {
                    Snake.music.stop();
                    musicStatus = false;
                } else {
                    Snake.music.start();
                    musicStatus = true;
                }
            }
        }
    }
    
    public void initGame() {
        Snake.dots = Snake.initDots;
        for (int z = 0; z < Snake.dots; z++) {
            Snake.x[z] = 50 - z * Snake.dotSize;
            Snake.y[z] = 50;
        }
        //if (Spike.spikes == true) {
            for (int i = 0; i < 20; i++) {
                Spike.spike_x[i] = Spike.genSpike();
                Spike.spike_y[i] = Spike.genSpike();
            }
        //}
        Coin.genCoin();
        
        if (Snake.snake == true) {
            Food.genFoodC();
            Food.genFoodY();
            Food.genFoodP();
        }
        
        if (Portal.portal == true) {
            Portal.genCube();
            Portal.genButtonPortal();
            Portal.genPortalBlue();
            Portal.genPortalOrange();
        }
    }
}