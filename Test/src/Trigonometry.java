import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


/**
 * @author Daizhenwei
 * @Description	绘制三角函数图
 * @Data 2016-8-29 上午09:10:25
 */
public class Trigonometry extends JFrame{
	private static int x;
	private static int y;
	private final static int tri = (int)Math.tan(Math.PI/2)*100;
	private final static int p = (int)(Math.PI*100);
	public static void main(String[] args) {
		new Trigonometry();
	}
	public Trigonometry(){
		setTitle("Trigonometry");
		setBounds(100, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		super.paintComponents(g);
		this.drawTri(g);
	}
	
	public void drawTri(Graphics g){
		g.setColor(Color.BLACK);
		for(int i=0;i<p;i++){
			y = i;
			x = y*p;
			g.fill3DRect(x+250, y, 1, 1, true);
			System.out.println("X  "+x);
			System.out.println("Y  "+y);
		}
		g.drawLine(0, 200, 500, 200);
		g.drawLine(250, 0, 250, 400);
	}
}
