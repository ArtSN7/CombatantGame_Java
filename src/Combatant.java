public class Combatant {

    String name;
    int strength, attack, defence, toughness, agility, speed, luck;
    int maxHP = 30;
    int currHP = maxHP;

    public Combatant(String _name, int str, int att, int def, int tough, int lck, int agil, int speed) {
        this.name = _name;
        this.strength = str;
        this.attack = att;
        this.defence = def;
        this.toughness = tough;
        this.luck = lck;
        this.agility = agil;
        this.speed = speed;
    }

    public int Damage(int dam) {
        currHP = currHP - dam;
        return currHP;
    }
}

