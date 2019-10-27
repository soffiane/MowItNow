package beans;

import static beans.Direction.*;

public class Tondeuse {

    private Position position;
    private Direction orientation;

    public Tondeuse(Position position, Direction orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void deplacer(int dimensionPelouseX, int dimensionPelouseY) {
        switch (this.getOrientation()) {
            case E:
                if (estUnDeplacementPossible(this.getPosition().getX() + 1, this.getPosition().getY(), dimensionPelouseX, dimensionPelouseY)) {
                    this.getPosition().setX(this.getPosition().getX() + 1);
                }
                break;
            case S:
                if (estUnDeplacementPossible(this.getPosition().getX(), this.getPosition().getY() - 1, dimensionPelouseX, dimensionPelouseY)) {
                    this.getPosition().setY(this.getPosition().getY() - 1);
                }
                break;
            case W:
                if (estUnDeplacementPossible(this.getPosition().getX() - 1, this.getPosition().getY(), dimensionPelouseX, dimensionPelouseY)) {
                    this.getPosition().setX(this.getPosition().getX() - 1);
                }
                break;
            case N:
                if (estUnDeplacementPossible(this.getPosition().getX(), this.getPosition().getY() + 1, dimensionPelouseX, dimensionPelouseY)) {
                    this.getPosition().setY(this.getPosition().getY() + 1);
                }
                break;
            default:
        }
    }

    private boolean estUnDeplacementPossible(int futurX, int futurY, int dimensionPelouseX, int dimensionPelouseY) {
        return futurX >= 0 && futurX <= dimensionPelouseX && futurY >= 0 && futurY <= dimensionPelouseY;
    }


    public void tournerADroite() {
        tourner(S, W, N, E);
    }

    public void tournerAGauche() {
        tourner(N, E, S, W);
    }

    private void tourner(Direction s, Direction w, Direction n, Direction e) {
        switch (this.getOrientation()) {
            case E:
                this.setOrientation(s);
                break;
            case S:
                this.setOrientation(w);
                break;
            case W:
                this.setOrientation(n);
                break;
            case N:
                this.setOrientation(e);
                break;
            default:
        }
    }
}
