/*package paquete1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class HoughTransformLines {

    public static void main(String[] args) {
        try {
            // Cargar la imagen desde el archivo
            BufferedImage image = ImageIO.read(new File("C:\\Imagen/JobsCareers-901568660.jpg"));

            // Obtener el ancho y alto de la imagen
            int width = image.getWidth();
            int height = image.getHeight();

            // Parámetros para la transformada de Hough
            int maxRho = (int) Math.hypot(width, height); // Máximo valor posible para rho
            int[] accumulator = new int[180 * 2 * maxRho]; // Acumulador para almacenar los votos
            double[] sinTable = new double[180]; // Tabla de senos para θ de 0 a 179 grados
            double[] cosTable = new double[180]; // Tabla de cosenos para θ de 0 a 179 grados

            // Precalcular los valores de seno y coseno para cada θ
            for (int theta = 0; theta < 180; theta++) {
                double rad = Math.toRadians(theta); // Convertir grados a radianes
                sinTable[theta] = Math.sin(rad); // Calcular seno y almacenarlo en la tabla
                cosTable[theta] = Math.cos(rad); // Calcular coseno y almacenarlo en la tabla
            }

            // Realizar la transformada de Hough
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Obtener el valor de color del píxel (asumiendo imagen en escala de grises)
                    int color = image.getRGB(x, y) & 0xFF;
                    if (color < 128) { // Considerar píxeles negros (valor menor a 128)
                        for (int theta = 0; theta < 180; theta++) {
                            // Calcular rho usando la fórmula de la transformada de Hough
                            int rho = (int) (x * cosTable[theta] + y * sinTable[theta]);
                            // Calcular el índice del acumulador y aumentar el contador
                            int index = (theta * 2 * maxRho) + (rho + maxRho);
                            accumulator[index]++;
                        }
                    }
                }
            }

            // Buscar picos en el acumulador para detectar líneas
            for (int theta = 0; theta < 180; theta++) {
                for (int rho = -maxRho; rho < maxRho; rho++) {
                    int index = (theta * 2 * maxRho) + (rho + maxRho);
                    if (accumulator[index] > 100) { // Umbral para considerar una línea detectada
                        System.out.println("Línea detectada en θ: " + theta + ", ρ: " + rho);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/