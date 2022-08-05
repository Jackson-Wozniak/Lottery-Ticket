package panels;

import visualdetails.CustomColors;

import javax.swing.*;
import java.awt.*;

public class LotteryPanel extends JPanel {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final ResultsPanel resultsPanel;
    private final JackpotPanel jackpotPanel;
    private final ChooseNumbersPanel chooseNumbersPanel;
    private final PlayPanel playPanel;

    public LotteryPanel(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(getScreenWidth(), getScreenHeight()));
        this.setBackground(CustomColors.darker);

        this.resultsPanel = new ResultsPanel();
        this.jackpotPanel = new JackpotPanel();
        this.chooseNumbersPanel = new ChooseNumbersPanel();
        this.playPanel = new PlayPanel(resultsPanel, jackpotPanel, chooseNumbersPanel);
        chooseNumbersPanel.setPlayPanel(playPanel);


        resultsPanel.setBounds(0,0,320,320);
        this.add(resultsPanel);

        chooseNumbersPanel.setBounds(840, 0, 420, 720);
        this.add(chooseNumbersPanel);

        playPanel.setBounds(340,0, 500, 720);
        this.add(playPanel);

        jackpotPanel.setBounds(30, 350, 250, 260);
        this.add(jackpotPanel);
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }

    public JackpotPanel getJackpotPanel() {
        return jackpotPanel;
    }

    public ChooseNumbersPanel getChooseNumbersPanel() {
        return chooseNumbersPanel;
    }

    public PlayPanel getPlayPanel() {
        return playPanel;
    }

    public int getScreenWidth(){
        return (int) screenSize.getWidth();
    }

    public int getScreenHeight(){
        return (int) screenSize.getHeight();
    }
}
