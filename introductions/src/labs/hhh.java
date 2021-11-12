package labs;


public class hhh {

    public static void main(String args[]){
    
           Turtle t = new Turtle();
    
           t.delay(0);
    
           //mickeyFace(t, 200);
    
           fractalMickeyMouse(t, 200, 6);
    
       }
    
       public static void mickeyFace(Turtle t, double r){
    
           t.left(90);
    
           t.penup();
    
           t.forward(r);
    
           t.right(90);
    
           double sides = 1000;
    
           double angle = 180/(sides-2);
    
           t.pendown();
    
           // Mickey's face
    
           double x=Math.sin(angle * Math.PI / 180)*r*2;
    
           for(int i=0; i<sides; i++){
    
               t.forward(x);
    
               t.right(360/sides);}
    
           t.right(90);
    
           t.penup();
    
           t.forward(r/2);
    
           t.left(90);
    
           t.forward(r/4);
    
           t.pendown();
    
           // Mickey's right eye
    
           double y=Math.sin(angle * Math.PI / 180)*r/4*2;
    
           for(int i=0; i<sides; i++){
    
               t.forward(y);
    
               t.right(360/sides);
    
           };
    
           t.left(180);
    
           t.penup();
    
           t.forward(r/2);
    
           t.right(180);
    
           t.pendown();
    
           // Mickey's left eye
    
           double z=Math.sin(angle * Math.PI / 180)*r/4*2;
    
           for(int i=0; i<sides; i++){
    
               t.forward(z);
    
               t.right(360/sides);
    
           };
    
           t.penup();
    
           t.forward(r/4);
    
           t.right(90);
    
           t.forward(r);
    
           t.left(90);
    
           t.pendown();
    
           // m
    
           t.forward(r/4);
    
           t.backward(r/2);
    
           t.forward(r/4);
    
           t.left(90);
    
           t.penup();
    
           t.forward(r/2);
    
           t.right(90);
    
           t.pendown();
    
           // The nose
    
           double w=Math.sin(angle * Math.PI / 180)*r/8*2;
    
           for(int i=0; i<sides; i++){
    
               t.forward(w);
    
               t.right(360/sides);
    
           }
    
       }
    
       public static void fractalMickeyMouse(Turtle t, double r, int level){
    
          // mickeyFace(t, r);
    
           if(level == 0)
    
               mickeyFace(t, r);
    
           else {
    
               // the right ears
    
               mickeyFace(t, r);
    
               t.left(45);
    
               t.penup();
    
               t.forward(r*3/2);
    
               t.right(45);
    
               t.pendown();
    
               // extend
    
               fractalMickeyMouse(t, r/2, level-1);
    
               t.penup();
    
               t.left(45);
    
               t.backward(r*3/2);
    
               t.right(45);
    
               // left ears
    
               t.left(135);
    
               t.penup();
    
               t.forward(r*3/2);
    
               t.right(135);
    
               t.pendown();
    
               // extend
    
               fractalMickeyMouse(t, r/2, level-1);
    
               t.penup();
    
               t.left(135);
    
               t.backward(r*3/2);
    
               t.right(135);
    
           }
    
       }
    
    }