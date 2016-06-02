package snakeplusplus;

import javax.swing.JOptionPane;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Keeps track of all the levels.                                             *
 ********************************************************************************************/

public class Level {
    public static int level = 1;
    public static boolean level1 = true;
    public static boolean level2 = false;
    public static boolean level3 = false;
    public static boolean level4 = false;
    public static boolean level5 = false;
    public static boolean level6 = false;
    public static boolean level7 = false;
    public static boolean level8 = false;
    public static boolean level9 = false;
    public static boolean level10 = false;
    
    public static void checkLevel() {
        if (level2 == false) {
            if (Snake.scoreC >= 1 && Snake.scoreY >= 1 && Snake.scoreP >= 1) {
                level = 2;
                Snake.denC = 3;
                Snake.denY = 3;
                Snake.denP = 3;
                System.err.println("Level 2");
                level2 = true;
            }
        }
        if (level3 == false) {
            if (Snake.scoreC >= 3 && Snake.scoreY >= 3 && Snake.scoreP >= 3) {
                level = 3;
                Snake.denC = 5;
                Snake.denY = 5;
                Snake.denP = 5;
                System.err.println("Level 3");
                level3 = true;
            }
        }
        if (level4 == false) {
            if (Snake.scoreC >= 5 && Snake.scoreY >= 5 && Snake.scoreP >= 5) {
                level = 4;
                Snake.snake = false;
                Portal.portal = true;
                Portal.denB = 1;
                Portal.genCube();
                Portal.genPortalBlue();
                Portal.genPortalOrange();
                Portal.genButtonPortal();
                System.err.println("Level 4");
                System.err.println("Portal Levels Started.");
                level4 = true;
                
                pause();
                
                JOptionPane.showMessageDialog(null, "Welcome to the Portal Levels!\nThe objective in this game mode is to push the cube\nonto the red button to go to the next level\nand increase your snake size by 3.", "Snake++ - Portal Levels", -1);
            }
        }
        if (level5 == false) {
            if (Portal.cubes >= 1) {
                level = 5;
                Portal.denB = 2;
                System.err.println("Level 5");
                level5 = true;
            }
        }
        if (level6 == false) {
            if (Portal.cubes >= 2) {
                level = 6;
                Portal.denB = 3;
                System.err.println("Level 6");
                level6 = true;
            }
        }
        if (level7 == false) {
            if (Portal.cubes >= 3) {
                level = 7;
                Portal.portal = false;
                Snake.snake = true;
                Snake.denC = 10;
                Snake.denY = 10;
                Snake.denP = 10;
                Food.genFoodC();
                Food.genFoodP();
                Food.genFoodY();
                System.err.println("Level 7");
                System.err.println("Portal Levels Ended.");
                level7 = true;
            }
        }
        if (level8 == false) {
            if (Snake.scoreC >= 10 && Snake.scoreY >= 10 && Snake.scoreP >= 10) {
                level = 8;
                Snake.denC = 15;
                Snake.denY = 15;
                Snake.denP = 15;
                System.err.println("Level 8");
                level8 = true;
            }
        }
        if (level9 == false) {
            if (Snake.scoreC >= 15 && Snake.scoreY >= 15 && Snake.scoreP >= 15) {
                level = 9;
                Snake.denC = 20;
                Snake.denY = 20;
                Snake.denP = 20;
                System.err.println("Level 9");
                level9 = true;
            }
        }
        if (level10 == false) {
            if (Snake.scoreC >= 20 && Snake.scoreY >= 20 && Snake.scoreP >= 20) {
                level = 10;
                //Snake.denC = 25;
                //Snake.denY = 25;
                //Snake.denP = 25;
                System.err.println("Level 10");
                level10 = true;
                
                pause();
                
                JOptionPane.showMessageDialog(null, "Congratulations, you have finished the game!\nYou can continue playing for your score,\n but there are no more levels.", "Congratulations!", -1);
            }
        }
    }
    
    public static void pause() {
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
    }
}