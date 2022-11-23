import java.io.*;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.Position;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







//







public class Game{
    //Swing objects... fonts.
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel,  choiceButtonPanel, playerPanel, mobPanel;
    JTextArea mainTextArea, combatTextArea;
    JButton startButton, choice1, choice2, choice3, choice4;
    JLabel titleNameLabel, hpLabel, hpLabelCur, coinLabel, coinLabelValue, mobHpLabel, mobHpLabelCur;
    Timer t;
    Container con;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 100);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    String position, style;
    





















    //objects for terminal version
    public static final String ANSI_RESET = "\u001B[0m";
    Player player = new Player(10, 10, 2, 1, 0, 20, 1, null,0);
    Mob introZombie = new Mob("Zombie",8,8, 0, 5, 1);
    Scanner sc = new Scanner(System.in);
    int choice;
    int roll = 0;
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
    GameMap forest = new GameMap(0, 0, 0, 0, 10, 10, 10, 10);
    GameMap cellar = new GameMap(0, 0, 0, 0, 0, 0, 15, 15);
    List<GameMap> maps = new ArrayList<GameMap>(
        Arrays.asList(forest, cellar)
    );
























    public Game(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();
        //creates jframe window and resoultion for the display
        //adds the jframe to a container... this may get reimplemented.

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Broken Game");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        //Game title on launch

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);
        //Panel for start button

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler);


    
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        window.setVisible(true);

        


    }
//The implementation of the display, call to create screen with default layout. 
public void createGameScreen() {
    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);
    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100,100,600,250);
    mainTextPanel.setBackground(Color.black);
    con.add(mainTextPanel);

    mainTextArea = new JTextArea("This is where the text goes... This is a long sentence");
    mainTextArea.setBounds(100,100,600,250);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(normalFont);
    mainTextArea.setLineWrap(true);
    mainTextPanel.add(mainTextArea);

    combatTextArea = new JTextArea();
    combatTextArea.setBounds(400,100,600,250);
    combatTextArea.setBackground(Color.blue);
    combatTextArea.setForeground(Color.white);
    combatTextArea.setFont(normalFont);
    combatTextArea.setLineWrap(true);
    mainTextPanel.add(combatTextArea);

    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(250,350,300,150);
    choiceButtonPanel.setBackground(Color.black);
    choiceButtonPanel.setLayout(new GridLayout(4,1));
    con.add(choiceButtonPanel);

    choice1 = new JButton("Option1");
    choice1.setBackground(Color.black);
    choice1.setForeground(Color.white);
    choice1.setFont(normalFont);
    choice1.setFocusPainted(false);
    choice1.addActionListener(choiceHandler);
    choice1.setActionCommand("c1");
    choiceButtonPanel.add(choice1);
    
    choice2 = new JButton("Option2");
    choice2.setBackground(Color.black);
    choice2.setForeground(Color.white);
    choice2.setFont(normalFont);
    choice2.setFocusPainted(false);
    choice2.addActionListener(choiceHandler);
    choice2.setActionCommand("c2");
    choiceButtonPanel.add(choice2);

    choice3 = new JButton("Option3");
    choice3.setBackground(Color.black);
    choice3.setForeground(Color.white);
    choice3.setFont(normalFont);
    choice3.setFocusPainted(false);
    choice3.addActionListener(choiceHandler);
    choice3.setActionCommand("c3");
    choiceButtonPanel.add(choice3);

    choice4 = new JButton("Option4");
    choice4.setBackground(Color.black);
    choice4.setForeground(Color.white);
    choice4.setFont(normalFont);
    choice4.setFocusPainted(false);
    choice4.addActionListener(choiceHandler);
    choice4.setActionCommand("c4");
    choiceButtonPanel.add(choice4);

    playerPanel = new JPanel();
    playerPanel.setBounds(100,15,600,50);
    playerPanel.setBackground(Color.blue);
    playerPanel.setVisible(true);
    playerPanel.setLayout(new GridLayout(1,4));
    con.add(playerPanel);

    hpLabel = new JLabel("HP:");
    hpLabel.setFont(normalFont);
    hpLabel.setForeground(Color.white);
    playerPanel.add(hpLabel);

    hpLabelCur = new JLabel();
    hpLabelCur.setText(Integer.toString(player.getHp()) + "/" +Integer.toString(player.getMaxhp()));
    hpLabelCur.setFont(normalFont);
    hpLabelCur.setForeground(Color.white);
    playerPanel.add(hpLabelCur);

    coinLabel = new JLabel("Coins:");
    coinLabel.setFont(normalFont);
    coinLabel.setForeground(Color.white);
    playerPanel.add(coinLabel);

    coinLabelValue = new JLabel();
    coinLabelValue.setText(Integer.toString(player.getCoins()));
    coinLabelValue.setFont(normalFont);
    coinLabelValue.setForeground(Color.white);

    playerPanel.add(coinLabelValue);
     introScreen();
}

