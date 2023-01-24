package net.app;

public class Point {

	public float x, y, z;

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point rotateOnY(float angle) {
		float c = (float) Math.cos(angle);
		float s = (float) Math.sin(angle);
		return new Point(c * x + s * z, y, -s * x + c * z);
	}

	public static Point[] rotatePointsOnY(Point[] points, float angle) {
		Point[] res = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			res[i] = points[i].rotateOnY(angle);
		}
		return res;
	}

}