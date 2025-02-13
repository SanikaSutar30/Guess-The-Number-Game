import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGUI extends JFrame {
    private int numberToGuess;
    private int attemptsLeft = 7;
    private int round = 1;
    private int maxRounds = 3;
    private int score = 0;

    private JLabel roundLabel;
    private JLabel attemptsLabel;
    private JLabel promptLabel;
    private JTextField guessField;
    private JButton submitButton;
    private JLabel scoreLabel;

    public GuessTheNumberGUI() {
        // Set JFrame properties
        setTitle("Guess the Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setResizable(false);

        // Set background color and layout
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue background
        setLayout(new GridBagLayout()); // Use GridBagLayout for centering

        initializeGame();
        initializeComponents();

        setVisible(true);
    }

    private void initializeGame() {
        numberToGuess = (int) (Math.random() * 100) + 1;
        System.out.println("Number to guess (for testing): " + numberToGuess); // Debugging
    }

    private void initializeComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Round Label
        roundLabel = new JLabel("Round: " + round + " / " + maxRounds);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        roundLabel.setHorizontalAlignment(JLabel.CENTER);
        add(roundLabel, gbc);

        // Attempts Label
        attemptsLabel = new JLabel("Attempts Left: " + attemptsLeft);
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridy = 1;
        attemptsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(attemptsLabel, gbc);

        // Prompt Label
        promptLabel = new JLabel("Guess a number between 1 and 100.");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        gbc.gridy = 2;
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        add(promptLabel, gbc);

        // Guess Field
        guessField = new JTextField(10);
        guessField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        guessField.setForeground(Color.BLACK);
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(guessField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        submitButton.setForeground(Color.WHITE); // White text
        submitButton.setBackground(new Color(50, 50, 150));
        submitButton.addActionListener(new SubmitButtonListener());
        gbc.gridx = 1;
        add(submitButton, gbc);

        // Score Label
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        add(scoreLabel, gbc);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guessText = guessField.getText();
            try {
                int guess = Integer.parseInt(guessText);
                if (guess < 1 || guess > 100) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                    return;
                }

                attemptsLeft--;
                attemptsLabel.setText("Attempts Left: " + attemptsLeft);

                if (guess == numberToGuess) {
                    score += 10;
                    scoreLabel.setText("Score: " + score); // Update score label
                    JOptionPane.showMessageDialog(null, "Correct! You've earned 10 points.");
                    nextRound();
                } else if (attemptsLeft == 0) {
                    JOptionPane.showMessageDialog(null, "Game Over! The correct number was " + numberToGuess);
                    nextRound();
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private void nextRound() {
        if (round < maxRounds) {
            round++;
            roundLabel.setText("Round: " + round + " / " + maxRounds);
            attemptsLeft = 7;
            attemptsLabel.setText("Attempts Left: " + attemptsLeft);
            numberToGuess = (int) (Math.random() * 100) + 1;
            System.out.println("New number to guess (for testing): " + numberToGuess); // Debugging
            guessField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Game Over! Your final score is " + score);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GuessTheNumberGUI();
    }
}