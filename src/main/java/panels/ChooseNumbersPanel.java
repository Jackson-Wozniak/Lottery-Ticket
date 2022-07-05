package panels;

import visualdetails.CustomColors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChooseNumbersPanel extends JPanel {
    PlayPanel playPanel;
    JPanel gridOfNumbers;
    int guess = 0;
    ArrayList<Integer> listOfGuesses = new ArrayList<>();
    JButton[] numberButtons = new JButton[37];

    public ChooseNumbersPanel(){
        guess = 0;
        this.setLayout(null);
        this.setBackground(CustomColors.darker);

        gridOfNumbers = new JPanel();
        gridOfNumbers.setBackground(CustomColors.darker);
        this.add(gridOfNumbers);
        gridOfNumbers.setBounds(50,150, 360, 340);
        gridOfNumbers.setLayout(new GridLayout(6,6,10,10));

        JLabel chooseGuessesLabel = new JLabel("Choose Guesses");
        chooseGuessesLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        chooseGuessesLabel.setBounds(125, 100, 200, 50);
        chooseGuessesLabel.setForeground(CustomColors.light);
        this.add(chooseGuessesLabel);

        for(int i = 1; i < numberButtons.length; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtonsDetails(numberButtons[i]);
            gridOfNumbers.add(numberButtons[i]);
            int finalI = i;
            numberButtons[i].addActionListener(e -> {

                //lottery can only handle 6 guesses in total
                if(guess >= 6){
                    tooManyGuessesError();
                    return;
                }

                //If background is dark, then the button was already pressed
                if(numberButtons[finalI].getBackground() == CustomColors.dark) return;
                listOfGuesses.add(finalI);
                playPanel.setGuessText(guess, finalI);
                numberButtons[finalI].setBackground(CustomColors.dark);
                guess++;
            });
        }
    }

    public void resetGuesses(){
        guess = 0;
    }

    //get instance of PlayPanel from main panel
    public void setPlayPanel(PlayPanel playPanel){
        this.playPanel = playPanel;
    }

    public void tooManyGuessesError(){
        JOptionPane.showMessageDialog(new JFrame(),
                "Cannot Guess more than 6 times",
                "Invalid Guess", JOptionPane.ERROR_MESSAGE);
    }

    //set the detail for each of the 36 buttons
    public void numberButtonsDetails(JButton numberButton){
        numberButton.setBackground(CustomColors.darkest);
        numberButton.setBorderPainted(false);
        numberButton.setFocusPainted(false);
        numberButton.setFont(new Font(Font.SERIF, Font.BOLD, 13));
        numberButton.setForeground(CustomColors.light);
    }

    public void setNewBackground(){
        /*for(int i = 0; i < numberButtons.length; i++){
            this.numberButtons[i].setBackground(CustomColors.darkest);
        }*/
    }
}
