package panels;

import lotterydrawing.CalculateLottery;
import visualdetails.CustomColors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PlayPanel extends JPanel {

    private ResultsPanel resultsPanel;
    private JackpotPanel jackpotPanel;
    private ChooseNumbersPanel chooseNumbersPanel;

    private final ArrayList<Integer> listOfGuesses = new ArrayList<>(); //max of 6
    private final JButton[] guessButtonList = new JButton[6];
    private final JButton[] lotteryButtonList = new JButton[6];

    public PlayPanel(ResultsPanel resultsPanel,
                     JackpotPanel jackpotPanel,
                     ChooseNumbersPanel chooseNumbersPanel){

        this.resultsPanel = resultsPanel;
        this.jackpotPanel = jackpotPanel;
        this.chooseNumbersPanel = chooseNumbersPanel;

        this.setLayout(null);
        this.setBorder(new LineBorder(CustomColors.dark, 2));
        this.setBackground(CustomColors.darker);

        addLotteryLabel();
        addGuessesLabel();
        
        for(int i = 0; i < lotteryButtonList.length; i++){
            lotteryButtonList[i] = new JButton();
            lotteryButtonsDetails(lotteryButtonList[i], i);
            this.add(lotteryButtonList[i]);
        }

        for(int i = 0; i < guessButtonList.length; i++){
            guessButtonList[i] = new JButton();
            guessButtonListDetails(guessButtonList[i], i);
            this.add(guessButtonList[i]);
        }

        JButton playButton = new JButton("Play");
        playButtonDetails(playButton, 140);
        this.add(playButton);
        playButton.addActionListener(e -> playButtonActionListener(playButton));

        JButton restartButton = new JButton("Restart");
        playButtonDetails(restartButton, 260);
        this.add(restartButton);
        restartButton.addActionListener(e -> restartButtonActionListener(playButton));
    }

    public void playButtonActionListener(JButton playButton){
        //keeps tracking of the guessed numbers that match lottery winners
        int matchingNumbers = 0;
        //make sure that the user has already made 6 guesses before playing
        for (JButton jButton : guessButtonList) {
            if (jButton.getText().equals("")) {
                JOptionPane.showMessageDialog(new JFrame(), "Must guess 6 times");
                return;
            }
        }

        //do random drawing for the 6 lottery numbers, add them to the buttons
        //max of 6
        ArrayList<Integer> lotteryResults = CalculateLottery.calculateLotteryNumbers();
        for(int i = 0; i < lotteryResults.size(); i++){
            lotteryButtonList[i].setText(String.valueOf(lotteryResults.get(i)));
            listOfGuesses.add(Integer.valueOf(guessButtonList[i].getText()));
        }

        for(int i = 0; i < 6; i++){
            int guess = lotteryResults.get(i);
            if(listOfGuesses.contains(guess)){
                matchingNumbers++;
                lotteryButtonList[i].setBackground(CustomColors.gold);
                lotteryButtonList[i].setForeground(CustomColors.dark);
            }
        }
        resultsPanel.setTextFields(jackpotPanel.getPrizeWinnings(matchingNumbers));
        playButton.setEnabled(false);
    }

    public void restartButtonActionListener(JButton playButton){
        playButton.setEnabled(true);
        for(int i = 0; i < guessButtonList.length; i++){
            resetButtonPropertiesForNewGame(guessButtonList);
            resetButtonPropertiesForNewGame(lotteryButtonList);
            lotteryButtonList[i].setForeground(CustomColors.light);
            chooseNumbersPanel.setGuessZero();
        }
    }

    public void addLotteryLabel(){
        JLabel lotteryLabel = new JLabel("Lottery Results:");
        lotteryLabel.setForeground(CustomColors.light);
        lotteryLabel.setBounds(175, 350, 150, 40);
        lotteryLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(lotteryLabel);
    }

    public void addGuessesLabel(){
        JLabel guessesLabel = new JLabel("Your Guesses:");
        guessesLabel.setForeground(CustomColors.light);
        guessesLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        guessesLabel.setBounds(175, 50, 150, 40);
        this.add(guessesLabel);
    }

    public void playButtonDetails(JButton playButton, int xValue){
        playButton.setBackground(CustomColors.darkest);
        playButton.setBorderPainted(false);
        playButton.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        playButton.setForeground(CustomColors.light);
        playButton.setFocusPainted(false);
        playButton.setBounds(xValue, 250, 100, 50);
    }

    public void setGuessText(int index, int number){
        guessButtonList[index].setText(String.valueOf(number));
    }
    
    public void lotteryButtonsDetails(JButton lotteryButtonList, int i){
        lotteryButtonList.setBackground(CustomColors.darkest);
        lotteryButtonList.setBorderPainted(false);
        lotteryButtonList.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        lotteryButtonList.setForeground(CustomColors.light);
        lotteryButtonList.setBounds(45 + (i * 70), 410, 60,60);
    }

    public void guessButtonListDetails(JButton guessButtonList, int i){
        guessButtonList.setBackground(CustomColors.darkest);
        guessButtonList.setBorderPainted(false);
        guessButtonList.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        guessButtonList.setForeground(CustomColors.light);
        guessButtonList.setBounds(45 + (i * 70), 110, 60,60);
    }

    public void resetButtonPropertiesForNewGame(JButton[] buttons){
        for (JButton button : buttons) {
            button.setBackground(CustomColors.darkest);
            button.setText("");
        }
    }

}
