package HW_CrossZero.view;

import HW_CrossZero.controller.GameController;
import HW_CrossZero.model.Field;
import HW_CrossZero.model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    public static final int SIZE = 3;
    JButton[][] buttons = new JButton[SIZE][SIZE];;
    JPanel jPanel = new JPanel();

    public void init(Field field) {
        setSize(400, 400);
        setTitle("CrossZero");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
            JButton jButton = new JButton();
            switch (field.cells[i][j]) {
                  case NONE:
                  jButton.setText(" . ");
                  break;
                  case X:
                  jButton.setText(" X ");
                  break;
                  case O:
                  jButton.setText(" O ");
                  break;
            }

            final int finalJ = j;
            final int finalI = i;
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       GameController.doShoot(new Point(finalI, finalJ), Field.Type.X);
                       showField(field);
                    }
                });

                buttons[i][j] = jButton;
                jPanel.add(jButton);
            }
        }

        add(jPanel);
        setVisible(true);
    }

     public void showField(Field field) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                switch(field.cells[i][j]){
                    case NONE:
                        buttons[i][j].setText(" . ");
                        break;
                    case X:
                        buttons[i][j].setText(" X ");
                        break;
                    case O:
                        buttons[i][j].setText(" 0 ");;
                        break;
                        }
                    }
               }
           }


       public void showResult(String s) {
           Object[] options = {"Continue", "Exit"};
           int j = JOptionPane.showOptionDialog(this, s, "Game is over", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
           switch (j) {
               case 1:
                   System.exit(0);
               case 0:
                   GameController.restart();
                   break;
           }
       }
  }

