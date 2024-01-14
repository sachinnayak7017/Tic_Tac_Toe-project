import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Computer extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;
    private int moves;
    private JButton goBackButton;

    public Computer() {
        setTitle("Tic Tac Toe");
        setSize(320, 400);
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[3][3];
        currentPlayer = 'X';
        moves = 0;


        initializeGrid();

        setLayout(null);


        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(100, 320, 100, 30);
        add(goBackButton);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectGame().setVisible(true);
                setVisible(false);
            }
        });
    }

    private void initializeGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));

                final int row = i;
                final int col = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });

                buttons[i][j].setBounds(j * 100, i * 100, 100, 100);

                add(buttons[i][j]);
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (buttons[row][col].getText().equals("")) {
            buttons[row][col].setText(String.valueOf(currentPlayer));
            moves++;

            if (checkForWin(row, col)) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
            } else if (moves == 9) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                if (currentPlayer == 'O') {
                    // Delay before the computer makes a move
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            makeComputerMove();
                            ((Timer) e.getSource()).stop(); // Stop the timer after making the move
                        }
                    });
                    timer.setRepeats(false); // Set the timer to run only once
                    timer.start();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid move. Cell already occupied.");
        }
    }

    private void makeComputerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!buttons[row][col].getText().equals(""));

        buttons[row][col].setText(String.valueOf(currentPlayer));
        moves++;

        if (checkForWin(row, col)) {
            JOptionPane.showMessageDialog(this, "Computer wins!");
            resetGame();
        } else if (moves == 9) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetGame();
        }

        currentPlayer = 'X'; // Switch back to the player after the computer moves
    }

    private boolean checkForWin(int row, int col) {
        // Check row
        if (buttons[row][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[row][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[row][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        // Check column
        if (buttons[0][col].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][col].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][col].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        currentPlayer = 'X';
        moves = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Computer().setVisible(true);
            }
        });
    }
}

