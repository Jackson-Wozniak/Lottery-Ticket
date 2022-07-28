package panels;

import visualdetails.CustomColors;

import javax.swing.*;
import java.awt.*;

public class LotteryPanel extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ResultsPanel resultsPanel;
    JackpotPanel jackpotPanel;
    ChooseNumbersPanel chooseNumbersPanel;
    PlayPanel playPanel;

    public LotteryPanel(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(screenWidth(),screenHeight()));
        this.setBackground(CustomColors.darker);

        this.resultsPanel = new ResultsPanel();
        this.jackpotPanel = new JackpotPanel();
        this.chooseNumbersPanel = new ChooseNumbersPanel();
        this.playPanel = new PlayPanel();

        resultsPanel.setBounds(0,0,320,320);
        this.add(resultsPanel);

        chooseNumbersPanel.setBounds(840, 0, 420, 720);
        this.add(chooseNumbersPanel);

        playPanel.setBounds(340,0, 500, 720);
        this.add(playPanel);

        jackpotPanel.setBounds(30, 350, 250, 260);
        this.add(jackpotPanel);

        setInstance();
        setInstance2();
    }

    public void setInstance(){
        chooseNumbersPanel.setPlayPanel(playPanel);
    }

    public void setInstance2(){
        playPanel.setInstancePanel(resultsPanel, jackpotPanel, chooseNumbersPanel);
    }

    public int screenWidth(){
        return (int) screenSize.getWidth();
    }

    public int screenHeight(){
        return (int) screenSize.getHeight();
    }
}
