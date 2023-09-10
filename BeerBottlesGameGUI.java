import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeerBottlesGameGUI extends JFrame {

    private int totalBottles = 21;
    private JLabel statusLabel;
    private JTextField userPickField;
    private JButton pickButton;

    public BeerBottlesGameGUI() {
        setTitle("Beer Bottles Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        statusLabel = new JLabel("There are 21 beer bottles...");
        panel.add(statusLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel userPickLabel = new JLabel("How many you would like to pick up? (1-4): ");
        userPickField = new JTextField(2);
        pickButton = new JButton("Pick");

        inputPanel.add(userPickLabel);
        inputPanel.add(userPickField);
        inputPanel.add(pickButton);

        panel.add(inputPanel, BorderLayout.CENTER);

        pickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickBottles();
            }
        });

        add(panel);
    }

    private void pickBottles() {
        try {
            int userPick = Integer.parseInt(userPickField.getText());
            if (userPick < 1 || userPick > 4 || userPick > totalBottles) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please pick between 1 and 4 inclusive.");
                return;
            }

            totalBottles -= userPick;

            if (totalBottles == 0) {
                JOptionPane.showMessageDialog(this, "You will have to pick up the last...you are the loser");
                resetGame();
            } else {
                int computerPick = 5 - userPick;
                totalBottles -= computerPick;

                if (totalBottles == 0) {
                    JOptionPane.showMessageDialog(this, "Computer will have to pick up the last...computer is the loser");
                    resetGame();
                } else {
                    statusLabel.setText("The bottles remaining are: " + totalBottles);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    private void resetGame() {
        totalBottles = 21;
        statusLabel.setText("There are 21 beer bottles...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BeerBottlesGameGUI game = new BeerBottlesGameGUI();
                game.setVisible(true);
            }
        });
    }
}
