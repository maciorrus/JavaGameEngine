package engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RenderHandler {
	
	private BufferedImage view;
	private int[] pixels;
	private Image face;
	private int x,y;

	public RenderHandler(int width, int height) {
		view = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
		try {
			face = ImageIO.read(RenderHandler.class.getResource("9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		x= width /2;
		y = height /2;
	}

	public void Render(Graphics g) {/*
		for(int i = 0; i<pixels.length; i++)
			pixels[i] = (int) (Math.random() * 0xFFFFFF);
		g.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);*/
		x += System.nanoTime() % 3 -1;
		y += System.nanoTime() % 3 -1;
		g.drawImage(face, x, y, null);
	}

}
