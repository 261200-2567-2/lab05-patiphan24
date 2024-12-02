interface Character {
    String getName();
    int getHP();
    void setHP(int hp);
    int getMana();
    void setMana(int mana);
    int getATK();
    void setATK(int atk);
    int getDEF();
    void setDEF(int def);
    int getLevel();

    void attack(Monster monster);
    void levelUp();
    void equipAccessory(Accessory accessory);
    void unequipAccessory(Accessory accessory);
    void takeDamage(int damage);
}