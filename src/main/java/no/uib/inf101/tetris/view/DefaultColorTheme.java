package no.uib.inf101.tetris.view;

import java.awt.Color;

import no.uib.inf101.tetris.model.tetromino.GameState;

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
        if (GameState.GAME_OVER == GameState.GAME_OVER)
        {
            return (new Color(0,0,0,200));
        }
        else{
            return (new Color(0,0,0,0));
            }
        }

        // public Color getFadedGameOver() {
        //     return new Color(0,0, 0, 128);
        // }
}

