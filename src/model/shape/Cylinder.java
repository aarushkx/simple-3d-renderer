package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Cylinder extends Model {
    private static final int SEGMENTS = 100;

    @Override
    protected void setupShape() {
        double angleStep = 2 * Math.PI / SEGMENTS;

        for (int i = 0; i < SEGMENTS; i++) {
            double angle = i * angleStep;
            double x = SCALE * Math.cos(angle);
            double z = SCALE * Math.sin(angle);
            vertices.add(new Vertex(x, -SCALE, z));
            vertices.add(new Vertex(x, SCALE, z));
        }

        for (int i = 0; i < SEGMENTS; i++) {
            edges.add(new Edge(i * 2, ((i + 1) % SEGMENTS) * 2));
        }

        for (int i = 0; i < SEGMENTS; i++) {
            edges.add(new Edge(i * 2 + 1, ((i + 1) % SEGMENTS) * 2 + 1));
        }

        for (int i = 0; i < SEGMENTS; i++) {
            edges.add(new Edge(i * 2, i * 2 + 1));
        }
    }
}
