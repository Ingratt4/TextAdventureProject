import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Game{
    public static final String ANSI_RESET = "\u001B[0m";

    //Misc objects



    Player player = new Player(10, 10, 2, 1, 0, 20, 1, null,0);
    Mob introZombie = new Mob("Zombie",8,8, 0, 5, 1);
    Scanner sc = new Scanner(System.in);
    int choice;
    int roll = 0;
   
    //All items
    //public Item(String name, int damageVal, int buyPrice, int sellPrice, int healVal, int armorVal) {

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
     /*
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */

public void intro() throws InterruptedException{
 /*  System.out.println("Welcome to my adventure game!");
    Thread.sleep(1500);
    System.out.println("This will be a quick tutorial to explain how the game works");
    Thread.sleep(2000);
    System.out.println("Lets get started with some combat...");
    Thread.sleep(2000);
    System.out.println("\u001B[34m" +"A zombie appears..."+ ANSI_RESET);
    Thread.sleep(2000);
    System.out.println("When in combat you are given a few options");
    Thread.sleep(2000);
    System.out.println("1.Attack\t2.Block\n3.Heal\t\t4.Surrender");
    Thread.sleep(2000);
    System.out.println("Attacking will use your characters attack value and a dice roll to deal damage to an enemy.");
    Thread.sleep(4000);
    System.out.println("The dice can roll any number between -2 and +2, this number will be added to your characters base damage.");
    Thread.sleep(4000);
    System.out.println("So for example, if your base damage is 2 and your rolled a -1, your damage for that turn will be 1.");
    Thread.sleep(4000);
    System.out.println("Your characters starting base damage will always be 1.");
    Thread.sleep(4000);
    System.out.println("You may also chose to block on your turn, doing this will block damage equal to your characters armor.");
    Thread.sleep(4000);
    System.out.println("Your character starts off with 1 armor");
    Thread.sleep(4000);
    System.out.println("You may also chose to heal on your turn, however this will require consumable items.");
    Thread.sleep(4000);
    System.out.println("Your final option is to surrender, if you chose to surrender you will exit the scenario and your current experience will be set to 0.");
    Thread.sleep(4000);
    System.out.println("Lets defeat this zombie.");
    Thread.sleep(2000);*/
    combat(player, introZombie); 
}

public void mainMenu(Player p){ 
    String menu = "1.View map\t2.View Inventory\t3."
    while(){
        choice=sc.nextInt();
        switch (choice) {
            
            case 1:
                
            case 2:
                
            //case3:
                
            //case4:
                
             }
}


}
        
private void attack(Player player, Mob mob) throws InterruptedException{  //attack function
        if(player.isAlive()){
        int roll = roll();
        int pdamage = player.getDamage() +roll;
        if(pdamage <= 0){
            System.out.println("You rolled a "+roll+" dealt no damage");
           

        }
        else{
            System.out.println("You rolled a "+roll+ " dealt "+pdamage+" damage");
            mob.setHp(mob.getHp()-pdamage);
        }

        Thread.sleep(1500);
        System.out.println("=====================================");

        
    }
        if(mob.isAlive()){
        int mroll = roll();
        int mdamage = mob.getAttack() + mroll;
        if(mdamage <= 0){
            System.out.println(mob.getName() +" rolls a "+mroll+" and dealt no damage");
            Thread.sleep(1500);
            System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());

        }
        else{
            System.out.println(mob.getName() +" rolls a "+mroll+" and dealt "+mdamage+" damage");
            Thread.sleep(1500);
            player.setHp(player.getHp()-mdamage);
            System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());
        }
    }
    Thread.sleep(1500);
    System.out.println("=====================================");

 }

private void block(Player player, Mob mob) throws InterruptedException{ //block function
            int pblock = player.getArmor();
            System.out.println("Player is blocking "+pblock+" damage");
           
            if(mob.isAlive()){
            int mroll = roll();
            int mdamage = mob.getAttack() + mroll -pblock;

            if(mdamage <= 0){
                System.out.println(mob.getName() +" rolls a "+mroll+" and dealt no damage");
                Thread.sleep(1500);
                System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());
            }

            else{
                System.out.println(mob.getName() +" rolls a "+mroll+" and dealt "+mdamage+" damage");
                Thread.sleep(1500);
                player.setHp(player.getHp()-mdamage);
                System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());
            }
        }
     Thread.sleep(1500);
     System.out.println("=====================================");

    }
    
private int roll(){ //roll function for combat
        Random random = new Random();
        int randomNumber = random.nextInt(2 - -2) + -2;
        return randomNumber;

    }



private void isDefeated(Mob mob) throws InterruptedException{ //rewards experience after mob death

         System.out.println(mob.getName()+ " has been defeated, you are rewarded "+mob.getExperience()+" experience!");
         player.setCurrentExperience(+5);
         Thread.sleep(2000);
         System.out.println("Your current experience is..."+player.getCurrentExperience());
    }

private void combat(Player player, Mob mob) throws InterruptedException{
    String menu = "1.Attack\t2.Block\n3.Heal\t\t4.Surrender\n"+mob.getName()+" HP:"+mob.getHp()+"/"+mob.getMaxhp();

    while(player.isAlive() && mob.isAlive()){
        System.out.println(menu);
        choice=sc.nextInt();
        switch (choice) {
            
            case 1:
                attack(player, mob);
                break;
            case 2:
                block(player,mob);
            //case3:
                //heal(player);
            //case4:
                //surrender();
             }
}
isDefeated(mob);
mob.loot(player, mob.lootRoll());



}







}