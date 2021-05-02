package fr.publicissapient.direction.modele;

public enum Direction {
    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    private String name = "";

    Direction(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
