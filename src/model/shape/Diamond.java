package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Diamond extends Model {

    @Override
    protected void setupShape() {
        vertices.add(new Vertex(0, -SCALE, 0));
        vertices.add(new Vertex(0, SCALE, 0));

        vertices.add(new Vertex(-SCALE, 0, -SCALE));
        vertices.add(new Vertex(SCALE, 0, -SCALE));
        vertices.add(new Vertex(SCALE, 0, SCALE));
        vertices.add(new Vertex(-SCALE, 0, SCALE));

        edges.add(new Edge(0, 2));
        edges.add(new Edge(0, 3));
        edges.add(new Edge(0, 4));
        edges.add(new Edge(0, 5));

        edges.add(new Edge(1, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(1, 4));
        edges.add(new Edge(1, 5));

        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(5, 2));
    }
}