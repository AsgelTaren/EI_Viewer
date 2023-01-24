package net.app;

import java.nio.FloatBuffer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import com.jogamp.common.nio.Buffers;

public class Solid {

	private FloatBuffer verticesBuff, colorsBuff;
	private float[] vertices;
	public float rx, ry, rz;
	private float x, y, z;

	public Solid(float[] vertices, float[] colors) {
		this.vertices = vertices;

		verticesBuff = Buffers.newDirectFloatBuffer(vertices);
		colorsBuff = Buffers.newDirectFloatBuffer(colors);
	}

	public Solid(float[] vertices, float[] colors, float x, float y, float z) {
		this.vertices = vertices;

		verticesBuff = Buffers.newDirectFloatBuffer(vertices);
		colorsBuff = Buffers.newDirectFloatBuffer(colors);

		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void render(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glTranslatef(x, y, z);
		gl.glRotatef(rx, 1, 0, 0);
		gl.glRotatef(ry, 0, 1, 0);
		gl.glRotatef(rz, 1, 0, 0);

		gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL2.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL2.GL_FLOAT, 0, verticesBuff);
		gl.glColorPointer(3, GL2.GL_FLOAT, 0, colorsBuff);

		gl.glDrawArrays(GL2.GL_QUADS, 0, vertices.length / 3);
	}
}