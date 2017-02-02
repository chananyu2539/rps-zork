package rps;

/**
 * Created by chananyu2539 on 1/31/2017 AD.
 */
public class Potion extends Item{
    private int healAmounth = 0;

    private String name = "";

    private String silencable = "None";

    public Potion(){
        this.healAmounth = 10;
        this.name = "healing potion";
    }

    public Potion(String s){
        this.name = "debuff potion";
        this.silencable = s;
    }

    @Override
    public String getInfo() {
        return this.name+", can heal: "+this.healAmounth+", can silence: "+silencable;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
