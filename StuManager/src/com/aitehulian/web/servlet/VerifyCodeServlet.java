package com.aitehulian.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aitehulian.common.Constants;
/**
 * 验证码生成器
 * @author qysy
 *
 */
public class VerifyCodeServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width=120;//验证码宽
	private int height=40;//验证码高
	private int codeCount=4;//验证码个数
	private int lineCount=10;//干扰线的条数
	private int x=0;
	private int fontHeight;//字体高度
	private int codeY;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'i', 'J',
			'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
	/**
	 * 初始化验证码图片属性
	 */
	public void init() throws ServletException {
		//从web.xml中获取初始信息
		String strWidth=this.getInitParameter("width");
		String strHeight=this.getInitParameter("height");
		String strCodeCount=this.getInitParameter("codeCount");
		String strLineCount=this.getInitParameter("lineCount");
		//将信息转换成数值
		try{
			if(strWidth!=null&&strWidth.length()>0){
				width=Integer.parseInt(strWidth);
			}
			if(strHeight!=null&&strHeight.length()>0){
				height=Integer.parseInt(strHeight);
			}
			if(strCodeCount!=null&&strCodeCount.length()>0){
				codeCount=Integer.parseInt(strCodeCount);
			}
			if(strLineCount!=null&&strLineCount.length()>0){
				lineCount=Integer.parseInt(strLineCount);
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		x=width/(codeCount+1);
		fontHeight=height-2;
		codeY=height-4;
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//定义图像buffer
		BufferedImage buffImg=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g=buffImg.createGraphics();
		//创建一个随机数生成器
		Random rand=new Random();
		//将图像填充成白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//创建字体（字体大小根据图片的高度来定）
		Font font=new Font("Fixedsys",Font.PLAIN,fontHeight);
		//设置字体
		g.setFont(font);
		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		//随机产生N条干扰线。
		g.setColor(Color.BLACK);
		for (int i = 0; i < lineCount; i++) {
			int x=rand.nextInt(width);
			int y=rand.nextInt(height);
			int x1=rand.nextInt(20);
			int y1=rand.nextInt(20);
			g.drawLine(x, y, x+x1, y+y1);
		}
		//randomCode保存随机产生的验证码。
		StringBuffer randomCode=new StringBuffer();
		int red=0,green=0,blue=0;
		//随机产生验证码
		for (int i = 0; i < codeCount; i++) {
			String strRand=String.valueOf(codeSequence[rand.nextInt(32)]);
			//产生随机的颜色分量
			red=rand.nextInt(255);
			green=rand.nextInt(255);
			blue=rand.nextInt(255);
			//绘制到图像中
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i+1)*x, codeY);
			//四个随机数组合在一起用于校验
			randomCode.append(strRand);
		}
		HttpSession session=req.getSession();
		session.setAttribute(Constants.CODE_VALIDATE_KEY, randomCode.toString());
		//禁止图像缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		//设置响应文件类型
		resp.setContentType("image/jpeg");
		//将图片输出到Servlet输出流中。
		ServletOutputStream sos=resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg",sos);
		sos.close();
		
	}
}
