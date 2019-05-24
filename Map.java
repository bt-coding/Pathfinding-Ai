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