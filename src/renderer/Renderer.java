package renderer;

import geometry.Edge;
import geometry.Vertex;
import model.Model;

import javax.swing.*;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.util.ArrayList;
import java.util.List;

public class Renderer extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double FOV = 500;

    private final Model model;

    public Renderer(Model model) {
        this.model = model;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(1.0f));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        List<Vertex> vertices = model.getVertices();
        List<Edge> edges = model.getEdges();

        List<Point> projectedPoints = new ArrayList<>();
        for (Vertex vertex : vertices) {
            Vertex transformed = model.getTransformedVertex(vertex);
            Point projected = project(transformed);
            projectedPoints.add(projected);
        }

        g2d.setColor(Color.WHITE);
        for (Edge edge : edges) {
            Point p1 = projectedPoints.get(edge.start);
            Point p2 = projectedPoints.get(edge.end);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        g2d.setColor(Color.GREEN);
        g2d.drawString("FPS: " + Animation.getCurrentFps(), 10, 20);
    }

    private Point project(Vertex vertex) {
        double scale = FOV / (FOV + vertex.z);
        int x = (int) (vertex.x * scale + WIDTH / 2);
        int y = (int) (vertex.y * scale + HEIGHT / 2);
        return new Point(x, y);
    }
}