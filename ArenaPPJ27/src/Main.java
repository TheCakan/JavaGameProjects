public class Main {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("Sword",10,2,1,1);
        //This is the special weapon type. Monsters are weak against this sword!
        Weapon monsterSlayer = new Weapon("Monster Slayer",10,2,1,2);
        Potion potion = new Potion("HP Potion",10,2);
        Monster monster = new Monster(10,2,20,10);
        Avatar avatar = new Avatar("Selim",10,potion,10);
        Warrior warrior = new Warrior("Salazar",10,monsterSlayer,10);
        Arena arena = new Arena(warrior,monster);
        arena.fight();
    }
}
