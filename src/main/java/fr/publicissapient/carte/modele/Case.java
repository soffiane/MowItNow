package fr.publicissapient.carte.modele;

import fr.publicissapient.tondeuse.modele.Tondeuse;

public class Case {

    private int posX;
    private int posY;
    private Tondeuse tondeuse;

    public Case() {
    }

    public Case(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Tondeuse getTondeuse() {
        return tondeuse;
    }

    public void setTondeuse(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
    }
}
