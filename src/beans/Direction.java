package beans;

public enum Direction {
    N("NORTH"),
    E("SOUTH"),
    W("EAST"),
    S("WEST");

    private String name = "";

    Direction(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
