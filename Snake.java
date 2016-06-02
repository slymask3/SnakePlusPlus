package snakeplusplus;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Properties;
import javax.sound.sampled.*;
import javax.swing.*;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Main class.                                                                *
 ********************************************************************************************/

public class Snake extends JPanel implements ActionListener {
    // Final Variables
    public final static int width = 310;
    public final static int height = 300;
    public final static int dotSize = 10;
    public final static int dotsAll = 900;
    public final static int randPos = 30;
    
    // Main Snake Coords Variables
    public static int[] x = new int[dotsAll];
    public static int[] y = new int[dotsAll];
    
    // Game Variable
    // 0 = Game Over
    // 1 = Game
    // 2 = Start
    public static int game = 2;
    
    // Variables
    public static int dots;
    public static int score;
    public static int scoreC;
    public static int scoreY;
    public static int scoreP;
    public static int denC = 1;
    public static int denY = 1;
    public static int denP = 1;
    public static int remDir = 3;
    public static int right = 0;
    public static int left = 0;
    public static int up = 0;
    public static int down = 0;
    
    // Boolean Variables
    public static boolean pause = false;
    public static boolean notMove = true;
    public static boolean snake = true;
    
    // Timer Variable
    public static Timer timer;
    
    // Image Variables
    public Image spike = new ImageIcon(this.getClass().getResource("png/spike.png")).getImage();
    public Image foodC = new ImageIcon(this.getClass().getResource("png/foodC.png")).getImage();
    public Image foodY = new ImageIcon(this.getClass().getResource("png/foodY.png")).getImage();
    public Image foodP = new ImageIcon(this.getClass().getResource("png/foodP.png")).getImage();
    public Image body = new ImageIcon(this.getClass().getResource("png/body.png")).getImage();
    public Image head = new ImageIcon(this.getClass().getResource("png/body.png")).getImage();
    public Image headr = new ImageIcon(this.getClass().getResource("png/headr.png")).getImage();
    public Image headl = new ImageIcon(this.getClass().getResource("png/headl.png")).getImage();
    public Image headu = new ImageIcon(this.getClass().getResource("png/headu.png")).getImage();
    public Image headd = new ImageIcon(this.getClass().getResource("png/headd.png")).getImage();
    public Image back = new ImageIcon(this.getClass().getResource("png/background.png")).getImage();
    public Image backgo = new ImageIcon(this.getClass().getResource("png/background_go.png")).getImage();
    public Image backStart = new ImageIcon(this.getClass().getResource("png/background_start.png")).getImage();
    public Image pauseI = new ImageIcon(this.getClass().getResource("png/pause.png")).getImage();
    public Image deathI = new ImageIcon(this.getClass().getResource("gif/death.gif")).getImage();
    public Image soundOn = new ImageIcon(this.getClass().getResource("png/soundOn.png")).getImage();
    public Image soundOff = new ImageIcon(this.getClass().getResource("png/soundOff.png")).getImage();
    public Image coin = new ImageIcon(this.getClass().getResource("png/coin.png")).getImage();
    public Image bodyG = new ImageIcon(this.getClass().getResource("png/body_g.png")).getImage();
    public Image headG = new ImageIcon(this.getClass().getResource("png/body_g.png")).getImage();
    public Image headrG = new ImageIcon(this.getClass().getResource("png/headr_g.png")).getImage();
    public Image headlG = new ImageIcon(this.getClass().getResource("png/headl_g.png")).getImage();
    public Image headuG = new ImageIcon(this.getClass().getResource("png/headu_g.png")).getImage();
    public Image headdG = new ImageIcon(this.getClass().getResource("png/headd_g.png")).getImage();
    public Image powerGM = new ImageIcon(this.getClass().getResource("png/godModeY.png")).getImage();
    public Image cube = new ImageIcon(this.getClass().getResource("png/cube2.png")).getImage();
    public Image buttonPortal = new ImageIcon(this.getClass().getResource("png/buttonPortal.png")).getImage();
    public Image portalBlue = new ImageIcon(this.getClass().getResource("png/portalBlue2.png")).getImage();
    public Image portalOrange = new ImageIcon(this.getClass().getResource("png/portalOrange2.png")).getImage();
    
