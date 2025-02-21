package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Cone extends Model {
    private static final int SEGMENTS = 50;

    @Override
    protected void setupShape() {
        Vertex apex = new Vertex(0, SCALE, 0);
        vertices.add(apex);

        Vertex baseCenter = new Vertex(0, -SCALE, 0);
        vertices.add(baseCenter);

        for (int i = 0; i < SEGMENTS; i++) {
            double angle = 2 * Math.PI * i / SEGMENTS;
            double x = SCALE * Math.cos(angle);
            double z = SCALE * Math.sin(angle);
            vertices.add(new Vertex(x, -SCALE, z));
        }

        int baseStartIndex = 2;

        for (int i = 0; i < SEGMENTS; i++) {
            int nextIndex = baseStartIndex + ((i + 1) % SEGMENTS);

            edges.add(new Edge(baseStartIndex + i, nextIndex));
            edges.add(new Edge(0, baseStartIndex + i));
            edges.add(new Edge(1, baseStartIndex + i));
        }
    }
}
