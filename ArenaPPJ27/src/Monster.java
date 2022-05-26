public class Monster {
    int health;
    int attackPower;
    int attackChance;
    int maxHealth;
    private Avatar avatar;

    public Monster(int health,int attackPower,int attackChance,int maxHealth){
        this.health = health;
        this.attackPower = attackPower;
        this.attackChance = attackChance;
        this.maxHealth = maxHealth;
    }

    public boolean isAlive() {
        if (health >= 0){
            return true;
        }else {
            return false;
        }
    }


    public int attack(){
        if (attackChance > 10){
            return attackPower;
        }else
            return 0;
    }

    public void hurt(int a){
        this.health = this.health-a;
        System.out.println("Monster lost "+ a +" health");
    }

    public String healthBar() {
        StringBuilder s = new StringBuilder("[");
        int total = 10;
        double count = Math.round(((double)health / maxHealth) * total);
        if ((count == 0) && (isAlive())) {
            count = 1;
        }
        for (int i = 0; i < count; i++) {
            s.append("#");
        }
        for (int i = 0; i < total - count; i++) {
            s.append(" ");
        }
        s.append("]");
        return s.toString();
    }


}
