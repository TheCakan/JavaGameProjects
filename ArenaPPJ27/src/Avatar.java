public class Avatar {
    private String characterName;
    private int health;
    public Object hand = null;
    private int maxHealth;


    public Avatar(String characterName, int health, Object hand, int maxHealth) {
        this.characterName = characterName;
        this.health = health;
        this.maxHealth = maxHealth;
        this.hand = hand;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Object getHand() {
        return hand;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHand(Object hand) {
        this.hand = hand;
    }

    public boolean isAlive() {
        if (health >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int attack() {
        if (this.hand instanceof Weapon) {
            return ((Weapon) getHand()).baseAttack;
        }
        else if (this.hand instanceof Potion){
            if(this.getHealth() == this.getMaxHealth()) {
                return 0;
            } else
                setHealth(this.getHealth() +((Potion) this.hand).getHealAmount());
            return 0;
        }
        else
            return 0;
    }

    public void hurt(int a){
            this.health = this.health - a;
            System.out.println(getCharacterName()+" lost "+ a + " health");
        }

        public String healthBar() {
            String s = "[";
            int total = 10;
            double count = Math.round(((double) health / maxHealth) * total);
            if ((count == 0) && (isAlive())) {
                count = 1;
            }
            for (int i = 0; i < count; i++) {
                s += "#";
            }
            for (int i = 0; i < total - count; i++) {
                s += " ";
            }
            s += "]";
            return s;
        }
    @Override
    public String toString() {
        return characterName+" has " +
                hand +
                " in hand";
    }
    }





