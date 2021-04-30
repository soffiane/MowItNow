package fr.publicissapient.tondeuse.modele;

import fr.publicissapient.deplacement.modele.Deplacement;
import fr.publicissapient.direction.modele.Direction;
import fr.publicissapient.position.modele.Position;

import java.util.List;

public class Tondeuse {

    private Position position;
    private Direction orientation;
    private List<Deplacement> deplacements;

    public Tondeuse(Position position, Direction orientation, List<Deplacement> deplacements) {
        this.position = position;
        this.orientation = orientation;
        this.deplacements = deplacements;
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


}
