public interface Runnable { // runnable interface — this is sort of superfluous given the scale of the program, but it is still a good idea/practice
    public String run();// returns string for the purpose of relaying information to whatever calls it (ie "running", "wants to be done running", "game over" etc.)
}