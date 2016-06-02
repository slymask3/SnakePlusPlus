package snakeplusplus;

import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Menu bar actions.                                                          *
 ********************************************************************************************/

public class Action implements ActionListener {
    
    public JFileChooser fc = new JFileChooser(".");
    public static JMenuItem newM = new JMenuItem("New");
    public static JMenuItem open = new JMenuItem("Open");
    public static JMenuItem save = new JMenuItem("Save");
    public static JMenuItem help = new JMenuItem("Help");
    public static JMenuItem about = new JMenuItem("About");
    public static JMenuItem quit = new JMenuItem("Quit (Esc)");
    public static JCheckBoxMenuItem spikes = new JCheckBoxMenuItem("Spikes");
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == newM) {
            Start.f.setTitle("Snake++ (New)");
            Snake.game = 2;
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
        } else if (source == open) {
            FileFilter ss = new ExtensionFileFilter("SS (Snake++ Save)", "SS");
            fc.setFileFilter(ss);

            int status = fc.showOpenDialog(Start.f);
            if (status == JFileChooser.APPROVE_OPTION) {
                Properties props = new Properties();
                File selectedFile = fc.getSelectedFile();
                try {
                    props.load(new FileInputStream(selectedFile.getName()));
                    String xS = props.getProperty("x");
                    String[] xSA = xS.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" ");
                    int[] xIA = new int[xS.length()];
                    for (int i = 0; i < xSA.length; i++) {
                        xIA[i] = Integer.parseInt(xSA[i]);
                    }
                    Snake.x = xIA;
                    String yS = props.getProperty("y");
                    String[] ySA = yS.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").split(" ");
                    int[] yIA = new int[yS.length()];
                    for (int i = 0; i < ySA.length; i++) {
                        yIA[i] = Integer.parseInt(ySA[i]);
                    }
                    Snake.y = yIA;
                    Snake.dots = Integer.parseInt(props.getProperty("dots"));
                    Snake.score = Integer.parseInt(props.getProperty("score"));
                    Snake.scoreC = Integer.parseInt(props.getProperty("scoreC"));
                    Snake.scoreY = Integer.parseInt(props.getProperty("scoreY"));
                    Snake.scoreP = Integer.parseInt(props.getProperty("scoreP"));
                    Snake.scoreC = Integer.parseInt(props.getProperty("scoreC"));
                    Snake.denC = Integer.parseInt(props.getProperty("denC"));
                    Snake.denY = Integer.parseInt(props.getProperty("denY"));
                    Snake.denP = Integer.parseInt(props.getProperty("denP"));
                    Snake.game = Integer.parseInt(props.getProperty("game"));
                    Snake.remDir = Integer.parseInt(props.getProperty("remDir"));
                    Snake.right = Integer.parseInt(props.getProperty("right"));
                    Snake.left = Integer.parseInt(props.getProperty("left"));
                    Snake.up = Integer.parseInt(props.getProperty("up"));
                    Snake.down = Integer.parseInt(props.getProperty("down"));
                    Snake.pause = Boolean.parseBoolean(props.getProperty("pause"));
                    Snake.notMove = Boolean.parseBoolean(props.getProperty("notMove"));
                    Food.foodC_x = Integer.parseInt(props.getProperty("foodC_x"));
                    Food.foodC_y = Integer.parseInt(props.getProperty("foodC_y"));
                    Food.foodY_x = Integer.parseInt(props.getProperty("foodY_x"));
                    Food.foodY_y = Integer.parseInt(props.getProperty("foodY_y"));
                    Food.foodP_x = Integer.parseInt(props.getProperty("foodP_x"));
                    Food.foodP_y = Integer.parseInt(props.getProperty("foodP_y"));
                    Coin.coin_x = Integer.parseInt(props.getProperty("coin_x"));
                    Coin.coin_y = Integer.parseInt(props.getProperty("coin_y"));
                    Coin.powerGM_x = Integer.parseInt(props.getProperty("powerGM_x"));
                    Coin.powerGM_x = Integer.parseInt(props.getProperty("powerGM_y"));
                    Coin.coins = Integer.parseInt(props.getProperty("coins"));
                    Coin.coinsTotal = Integer.parseInt(props.getProperty("coinsTotal"));
                    Coin.god = Boolean.parseBoolean(props.getProperty("god"));
                    Level.level = Integer.parseInt(props.getProperty("level"));
                    Level.level1 = Boolean.parseBoolean(props.getProperty("level1"));
                    Level.level2 = Boolean.parseBoolean(props.getProperty("level2"));
                    Level.level3 = Boolean.parseBoolean(props.getProperty("level3"));
                    Level.level4 = Boolean.parseBoolean(props.getProperty("level4"));
                    Level.level5 = Boolean.parseBoolean(props.getProperty("level5"));
                    Level.level6 = Boolean.parseBoolean(props.getProperty("level6"));
                    Level.level7 = Boolean.parseBoolean(props.getProperty("level7"));
                    
                    
                    Spike.spike_x[0] = Integer.parseInt(props.getProperty("spike0_x"));
                    Spike.spike_x[1] = Integer.parseInt(props.getProperty("spike1_x"));
                    Spike.spike_x[2] = Integer.parseInt(props.getProperty("spike2_x"));
                    Spike.spike_x[3] = Integer.parseInt(props.getProperty("spike3_x"));
                    Spike.spike_x[4] = Integer.parseInt(props.getProperty("spike4_x"));
                    Spike.spike_x[5] = Integer.parseInt(props.getProperty("spike5_x"));
                    Spike.spike_x[6] = Integer.parseInt(props.getProperty("spike6_x"));
                    Spike.spike_x[7] = Integer.parseInt(props.getProperty("spike7_x"));
                    Spike.spike_x[8] = Integer.parseInt(props.getProperty("spike8_x"));
                    Spike.spike_x[9] = Integer.parseInt(props.getProperty("spike9_x"));
                    Spike.spike_x[10] = Integer.parseInt(props.getProperty("spike10_x"));
                    Spike.spike_x[11] = Integer.parseInt(props.getProperty("spike11_x"));
                    Spike.spike_x[12] = Integer.parseInt(props.getProperty("spike12_x"));
                    Spike.spike_x[13] = Integer.parseInt(props.getProperty("spike13_x"));
                    Spike.spike_x[14] = Integer.parseInt(props.getProperty("spike14_x"));
                    Spike.spike_x[15] = Integer.parseInt(props.getProperty("spike15_x"));
                    Spike.spike_x[16] = Integer.parseInt(props.getProperty("spike16_x"));
                    Spike.spike_x[17] = Integer.parseInt(props.getProperty("spike17_x"));
                    Spike.spike_x[18] = Integer.parseInt(props.getProperty("spike18_x"));
                    Spike.spike_x[19] = Integer.parseInt(props.getProperty("spike19_x"));
                    
                    Spike.spike_y[0] = Integer.parseInt(props.getProperty("spike0_y"));
                    Spike.spike_y[1] = Integer.parseInt(props.getProperty("spike1_y"));
                    Spike.spike_y[2] = Integer.parseInt(props.getProperty("spike2_y"));
                    Spike.spike_y[3] = Integer.parseInt(props.getProperty("spike3_y"));
                    Spike.spike_y[4] = Integer.parseInt(props.getProperty("spike4_y"));
                    Spike.spike_y[5] = Integer.parseInt(props.getProperty("spike5_y"));
                    Spike.spike_y[6] = Integer.parseInt(props.getProperty("spike6_y"));
                    Spike.spike_y[7] = Integer.parseInt(props.getProperty("spike7_y"));
                    Spike.spike_y[8] = Integer.parseInt(props.getProperty("spike8_y"));
                    Spike.spike_y[9] = Integer.parseInt(props.getProperty("spike9_y"));
                    Spike.spike_y[10] = Integer.parseInt(props.getProperty("spike10_y"));
                    Spike.spike_y[11] = Integer.parseInt(props.getProperty("spike11_y"));
                    Spike.spike_y[12] = Integer.parseInt(props.getProperty("spike12_y"));
                    Spike.spike_y[13] = Integer.parseInt(props.getProperty("spike13_y"));
                    Spike.spike_y[14] = Integer.parseInt(props.getProperty("spike14_y"));
                    Spike.spike_y[15] = Integer.parseInt(props.getProperty("spike15_y"));
                    Spike.spike_y[16] = Integer.parseInt(props.getProperty("spike16_y"));
                    Spike.spike_y[17] = Integer.parseInt(props.getProperty("spike17_y"));
                    Spike.spike_y[18] = Integer.parseInt(props.getProperty("spike18_y"));
                    Spike.spike_y[19] = Integer.parseInt(props.getProperty("spike19_y"));
                    
                    
                    Death.remDir2 = Integer.parseInt(props.getProperty("remDir2"));
                    
                    
                    Portal.cubes = Integer.parseInt(props.getProperty("cubes"));
                    Portal.cube_x = Integer.parseInt(props.getProperty("cube_x"));
                    Portal.cube_y = Integer.parseInt(props.getProperty("cube_y"));
                    Portal.buttonPortal_x = Integer.parseInt(props.getProperty("buttonPortal_x"));
                    Portal.buttonPortal_y = Integer.parseInt(props.getProperty("buttonPortal_y"));
                    Portal.portalBlue_x = Integer.parseInt(props.getProperty("portalBlue_x"));
                    Portal.portalBlue_y = Integer.parseInt(props.getProperty("portalBlue_y"));
                    Portal.portalOrange_x = Integer.parseInt(props.getProperty("portalOrange_x"));
                    Portal.portalOrange_y = Integer.parseInt(props.getProperty("portalOrange_y"));
                    Portal.denB = Integer.parseInt(props.getProperty("denB"));
                    Portal.portal = Boolean.parseBoolean(props.getProperty("portal"));
                    Snake.snake = Boolean.parseBoolean(props.getProperty("snake"));
                    
                    if (Coin.god == true) {
                        Keys.godT = new java.util.Timer();
                        Keys.godT.schedule(new Coin(), 5000);
                        System.out.println("Game loaded with GodMode. Starting Timer...");
                    }
                } catch (IOException ex) {}
                Start.f.setTitle("Snake++ (" + selectedFile.getName() + ")");
            } else if (status == JFileChooser.CANCEL_OPTION) {
                System.out.println(JFileChooser.CANCEL_OPTION);
            }
        } else if (source == save) {
            FileFilter ss = new ExtensionFileFilter("SS (Snake++ Save)", "SS");
            fc.setFileFilter(ss);

            int status = fc.showSaveDialog(Start.f);
            if (status == JFileChooser.APPROVE_OPTION) {
                Properties props = new Properties();
                String file = fc.getSelectedFile().getName();
                String fileP = fc.getSelectedFile().getParent();
                try {
                    props.setProperty("x", Arrays.toString(Snake.x));
                    props.setProperty("y", Arrays.toString(Snake.y));
                    props.setProperty("dots", Integer.toString(Snake.dots));
                    props.setProperty("score", Integer.toString(Snake.score));
                    props.setProperty("scoreC", Integer.toString(Snake.scoreC));
                    props.setProperty("scoreY", Integer.toString(Snake.scoreY));
                    props.setProperty("scoreP", Integer.toString(Snake.scoreP));
                    props.setProperty("scoreC", Integer.toString(Snake.scoreC));
                    props.setProperty("denC", Integer.toString(Snake.denC));
                    props.setProperty("denY", Integer.toString(Snake.denY));
                    props.setProperty("denP", Integer.toString(Snake.denP));
                    props.setProperty("game", Integer.toString(Snake.game));
                    props.setProperty("remDir", Integer.toString(Snake.remDir));
                    props.setProperty("right", Integer.toString(Snake.right));
                    props.setProperty("left", Integer.toString(Snake.left));
                    props.setProperty("up", Integer.toString(Snake.up));
                    props.setProperty("down", Integer.toString(Snake.down));
                    props.setProperty("pause", Boolean.toString(Snake.pause));
                    props.setProperty("notMove", Boolean.toString(Snake.notMove));
                    props.setProperty("foodC_x", Integer.toString(Food.foodC_x));
                    props.setProperty("foodC_y", Integer.toString(Food.foodC_y));
                    props.setProperty("foodY_x", Integer.toString(Food.foodY_x));
                    props.setProperty("foodY_y", Integer.toString(Food.foodY_y));
                    props.setProperty("foodP_x", Integer.toString(Food.foodP_x));
                    props.setProperty("foodP_y", Integer.toString(Food.foodP_y));
                    props.setProperty("coin_x", Integer.toString(Coin.coin_x));
                    props.setProperty("coin_y", Integer.toString(Coin.coin_y));
                    props.setProperty("powerGM_x", Integer.toString(Coin.powerGM_x));
                    props.setProperty("powerGM_y", Integer.toString(Coin.powerGM_y));
                    props.setProperty("coins", Integer.toString(Coin.coins));
                    props.setProperty("coinsTotal", Integer.toString(Coin.coinsTotal));
                    props.setProperty("god", Boolean.toString(Coin.god));
                    props.setProperty("level", Integer.toString(Level.level));
                    props.setProperty("level1", Boolean.toString(Level.level1));
                    props.setProperty("level2", Boolean.toString(Level.level2));
                    props.setProperty("level3", Boolean.toString(Level.level3));
                    props.setProperty("level4", Boolean.toString(Level.level4));
                    props.setProperty("level5", Boolean.toString(Level.level5));
                    props.setProperty("level6", Boolean.toString(Level.level6));
                    props.setProperty("level7", Boolean.toString(Level.level7));
                    props.setProperty("level8", Boolean.toString(Level.level9));
                    props.setProperty("level9", Boolean.toString(Level.level8));
                    props.setProperty("level10", Boolean.toString(Level.level10));
                    
                    
                    props.setProperty("spike0_x", Integer.toString(Spike.spike_x[0]));
                    props.setProperty("spike1_x", Integer.toString(Spike.spike_x[1]));
                    props.setProperty("spike2_x", Integer.toString(Spike.spike_x[2]));
                    props.setProperty("spike3_x", Integer.toString(Spike.spike_x[3]));
                    props.setProperty("spike4_x", Integer.toString(Spike.spike_x[4]));
                    props.setProperty("spike5_x", Integer.toString(Spike.spike_x[5]));
                    props.setProperty("spike6_x", Integer.toString(Spike.spike_x[6]));
                    props.setProperty("spike7_x", Integer.toString(Spike.spike_x[7]));
                    props.setProperty("spike8_x", Integer.toString(Spike.spike_x[8]));
                    props.setProperty("spike9_x", Integer.toString(Spike.spike_x[9]));
                    props.setProperty("spike10_x", Integer.toString(Spike.spike_x[10]));
                    props.setProperty("spike11_x", Integer.toString(Spike.spike_x[11]));
                    props.setProperty("spike12_x", Integer.toString(Spike.spike_x[12]));
                    props.setProperty("spike13_x", Integer.toString(Spike.spike_x[13]));
                    props.setProperty("spike14_x", Integer.toString(Spike.spike_x[14]));
                    props.setProperty("spike15_x", Integer.toString(Spike.spike_x[15]));
                    props.setProperty("spike16_x", Integer.toString(Spike.spike_x[16]));
                    props.setProperty("spike17_x", Integer.toString(Spike.spike_x[17]));
                    props.setProperty("spike18_x", Integer.toString(Spike.spike_x[18]));
                    props.setProperty("spike19_x", Integer.toString(Spike.spike_x[19]));
                    
                    props.setProperty("spike0_y", Integer.toString(Spike.spike_y[0]));
                    props.setProperty("spike1_y", Integer.toString(Spike.spike_y[1]));
                    props.setProperty("spike2_y", Integer.toString(Spike.spike_y[2]));
                    props.setProperty("spike3_y", Integer.toString(Spike.spike_y[3]));
                    props.setProperty("spike4_y", Integer.toString(Spike.spike_y[4]));
                    props.setProperty("spike5_y", Integer.toString(Spike.spike_y[5]));
                    props.setProperty("spike6_y", Integer.toString(Spike.spike_y[6]));
                    props.setProperty("spike7_y", Integer.toString(Spike.spike_y[7]));
                    props.setProperty("spike8_y", Integer.toString(Spike.spike_y[8]));
                    props.setProperty("spike9_y", Integer.toString(Spike.spike_y[9]));
                    props.setProperty("spike10_y", Integer.toString(Spike.spike_y[10]));
                    props.setProperty("spike11_y", Integer.toString(Spike.spike_y[11]));
                    props.setProperty("spike12_y", Integer.toString(Spike.spike_y[12]));
                    props.setProperty("spike13_y", Integer.toString(Spike.spike_y[13]));
                    props.setProperty("spike14_y", Integer.toString(Spike.spike_y[14]));
                    props.setProperty("spike15_y", Integer.toString(Spike.spike_y[15]));
                    props.setProperty("spike16_y", Integer.toString(Spike.spike_y[16]));
                    props.setProperty("spike17_y", Integer.toString(Spike.spike_y[17]));
                    props.setProperty("spike18_y", Integer.toString(Spike.spike_y[18]));
                    props.setProperty("spike19_y", Integer.toString(Spike.spike_y[19]));
                    
                    
                    props.setProperty("remDir2", Integer.toString(Death.remDir2));
                    
                    
                    props.setProperty("cubes", Integer.toString(Portal.cubes));
                    props.setProperty("cube_x", Integer.toString(Portal.cube_x));
                    props.setProperty("cube_y", Integer.toString(Portal.cube_y));
                    props.setProperty("buttonPortal_x", Integer.toString(Portal.buttonPortal_x));
                    props.setProperty("buttonPortal_y", Integer.toString(Portal.buttonPortal_y));
                    props.setProperty("portalBlue_x", Integer.toString(Portal.portalBlue_x));
                    props.setProperty("portalBlue_y", Integer.toString(Portal.portalBlue_y));
                    props.setProperty("portalOrange_x", Integer.toString(Portal.portalOrange_x));
                    props.setProperty("portalOrange_y", Integer.toString(Portal.portalOrange_y));
                    props.setProperty("denB", Integer.toString(Portal.denB));
                    props.setProperty("portal", Boolean.toString(Portal.portal));
                    props.setProperty("snake", Boolean.toString(Snake.snake));
                    
                    if (file.endsWith(".ss")) {
                        props.store(new FileOutputStream(file), null);
                    } else {
                        props.store(new FileOutputStream(file + ".ss"), null);
                    }
                } catch (IOException ex) {}
                if (file.endsWith(".ss")) {
                    System.out.println(file + " has been saved in " + fileP);
                } else {
                    System.out.println(file + ".ss has been saved in " + fileP);
                }
            } else if (status == JFileChooser.CANCEL_OPTION) {
                System.out.println("Save Cancelled.");
            }
        } else if (source == help) {
            JOptionPane.showMessageDialog(Start.f,
                "Goal:\n" 
              + "Your goal is to collect as many food items without\n"
              + "touching the spikes or your body parts.\n"
              + "You may also collect gold coins in your journey,\n"
              + "which may be spent to buy power ups.\n"
              + "\n"
              + "Default Controls:\n"
              + "Arrow Keys - Move your Snake.\n"
              + "R - Restart Game\n"
              + "Space - Pause Game\n"
              + "Esc - Quit Game\n"
              + "M - Pause Music\n"
              + "Q - God Mode\n"
              + "\n"
              + "Power Ups:\n"
              + "God Mode - 5 Coins", 
                "Snake++ Help Guide", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == about) {
            JOptionPane.showMessageDialog(Start.f, 
                "Game programmed in Java.\n"
              + "© Konstantin Satchkov, 2013.",
                "About Snake++", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == quit) {
            System.exit(0);
        } else if (source == spikes) {
            if (spikes.isSelected() == true) {
                System.out.println("Spikes Selected.");
                Spike.spikes = true;
            } else {
                System.out.println("Spikes Unselected.");
                Spike.spikes = false;
            }
        }
    }
    
    public void initGame() {
        Snake.dots = Snake.initDots;
        for (int z = 0; z < Snake.dots; z++) {
            Snake.x[z] = 50 - z * Snake.dotSize;
            Snake.y[z] = 50;
        }
        if (Spike.spikes == true) {
            for (int i = 0; i < 20; i++) {
                Spike.spike_x[i] = Spike.genSpike();
                Spike.spike_y[i] = Spike.genSpike();
            }
        }
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