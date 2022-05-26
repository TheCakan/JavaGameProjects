import java.util.ArrayList;
import java.util.List;

public class Weapon extends Stuff {

    public static List<Weapon> weaponInstances = new ArrayList<>();
    public int baseAttack;
    public int bonus;
    public int type;

    public Weapon(String name, int weight,int baseAttack, int bonus, int type) {
        super(name, weight);
        this.baseAttack = baseAttack;
        this.bonus = bonus;
        weaponInstances.add((this));
        this.type = type;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
