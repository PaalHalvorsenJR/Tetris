package no.uib.inf101.tetris.view;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.Color;
import org.junit.jupiter.api.Test;



public class TestDefaultColorTheme {
    @Test
    public void sanityTestDefaultColorTheme() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(new Color(0, 0, 0, 255), colors.getBackgroundColor());
    assertEquals(new Color(204,204,204, 255), colors.getFrameColor());
    
    }

}
