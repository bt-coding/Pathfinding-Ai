public class Map{
    int[][] array;
    int[] startPos;
    int[] goalPos;
    int maxX;
    int maxY;
    public Map(int mapNum){
        maxX = 100;
        maxY = 40;
        getMap(mapNum);
        startPos = new int[]{5,20};
    }
    public void getMap(int mn){
        if(mn == 0){
            array = new int[maxX][maxY];
            goalPos = new int[]{18,10};
        }
        else if(mn == 1){
            array = new int[maxX][maxY];
            for(int y = 10; y < 30; y++){
                array[25][y] = 1;
            }
            for(int y = 00; y < 40; y++){
                if(y < 15 || y > 25){
                    array[50][y] = 1;
                }
            }
            for(int a = -1; a < 2; a+=2){
                for(int y = 0; y < 5; y++){
                    array[70+y][20+(y*a)] = 1;
                }
            }
            goalPos = new int[]{95,20};
        }
    }
    public boolean checkCollition(int[] l){
        if(l[0] < 1 || l[1] < 1 || l[0] >= maxX-1 || l[1] >= maxY-1){
            return true;
        }
        else if(array[l[0]][l[1]] == 1){
            return true;
        }
        return false;
    }
}