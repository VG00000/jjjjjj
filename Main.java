// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
Warrior w = new Warrior("Thanos", 150, 50, 10, 30, 30);
Mage m = new Mage("Harry", 50, 120, 10, 30, 30);
    Rogue r = new Rogue("Geralt", 90, 90, 10, 30, 30);
        w.attack(m);
        m.castSpell(w);
        r.attack(m);
        m.defend();
        w.superAttack(r);
        r.defend();
        m.fireball(w);
        r.sneakAttack(m);
        r.sneakAttack(w);
        w.defend();
        w.levelUp();
        m.levelUp();
        r.levelUp();


    }
    }
class Character{//protected because it doesnt work if private
    protected String name;
    protected int health;
    protected int mana;
    protected int level;
    public Character(String name, int health, int mana, int level){
        this.name=name;
        this.health=health;
        this.mana=mana;
        this.level=level;//main constructor
    }
//general methods
    public void attack(Character target){
        System.out.println(this.name+ " used Attack against " + target.name + ".");
        mana--;
        target.health--;
    }
    public void defend(){
        System.out.println(this.name + " used Defend.");
        mana--;
        health++;
    }
    public void levelUp(){
        System.out.println(this.name + " leveled up!");
        level++;
        mana++;
    }
    public void castSpell(Character target){
        System.out.println(this.name + " used Spell against " + target.name + ".");
        mana--;
        target.health--;
    }
}
class Warrior extends Character{
    private int strength;//constructor + super
    private int armor;
    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.strength=strength;
        this.armor=armor;

    }
    public void superAttack(Character target){//special move + custom level-up
        System.out.println(this.name + " used Super Attack against " + target.name +".");
    mana-=5;
    target.health-=3;
    System.out.println(target.name + " is Stunned!");
    target.level--;
    System.out.println(target.name + " level: "+ target.level);
    }
    public void levelUp() {
        super.levelUp();
        this.strength += 5;
        this.armor += 3;
        System.out.println(this.name + "'s strength increased to " + this.strength + " and armor increased to " + this.armor + "!");
    }
}

class Mage extends Character{
    private int intelligence;
    private int spellPower;
    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence=intelligence;
        this.spellPower=spellPower;
    }
    public void fireball(Character target){
     System.out.println(this.name + " used Fireball against " + target.name +".");
mana-=4;
target.health-=2;
System.out.println(target.name + " is on fire!");
target.health--;
System.out.println(target.name + " health: " + target.health);

        target.health--;
        System.out.println(target.name + " health: " + target.health);

        target.health--;
        System.out.println(target.name + " health: " + target.health);
    }
    public void levelUp() {
        super.levelUp();
        this.intelligence += 5;
        this.spellPower += 5;
        System.out.println(this.name + "'s intelligence increased to " + this.intelligence + " and spell power increased to " + this.spellPower + "!");
    }
}

class Rogue extends Character{
private int agility;
private int dexterity;
    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
    this.agility=agility;
    this.dexterity=dexterity;
    }
    public void sneakAttack(Character target){
        System.out.println(this.name + " used Sneak Attack against "  + target.name + ".");
        mana-=3;
        System.out.println(target.name + " is bleeding!");
        target.health-=1;
        System.out.println(target.name + " health: " + target.health);

        target.health-=1;
        System.out.println(target.name + " health: " + target.health);
        System.out.println(this.name + " stole 1 health from " + target.name + ".");
        this.health++;
        System.out.println(this.name + " health: " + this.health);

    }
    public void levelUp() {
        super.levelUp();
        this.agility += 5;
        this.dexterity += 4;
        System.out.println(this.name + "'s agility increased to " + this.agility + " and dexterity increased to " + this.dexterity + "!");
    }

}
