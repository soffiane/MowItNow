package beans;

public enum Direction {
    N("NORTH"),
    E("SOUTH"),
    W("EAST"),
    S("WEST");

    private String direction = "";

    Direction(String name){
        this.direction = direction;
    }

    @Override
    public String toString(){
        return direction;
    }
}
