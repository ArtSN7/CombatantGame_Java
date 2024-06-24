import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {

        Random random = new Random(); // adding random object

        ArrayList<Combatant> combatants = new ArrayList<>(); // Create a list of combatants

        // adding combatants to the list
        combatants.add(new Combatant("Archer", 3, 4, 2, 1, 5, 3, 2));
        combatants.add(new Combatant("Mage", 2, 5, 3, 2, 3, 2, 2));
        combatants.add(new Combatant("Barbarian", 4, 3, 3, 3, 1, 1, 1));
        combatants.add(new Combatant("Giant", 5, 3, 2, 4, 0, 1, 1));


        while (combatants.size() > 1) { // while there is more than 1 combatant

            Combatant attacker = combatants.get(random.nextInt(0, combatants.size())); // select attacker
            Combatant defender = combatants.get(random.nextInt(0, combatants.size())); // select defender

            // picking different players
            while (attacker == defender) {
                defender = combatants.get(random.nextInt(0, combatants.size()));
            }

            // start the fight
            Combat(attacker, defender);

            // Remove any dead combatants
            combatants.removeIf(combatant -> combatant.currHP <= 0);
        }

        // Print out the winner
        if (!combatants.isEmpty()) {
            System.out.println("The one, the only - undispited " + combatants.get(0).name + " wins!");
        }

    }


    // function of battle
    public static void Combat(Combatant attacker, Combatant defender) {

        Random random = new Random();

        int HP; // HP of the defender
        HP = 0;

        System.out.println("\nFight between " + attacker.name + " and " + defender.name + ".");

        // total Power
        int attPower = attacker.strength + attacker.attack + attacker.speed; // attack power ( aka max damage )

        // absolutely terrible attempt to make them equally powerful
        if (attacker.luck == 2 || attacker.luck == 3) {
            attPower *= random.nextInt(1, 3);
        }else if (attacker.luck == 4 || attacker.luck == 5){
            attPower *= random.nextInt(1, 4);
        }else if (attacker.luck == 0 || attacker.luck == 1){
            attPower *= random.nextInt(1, 2);
        }


        int defPower = defender.defence + defender.agility + defender.luck + defender.toughness; // defence power ( aka shield )


        // absolutely terrible attempt to make them equally powerful
        if (defender.luck == 2 || defender.luck == 3) {
            defPower *= random.nextInt(1, 3);
        }else if (defender.luck == 4 || defender.luck == 5){
            defPower *= random.nextInt(1, 4);
        }else if (defender.luck == 0 || defender.luck == 1){
            defPower *= random.nextInt(1, 2);
        }

        // Calculate damage
        int damage = defPower - attPower; // total damage each attack
        if (damage < 0 ) {
            damage *= -1;
        }else if ( damage == 0){
            damage = 1;
        }


        int attackerTotal = random.nextInt(1, 6); // number of shots

        System.out.println("\nNumber of attacks:" + attackerTotal);

        for (int i = 0; i < attackerTotal; i++) {

            System.out.println("\nAttack number " + (i + 1));

            System.out.println(attacker.name + " hits " + defender.name + " for " + damage + " damage.");

            HP = defender.Damage(damage);

            if (HP > 0) {

                System.out.println(defender.name + " successfully defended the attack. " + "HP left: " + HP);

            }else{
                System.out.println(defender.name + " was defeated");
                break;
            }
        }

        System.out.println("\nThe fight is over.");
        if (HP > 0 ){
            System.out.println(defender.name + " successfully defended its life in the fight");

        }

    }

}