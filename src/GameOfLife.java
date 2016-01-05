/**
 * Created by koolzz on 12/27/2015.
 */
public class GameOfLife {
    private static int[][] map;

    private static int xLength,yLength;
    public  GameOfLife(int xLength,int yLength){
        this.xLength=xLength;
        this.yLength=yLength;

        map=new int[xLength][yLength];
        for(int y=0;y<yLength;y++){
            for(int x=0;x<xLength;x++) {
                map[x][y]=0;
            }
        }
/*
        map[3][5]=1;
        map[4][5]=1;
        map[5][5]=1;
        map[5][4]=1;
        map[4][3]=1;
*/
        map[25][25]=1;
        map[29][25]=1;
        map[25][24]=1;
        map[29][24]=1;
        map[25][23]=1;
        map[29][23]=1;
        map[25][22]=1;
        map[29][22]=1;
        map[25][21]=1;
        map[29][21]=1;
        map[27][25]=1;
        map[27][21]=1;


    }

    public static void tick(){
        for(int y=0;y<yLength;y++){
            for(int x=0;x<xLength;x++) {
                int n=neighbors(x,y);
                //System.out.print(n+" ");
                if(map[x][y]==0){
                    //System.out.println("x="+x+" y="+y+" = "+n);

                    if(n==3){
                        map[x][y]=3;
                    }
                }
                else if(map[x][y]==1){
                    if(n>3)
                        map[x][y]=2;
                    if(n<2)
                        map[x][y]=2;
                }
            }
            //System.out.print("\n");
        }
        for(int y=0;y<yLength;y++){
            for(int x=0;x<xLength;x++) {
                if(map[x][y]==3)
                    map[x][y]=1;
                else if(map[x][y]==2)
                    map[x][y]=0;

                }
            }
    }

    public static int neighbors(int x,int y){
        int count=0;
        int right=x+1;
        int left=x-1;
        int up=y-1;
        int down=y+1;

        if(right>=xLength)
            right=0;
        if(left<0)
            left=xLength-1;
        if(up<0)
            up=yLength-1;
        if(down>=yLength)
            down=0;

            if(map[right][y]==1||map[right][y]==2)
                count++;
            if(map[x][down]==1||map[x][down]==2)
                count++;
            if(map[left][y]==1||map[left][y]==2)
                count++;
            if(map[x][up]==1||map[x][up]==2)
                count++;

            if(map[right][up]==1||map[right][up]==2)
                count++;
            if(map[right][down]==1||map[right][down]==2)
                count++;
            if(map[left][up]==1||map[left][up]==2)
                count++;
            if(map[left][down]==1||map[left][down]==2)
                count++;

        return count;
    }
    public static void clear(){
        for (int y=0;y<yLength;y++){
            for(int x=0;x<xLength;x++){
                map[x][y]=0;
            }
        }
    }

    public static void randomFill(){
        for (int y=0;y<yLength;y++){
            for(int x=0;x<xLength;x++){
                map[x][y]= (int) Math.round(Math.random());
            }
        }
    }

    public static int[][] getMap(){
        return map;
    }
    public static void setCell(int x,int y){
        if(x<xLength||y<yLength)
            map[x][y]=1;
    }
}
