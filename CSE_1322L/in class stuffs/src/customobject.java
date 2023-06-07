import javax.lang.model.type.NullType;

class table{
    private int numLegs;
    private int width;
    private int length;
    private int height;
    private String woodType;
    private boolean rolls;

    public table(){
        numLegs = 4;
        width = 4;
        length = 2;
        height = 3;
        woodType = null;
        rolls = false;
    }
    public table(int legInput, int widthInput, int lengthInput, int heightInput, boolean rollInput){
        this.numLegs = legInput;
        this.width = widthInput;
        this.length=lengthInput;
        this.height=heightInput;
        this.rolls=rollInput;
    }
     int getNumLegs(){
        return(this.numLegs);
    }
     int getWidth(){
        return(this.width);
    }
     int getLength(){
        return(this.length);
    }
     int getHeight(){
        return(this.height);
    }
    String getWoodType(){
        return(woodType);
    }
     boolean getRolling(){
        return(this.rolls);
    }
     void setNumLegs(int newLegAmount){
        this.numLegs = newLegAmount;
    }
     void setWidth(int newWidth){
        this.width = newWidth;
    }
     void setLength(int newLength){
        this.length = newLength;
    }
     void setHeight(int newHeight){
        this.height = newHeight;
    }
     void setRolling(boolean newRollStatus){
        this.rolls = newRollStatus;
    }


}


public class customobject {
    public static void main(String[] args){
        table tbl = new table();
        int length = tbl.getLength();
        System.out.print(tbl.getWoodType());
    }
}