public class TitleScreenHandler implements ActionListener{

    public void actionPerformed(ActionEvent event){
     

        createGameScreen();
        
    }
}


public class ChoiceHandler implements ActionListener{ 

    public void actionPerformed(ActionEvent event){

        String choice = event.getActionCommand();

       switch(position){
            case "zombieFight":
            switch(choice){

                case"c1": try {
                        attack(player, introZombie);
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case"c2": try {
                        block(player,introZombie);
                    
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                    break;
             }

            case "introScreen":
             switch(choice){

             case "c1":
                zombieFight();
                break;

        }
       
    }
}
}
ActionListener taskPerformed = new ActionListener(){
    public void actionPerformed(ActionEvent event){

        combatTextArea.setText("Hello this is a test");


    }
};

private void attack(Player player, Mob mob) throws InterruptedException{  //attack function

    Timer timer = new Timer(1000, taskPerformed);
    
    if(player.isAlive()){
    int roll = roll();
    int pdamage = player.getDamage() +roll;
    if(pdamage <= 0){
        combatTextArea.setText("You rolled a "+roll+" and dealt no damage");
       

    }
    else{
        combatTextArea.setText("You rolled a "+roll+ " and dealt "+pdamage+" damage");
        mob.setHp(mob.getHp()-pdamage);
        
    }
    timer.start();
    
   
    
    }
    if(mob.isAlive())
    {
    int mroll = roll();
    int mdamage = mob.getAttack() + mroll;

     if(mdamage <= 0){
       combatTextArea.setText(mob.getName() +" rolls a "+mroll+" and dealt no damage");
    }
    else{
        combatTextArea.setText(mob.getName() +" rolls a "+mroll+" and dealt "+mdamage+" damage");
        player.setHp(player.getHp()-mdamage);
    }
}




}
private void block(Player player, Mob mob) throws InterruptedException{ //block function
    int pblock = player.getArmor();
    combatTextArea.setText("Player is blocking "+pblock+" damage");
   
    if(mob.isAlive()){
    int mroll = roll();
    int mdamage = mob.getAttack() + mroll -pblock;

    if(mdamage <= 0){
        System.out.println(mob.getName() +" rolls a "+mroll+" and dealt no damage");
        System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());
    }

    else{
        System.out.println(mob.getName() +" rolls a "+mroll+" and dealt "+mdamage+" damage");
        player.setHp(player.getHp()-mdamage);
        System.out.println("Player HP:"+player.getHp()+"/"+player.getMaxhp());
    }
}
}


public void zombieFight(){
    position = "zombieFight";
    mainTextArea.setText("Zombie HP:" + Integer.toString(introZombie.getHp()));
    hpLabelCur.setText(Integer.toString(player.getHp()) + "/" +Integer.toString(player.getMaxhp()));
    choice1.setText("Attack");
    choice2.setText("Block");
    choice2.setVisible(true);
    choice3.setText("");
    choice4.setText("");


}
public void introScreen(){

    position = "introScreen";
    mainTextArea.setText("A zombie approaches... and he doesn't seem very friendly..");
   
    choice1.setText("Fight the zombie");
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);































































































































//Terminal version of the game*************************************************************************************************************************************
//Contains most of the games logic*************************************************************************************************************************************
}
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




    public void mainMenu(Player p){ 
        String menu = "1.View map\t2.View Inventory\t3.";
        
        while(true){
            choice=sc.nextInt();
            switch (choice) {
                
                case 1:
                    
                case 2:
                p.inventory();
                    
                //case3:
                    
                //case4:
                    
                 }
    }
    
    
    }




}

