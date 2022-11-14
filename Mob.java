import java.util.Random;

public class Mob  {
    static String name;
    int hp;
    int maxhp;
    int armor;
    int experience;
    int attack;
    public Mob(String name,int hp, int maxhp, int armor, int experience, int attack) {
        this.name = name;
        this.hp = hp;
        this.maxhp = maxhp;
        this.armor = armor;
        this.experience = experience;
        this.attack = attack;
    }
    
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMaxhp() {
        return maxhp;
    }
    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    boolean isAlive(){
        return hp > 0;
    }
 

    public String getName() {
        return name;
    }
    public void loot(Player p, int lootNum) throws InterruptedException{
        if(lootNum == -2 || lootNum == -1){
            System.out.println("The monster had no loot");
        }
        
        if(lootNum == 0){
            System.out.println("You find two coins");
            p.setCoins(+2);
        }
        if(lootNum == 1){
            System.out.println("You find six coins");
            p.setCoins(+6);
            
        }
        if(lootNum == 2){
            System.out.println("You search the lifeless corpse and find...");
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(2000);
            System.out.println("");
         }


    }

    
    

    
}
