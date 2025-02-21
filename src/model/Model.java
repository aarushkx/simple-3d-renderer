package model;

import geometry.Edge;
import geometry.Vertex;
import geometry.transformation.Rotation;

import java.util.ArrayList;
import java.util.List;

public abstract class Model {
    protected static final double SCALE = 100;
    protected final List<Vertex> vertices;
    protected final List<Edge> edges;
    protected final Rotation rotation;

    public Model() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        rotation = new Rotation();
        setupShape();
    }

    protected abstract void setupShape();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public Vertex getTransformedVertex(Vertex v) {
        return rotation.rotateVertex(v);
    }
}
