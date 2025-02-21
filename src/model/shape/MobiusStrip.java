package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class MobiusStrip extends Model {
    private static final int SEGMENTS = 120;
    private static final int WIDTH_SEGMENTS = 20;

    @Override
    protected void setupShape() {
        double alphaStep = 2 * Math.PI / SEGMENTS;
        double rStep = 2.0 / WIDTH_SEGMENTS;

        for (int i = 0; i <= SEGMENTS; i++) {
            double alpha = i * alphaStep;
            for (int j = 0; j <= WIDTH_SEGMENTS; j++) {
                double r = -1.0 + j * rStep;

                double x = Math.cos(alpha) * (1 + (r / 2) * Math.cos(alpha / 2)) * SCALE;
                double y = Math.sin(alpha) * (1 + (r / 2) * Math.cos(alpha / 2)) * SCALE;
                double z = (r / 2) * Math.sin(alpha / 2) * SCALE;

                vertices.add(new Vertex(x, y, z));
            }
        }

        for (int i = 0; i < SEGMENTS; i++) {
            for (int j = 0; j < WIDTH_SEGMENTS; j++) {
                int current = i * (WIDTH_SEGMENTS + 1) + j;
                int next = (i + 1) * (WIDTH_SEGMENTS + 1) + j;
                int nextRow = current + 1;
                int nextDiagonal = next + 1;

                edges.add(new Edge(current, next));
                edges.add(new Edge(current, nextRow));

                if (j == WIDTH_SEGMENTS - 1) {
                    edges.add(new Edge(nextRow, nextDiagonal));
                }
            }
        }

        for (int j = 0; j < WIDTH_SEGMENTS; j++) {
            int start = j;
            int end = SEGMENTS * (WIDTH_SEGMENTS + 1) + j;
            edges.add(new Edge(start, end));
        }
    }
}
