package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Torus extends Model {
    private static final int SEGMENTS_MAJOR = 24; // Number of divisions around the torus center
    private static final int SEGMENTS_MINOR = 12; // Number of divisions around the tube
    private static final double MAJOR_RADIUS = SCALE * 1.5; // Distance from the center to the tube center
    private static final double MINOR_RADIUS = SCALE * 0.5;  // Radius of the tube itself

    @Override
    protected void setupShape() {
        double phiStep = 2 * Math.PI / SEGMENTS_MAJOR;
        double thetaStep = 2 * Math.PI / SEGMENTS_MINOR;

        // Generate vertices
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

        // Generate edges
        for (int i = 0; i < SEGMENTS_MAJOR; i++) {
            for (int j = 0; j < SEGMENTS_MINOR; j++) {
                int current = i * SEGMENTS_MINOR + j;
                int nextMinor = i * SEGMENTS_MINOR + (j + 1) % SEGMENTS_MINOR;
                int nextMajor = ((i + 1) % SEGMENTS_MAJOR) * SEGMENTS_MINOR + j;

                // Connect points around the tube
                edges.add(new Edge(current, nextMinor));

                // Connect points along the major radius
                edges.add(new Edge(current, nextMajor));
            }
        }
    }
}
