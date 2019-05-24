import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Display extends JComponent{
    int scale;
    Map map;
    ArrayList<ArrayList<Creature>> creatures;
    public Display(Map m,ArrayList<ArrayList<Creature>> c){
        map = m;
        scale = 12;
        creatures = c;
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,map.maxX*scale,map.maxY*scale);
        g.setColor(Color.WHITE);
        g.fillRect(scale,scale,(map.maxX-2)*scale,(map.maxY-2)*scale);
        g.setColor(Color.RED);
        for(int x = 0; x < map.array.length; x++){
            for(int y = 0; y < map.array[x].length; y++){
                if(map.array[x][y] == 1){
                    g.fillRect(x*scale,y*scale,scale,scale);
                }
            }
        }
        g.setColor(Color.GREEN);
        g.fillRect(map.goalPos[0]*scale,map.goalPos[1]*scale,scale,scale);
        for(int a = 0; a < creatures.size(); a++){
            g.setColor(creatures.get(a).get(0).color);
            for(int b = 0; b < creatures.get(a).size(); b++){
                g.fillRect(creatures.get(a).get(b).loc[0]*scale,creatures.get(a).get(b).loc[1]*scale,scale,scale);
            }
        }
    }
}