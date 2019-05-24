import java.awt.*;
public class Creature{
    String geneticCode;
    int stringLength;
    int[] loc;
    boolean isAlive;
    Color color;
    int geneticIndex;
    public Creature(Color c){
        stringLength = 200;
        geneticCode = randomize(stringLength);
        color = c;
        startRound(new int[2]);
    }
    public void startRound(int[] startPoint){
        loc = new int[]{startPoint[0],startPoint[1]};
        isAlive = true;
        geneticIndex = 0;
    }
    //0 == up,1 == right, 2 == down, 3 == left
    public void move(){
        int temp = Integer.parseInt(geneticCode.substring(geneticIndex%200,geneticIndex%200+1));
        if(temp == 0){
            loc[1] --;
        }
        else if(temp == 1){
            loc[0] ++;
        }
        else if(temp == 2){
            loc[1] ++;
        }
        else{
            loc[0] --;
        }
        geneticIndex++;
    }
    public Creature(String gc, Color c){
        geneticCode = gc;
        color = c;
    }
    private String randomize(int a){
        String temp = "";
        for(int b = 0; b < a; b++){
            temp += (int)(Math.random()*4);
        }
        return temp;
    }
    public Creature clone(){
        return new Creature(geneticCode,color);
    }
}