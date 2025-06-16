import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class GuessingGameUI extends JFrame {
    private JTextField guessField;
    private JButton guessButton, newRoundButton;
    private JLabel feedbackLabel, attemptsLabel, scoreLabel;

    private final Random rand = new Random();
    private int targetNumber, attemptsLeft, score, totalRounds;
    private static final int MAX_ATTEMPTS = 7;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public GuessingGameUI() {
        super("Number Guessing Game");
        setupUI();
        initGame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);  // center window
        setVisible(true);
    }

    private void setupUI() {
        guessField = new JTextField(5);
        guessButton = new JButton("Guess");
        newRoundButton = new JButton("New Round");
        feedbackLabel = new JLabel("Enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND);
        attemptsLabel = new JLabel();
        scoreLabel = new JLabel();

        JPanel topPanel = new JPanel();
        topPanel.add(feedbackLabel);

        JPanel midPanel = new JPanel();
        midPanel.add(new JLabel("Your guess:"));
        midPanel.add(guessField);
        midPanel.add(guessButton);
        midPanel.add(newRoundButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(attemptsLabel);
        bottomPanel.add(scoreLabel);

        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        guessButton.addActionListener(e -> processGuess());
        newRoundButton.addActionListener(e -> initGame());
        guessField.addActionListener(e -> processGuess());
    }

    private void initGame() {
        targetNumber = rand.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        attemptsLeft = MAX_ATTEMPTS;
        totalRounds++;
        score = score; // keep existing score
        updateLabels(true);
        guessButton.setEnabled(true);
        guessField.setText("");
        guessField.requestFocusInWindow();
    }

    private void processGuess() {
        String text = guessField.getText().trim();
        int guess;
        try {
            guess = Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            feedbackLabel.setText("Please enter a valid number.");
            return;
        }

        attemptsLeft--;
        if (guess == targetNumber) {
            score += attemptsLeft + 1;
            feedbackLabel.setText("Correct! The number was " + targetNumber);
            guessButton.setEnabled(false);
        } else if (attemptsLeft > 0) {
            feedbackLabel.setText(guess < targetNumber ? "Too low!" : "Too high!");
        } else {
            feedbackLabel.setText("Out of attempts! It was " + targetNumber);
            guessButton.setEnabled(false);
        }

        updateLabels(false);
    }

    private void updateLabels(boolean isInit) {
        attemptsLabel.setText("Attempts left: " + attemptsLeft + "    ");
        scoreLabel.setText("Score: " + score + " | Rounds: " + totalRounds);
        if (isInit) feedbackLabel.setText("New Round! Guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessingGameUI::new);
    }
}
