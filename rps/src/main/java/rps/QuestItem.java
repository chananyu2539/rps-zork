package rps;

/**
 * Created by chananyu2539 on 1/31/2017 AD.
 */
public class QuestItem extends Item {
    private int key;

    public QuestItem(int k){
        this.key = k;
    }

    @Override
    public String getInfo() {
        return "key: "+this.key;
    }

    @Override
    public String getName() {
        return "key"+this.key;
    }
}
