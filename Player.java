import java.util.ArrayList;
import java.util.List;

public class Player {
    int hp;
    int maxhp;
    int damage;
    int armor;
    int currentExperience;
    int maxExperience;
    int level;
    List<Item> inv;

    Player(int hp, int maxhp, int damage, int armor, int currentExperience, int maxExperience, int level, List<Item> inv) {
        this.hp = hp;
        this.maxhp = maxhp;
        this.damage = damage;
        this.armor = armor;
        this.currentExperience = currentExperience;
        this.maxExperience = maxExperience;
        this.level = level;
        inv = new ArrayList<Item>();
        
    }
    int getHp() {
        return hp;
    }
    void setHp(int hp) {
        this.hp = hp;
    }
    int getMaxhp() {
        return maxhp;
    }
    private void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }
    public int getDamage() {
        return damage;
    }
    private void setDamage(int damage) {
        this.damage = damage;
    }
    int getArmor() {
        return armor;
    }
    private void setArmor(int armor) {
        this.armor = armor;
    }
    int getCurrentExperience() {
        return currentExperience;
    }
    void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }
    private int getMaxExperience() {
        return maxExperience;
    }
    private void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }
    private int getLevel() {
        return level;
    }
    private void setLevel(int level) {
        this.level = level;
    }
    private void levelUp(){
        if(currentExperience >= maxExperience){
            level =+1;
            currentExperience = currentExperience - maxExperience;
            maxExperience +=5;
        }
    }
    boolean isAlive(){
        return hp >0;
    }
    public void inventory(){
        if(inv.size()==0){
            System.out.println("Your inventory is empty.");
        }
        else{
        for(int i = 0; i < inv.size(); i++){
            System.out.println(inv.get(i));

        }
    }
}
    public void addToInventory(Item item){
        inv.add(item);
        System.out.println(item+" Has been added to your inventory");
    }
    public void headPiece(Item item){
        setArmor(+item.getArmorVal());

    }
    public void chestPiece(Item item){
        setArmor(+item.getArmorVal());


    }
    public void weapon(Item item){
        setDamage(item.getDamageVal());

    }
    public void shield(Item item){
        setArmor(+item.getArmorVal());

    }
    public void legPiece(Item item){
        setArmor(+item.getArmorVal());

    }
    public void footPiece(Item item){
        setArmor(+item.getArmorVal());

    }
    public void handPiece(Item item){
        setArmor(+item.getArmorVal());

    }

}


    




