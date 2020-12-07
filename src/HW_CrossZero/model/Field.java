package HW_CrossZero.model;

public class Field {
    public static final int SIZE = 3;
    public boolean fieldsFill = false;
    public boolean shootIsSuccess = false;

    //    char[][] cells = new char[SIZE][SIZE];
    public enum Type {
        X, O, NONE
    }

    public static Type[][] cells = new Type[SIZE][SIZE];

    public void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = Type.NONE;
            }
        }
    }

    public void showField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (cells[i][j]) {
                    case NONE:
                        System.out.print(" . ");
                        break;
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void shoot(Point point, Type who) {
        boolean haveFreePoint = false;
        shootIsSuccess = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == Type.NONE) {
                    haveFreePoint = true;
                    break;
                }
            }
            if (haveFreePoint){
                break;
            }
        }
        if (cells[point.getX()][point.getY()] == Type.NONE) {
                  cells[point.getX()][point.getY()] = who;
                  shootIsSuccess = true;
             }
  }

    public Type whoIsWinner() {
        if (checkWin(Type.X)) {
            return Type.X;
        }
        if (checkWin(Type.O)) {
            return Type.O;
        }
        return Type.NONE;
    }

    private boolean checkWin(Type t) {
        byte countT = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == t) {
                    countT += 1;
                }
            }

           if (countT == SIZE){
              return true;
           }else{
               countT = 0;
           }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[j][i] == t) {
                    countT += 1;
                }
            }
            if (countT == SIZE){
                return true;
            }else{
                countT = 0;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (cells[i][i] == t) {
                    countT += 1;
                }
            }
            if (countT == SIZE){
                return true;
            }
             return false;
       }
    }
