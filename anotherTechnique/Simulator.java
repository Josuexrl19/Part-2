package anotherTechnique;

import com.sun.awt.SecurityWarning;
import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
  private Rectangle myRectangle;

//pruebas:  
    
    int circlex = (int) (Math.random() * 300);
    int circley = (int) (Math.random() *300); 
    int circlex_an =1, circley_an =1;//desplsamiento
    
    int rectanglex = (int) (Math.random() * 150);
    int rectangley = (int) (Math.random() *150) ;
    int rectanglex_an =1, rectangley_an =1;//desplsamiento
    

    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito
        while (true)
        {
 
            
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa y la excepcion hace que valla mas dspacio la figuar
            try{
            Thread.sleep(waitingTime);//
            }
            catch(InterruptedException ex){
            break;
            }
         }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
    
    //prueba1:
    //int x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
    //int y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
//    
//    int radio =10;
//    int anchoApplet1=60 ;
//    int altoApplet1=70;
//      
//    if (x >= (anchoApplet1-radio) || x <= radio) x_an*= -1;
//     if (y >= (altoApplet1-radio)  || y <= radio) y_an*= -1;
    
    //prueba2:   
        if(circlex+circlex_an<0)
            circlex_an= 1;
        else if(circlex+circlex_an>myDisplayer.getWidth()-90)
            circlex_an=-1;
        if(circley+circley_an<0)
            circley_an= 1;
        else if(circley+circley_an>myDisplayer.getWidth()-90)
            circley_an=-1;

        circlex+= circlex_an ;
        circley+= circley_an;

        
        getMyCircle().setRow(circley);
        getMyCircle().setColumn(circlex);

        //x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
        //y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
        
        //getMyRectangle().setRow(y);
        //getMyRectangle().setColumn(x);
        
        if(rectanglex+rectanglex_an<0)
            rectanglex_an= 1;
        else if(rectanglex+rectanglex_an>myDisplayer.getWidth()-90)
            rectanglex_an=-1;
        if(rectangley+rectangley_an<0)
            rectangley_an= 1;
        else if(rectangley+rectangley_an>myDisplayer.getWidth()-90)
            rectangley_an=-1;

        rectanglex+= rectanglex_an ;
        rectangley+= rectangley_an;
        
        getMyRectangle().setRow(rectangley);
        getMyRectangle().setColumn(rectanglex);


    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    

}
