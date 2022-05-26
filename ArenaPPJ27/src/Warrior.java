public class Warrior extends Avatar{

    public Warrior(String characterName, int health, Object hand, int maxHealth) {
        super(characterName, health, hand, maxHealth);
    }

    @Override
    public int attack() {
        if (this.hand instanceof Weapon) {
            if (this.hand instanceof Weapon && ((Weapon) getHand()).type == 2) {
                int hit = ((Weapon)getHand()).baseAttack+((Weapon)getHand()).bonus+2;
                System.out.println(getCharacterName() + " attacks with Monster Slayer a hit worth: " + hit);
                return ((Weapon) getHand()).baseAttack + ((Weapon) getHand()).bonus + 2;
            } else if (this.hand instanceof Weapon && ((Weapon) getHand()).type == 1) {
                int hit = ((Weapon)getHand()).baseAttack+((Weapon)getHand()).bonus;
                System.out.println(getCharacterName() + " attacks with a Sword hit worth: " + hit);
                return ((Weapon) getHand()).baseAttack + ((Weapon) getHand()).bonus;
            }
        } else if (this.hand instanceof Potion) {
            if (this.getHealth() == this.getMaxHealth()) {
                System.out.println("Health is full can't use a potion!");
                return 0;
            } else
                System.out.println(getCharacterName() + " used a potion healed: "
                        + ((Potion) this.hand).getHealAmount() + "hp");
            setHealth(this.getHealth() + ((Potion) this.hand).getHealAmount());
            return 0;
        } else
            return 0;
        return 0;
    }
}
