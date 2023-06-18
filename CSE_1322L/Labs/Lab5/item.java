public abstract class item {
    
    private String title;
    public item(){
        title = "";
    }
    public item(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String toString(){
        return title;
    }
    public abstract String getListing();

}
