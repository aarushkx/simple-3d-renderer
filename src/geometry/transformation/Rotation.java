package geometry.transformation;

import geometry.Vertex;

public class Rotation {
    public static final double ROTATION_SPEED = 2.25;

    private double angleX = 0;
    private double angleY = 0;

    public void rotateX(double angle) {
        angleX += angle;
    }

    public void rotateY(double angle) {
        angleY += angle;
    }

    public Vertex rotateVertex(Vertex vertex) {
        Vertex rotated = rotateX(vertex, angleX);
        rotated = rotateY(rotated, angleY);
        return rotated;
    }

    private Vertex rotateX(Vertex vertex, double angle) {
        double y = vertex.y * Math.cos(angle) - vertex.z * Math.sin(angle);
        double z = vertex.y * Math.sin(angle) + vertex.z * Math.cos(angle);
        return new Vertex(vertex.x, y, z);
    }

    private Vertex rotateY(Vertex vertex, double angle) {
        double x = vertex.x * Math.cos(angle) + vertex.z * Math.sin(angle);
        double z = -vertex.x * Math.sin(angle) + vertex.z * Math.cos(angle);
        return new Vertex(x, vertex.y, z);
    }
}
