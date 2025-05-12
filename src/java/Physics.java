import java.lang.Math;

public class Physics implements Runnable{// physics class — handles gravity, especially the annoyance of acceleration
    private int acceleration;
    UsesPhysics user;
    boolean grounded = true;
    Board board;

    public Physics(UsesPhysics user, Board board) {
        this.acceleration = -5;
        this.velocity = 0;
        this.user = user;
        this.board = board;
    }


    public String run(){
        grounded = (user.getY() == 6);
        fall();
        return toString() + " running";
    }

    public void jump(){
        if (grounded)
            acceleration = 5; // reverse gravity
    }

    public void fall(){ // gravity enacted
        if (!grounded || acceleration >= 0){ // the one case where no movement happens is when gravity is pushing down and we are already on the ground
            System.out.println("time: " + board.getTime() /1000 + " acceleration: " + acceleration + " abs: " + (6-Math.abs(acceleration)) + " true: " + (board.getTime() *1000 % ((6-Math.abs(acceleration))) == 0));
            if (board.getTime() /1000 % ((6-Math.abs(acceleration))) == 0){            
                if (acceleration > 0){
                    user.setY(user.getY() - 1);
                } else {
                    
                    user.setY(user.getY() + 1);
                }
                acceleration = acceleration - 1;;
                if (acceleration < -5){
                    acceleration = -5;
                }
            }
        }
    }

}
