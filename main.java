import javax.swing.*;
import java.awt.*;
import java.util.*;
public class main{
    public static void main(String[] args){
        ArrayList<ArrayList<Creature>> creatures = new ArrayList<ArrayList<Creature>>();
        int numTestGroups = 7;
        int creaturesPerTestGroup = 150;
        for(int a = 0; a < numTestGroups; a++){
            creatures.add(new ArrayList<Creature>());
            Color color = new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
            for(int b = 0; b < creaturesPerTestGroup; b++){
                creatures.get(a).add(new Creature(color));
            }
        }
        JFrame frame = new JFrame("Map");
        //frame.setUndecorated(true);
        Map map = new Map(3);
        Display screen = new Display(map,creatures);
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550,1050);
        frame.setVisible(true);
        restartCreatures(creatures,map.startPos);
        while(true){
            for(int a = 0; a < 600;a++){
                screen.draw();
                moveCreatures(creatures,map);
                if(checkEnd(creatures, map)){
                    break;
                }
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            creatures = newGen(creatures,map);
            restartCreatures(creatures,map.startPos);
            screen.creatures = creatures;
        }
    }
    public static void restartCreatures(ArrayList<ArrayList<Creature>> cs,int[] sl){
        for(int a = 0; a < cs.size(); a++){
            for(int b = 0; b < cs.get(a).size(); b++){
                cs.get(a).get(b).startRound(sl);
            }
        }
    }
    public static void moveCreatures(ArrayList<ArrayList<Creature>> cs,Map m){
        for(int a = 0; a < cs.size(); a++){
            for(int b = 0; b < cs.get(a).size(); b++){
                if(cs.get(a).get(b).isAlive){
                    //System.out.print("Creature "+a+","+b+" moved from ("+cs.get(a).get(b).loc[0]+","+cs.get(a).get(b).loc[1]+") to ");
                    cs.get(a).get(b).move();
                    //System.out.println("("+cs.get(a).get(b).loc[0]+","+cs.get(a).get(b).loc[1]+")");
                    if(m.checkCollition(cs.get(a).get(b).loc)){
                        cs.get(a).get(b).isAlive = false;
                    }
                }
            }
        }
    }
    public static ArrayList<ArrayList<Creature>> newGen(ArrayList<ArrayList<Creature>> c,Map m){
        double topPercent = 0.2;
        c = sort(c,m);
        ArrayList<ArrayList<Creature>> gen = new ArrayList<ArrayList<Creature>>();
        for(int a = 0; a < c.size(); a++){
            ArrayList<Creature> temp = new ArrayList<Creature>();
            for(int b = 0; b < c.get(a).size(); b++){
                temp.add(new Creature(cross(c.get(a).get((int)(c.get(a).size()*topPercent*Math.random())).geneticCode,c.get(a).get((int)(c.get(a).size()*topPercent*Math.random())).geneticCode),c.get(a).get(b).color));
            }
            gen.add(temp);
        }
        return gen;
    }
    public static String cross(String c1, String c2){
        String temp = "";
        for(int a = 0; a < c1.length(); a++){
            if(Math.random() < 0.008){
                temp += (int)(Math.random()*4);
            }
            else{
                if(Math.random() < 0.5){
                    temp += c1.substring(a,a+1);
                }
                else{
                    temp += c2.substring(a,a+1);
                }
            }
        }
        return temp;
    }
    public static boolean checkEnd(ArrayList<ArrayList<Creature>> cs, Map m){
        for(ArrayList<Creature> a: cs){
            for(Creature c: a){
                if(c.loc[0] == m.goalPos[0] && c.loc[1] == m.goalPos[1]){
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<ArrayList<Creature>> sort(ArrayList<ArrayList<Creature>> c, Map m){
        ArrayList<ArrayList<Creature>> gen = new ArrayList<ArrayList<Creature>>();
        //sorts the creatures based on distance from goal position
        for(int a = 0; a < c.size(); a++){
            gen.add(new ArrayList<Creature>());
            gen.get(a).add(c.get(a).get(0).clone());
            for(int b = 1; b < c.get(a).size(); b++){
                int count = 0;
                boolean contin = true;
                while(count < gen.get(a).size() && contin){
                    if(getDis(c.get(a).get(b).loc,m.goalPos) < getDis(gen.get(a).get(count).loc, m.goalPos)){
                        gen.get(a).add(count,c.get(a).get(b).clone());
                        contin = false;
                    }
                    count++;
                }
                if(contin){
                    gen.get(a).add(c.get(a).get(b).clone());
                }
            }
        }
        return gen;
    }
    public static double getDis(int[] p1,int[] p2){
        return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]));
    }
}