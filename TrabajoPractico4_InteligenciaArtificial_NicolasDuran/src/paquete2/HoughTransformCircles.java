/*package paquete2; 

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class HoughTransformCircles {

    public static void main(String[] args) {
        try {
            // Ruta absoluta al archivo de imagen
            String filePath = "C:\\Imagen/JobsCareers-901568660.jpg";
            // Cargar la imagen desde el archivo
            BufferedImage image = ImageIO.read(new File(filePath));

            // Verificar que la imagen se haya cargado correctamente
            if (image == null) {
                System.out.println("No se pudo cargar la imagen: " + filePath);
                return;
            }

            // Obtener el ancho y alto de la imagen
            int width = image.getWidth();
            int height = image.getHeight();
            int minRadius = 15; // Radio mínimo de la circunferencia a detectar
            int maxRadius = 25; // Radio máximo de la circunferencia a detectar

            // Inicializar el acumulador 3D para almacenar los votos
            int[][][] accumulator = new int[width][height][maxRadius - minRadius];

            // Precalcular valores de seno y coseno para cada theta
            double[] cosTable = new double[180];
            double[] sinTable = new double[180];
            for (int theta = 0; theta < 180; theta++) {
                double rad = Math.toRadians(theta * 2); // Convertir grados a radianes
                cosTable[theta] = Math.cos(rad);
                sinTable[theta] = Math.sin(rad);
            }

            // Realizar la transformada de Hough para circunferencias
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Obtener el valor de color del píxel (asumiendo imagen en escala de grises)
                    int color = image.getRGB(x, y) & 0xFF;
                    if (color < 128) { // Considerar píxeles negros (valor menor a 128)
                        for (int r = minRadius; r < maxRadius; r++) {
                            for (int theta = 0; theta < 180; theta++) {
                                int a = (int) (x - r * cosTable[theta]);
                                int b = (int) (y - r * sinTable[theta]);
                                // Verificar que el centro esté dentro de los límites de la imagen
                                if (a >= 0 && a < width && b >= 0 && b < height) {
                                    accumulator[a][b][r - minRadius]++; // Incrementar el contador en el acumulador
                                }
                            }
                        }
                    }
                }
            }

            // Buscar picos en el acumulador para detectar circunferencias
            for (int a = 0; a < width; a++) {
                for (int b = 0; b < height; b++) {
                    for (int r = 0; r < maxRadius - minRadius; r++) {
                        if (accumulator[a][b][r] > 100) { // Umbral para considerar una circunferencia detectada
                            System.out.println("Circunferencia detectada en (a, b, r): (" + a + ", " + b + ", " + (r + minRadius) + ")");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} */