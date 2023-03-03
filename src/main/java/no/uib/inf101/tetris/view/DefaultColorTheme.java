package no.uib.inf101.tetris.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme {
    @Override
    public Color getCellColor(Character c) {
    Color color = switch(c) {
        case 'r' -> Color.RED;
        case 'g' -> Color.GREEN;
        case 'b' -> Color.BLUE;
        case 'y' -> Color.YELLOW;
        // .... fyll ut dine favorittfarger
        case '-' -> Color.BLACK;
        default -> throw new IllegalArgumentException(
            "No available color for '" + c + "'");
    };
    return color;
}

    @Override
    public Color getBackgroundColor() {
        return null;
    }

    @Override
    public Color getFrameColor() {
        return (new Color(0,0,0,0));
    }

}

