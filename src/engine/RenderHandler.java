package engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class RenderHandler {
	
	private BufferedImage view;
	private int[] pixels;

	public RenderHandler(int width, int height) {
		view = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
	}

	public void Render(Graphics g) {
		for(int i = 0; i<pixels.length; i++)
			pixels[i] = (int) (Math.random() * 0xFFFFFF);
		g.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
	}

}
