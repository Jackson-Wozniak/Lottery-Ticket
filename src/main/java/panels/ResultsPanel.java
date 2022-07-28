package panels;

import visualdetails.CustomColors;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {
    JLabel resultLabel;
    JLabel resultOutput;

    public ResultsPanel(){
        this.setLayout(null);
        this.setBackground(CustomColors.darker);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("img.png").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
        label.setBounds(10,10, 300,200);
        this.add(label);

        resultLabel = new JLabel("Winning Amount:");
        resultLabel.setBounds(55, 230, 200, 30);
        resultLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 19));
        resultLabel.setForeground(CustomColors.light);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        resultOutput = new JLabel();
        resultOutput.setBounds(55, 270, 200, 30);
        resultOutput.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        resultOutput.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(resultLabel);
        this.add(resultOutput);
    }

    public void setTextFields(double winningBet){
        if(winningBet == 0) {
            resultOutput.setForeground(CustomColors.red);
            resultOutput.setText("No Winners");
            return;
        }
        if(winningBet == 6){
            resultOutput.setForeground(CustomColors.gold);
            resultOutput.setText("$" + String.format("%.2f", winningBet) + " million!");
            return;
        }
        resultOutput.setForeground(CustomColors.purple);
        resultOutput.setText("$" + String.format("%.2f", winningBet) + " thousand!");

    }
}
