package io.github.kubaue.raceGame.engine;

import io.github.kubaue.raceGame.engine.imageProcessing.ImageMap;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TrackImage {

    private ImageMap trackImageMap = prepareTrackImageMap();

    private ImageMap prepareTrackImageMap() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName()).getFile());
            BufferedImage bufferedImage = ImageIO.read(file);
            return new ImageMap(SwingFXUtils.toFXImage(bufferedImage, null));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load track image");
        }
    }

    public int width() {
        return trackImageMap.width();
    }

    public int height() {
        return trackImageMap.height();
    }

    public String fileName() {
        return "track.png";
    }
}
