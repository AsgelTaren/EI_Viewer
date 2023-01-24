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
		Color c1 = new Color(69, 255, 208);
		Color c2 = new Color(44, 171, 139);
		Color c3 = new Color(0, 189, 141);
		ArrayList<Color> colorList = new ArrayList<>();
		colorList.add(c3);
		colorList.add(c2);
		colorList.add(c1);
		colorList.add(c3);
		colorList.add(c2);
		colorList.add(c1);
		colorList.add(c1);
		colorList.add(c3);
		colorList.add(c3);
		colorList.add(c2);
		return new Solid(vertices, getColorAsFloat(colorList), size/2 + a / 2, 0, 0);
	}

	public static Solid getArc(float r1, float r2, float a, int subdiv, float l1, float l2) {

		Color border = new Color(122, 122, 122);
		Color border2 = new Color(168, 168, 168);
		Color end = new Color(99, 98, 98);

		Point[] points = new Point[] { new Point(0, -a / 2, -r1), new Point(0, a / 2, -r1), new Point(0, a / 2, -r2),
				new Point(0, -a / 2, -r2) };

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();

		pointList.addAll(Arrays.asList(points));
		colorList.add(end);

		for (int i = 0; i < subdiv; i++) {
			Point[] newPoints = Point.rotatePointsOnY(points, (float) Math.PI / subdiv);

			pointList.addAll(Arrays.asList(new Point[] { points[0], newPoints[0], newPoints[1], points[1] })); // Up
																												// face
			colorList.add(border2);

			pointList.addAll(Arrays.asList(new Point[] { points[0], newPoints[0], newPoints[3], points[3] })); // Left
																												// face
			colorList.add(border);

			pointList.addAll(Arrays.asList(new Point[] { points[3], newPoints[3], newPoints[2], points[2] })); // Down
																												// face

			colorList.add(border2);

			pointList.addAll(Arrays.asList(new Point[] { points[2], newPoints[2], newPoints[1], points[1] })); // Right
																												// face
			colorList.add(border);

			points = newPoints;
		}

		pointList.addAll(Arrays.asList(points));

		colorList.add(end);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), -a / 2 + l2 + r2, l1 / 2, 0);
	}

	public static Solid getBasis(float size, float a) {
		Point[] points = new Point[] { new Point(0.5f*size, 0.5f*size, size), new Point(0.5f*size, 0.5f*size, -2*size),
				new Point(0.5f*size, -0.5f*size, -2*size), new Point(0.5f*size, -0.5f*size, size), new Point(-0.5f*size, 0.5f*size, size),
				new Point(-0.5f*size, 0.5f*size, -2*size), new Point(-0.5f*size, -0.5f*size, -2*size), new Point(-0.5f*size, -0.5f*size, size) };

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();
		
		Color c1 = new Color(4, 204, 24);
		Color c2 = new Color(0, 143, 14);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[2], points[3] }));
		colorList.add(c1);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[4], points[5], points[6] }));
		colorList.add(c1);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[3], points[7], points[4] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[1], points[2], points[6], points[5] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[3], points[2], points[6] }));
		colorList.add(Color.GREEN);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[5], points[4] }));
		colorList.add(Color.GREEN);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), -size - a / 2, 0, 0);
	}

	public static Solid getElevator(float size, float height, float a, float r1, float r2) {
		Point[] points = new Point[] { new Point(size, size, height), new Point(size, size, -height),
				new Point(size, -size, -height), new Point(size, -size, height), new Point(-size, size, height),
				new Point(-size, size, -height), new Point(-size, -size, -height), new Point(-size, -size, height) };
		Color c1 = new Color(224, 2, 2);
		Color c2 = new Color(179, 2, 2);

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[2], points[3] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[4], points[5], points[6] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[3], points[7], points[4] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[1], points[2], points[6], points[5] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[3], points[2], points[6] }));
		colorList.add(c1);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[5], points[4] }));
		colorList.add(c1);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), 0, -size - a / 2, (r1 + r2) / 2);
	}
	
	public static Solid getElevator2(float size, float height, float a, float r1, float r2) {
		Point[] points = new Point[] { new Point(size, size, height), new Point(size, size, -height),
				new Point(size, -size, -height), new Point(size, -size, height), new Point(-size, size, height),
				new Point(-size, size, -height), new Point(-size, -size, -height), new Point(-size, -size, height) };
		Color c1 = new Color(224, 2, 2);
		Color c2 = new Color(179, 2, 2);

		ArrayList<Point> pointList = new ArrayList<>();
		ArrayList<Color> colorList = new ArrayList<>();

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[2], points[3] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[4], points[5], points[6] }));
		colorList.add(Color.red);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[3], points[7], points[4] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[1], points[2], points[6], points[5] }));
		colorList.add(c2);

		pointList.addAll(Arrays.asList(new Point[] { points[7], points[3], points[2], points[6] }));
		colorList.add(c1);

		pointList.addAll(Arrays.asList(new Point[] { points[0], points[1], points[5], points[4] }));
		colorList.add(c1);

		return new Solid(getVerticesFromPoints(pointList), getColorAsFloat(colorList), 0, 0, -(r1 + r2));
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
