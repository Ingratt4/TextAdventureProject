public class GameMap {
    int n,s,e,w;
    int maxN,maxS,maxE,maxW;


    public GameMap(int n, int s, int e, int w, int maxN, int maxS, int maxE, int maxW) {
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
        this.maxN = maxN;
        this.maxS = maxS;
        this.maxE = maxE;
        this.maxW = maxW;
    }

    public void moveNorth(){
        if(n < maxN){
        n++;
        }
        else{
            System.out.println("You cannot move any more north");
        }
    }

    public void moveEast(){
        if(e < maxE){
            e++;
            }
            else{
                System.out.println("You cannot move any more east");
            }
    }

    public void moveSouth(){
        if(s < maxS){
            s++;
            }
            else{
                System.out.println("You cannot move any more south");
            }
    }

    public void moveWest(){
        if(w < maxW){
            w++;
            }
            else{
                System.out.println("You cannot move any more west");
            }
    }




    public int getN() {
        return n;
    }




    public void setN(int n) {
        this.n = n;
    }




    public int getS() {
        return s;
    }




    public void setS(int s) {
        this.s = s;
    }




    public int getE() {
        return e;
    }




    public void setE(int e) {
        this.e = e;
    }




    public int getW() {
        return w;
    }




    public void setW(int w) {
        this.w = w;
    }

    



    
   
    
}
