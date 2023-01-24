package net.app;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomModel {

	public static Solid getPiece1(float a, float b, float l1, float l2, float size) {
		float[] vertices = new float[] { // Specifying all vertices
				a / 2, -(l1 - a) / 2, b / 2, // 0, 0 -> 0
				a / 2, (l1 + a) / 2, b / 2, // 1, 0 -> 1
				-a / 2, (l1 + a) / 2, b / 2, // 2, 0 -> 2
				-a / 2, -(l1 - a) / 2, b / 2, // 3, 0 -> 3
				a / 2, -(l1 - a) / 2, b / 2, // 4, 1 -> 0
				a / 2, (l1 - a) / 2, b / 2, // 5, 1 -> 1
				a / 2, (l1 - a) / 2, -b / 2, // 6, 1 -> 2
				a / 2, -(l1 - a) / 2, -b / 2, // 7, 1 -> 3
				a / 2, -(l1 - a) / 2, b / 2, // 8, 2 -> 0
				a / 2, -(l1 - a) / 2, -b / 2, // 9, 2 -> 1
				-a / 2, -(l1 - a) / 2, -b / 2, // 10, 2 -> 2
				-a / 2, -(l1 - a) / 2, b / 2, // 11, 2 -> 3
				a / 2, -(l1 - a) / 2, -b / 2, // 12, 3 -> 0
				a / 2, (l1 + a) / 2, -b / 2, // 13, 3 -> 1
				-a / 2, (l1 + a) / 2, -b / 2, // 14, 3 -> 2
				-a / 2, -(l1 - a) / 2, -b / 2, // 15, 3 -> 3
				-a / 2, -(l1 - a) / 2, b / 2, // 16
				-a / 2, -(l1 - a) / 2, -b / 2, // 17
				-a / 2, (l1 + a) / 2, -b / 2, // 18
				-a / 2, (l1 + a) / 2, b / 2, // 19
				-a / 2, (l1 + a) / 2, b / 2, // 20
				-a / 2, (l1 + a) / 2, -b / 2, // 21
				l2 - a / 2, (l1 + a) / 2, -b / 2, // 22
				l2 - a / 2, (l1 + a) / 2, b / 2, // 23
				a / 2, (l1 - a) / 2, b / 2, // 24
				a / 2, (l1 - a) / 2, -b / 2, // 25
				l2 - a / 2, (l1 - a) / 2, -b / 2, // 26
				l2 - a / 2, (l1 - a) / 2, b / 2, // 27
				a / 2, (l1 - a) / 2, b / 2, // 28
				a / 2, (l1 + a) / 2, b / 2, // 29
				l2 - a / 2, (l1 + a) / 2, b / 2, // 30
				l2 - a / 2, (l1 - a) / 2, b / 2, // 31
				a / 2, (l1 - a) / 2, -b / 2, // 32
				a / 2, (l1 + a) / 2, -b / 2, // 33
				l2 - a / 2, (l1 + a) / 2, -b / 2, // 34
				l2 - a / 2, (l1 - a) / 2, -b / 2, // 35
				l2 - a / 2, (l1 + a) / 2, b / 2, // 36
				l2 - a / 2, (l1 + a) / 2, -b / 2, // 37
				l2 - a / 2, (l1 - a) / 2, -b / 2, // 38
				l2 - a / 2, (l1 - a) / 2, b / 2, // 39
		};
		float[] colors = new float[] { // Specifying all colors
				1, 0, 0, // 0 -> 0
				1, 0, 0, // 0 -> 1
				1, 0, 0, // 0 -> 2
				1, 0, 0, // 0 -> 3
				0, 1, 0, // 1 -> 0
				0, 1, 0, // 1 -> 1
				0, 1, 0, // 1 -> 2
				0, 1, 0, // 1 -> 3
				0, 0, 1, // 2 -> 0
				0, 0, 1, // 2 -> 1
				0, 0, 1, // 2 -> 2
				0, 0, 1, // 2 -> 3
				1, 0, 1, // 3 -> 0
				1, 0, 1, // 3 -> 1
				1, 0, 1, // 3 -> 2
				1, 0, 1, // 3 -> 3
				1, 1, 0, // 4 -> 0
				1, 1, 0, // 4 -> 1
				1, 1, 0, // 4 -> 2
				1, 1, 0, // 4 -> 3
				0, 0, 1, // 5 -> 0
				0, 0, 1, // 5 -> 1
				0, 0, 1, // 5 -> 2
				0, 0, 1, // 5 -> 3
				0, 1, 0, // 6 -> 0
				0, 1, 0, // 6 -> 1
				0, 1, 0, // 6 -> 2
				0, 1, 0, // 6 -> 3
				1, 0, 0, // 7 -> 0
				1, 0, 0, // 7 -> 1
				1, 0, 0, // 7 -> 2
				1, 0, 0, // 7 -> 3
				1, 0, 0, // 8 -> 0
				1, 0, 0, // 8 -> 1
				1, 0, 0, // 8 -> 2
				1, 0, 0, // 8 -> 3
				0, 0, 1, // 9 -> 0
				0, 0, 1, // 9 -> 1
				0, 0, 1, // 9 -> 2
				0, 0, 1, // 9 -> 3
		};
		return new Solid(vertices, colors, size + a / 2, 0, 0);
	}

	public static Solid getArc(float r1, float r2, float a, int subdiv, float l1, float l2) {
		Point[] points = new Point[] { new Point(0, -a / 2, -r1), new Point(0, a / 2, -r1), new Point(0, a / 2, -r2),
				new Point(0, -a / 2, -r2) };

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();

		pointList.addAll(Arrays.asList(points));
		colorList.add(Color.RED);

		for (int i = 0; i < subdiv; i++) {
			Point[] newPoints = Point.rotatePointsOnY(points, (float) Math.PI / subdiv);

			pointList.addAll(Arrays.asList(new Point[] { points[0], newPoints[0], newPoints[1], points[1] })); // Up
																												// face
			colorList.add(Color.GREEN);

			pointList.addAll(Arrays.asList(new Point[] { points[0], newPoints[0], newPoints[3], points[3] })); // Left
																												// face
			colorList.add(Color.BLUE);

			pointList.addAll(Arrays.asList(new Point[] { points[3], newPoints[3], newPoints[2], points[2] })); // Down
																												// face

			colorList.add(Color.GREEN);

			pointList.addAll(Arrays.asList(new Point[] { points[2], newPoints[2], newPoints[1], points[1] })); // Right
																												// face
			colorList.add(Color.BLUE);

			points = newPoints;
		}

		pointList.addAll(Arrays.asList(points));

		colorList.add(Color.RED);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), -a / 2 + l2 + r2, l1 / 2, 0);
	}

	public static Solid getBasis(float size, float a) {
		Point[] points = new Point[] { new Point(size, size, size), new Point(size, size, -size),
				new Point(size, -size, -size), new Point(size, -size, size), new Point(-size, size, size),
				new Point(-size, size, -size), new Point(-size, -size, -size), new Point(-size, -size, size) };

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[2], points[3] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[4], points[5], points[6] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[3], points[7], points[4] }));
		colorList.add(Color.BLUE);

		pointList.addAll(Arrays.asList(new Point[] { points[1], points[2], points[6], points[5] }));
		colorList.add(Color.BLUE);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[3], points[2], points[6] }));
		colorList.add(Color.GREEN);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[5], points[4] }));
		colorList.add(Color.GREEN);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), -size - a / 2, 0, 0);
	}

	public static float[] getVerticesFromPoints(ArrayList<Point> points) {
		float[] res = new float[points.size() * 3];
		for (int i = 0; i < points.size(); i++) {
			res[3 * i] = points.get(i).x;
			res[3 * i + 1] = points.get(i).y;
			res[3 * i + 2] = points.get(i).z;
		}
		return res;
	}

	public static float[] getColorAsFloat(ArrayList<Color> colors) {
		float[] res = new float[colors.size() * 12];
		for (int i = 0; i < colors.size(); i++) {
			for (int j = 0; j < 4; j++) {
				Color c = colors.get(i);
				res[12 * i + 3 * j] = c.getRed() / 255.0f;
				res[12 * i + 3 * j + 1] = c.getGreen() / 255.0f;
				res[12 * i + 3 * j + 2] = c.getBlue() / 255.0f;
			}
		}
		return res;
	}

}
