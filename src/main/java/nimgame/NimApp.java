
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nimgame;

    /* Added exception handling for all the custom exceptions as well as NumberFormatException.  If exception is thrown,
    * the guard clause is triggered, preventing the remainder of the method to be run.  An error message is shown whenever
    * one of the exceptions is thrown except for TooManyRowsException as the program cannot function properly if it is triggered.
    * Also fixed the win condition & button selection after the game has finished.
    */

import nimgame.exceptions.IllegalSticksException;
import nimgame.exceptions.NoSuchRowException;
import nimgame.exceptions.NotEnoughSticksException;
import nimgame.exceptions.TooManyRowsException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jrsullins
 */
public class NimApp extends JFrame implements ActionListener {

    private static final int ROWS = 3;
    private JTextField[] gameFields; // Where sticks for each row shown
    private JTextField rowField;     // Where player enters row to select
    private JTextField sticksField;  // Where player enters sticks to take
    private JButton playButton;      // Pressed to take sticks
    private JButton AIButton;        // Pressed to make AI's move

    private NimGame nim;

    public NimApp() {

        // Build the fields for the game play
        rowField = new JTextField(5);
        sticksField = new JTextField(5);
        playButton = new JButton("PLAYER");
        AIButton = new JButton("COMPUTER");
        playButton.addActionListener(this);
        AIButton.addActionListener(this);
        AIButton.setEnabled(false);

        // Create the layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);

        JPanel sticksPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(sticksPanel, BorderLayout.EAST);

        JPanel playPanel = new JPanel(new GridLayout(3, 2));
        mainPanel.add(playPanel, BorderLayout.CENTER);

        // Add the fields to the play panel
        playPanel.add(new JLabel("Row: ", JLabel.RIGHT));
        playPanel.add(rowField);
        playPanel.add(new JLabel("Sticks: ", JLabel.RIGHT));
        playPanel.add(sticksField);
        playPanel.add(playButton);
        playPanel.add(AIButton);

        // Build the array of textfields to display the sticks
        gameFields = new JTextField[ROWS];
        for (int i = 0; i < ROWS; i++) {
            gameFields[i] = new JTextField(10);
            gameFields[i].setEditable(false);
            sticksPanel.add(gameFields[i]);
        }
        setSize(350, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            nim = new NimGame(new int[]{3, 5, 7});
        } catch (TooManyRowsException e) {
            // Absolutely cannot continue if the incorrect amount of rows is supplied.
            e.printStackTrace();
        }
        draw();
    }

    // Utility function to redraw game
    private void draw() {
        for (int row = 0; row < ROWS; row++) {
            String sticks = "";
            for (int j = 0; j < nim.getRow(row); j++) {
                sticks += "|   ";
            }
            gameFields[row].setText(sticks);
        }
        rowField.setText("");
        sticksField.setText("");
    }

    /* Added exception handling for all the custom exceptions as well as NumberFormatException.  If exception is thrown,
    * the guard clause is triggered, preventing the remainder of the method to be run.
    * Also fixed the win condition & button selection after the game has finished.
    */
    public void actionPerformed(ActionEvent e) {

        // Player move
        if (e.getSource() == playButton) {

            // Get the row and number of sticks to take
            int row;
            int sticks;
            try {
                row = Integer.parseInt(rowField.getText()) - 1;
                sticks = Integer.parseInt(sticksField.getText());
            } catch (NumberFormatException exc) {
                // parsing a string into an int can cause a NumberFormatException if non-numeric characters are supplied.
                JOptionPane.showMessageDialog(null, "You can only supply numbers as arguments!");
                return;
            }

            // Play that move
            try {
                nim.play(row, sticks);
            } catch (NotEnoughSticksException exc) {
                JOptionPane.showMessageDialog(null, "There are not enough sticks to " +
                        "take from that row!");
                return;
            } catch (IllegalSticksException exc) {
                JOptionPane.showMessageDialog(null, "The amount of sticks " +
                        "must be between 1 and 3!");
                return;
            } catch (NoSuchRowException exc) {
                JOptionPane.showMessageDialog(null, "The row " +
                        "must be between 1 and 3!");
                return;
            }

            // Redisplay the board and enable the AI button
            draw();
            playButton.setEnabled(false);
            AIButton.setEnabled(true);

            // Determine whether the game is over
            if (nim.isOver()) {
                // moved the button enabling prior to the error box to allow for it to be removed prior to pressing "Ok".
                // Also added additional button.
                playButton.setEnabled(false);
                AIButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "You lose!");
                return;
            }
        }

        // Computer move
        if (e.getSource() == AIButton) {

            // Determine computer move
            nim.AIMove();

            // Redraw board
            draw();
            AIButton.setEnabled(false);
            playButton.setEnabled(true);

            // Is the game over?
            if (nim.isOver()) {
                // moved the button enabling prior to the error box to allow for it to be removed prior to pressing "Ok".
                // Also added additional button.
                playButton.setEnabled(false);
                AIButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "You win!");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NimApp a = new NimApp();
    }
}
