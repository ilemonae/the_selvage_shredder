public class Physics implements Runnable{// physics class — handles gravity, especially the annoyance of acceleration
    private double timeToFallNext;
    private boolean grounded;
    private boolean movingUp;
    private Board board;
    private UsesPhysics user;
    private static int s = 20;

    public Physics(UsesPhysics user, Board board) {
        this.board = board;
        this.user = user;
        grounded = true;
    }


    public String run(){
        fall();
        return "Physics is running";
    }

    public void jump(){
        if (grounded && timeToFallNext <= board.getTime()){
            user.setSprite(1);
            grounded = false;
            movingUp = true;
            timeToFallNext = board.getTime(); // time to fall next
        }
    }

    public void fall(){ // i got frustrated and ran out of time, so this is an unscalable, awful, hardcoded mess... funnily enough for this scale it was faster
        if (!grounded && timeToFallNext <= board.getTime()){
            if (movingUp){
                if (user.getY() == 6){
                    user.setY(5);
                    timeToFallNext = board.getTime() + 2 *s;

                } else if (user.getY() == 5){
                    user.setY(4);
                    timeToFallNext = board.getTime() + 3 * s;
                } else if (user.getY() == 4){
                    user.setY(3);
                    timeToFallNext = board.getTime() + 4 * s;
                } else if (user.getY() == 3){
                    user.setY(2);
                    timeToFallNext = board.getTime() + 5 * s;
                } else if (user.getY() == 2){
                    user.setY(1);
                    timeToFallNext = board.getTime() + 10 * s;
                    movingUp = false;
                }
            } else {
                if (user.getY() == 5){
                    user.setY(6);
                    timeToFallNext = board.getTime() + 2 * s;
                    grounded = true;
                    user.setSprite(0);
                }
                if (user.getY() == 4){
                    user.setY(5);
                    timeToFallNext = board.getTime() + 2*s;
                }
                if (user.getY() == 3){
                    user.setY(4);
                    timeToFallNext = board.getTime() + 3 * s;
                }
                if (user.getY() == 2){
                    user.setY(3);
                    timeToFallNext = board.getTime() + 4 * s;
                }
                if (user.getY() == 1){
                    user.setY(2);
                    timeToFallNext = board.getTime() + 5 * s;
                }
            }
        }
    }

}
