package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Donut extends Model {
    private static final int SEGMENTS_MAJOR = 96;
    private static final int SEGMENTS_MINOR = 48;
    private static final double MAJOR_RADIUS = SCALE * 1.5;
    private static final double MINOR_RADIUS = SCALE * 0.5;

    @Override
    protected void setupShape() {
        double phiStep = 2 * Math.PI / SEGMENTS_MAJOR;
        double thetaStep = 2 * Math.PI / SEGMENTS_MINOR;

        for (int i = 0; i < SEGMENTS_MAJOR; i++) {
            double phi = i * phiStep;
            double cosPhi = Math.cos(phi);
            double sinPhi = Math.sin(phi);

            for (int j = 0; j < SEGMENTS_MINOR; j++) {
                double theta = j * thetaStep;
                double cosTheta = Math.cos(theta);
                double sinTheta = Math.sin(theta);

                double x = (MAJOR_RADIUS + MINOR_RADIUS * cosTheta) * cosPhi;
                double y = (MAJOR_RADIUS + MINOR_RADIUS * cosTheta) * sinPhi;
                double z = MINOR_RADIUS * sinTheta;

                vertices.add(new Vertex(x, y, z));
            }
        }

        for (int i = 0; i < SEGMENTS_MAJOR; i++) {
            for (int j = 0; j < SEGMENTS_MINOR; j++) {
                int current = i * SEGMENTS_MINOR + j;
                int nextMinor = i * SEGMENTS_MINOR + (j + 1) % SEGMENTS_MINOR;
                int nextMajor = ((i + 1) % SEGMENTS_MAJOR) * SEGMENTS_MINOR + j;

                edges.add(new Edge(current, nextMinor));
                edges.add(new Edge(current, nextMajor));
            }
        }
    }
}
