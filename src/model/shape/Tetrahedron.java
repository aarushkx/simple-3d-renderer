package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Tetrahedron extends Model {

    @Override
    protected void setupShape() {
        vertices.add(new Vertex(0, -1 * SCALE, 0));
        vertices.add(new Vertex(-SCALE, SCALE, -SCALE));
        vertices.add(new Vertex(SCALE, SCALE, -SCALE));
        vertices.add(new Vertex(0, SCALE, SCALE));

        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));
        edges.add(new Edge(0, 3));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 1));
    }
}
