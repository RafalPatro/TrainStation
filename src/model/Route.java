package model;

import java.util.List;

public class Route {

    private final List<Position> positionList;

    public Route(List<Position> positionList) {
        this.positionList = positionList;
    }

    Position getNextPosition(Position position) {
        int index = positionList.indexOf(position);
        if (index == (positionList.size() - 1)) {
            index = 0;
        } else {
            index++;
        }
        return positionList.get(index);
    }

    public List<Position> getPositionList() {
        return positionList;
    }
}
