package io.github.kubaue.raceGame.engine.imageProcessing;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.util.HashMap;
import java.util.Map;

public class ImageMap {
    private Map<Integer, Map<Integer, ImageCanals>> map = new HashMap<>();

    public ImageMap(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int argb = pixelReader.getArgb(x, y);
                int a = (0xff & (argb >> 24));
                int r = (0xff & (argb >> 16));
                int g = (0xff & (argb >> 8));
                int b = (0xff & argb);
                this.put(x, y, new ImageCanals(r, g, b));
            }
        }
    }

    public ImageCanals get(int x, int y) {
        return map.get(x).get(y);
    }

    public int getGray(int x, int y) {
        return map.get(x).get(y).red;
    }

    public int height() {
        return map.get(0).size();
    }

    public int width() {
        return map.size();
    }

    private void put(int x, int y, ImageCanals ImageCanals) {
        Map<Integer, ImageCanals> innerMap = map.get(x);

        if (innerMap == null) {
            innerMap = new HashMap<>();
        }

        innerMap.put(y, ImageCanals);

        map.put(x, innerMap);
    }

    private ImageCanals getCanalValueOrNull(int x, int y) {
        if (x < 0 || x >= width() || y < 0 || y >= height()) {
            return null;
        }
        return map.get(x).get(y);
    }

}
