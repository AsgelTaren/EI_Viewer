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
				if (component.getIdentifier() == Identifier.Axis.X && component.getDeadZone() < Math.abs(value)) {
					app.solids.get(2).ry = 150 * value;
				}
				if (component.getIdentifier() == Identifier.Axis.RX && component.getDeadZone() < Math.abs(value)) {
					app.solids.get(1).rx = 150 * value;
				}
				if (component.getIdentifier() == Identifier.Axis.Z && component.getDeadZone() < Math.abs(value)) {
					app.solids.get(2).ry = 150 * value;
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
