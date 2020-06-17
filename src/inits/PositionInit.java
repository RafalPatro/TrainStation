package inits;

import model.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionInit {

    private PositionInit() {
    }

    public static List<Position> initPositions() {

        List<Position> positions = new ArrayList<>();
        positions.add(new Position(8, 11));
        positions.add(new Position(8, 8));
        positions.add(new Position(16, 5));
        positions.add(new Position(9, 10));
        return positions;
    }


}
