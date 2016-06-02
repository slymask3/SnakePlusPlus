package snakeplusplus;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Generates and checks the food items.                                       *
 ********************************************************************************************/

public class Food {
    public static int foodC_x;
    public static int foodC_y;
    public static int foodY_x;
    public static int foodY_y;
    public static int foodP_x;
    public static int foodP_y;
    
    public static void checkFoodC() {
        if ((Snake.x[0] == foodC_x) && (Snake.y[0] == foodC_y)) {
            Sound.PICKUP.play();
            Snake.dots++;
            Snake.score = Snake.score + 1;
            Snake.scoreC++;
            genFoodC();
        }
    }
    
    public static void checkFoodY() {
        if ((Snake.x[0] == foodY_x) && (Snake.y[0] == foodY_y)) {
            Sound.PICKUP.play();
            Snake.dots++;
            Snake.score = Snake.score + 5;
            Snake.scoreY++;
            genFoodY();
        }
    }
    
    public static void checkFoodP() {
        if ((Snake.x[0] == foodP_x) && (Snake.y[0] == foodP_y)) {
            Sound.PICKUP.play();
            Snake.dots++;
            Snake.score = Snake.score + 10;
            Snake.scoreP++;
            genFoodP();
        }
    }
    
    public static void genFoodC() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genFoodC();
            System.err.println("FoodC attemped to generate out of the square. Regenerating...");
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
            genFoodC();
            System.err.println("FoodC attemped to generate in a spike. Regenerating...");
        } else if ((rX2 == foodP_x) && (rY2 == foodP_y)
                || (rX2 == foodY_x) && (rY2 == foodY_y)) {
            genFoodC();
            System.err.println("FoodC attemped to generate in another Food. Regenerating...");
        } else {
            foodC_x = rX2;
            foodC_y = rY2;
        }
        
        if ((Coin.powerGM_x == -10) && (Coin.powerGM_y == -10)) {
            int ran = (int)(Math.random() * 20);
            if (ran == 19) {
                Coin.genPowerGM();
            }
        }
    }
    
    public static void genFoodY() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genFoodY();
            System.err.println("FoodY attemped to generate out of the square. Regenerating...");
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
            genFoodY();
            System.err.println("FoodY attemped to generate in a spike. Regenerating...");
        } else if ((rX2 == foodC_x) && (rY2 == foodC_y)
                || (rX2 == foodP_x) && (rY2 == foodP_y)) {
            genFoodY();
            System.err.println("FoodY attemped to generate in another Food. Regenerating...");
        } else {
            foodY_x = rX2;
            foodY_y = rY2;
        }
        
        if ((Coin.powerGM_x == -10) && (Coin.powerGM_y == -10)) {
            int ran = (int)(Math.random() * 20);
            if (ran == 19) {
                Coin.genPowerGM();
            }
        }
    }
    
    public static void genFoodP() {
        int rX = (int) (Math.random() * Snake.randPos);
        int rX2 = ((rX * Snake.dotSize));
        int rY = (int) (Math.random() * Snake.randPos);
        int rY2 = ((rY * Snake.dotSize));
        
        if ((rX2 <= 10) || rY2 <= 10) {
            genFoodP();
            System.err.println("FoodP attemped to generate out of the square. Regenerating...");
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
            genFoodP();
            System.err.println("FoodP attemped to generate in a spike. Regenerating...");
        } else if ((rX2 == foodC_x) && (rY2 == foodC_y)
                || (rX2 == foodY_x) && (rY2 == foodY_y)) {
            genFoodP();
            System.err.println("FoodP attemped to generate in another Food. Regenerating...");
        } else {
            foodP_x = rX2;
            foodP_y = rY2;
        }
        
        if ((Coin.powerGM_x == -10) && (Coin.powerGM_y == -10)) {
            int ran = (int)(Math.random() * 20);
            if (ran == 19) {
                Coin.genPowerGM();
            }
        }
    }
}