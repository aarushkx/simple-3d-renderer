package model.shape;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

public class Sphere extends Model {
    private static final int LATITUDE_DIVISIONS = 20;
    private static final int LONGITUDE_DIVISIONS = 30;

    @Override
    protected void setupShape() {
        Vertex northPole = new Vertex(0, SCALE, 0);
        Vertex southPole = new Vertex(0, -SCALE, 0);
        vertices.add(northPole);

        for (int lat = 1; lat < LATITUDE_DIVISIONS; lat++) {
            double theta = Math.PI * lat / LATITUDE_DIVISIONS;
            double sinTheta = Math.sin(theta);
            double cosTheta = Math.cos(theta);

            for (int lon = 0; lon < LONGITUDE_DIVISIONS; lon++) {
                double phi = 2 * Math.PI * lon / LONGITUDE_DIVISIONS;
                double x = SCALE * sinTheta * Math.cos(phi);
                double y = SCALE * cosTheta;
                double z = SCALE * sinTheta * Math.sin(phi);

                vertices.add(new Vertex(x, y, z));
            }
        }

        vertices.add(southPole);

        int poleIndexNorth = 0;
        int firstVertexIndex = 1;
        int poleIndexSouth = vertices.size() - 1;

        for (int lon = 0; lon < LONGITUDE_DIVISIONS; lon++) {
            int nextLon = firstVertexIndex + ((lon + 1) % LONGITUDE_DIVISIONS);
            edges.add(new Edge(poleIndexNorth, firstVertexIndex + lon));
        }

        for (int lat = 0; lat < LATITUDE_DIVISIONS - 2; lat++) {
            for (int lon = 0; lon < LONGITUDE_DIVISIONS; lon++) {
                int current = firstVertexIndex + lat * LONGITUDE_DIVISIONS + lon;
                int nextLon = firstVertexIndex + lat * LONGITUDE_DIVISIONS + ((lon + 1) % LONGITUDE_DIVISIONS);
                int nextLat = firstVertexIndex + (lat + 1) * LONGITUDE_DIVISIONS + lon;

                edges.add(new Edge(current, nextLon));
                edges.add(new Edge(current, nextLat));
            }
        }

        int lastRingStart = firstVertexIndex + (LATITUDE_DIVISIONS - 2) * LONGITUDE_DIVISIONS;
        for (int lon = 0; lon < LONGITUDE_DIVISIONS; lon++) {
            edges.add(new Edge(lastRingStart + lon, poleIndexSouth));
        }
    }
}
