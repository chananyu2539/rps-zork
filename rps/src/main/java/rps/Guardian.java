package rps;

/**
 * Created by chananyu2539 on 1/31/2017 AD.
 */
public class Guardian extends InteractObj{

    private String name;

    private int hp;

    public Guardian(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    public String getName(){
        return this.name;
    }


    @Override
    public String getInfo() {
        return "Guardian, Name: "+this.name+", HP: "+this.hp;
    }

    public boolean isAlive(){
        return this.hp > 0;
    }



}