    // Clip Variables
    public static Clip music;
    
    // Configurable Variables
    public static int delay;
    public static int initDots;
    
    // Default Configuration Values
    public static String defDelay = "140";
    public static String defDots = "3";
    public static String defSpikes = "true";
    public static String defPauseC = "32";
    public static String defRestartC = "82";
    public static String defUpC = "38";
    public static String defDownC = "40";
    public static String defLeftC = "37";
    public static String defRightC = "39";
    public static String defQuitC = "27";
    public static String defGodModeC = "81";
    public static String defMusicC = "77";

    public Snake() {
        Properties props = new Properties();
        File f = new File("config.properties");
        try {
            if (!f.exists()) {
                props.setProperty("delay", defDelay);
                props.setProperty("dots", defDots);
                props.setProperty("spikes", defSpikes);
                props.setProperty("controlPause", defPauseC);
                props.setProperty("controlRestart", defRestartC);
                props.setProperty("controlUp", defUpC);
                props.setProperty("controlDown", defDownC);
                props.setProperty("controlLeft", defLeftC);
                props.setProperty("controlRight", defRightC);
                props.setProperty("controlQuit", defQuitC);
                props.setProperty("controlGodMode", defGodModeC);
                props.setProperty("controlMusic", defMusicC);
                props.store(new FileOutputStream("config.properties"), null);
            }
            props.load(new FileInputStream("config.properties"));
            delay = Integer.parseInt(props.getProperty("delay"));
            initDots = Integer.parseInt(props.getProperty("dots"));
            Spike.spikes = Boolean.parseBoolean(props.getProperty("spikes"));
            Keys.pauseC = Integer.parseInt(props.getProperty("controlPause"));
            Keys.restartC = Integer.parseInt(props.getProperty("controlRestart"));
            Keys.upC = Integer.parseInt(props.getProperty("controlUp"));
            Keys.downC = Integer.parseInt(props.getProperty("controlDown"));
            Keys.leftC = Integer.parseInt(props.getProperty("controlLeft"));
            Keys.rightC = Integer.parseInt(props.getProperty("controlRight"));
            Keys.quitC = Integer.parseInt(props.getProperty("controlQuit"));
            Keys.godModeC = Integer.parseInt(props.getProperty("controlGodMode"));
            Keys.musicC = Integer.parseInt(props.getProperty("controlMusic"));
        } catch (IOException ex) {}

        try {
            URL dir = this.getClass().getResource("sfx/music.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(dir);
            music = AudioSystem.getClip();
            music.open(ais);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {}

        music.setFramePosition(0);
        music.start();

        addKeyListener(new Keys());
        setBackground(Color.BLACK);

        timer = new Timer(delay, this);
        timer.start();

        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (game == 1) {
            Font small = new Font("Arial", Font.BOLD, 16);
            g.setColor(Color.white);
            g.setFont(small);
            
            g.drawImage(back, 0, 0, this);

            if (Death.freeze == true) {
                g.drawImage(deathI, 0, 0, this);
            }
            
            // Draw Spikes
            if (Spike.spikes == true) {
                for (int i = 0; i < 20; i++) {
                    g.drawImage(spike, Spike.spike_x[i], Spike.spike_y[i], this);
                }
            }
            
            // Draw Snake Levels
            if (snake == true) {
                g.drawImage(foodC, Food.foodC_x, Food.foodC_y, this);
                g.drawImage(foodY, Food.foodY_x, Food.foodY_y, this);
                g.drawImage(foodP, Food.foodP_x, Food.foodP_y, this);
            
                g.drawString("Blueberries: " + scoreC + "/" + denC, 30, 333);
                g.drawString("Bananas: " + scoreY + "/" + denY, 30, 353);
                g.drawString("Cherries: " + scoreP + "/" + denP, 30, 373);
                g.drawImage(foodC, 10, 323, this);
                g.drawImage(foodY, 10, 343, this);
                g.drawImage(foodP, 10, 363, this);
            }
            
            if (Portal.portal == true) {
                g.drawImage(buttonPortal, Portal.buttonPortal_x, Portal.buttonPortal_y, this);
                g.drawImage(portalBlue, Portal.portalBlue_x, Portal.portalBlue_y, this);
                g.drawImage(portalOrange, Portal.portalOrange_x, Portal.portalOrange_y, this);
                g.drawImage(cube, Portal.cube_x, Portal.cube_y, this);
                
                g.drawString("Cubes: " + Portal.cubes + "/" + Portal.denB, 30, 333);
                g.drawImage(buttonPortal, 7, 320, this);
                g.drawImage(cube, 10, 323, this);
            }
            
            // Draw Level Status, Coin Status, and Power Up Status.
            g.drawImage(coin, Coin.coin_x, Coin.coin_y, this);
            g.drawImage(powerGM, Coin.powerGM_x, Coin.powerGM_y, this);
            g.drawString("Level: " + Level.level, 170, 333);
            g.drawString("Power Up: ", 170, 353);
            g.drawString("Coins: " + Coin.coins, 30, 393);
            g.drawImage(coin, 10, 383, this);
            
            // Draw GodMode Power Up
            if (Coin.god == true) {
                g.drawImage(powerGM, 255, 343, this);
            } else if (Coin.god == false) {
                g.drawString("None", 255, 353);
            }
            
            // Draw Music Status
            if (Keys.musicStatus == true) {
                g.drawImage(soundOn, 302, 323, this);
            } else if (Keys.musicStatus == false) {
                g.drawImage(soundOff, 302, 323, this);
            }
            
            // Draw Snake Head and Body
            if (Coin.god == false) {
                for (int z = 0; z < dots; z++) {
                    if (z > 0) {
                        g.drawImage(body, x[z], y[z], this);
                    } else if (z == 0) {
                        if (Death.freeze == false) {
                            if (right == 1) {
                                g.drawImage(headr, x[z], y[z], this);
                            } else if (left == 1) {
                                g.drawImage(headl, x[z], y[z], this);
                            } else if (up == 1) {
                                g.drawImage(headu, x[z], y[z], this);
                            } else if (down == 1) {
                                g.drawImage(headd, x[z], y[z], this);
                            } else if (remDir == 1) {
                                g.drawImage(headu, x[z], y[z], this);
                            } else if (remDir == 2) {
                                g.drawImage(headd, x[z], y[z], this);
                            } else if (remDir == 3) {
                                g.drawImage(headr, x[z], y[z], this);
                            } else if (remDir == 4) {
                                g.drawImage(headl, x[z], y[z], this);
                            } else if (remDir == 0) {
                                g.drawImage(headr, x[z], y[z], this);
                            } else {
                                g.drawImage(head, x[z], y[z], this);
                            }
                        } else {
                            if (Death.remDir2 == 1) {
                                g.drawImage(headu, x[z], y[z], this);
                            } else if (Death.remDir2 == 2) {
                                g.drawImage(headd, x[z], y[z], this);
                            } else if (Death.remDir2 == 3) {
                                g.drawImage(headr, x[z], y[z], this);
                            } else if (Death.remDir2 == 4) {
                                g.drawImage(headl, x[z], y[z], this);
                            } else if (Death.remDir2 == 0) {
                                g.drawImage(headr, x[z], y[z], this);
                            } else {
                                g.drawImage(head, x[z], y[z], this);
                            }
                        }
                    }
                }
            } else if (Coin.god == true) {
                for (int z = 0; z < dots; z++) {
                    if (z > 0) {
                        g.drawImage(bodyG, x[z], y[z], this);
                    } else if (z == 0) {
                        if (right == 1) {
                            g.drawImage(headrG, x[z], y[z], this);
                        } else if (left == 1) {
                            g.drawImage(headlG, x[z], y[z], this);
                        } else if (up == 1) {
                            g.drawImage(headuG, x[z], y[z], this);
                        } else if (down == 1) {
                            g.drawImage(headdG, x[z], y[z], this);
                        } else if (remDir == 1) {
                            g.drawImage(headuG, x[z], y[z], this);
                        } else if (remDir == 2) {
                            g.drawImage(headdG, x[z], y[z], this);
                        } else if (remDir == 3) {
                            g.drawImage(headrG, x[z], y[z], this);
                        } else if (remDir == 4) {
                            g.drawImage(headlG, x[z], y[z], this);
                        } else {
                            g.drawImage(headG, x[z], y[z], this);
                        }
                    }
                }
            }
            
            
            
            if (pause == true) {
                g.drawImage(pauseI, 30, height / 2, this);
            }

            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        } else if (game == 0) {
            g.drawImage(backgo, 0, 0, this);
            Color clr = new Color(0x282E3D);
            String levelT = "Level: " + Level.level;
            String dotsT = "Snake Size: " + dots;
            String scoreCT = "Blueberries Collected: " + scoreC;
            String scoreYT = "Bananas Collected: " + scoreY;
            String scorePT = "Cherries Collected: " + scoreP;
            String cubesT = "Cubes Collected: " + Portal.cubes;
            String coinsT = "Coins: " + Coin.coins;
            String coinsTT = "Total Coins: " + Coin.coinsTotal;
            Font small = new Font("Arial", Font.BOLD, 20);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(clr);
            g.setFont(small);
            g.drawString(levelT, (width - metr.stringWidth(levelT)) / 2, 110);
            g.drawString(dotsT, (width - metr.stringWidth(dotsT)) / 2, 140);
            //170
            g.drawString(scoreCT, (width - metr.stringWidth(scoreCT)) / 2, 185); //200
            g.drawString(scoreYT, (width - metr.stringWidth(scoreYT)) / 2, 215); //230
            g.drawString(scorePT, (width - metr.stringWidth(scorePT)) / 2, 245); //260
            g.drawString(cubesT, (width - metr.stringWidth(cubesT)) / 2, 275);
            //290
            g.drawString(coinsT, (width - metr.stringWidth(coinsT)) / 2, 320);
            g.drawString(coinsTT, (width - metr.stringWidth(coinsTT)) / 2, 350);
        } else if (game == 2) {
            g.drawImage(backStart, 0, 0, this);
        }
    }

    public void move() {
        if ((Death.freeze == false) && (notMove == false)) {
            for (int z = dots; z > 0; z--) {
                x[z] = x[(z - 1)];
                y[z] = y[(z - 1)];
            }
        }

        if (left == 1) {
            x[0] = x[0] - dotSize;
        }
        if (right == 1) {
            x[0] = x[0] + dotSize;
        }
        if (up == 1) {
            y[0] = y[0] - dotSize;
        }
        if (down == 1) {
            y[0] = y[0] + dotSize;
        }
    }

    public static void checkSelf() {
        if ((Death.die == false) && (Coin.god == false)) {
            for (int z = dots; z > 0; z--) {
                if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                    Death.die();
                }
            }
        }
    }
    
    public void checkWall() {
        if (y[0] > height) {
            y[0] = 0;
        }
        if (y[0] < 0) {
            y[0] = height;
        }
        if (x[0] > width) {
            x[0] = 0;
        }
        if (x[0] < 0) {
            x[0] = width;
        }
    }

    public void checkMusic() {
        if (Keys.musicStatus == true) {
            if (!music.isRunning()) {
                music.setFramePosition(0);
                music.start();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game == 1) {
            checkMusic();
            Coin.checkCoin();
            Coin.checkPowerGM();
            checkSelf();
            checkWall();
            Spike.checkSpikes();
            Level.checkLevel();
            move();
            if (snake == true) {
                Food.checkFoodC();
                Food.checkFoodY();
                Food.checkFoodP();
            }
            if (Portal.portal == true) {
                Portal.checkCube();
                Portal.checkButtonPortal();
                Portal.checkPortalOrange();
                Portal.checkPortalBlue();
            }
        }
        repaint();
    }
}