package de.hawlandshut.calculus;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hawlandshut.calculus.realfunctions.RealFunction;

import java.awt.Color;
import java.awt.Graphics;

public class Plotter extends JFrame{

  private static final long serialVersionUID = 1L;
  private static final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.ORANGE};
  private static final int width = 1024;
  private static final int height = 768;

  private RealFunction[] functions;
  private double xScale;
  private double yScale;

  private Plotter(double xScale, double yScale, RealFunction[] functions){
    super("Plotter");
    this.xScale = xScale;
    this.yScale = yScale;
    this.setResizable(false);
    this.setSize(width, height);
    this.functions = functions;
    this.add(new PlotPanel());

  }

  public static void plot(double xScale, double yScale, RealFunction... functions){
    Plotter plotter = new Plotter(xScale, yScale, functions);
    plotter.setVisible(true);
  }

  public static void plot(RealFunction... functions){
    Plotter plotter = new Plotter(100d, 100d, functions);
    plotter.setVisible(true);
  }

  private class PlotPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    private int toScreenY(double y){
      return (int) (height/2 - (yScale * y));
    }

    private int toScreenX(double x){
      return (int) (width/2 + (xScale * x));
    }

    private double fromScreenX(int x){
      return ((x-width/2)/xScale);
    }

    private double fromScreenY(int y){
      return ((height/2-y)/yScale);
    }



    @Override
    public void paintComponent(Graphics g){

      g.setColor(Color.BLACK);
      g.drawLine(0,height/2,width,height/2);
      g.drawLine(width/2,0,width/2,height);
      
      double xMin = Math.floor(fromScreenX(0));
      double xMax = Math.ceil(fromScreenX(width));
      for (double x = xMin; x < xMax; x+=1.0){
        g.drawLine(toScreenX(x),height/2-5,toScreenX(x),height/2+5);
      }

      double yMax = Math.ceil(fromScreenY(0));
      double yMin = Math.floor(fromScreenY(height));
      for (double y = yMin; y < yMax; y+=1.0){
        g.drawLine(width/2-5,toScreenY(y),width/2+5,toScreenY(y));
      }


      for (int i = 0; i < Plotter.this.functions.length; i++){
        g.setColor(Plotter.colors[i%Plotter.colors.length]);

        int prevScreenX = 0;
        int prevScreenY = 0;
        boolean prevAvailable = false;

        for (int screenX = 0; screenX < width; screenX++ ){
          double x = fromScreenX(screenX);

          if (!functions[i].inDomain(x))
            continue;

          double y = functions[i].evaluateAt(x);
          int screenY = toScreenY(y);

          if (prevAvailable){
            g.drawLine(prevScreenX, prevScreenY, screenX, screenY);
          }else{
            prevAvailable = true;
          }

          g.drawString(functions[i].toString(), 10, 20*(i+1));

          prevScreenX = screenX;
          prevScreenY = screenY;

        }

      }
      
    }



  }




}
