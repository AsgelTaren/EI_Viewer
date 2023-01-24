package net.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Component.Identifier;

public class ControllerManager implements Runnable {

	private App app;
	private Thread thread;
	private boolean running = false;

	public ControllerManager(App app) {
		this.app = app;
	}

	@Override
	public void run() {
		List<Controller> gamepads = Arrays.stream(ControllerEnvironment.getDefaultEnvironment().getControllers())
				.filter(controller -> controller.getType().equals(Controller.Type.GAMEPAD))
				.collect(Collectors.toList());
		if (gamepads.size() == 0)
			return;
		Controller gamepad = gamepads.get(0);

		Event event;
		Component component;
		float value;

		while (true) {
			gamepad.poll();

			EventQueue eq = gamepad.getEventQueue();
			event = new Event();

			while (eq.getNextEvent(event)) {
				component = event.getComponent();
				value = event.getValue();
				if (component.getIdentifier() == Identifier.Axis.X) {
					app.x = value;
				}
				if (component.getIdentifier() == Identifier.Axis.Y) {
					app.rx = value;
				}
				if (component.getIdentifier() == Identifier.Axis.RX) {
					app.betaIn = value;
				}
				if (component.getIdentifier() == Identifier.Axis.RY) {
					app.alphaIn = value;
				}
				if (Math.abs(app.x) < 0.3) {
					app.x = 0;
				}
				if (Math.abs(app.rx) < 0.3) {
					app.rx = 0;
				}
				if (Math.abs(app.alphaIn) < 0.3) {
					app.alphaIn = 0;
				}
				if (Math.abs(app.betaIn) < 0.3) {
					app.betaIn = 0;
				}
			}
		}
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

}
