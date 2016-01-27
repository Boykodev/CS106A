import java.awt.Point;
import java.util.ArrayList;

import acm.program.*;
import acm.graphics.*;

public class LineGraph extends GraphicsProgram {

	private static final int GRAPH_WIDTH = 500;
	private static final int GRAPH_HEIGHT = 400;
	private static final int OVAL_SIZE = 4;
	
	public void run() {
		ArrayList<Point> points = readPoints();
		GCompound lineGraph = buildGraph(points);
		double centerX = (getWidth() - lineGraph.getWidth()) / 2;
		double centerY = (getHeight() - lineGraph.getHeight()) / 2;
		add(lineGraph, centerX, centerY);
	}

	private ArrayList<Point> readPoints() {
		ArrayList<Point> points = new ArrayList<Point>();
		int sentinel = 0;
		
		while (true) {
			Point temp = new Point();
			temp.x = readInt("Enter x: ");
			if (temp.x < sentinel) {
				break;
			} else {
				sentinel = temp.x;
			}
			temp.y = readInt("Enter y: ");
			
			points.add(temp);
		}
		return points;
	}

	private GCompound buildGraph(ArrayList<Point> points) {
		GCompound graph = new GCompound();
		double maxX = points.get(points.size() - 1).x;
		double maxY = getMaxY(points);
		graph.add(new GRect(GRAPH_WIDTH, GRAPH_HEIGHT));
		
		for (int i = 0; i < points.size(); i++) {
			GOval point = new GOval(OVAL_SIZE, OVAL_SIZE);
			point.setFilled(true);
			double x = points.get(i).x * (GRAPH_WIDTH / maxX);
			double y = points.get(i).y * (GRAPH_HEIGHT / maxY);
			y = reverseY(y);
			if (i < points.size() - 1) {
				double nextX = points.get(i + 1).x * (GRAPH_WIDTH / maxX);
				double nextY = points.get(i + 1).y * (GRAPH_HEIGHT / maxY);
				nextY = reverseY(nextY);
				GLine line = new GLine(x, y, nextX, nextY);
				graph.add(line);
			}
			graph.add(point, x - (OVAL_SIZE / 2), y - (OVAL_SIZE / 2));
		}
		return graph;
	}

	private double reverseY(double y) {
		double centerY = GRAPH_HEIGHT / 2;
		if (y < centerY) {
			y += (centerY - y) * 2;
		} else if (y > centerY) {
			y -= (y - centerY) * 2;
		}
		return y;
	}

	private double getMaxY(ArrayList<Point> points) {
		double maxY = 0;
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).y > maxY) {
				maxY = points.get(i).y;
			}
		}
		return maxY;
	}
}
