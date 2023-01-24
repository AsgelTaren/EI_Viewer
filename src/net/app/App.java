package net.app;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class App implements GLEventListener, KeyListener, MouseWheelListener, MouseMotionListener, MouseListener {

	// Solids
	public ArrayList<Solid> solids;

	// Rots
	public float alpha, beta, zoom = 1.0f;
	private float lastX, lastY;

	private GLU glu = new GLU();

	public App() {
		this.solids = new ArrayList<Solid>();
		solids.add(CustomModel.getBasis(2, 1));
		solids.add(CustomModel.getPiece1(1, 2, 3, 4, 2));
		solids.add(CustomModel.getArc(2, 3, 1, 10, 3, 4));
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

		ControllerManager manager = new ControllerManager(this);
		manager.start();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0f, 0f, -5.0f);
		gl.glScalef(zoom, zoom, zoom);
		gl.glRotatef(alpha, 1, 0, 0);
		gl.glRotatef(beta, 0, 0, 1);

		for (Solid solid : solids) {
			solid.render(drawable);
		}

		gl.glEnd(); // Done Drawing The Quad
		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		final GL2 gl = drawable.getGL().getGL2();

		final float h = (float) width / (float) height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();

		glu.gluPerspective(45.0f, h, 0.5, 20.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public void start() {
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		canvas.addKeyListener(this);
		canvas.addMouseWheelListener(this);
		canvas.addMouseMotionListener(this);
		canvas.addMouseListener(this);
		canvas.setSize(400, 400);

		JFrame frame = new JFrame("Enseignement Intégration");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(canvas);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		FPSAnimator anim = new FPSAnimator(canvas, 300, true);
		anim.start();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			solids.get(2).ry -= 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			solids.get(2).ry += 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			solids.get(1).rx -= 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			solids.get(1).rx += 2;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		zoom *= Math.pow(1.12, e.getWheelRotation());

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		beta += (e.getX() - lastX) / 4.0;
		alpha += (e.getY() - lastY) / 4.0;
		lastX = e.getX();
		lastY = e.getY();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}