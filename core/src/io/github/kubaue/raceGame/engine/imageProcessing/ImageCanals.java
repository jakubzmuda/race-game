package io.github.kubaue.raceGame.engine.imageProcessing;

import java.util.Objects;

public class ImageCanals {
    final int red;
    final int green;
    final int blue;

    public ImageCanals(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageCanals)) return false;
        ImageCanals that = (ImageCanals) o;
        return red == that.red &&
                green == that.green &&
                blue == that.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "ImageCanals{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
