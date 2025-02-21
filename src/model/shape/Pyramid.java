package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Pyramid extends Model {

    @Override
    protected void setupShape() {
        vertices.add(new Vertex(-1 * SCALE, -1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, -1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, -1 * SCALE, 1 * SCALE));
        vertices.add(new Vertex(-1 * SCALE, -1 * SCALE, 1 * SCALE));
        vertices.add(new Vertex(0, 1 * SCALE, 0));

        edges.add(new Edge(0, 1));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 0));
        edges.add(new Edge(0, 4));
        edges.add(new Edge(1, 4));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(3, 4));
    }
}
