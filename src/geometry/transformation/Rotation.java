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

    public Vertex rotateVertex(Vertex v) {
        Vertex rotated = rotateX(v, angleX);
        rotated = rotateY(rotated, angleY);
        return rotated;
    }

    private Vertex rotateX(Vertex v, double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        double y = v.y * cos - v.z * sin;
        double z = v.y * sin + v.z * cos;

        return new Vertex(v.x, y, z);
    }

    private Vertex rotateY(Vertex v, double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        double x = v.x * cos + v.z * sin;
        double z = -v.x * sin + v.z * cos;

        return new Vertex(x, v.y, z);
    }
}
