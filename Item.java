public class Item {
    int damageVal;
    int buyPrice;
    int sellPrice;
    int healVal;
    int armorVal;


    
    
    public Item(int damageVal, int buyPrice, int sellPrice, int healVal, int armorVal) {
        this.damageVal = damageVal;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.healVal = healVal;
        this.armorVal = armorVal;
    }
    
    public int getDamageVal() {
        return damageVal;
    }
    public void setDamageVal(int damageVal) {
        this.damageVal = damageVal;
    }
    public int getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
    public int getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    public int getHealVal() {
        return healVal;
    }
    public void setHealVal(int healVal) {
        this.healVal = healVal;
    }
    public int getArmorVal() {
        return armorVal;
    }
    public void setArmorVal(int armorVal) {
        this.armorVal = armorVal;
    }
    
}
