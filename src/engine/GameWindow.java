package engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2455318675797450448L;
	private Canvas canvas = new Canvas();
	private RenderHandler renderer;

	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		add(canvas);
		setVisible(true);
		canvas.createBufferStrategy(3);
		renderer = new RenderHandler(getWidth(), getHeight());
	}

	public void update() {
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		super.paint(g);
		renderer.Render(g);
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {/*
						 * BufferStrategy bs = canvas.getBufferStrategy(); int i = 0; int x = 0;
		long lastTime = System.nanoTime();
		double nanoSecConversion = 1000000000 / 60;
		double changeInSec = 0;

						 */
		while (true) {/*
			long now = System.nanoTime();
			while (changeInSec < 10000) {
				changeInSec += (now - lastTime) / nanoSecConversion;
				now = System.nanoTime();
				update();
			}
			changeInSec = 0;*/
			System.out.println(System.currentTimeMillis());
			render();/*
			lastTime = now;*/
		}

	}

	public static void main(String[] args) {
		GameWindow gameWindow = new GameWindow();
		Thread gameThread = new Thread(gameWindow);
		gameThread.start();
	}

}
