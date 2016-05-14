package org.xxx.web.action;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

public class ServletApi {
	public void getCode() throws IOException{
		BufferedImage img = new BufferedImage(50, 20, BufferedImage.TYPE_INT_BGR);
		
		Graphics g = img.getGraphics();
		
		g.drawString("hehe",8 , 8);
		
		OutputStream out =ServletActionContext.getResponse().getOutputStream();
		ImageIO.write(img, "jpeg", out);
		
	}

}
