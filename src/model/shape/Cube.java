package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Cube extends Model {

    @Override
    protected void setupShape() {
        vertices.add(new Vertex(-1 * SCALE, -1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(-1 * SCALE, -1 * SCALE, 1 * SCALE));
        vertices.add(new Vertex(-1 * SCALE, 1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(-1 * SCALE, 1 * SCALE, 1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, -1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, -1 * SCALE, 1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, 1 * SCALE, -1 * SCALE));
        vertices.add(new Vertex(1 * SCALE, 1 * SCALE, 1 * SCALE));

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));
        edges.add(new Edge(0, 4));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(1, 5));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(2, 6));
        edges.add(new Edge(3, 7));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(4, 6));
        edges.add(new Edge(5, 7));
        edges.add(new Edge(6, 7));
    }
}