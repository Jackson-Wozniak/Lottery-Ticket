package frame;

import panels.LotteryPanel;

import javax.swing.*;

/*
icon link: https://www.pngkey.com/maxpic/u2e6q8u2y3u2y3w7/
 */

public class MainFrame extends JFrame {

    public MainFrame(){
        this.add(new LotteryPanel());
        ImageIcon img = new ImageIcon("img.png");
        this.setIconImage(img.getImage());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
