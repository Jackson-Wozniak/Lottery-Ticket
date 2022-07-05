package panels;

import visualdetails.CustomColors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class JackpotPanel extends JPanel{
    private final double[] prizeAmounts = new double[5];
    private final double jackpotAmount;

    public JackpotPanel(){
        this.setLayout(null);
        this.setBackground(CustomColors.darker);
        this.setBorder(new LineBorder(CustomColors.grey, 2));

        Random random = new Random();
        jackpotAmount = random.nextInt(600) + 1;

        prizeAmounts[0] = jackpotAmount / 2; //5 correct
        prizeAmounts[1] = jackpotAmount / 4; //4 correct
        prizeAmounts[2] = jackpotAmount / 8; //3 correct
        prizeAmounts[3] = jackpotAmount / 16; //2 correct
        prizeAmounts[4] = jackpotAmount / 50; //1 correct

        JLabel jackpotLabel = new JLabel("$" + jackpotAmount + "m Jackpot!");
        jackpotLabel.setBounds(30, 10, 200, 40);
        jackpotLabel.setForeground(CustomColors.gold);
        jackpotLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        this.add(jackpotLabel);

        JLabel[] prizeLabels = new JLabel[5];
        prizeLabels[0] = new JLabel("5 match: $" + String.format("%.2f", prizeAmounts[0]) + "k");
        prizeLabels[1] = new JLabel("4 match: $" + String.format("%.2f", prizeAmounts[1]) + "k");
        prizeLabels[2] = new JLabel("3 match: $" + String.format("%.2f", prizeAmounts[2]) + "k");
        prizeLabels[3] = new JLabel("2 match: $" + String.format("%.2f", prizeAmounts[3]) + "k");
        prizeLabels[4] = new JLabel("1 match: $" + String.format("%.2f", prizeAmounts[4]) + "k");

        for(int i = 0; i < prizeLabels.length; i++){
            prizeLabels[i].setBounds(50, 50 + (i * 40), 200, 40);
            prizeLabels[i].setForeground(CustomColors.pink);
            prizeLabels[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
            this.add(prizeLabels[i]);
        }
    }

    public double getPrizeWinnings(int matchingNumbers){
        return switch (matchingNumbers) {
            case 1 -> prizeAmounts[4];
            case 2 -> prizeAmounts[3];
            case 3 -> prizeAmounts[2];
            case 4 -> prizeAmounts[1];
            case 5 -> prizeAmounts[0];
            case 6 -> jackpotAmount;
            default -> 0;
        };
    }
}
