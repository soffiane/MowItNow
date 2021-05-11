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

    //TODO - mettre les methodes tourner a gauche et tourner a droite
    //essayer de les implementer ici
    //abstract method and implment them in Direction classes
}
