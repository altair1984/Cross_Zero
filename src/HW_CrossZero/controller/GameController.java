package HW_CrossZero.controller;


import HW_CrossZero.model.Field;
import HW_CrossZero.model.Game;
import HW_CrossZero.model.Point;
import HW_CrossZero.model.User;
import HW_CrossZero.view.GameWindow;

public class GameController {
    private GameWindow gameWindow;
    private static User user;


    public GameController(User user, GameWindow gameWindow) {
        this.user = user;
        this.gameWindow = gameWindow;
    }

    public static void doShoot(Point point, Field.Type type) {
        user.setPoint(point);
       // User.setIsShoot(true);
    }


    public void initWindow(Field field) {
        gameWindow.init(field);
    }

    public void showField(Field field) {
        gameWindow.showField(field);
    }


    public void showResult(String s){
        gameWindow.showResult(s);
    }

    public static void restart(){
        Game.restart = true;
    }
}
