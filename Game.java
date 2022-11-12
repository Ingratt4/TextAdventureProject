import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Game{
    public static final String ANSI_RESET = "\u001B[0m";
    Player player = new Player(10, 10, 2, 1, 0, 20, 1, null);
    Mob zombie = new Mob("Zombie",1,10, 0, 5, 1);
    Scanner sc = new Scanner(System.in);
    int choice;
    String menu = "1.Attack\t2.Block\n3.Heal\t\t4.Surrender";

    public void intro() throws InterruptedException{
        while(player.isAlive() && zombie.isAlive()){
            System.out.println(menu);
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    attack(player, zombie);
                    break;
                case 2:
                    block(player,zombie);
                //case3:
                    //heal(player);
                //case4:
                    //surrender();
                 }
    }
    isDefeated(zombie);

    


    
   /*   System.out.println("Welcome to my adventure game!");
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
    System.out.println("Lets defeat this zombie.");*/
    }

   
    








    
    private void attack(Player player, Mob mob) throws InterruptedException{
        if(player.isAlive()){
        int roll = roll();
        int pdamage = player.getDamage() +roll;
        if(pdamage <= 0){
            System.out.println("You rolled a "+roll+" dealt no damage");
            Thread.sleep(1500);
            System.out.println(mob.getName()+" HP:"+mob.getHp()+"/"+mob.getMaxhp());
           

        }
        else{
            System.out.println("You rolled a "+roll+ " dealt "+pdamage+" damage");
            mob.setHp(mob.getHp()-pdamage);
            Thread.sleep(1500);
            System.out.println(mob.getName()+" HP:"+mob.getHp()+"/"+mob.getMaxhp());
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
    private void block(Player player, Mob mob) throws InterruptedException{
        
            
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
    
    private int roll(){
        Random random = new Random();
        int randomNumber = random.nextInt(2 - -2) + -2;
        return randomNumber;

    }


    private int lootRoll(){
        Random randomLoot = new Random();
        int lootNum = randomLoot.nextInt(2- -2) + -2;
        if(lootNum == -2 || lootNum == -1){
            System.out.println("The monster had no loot");
        }
        if(lootNum == 0){
            System.out.println("You find some low tier loot");
        }
        if(lootNum == 1){
            System.out.println("You find medium tier loot");
        }
        if(lootNum == 2){
            System.out.println("You find high tier loot");
        }
        return lootNum;
        
    }
    private void isDefeated(Mob mob){
    System.out.println(mob.getName()+ " has been defeated, you are rewarded "+mob.getExperience()+" experience!");
    player.setCurrentExperience(+5);
    System.out.println("Your current experience is..."+player.getCurrentExperience());

    }






}