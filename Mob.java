import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mob  {
    static String name;
    int hp;
    int maxhp;
    int armor;
    int experience;
    int attack;
    Item brokenSword = new Item("Broken sword", 1, 5, 3, 0, 0,1);
    Item steelSword = new Item("Steel Sword", 3, 10, 5, 0, 0,2);
    Item ancientClaymore = new Item("Ancient Claymore", 6, 40, 20,  0, 0,3);
    Item rustyPlatebody = new Item("Rusty Platebody", 0,5,3,0,1,1);
    Item lightChainmail = new Item("Light Chainmail",0,10,5,0,2,2);
    Item ancientChestplate = new Item("Ancient Chestplate",0,40,20,0,3,3);
    List<Item> commonItems = new ArrayList<Item>(
        Arrays.asList(brokenSword,rustyPlatebody)
    );
    List<Item> uncommonItems = new ArrayList<Item>(
        Arrays.asList(steelSword,lightChainmail)
    );
    List<Item> rareItems = new ArrayList<Item>(
        Arrays.asList(ancientChestplate,ancientClaymore)
    );
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
            Thread.sleep(2000);
            System.out.println("The monster had no loot");
            

        }
        
        if(lootNum == 0){
            Thread.sleep(2000);
            System.out.println("You find two coins");
            p.setCoins(+2);
            

        }
        if(lootNum == 1){
            Thread.sleep(2000);
            System.out.println("You find six coins");
            p.setCoins(+6);
            

            
        }
        if(lootNum == 2){
            System.out.println("You search the lifeless corpse and find...");
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(2000);
            lootItem(p);
         }


    }
    int lootRoll(){  //rolls function to determine loot
        Random randomLoot = new Random();
        int lootNum = randomLoot.nextInt(2- -2) + -2;
        return lootNum;
        
    }
    private void lootItem(Player p){
        Random randomitem = new Random();
        int randomNumber = randomitem.nextInt(100 - 1) + -1;
        Item item = new Item(name, randomNumber, randomNumber, randomNumber, randomNumber, randomNumber, randomNumber);
        if(randomNumber <=60){
            Collections.shuffle(commonItems);
        item = commonItems.get(0);


        }
        if(randomNumber > 60 && randomNumber < 90 ){
            Collections.shuffle(uncommonItems);
            item = uncommonItems.get(0);
        }
        if(randomNumber >= 90){
            Collections.shuffle(rareItems);
            item = rareItems.get(0);


        }
        System.out.println(item.getName()+"!");
        p.addToInventory(item);

    }

    
    

    
}
