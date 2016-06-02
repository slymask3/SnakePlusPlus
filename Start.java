package snakeplusplus;

import javax.swing.*;


/********************************************************************************************
 * @Author: Konstantin Satchkov                                                             *
 * @Course: ICS3U                                                                           *
 * @Teacher: Mrs. Verardi                                                                   *
 * @Date: June 3, 2013                                                                      *
 * @Description: Creates and main frame, and laucnhes the main Snake class.                 *
 ********************************************************************************************/

public class Start {
    public static JFrame f = new JFrame();
    public static JPanel snake = new Snake();
    public static Action action = new Action();
    public static JMenuBar mb = new JMenuBar();
    public static JMenu file = new JMenu("File");
    public static JMenu options = new JMenu("Options");
    
    public static void main(String[] args) {
        f.add(mb);
        f.setJMenuBar(mb);
        
        mb.add(file);
        file.add(Action.newM);
        file.add(Action.open);
        file.add(Action.save);
        file.addSeparator();
        file.add(Action.help);
        file.add(Action.about);
        file.addSeparator();
        file.add(Action.quit);
        
        mb.add(options);
        options.add(Action.spikes);
        
        Action.newM.addActionListener(action);
        Action.open.addActionListener(action);
        Action.save.addActionListener(action);
        Action.help.addActionListener(action);
        Action.about.addActionListener(action);
        Action.quit.addActionListener(action);
        Action.spikes.addActionListener(action);
        
        Action.spikes.setSelected(true);
        
        f.add(snake);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(326, 451);
        f.setLocationRelativeTo(null);
        f.setTitle("Snake++ (New)");
        f.setResizable(false);
        f.setVisible(true);
    }
}