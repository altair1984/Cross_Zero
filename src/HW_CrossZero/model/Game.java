package HW_CrossZero.model;

import HW_CrossZero.controller.GameController;
import HW_CrossZero.view.GameWindow;

public class Game {
    public static boolean restart = false;
    Field field;
    User user;
    Computer computer;
    GameController gameController;
    GameWindow gameWindow;

    public void start() throws InterruptedException {
        field = new Field();
        user = new User();
        computer = new Computer();
        gameWindow = new GameWindow();
        gameController = new GameController(user, gameWindow);
        field.init();
        field.showField();
        gameController.initWindow(field);
        // field.showField();

        do {
            if (restart = true) {
                field.init();
                field.showField();
                gameController.showField(field);
            }
            restart = false;


        while (true) {
            do {
                field.shoot(user.getShootPoint(), Field.Type.X);
            }
            while ((field.shootIsSuccess == false) && (field.fieldsFill == false));
            field.showField();
            gameController.showField(field);
            if (field.fieldsFill == true) {
                gameController.showResult("Draw");
                break;
            }

            if (field.whoIsWinner() == Field.Type.X) {
                gameController.showResult("Победил " + Field.Type.X);
                break;
            }

            do {
                field.shoot(computer.getShootPoint(), Field.Type.O);
            }
            while ((field.shootIsSuccess == false) && (field.fieldsFill == false));

            field.showField();
            gameController.showField(field);
            if (field.fieldsFill == true) {
                gameController.showResult("Draw");
                break;
            }
            if (field.whoIsWinner() == Field.Type.O) {
                gameController.showResult("Победил " + Field.Type.O);
                break;
            }
        }

      }  while (restart == true);
    }
}

