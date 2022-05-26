import java.util.ArrayList;
import java.util.List;

public class Potion extends Stuff {

    private int healAmount;

    public static List<Potion> potionInstances = new ArrayList<>();

    public Potion(String name, int weight,int healAmount) {
        super(name, weight);
        this.healAmount = healAmount;
        potionInstances.add(this);
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
