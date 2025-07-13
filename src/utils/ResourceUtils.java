package utils;

import base.resource.Resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public abstract class ResourceUtils {

    public static BufferedImage readImage(String filePath) {
        try {
            return ImageIO.read(Objects.requireNonNull(Resources.class.getResourceAsStream(filePath)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
