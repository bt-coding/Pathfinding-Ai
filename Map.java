public class Map{
    int[][] array;
    int[] startPos;
    int[] goalPos;
    int maxX;
    int maxY;
    public Map(int mapNum){
        maxX = 100;
        maxY = 40;
        startPos = new int[]{10,10};
        getMap(mapNum);
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
                for(int y = 0; y < 10; y++){
                    array[70+y][20+(y*a)] = 1;
                }
            }
            goalPos = new int[]{95,20};
        }
        else if(mn == 2){
            maxX = 120;
            maxY = 120;
            array = new int[maxX][maxY];
            startPos = new int[]{10,10};
            goalPos = new int[]{110,110};
            for(int a = 0; a < 30; a++){
                array[15+a][15] = 1;
                array[15][15+a] = 1;
            }
            for(int a = 9; a < 40; a++){
                array[55][a] = 1;
                array[a][55] = 1;
            }
            for(int a  = 0; a < 30; a++){
                array[55+a][55] = 1;
                array[55][55+a] = 1;
            }
            for(int a = 0; a < 15; a++){
                array[65][95+a] = 1;
                array[65+a][95] = 1;
                array[95][65+a] = 1;
                array[95+a][65] = 1;
            }
            for(int a = 0; a < 25; a++){
                array[65+a][15] = 1;
                array[15][65+a] = 1;
            }
            for(int a = 0; a < 25; a++){
                array[80+a][40-a] = 1;
                array[15+a][105-a] = 1;
                array[85+a][75+a] = 1;
                array[75+a][85+a] = 1;
            }
        }
        else if(mn  == 3){
            maxX =  100;
            maxY = 50;
            array = new int[maxX][maxY];
            startPos = new int[]{5,25};
            goalPos = new int[]{95,25};
            for(int y = 0; y < 30; y++){
                array[12][y] = 1;
            }
            for(int y = 40; y < 50; y++){
                array[12][y] = 1;
            }
            for(int y = 35; y < 50; y++){
                array[25][y] = 1;
            }
            for(int x = 25; x < 36; x++){
                array[x][25] = 1;
                array[x][15] = 1;
            }
            for(int y = 0; y < 16; y++){
                array[36][y] = 1;
            }
            for(int y = 25; y < 50; y++){
                array[36][y] = 1;
            }
            for(int y = 15; y < 35; y ++){
                array[50][y] = 1;
                array[59][y] = 1;
            }
            for(int y = 0; y < 5; y++){
                array[50][y] = 1;
                array[59][y] = 1;
                array[50][y+45] = 1;
                array[59][y+45] = 1;
                array[70][y+45] = 1;
                array[80][y+45] = 1;
            }
            for(int x = 51; x < 60; x++){
                array[x][4] = 1;
                array[x][15] = 1;
                array[x][34] = 1;
                array[x][45] = 1;
                array[x+20][34] = 1;
                array[x+20][45] = 1;
            }
            for(int y = 0; y < 35; y++){
                array[70][y] = 1;
                array[80][y] = 1;
            }
            for(int y = 0; y < 20; y++){
                array[90][y] = 1;
                array[90][30+y] = 1;
            }
            for(int x = 91; x < 100; x++){
                array[x][19] = 1;
                array[x][30] = 1;
            }
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