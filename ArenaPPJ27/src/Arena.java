public class Arena {
        private Avatar avatar1;
        private Monster monster1;

        public Arena(Avatar avatar1, Monster monster1){
            this.avatar1 = avatar1;
            this.monster1 = monster1;
        }


    private void render(){
            System.out.println("-------------- Arena -------------- \n");
            System.out.println(avatar1.getCharacterName()+" health:");
            System.out.println(" " + avatar1.healthBar());
            System.out.println(" " +avatar1 + "\n");
            System.out.println("Monster's health:");
            System.out.println(" " + monster1.healthBar() + "\n");
        }

        public void fight() {
            System.out.println("Welcome to the Arena!");
            while (avatar1.isAlive() && monster1.isAlive()){
            render();
            monster1.hurt(avatar1.attack());
            avatar1.hurt(monster1.attack());
            if (avatar1.isAlive() && !monster1.isAlive()){
                System.out.println("\n"+avatar1.getCharacterName()+" Wins the battle");
            }else if (monster1.isAlive() && !avatar1.isAlive())
                System.out.println("\n"+monster1+" Wins the battle");

            }
        }


}
