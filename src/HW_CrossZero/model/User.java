package HW_CrossZero.model;

public class User {
    private static Point point;
    private volatile static boolean isShoot;
    private static Object key = new Object();


    public static void setPoint(Point point) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (key) {
                    User.point = point;
                    isShoot = true;
                    key.notifyAll();
                }
            }
        }).start();

    }

    public Point getShootPoint() throws InterruptedException{
        isShoot = false;
        synchronized (key){
                while(isShoot == false){
                    try{
                        key.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                key.notifyAll();
            }
        return point;
    }

    public static void setIsShoot(boolean s) {
        isShoot = s;
    }
}
