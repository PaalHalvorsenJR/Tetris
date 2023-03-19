package no.uib.inf101.tetris.view;

import java.awt.Color;

/**
 * The DefaultColorTheme class implements the ColorTheme interface.
 */
public class DefaultColorTheme implements ColorTheme {
    
    @Override
    public Color getCellColor(char c) {
    Color color = switch(c) {
        case 'I' -> Color.CYAN;
        case 'J' -> Color.BLUE;
        case 'L' -> Color.ORANGE;
        case 'O' -> Color.YELLOW;
        case 'S' -> Color.GREEN;
        case 'T' -> Color.MAGENTA;
        case 'Z' -> Color.RED;

        // .... fyll ut dine favorittfarger
        case '-' -> gameOverColor();
        default -> throw new IllegalArgumentException(
            "No available color for '" + c + "'");
    };
    return color;
}

    @Override
    public Color getBackgroundColor() {
        return new Color(0, 0, 0, 255);
    }

    // I want to return an image here, but I don't know how to do it.
    @Override
    public Color getFrameColor() {
        return new Color(204,204,204, 255);
    }

    @Override 
    public Color gameOverColor(){
        return new Color(255, 99, 71, 255);

    } 




}


