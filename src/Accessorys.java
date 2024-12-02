
class CloakOfDarkness implements Accessory {
    private int atk = 200; // เพิ่มความคล่องตัว 50 ถาวร
    private int def = 50; // เพิ่มการป้องกัน 20 ถาวร
    private int mana = 100;

    @Override
    public void applyEffect(Character character) {
        character.setATK(character.getATK() + atk);
        character.setMana(character.getMana() + mana);
        character.setDEF(character.getDEF() + def);
        System.out.println("Cloak of Darkness สวมใส่: เพิ่ม ATK " + atk + " และ DEF " + def + "เพิ่ม MANA " + mana);
    }

    @Override
    public void removeEffect(Character character) {
        character.setATK(character.getATK() - atk);
        character.setDEF(character.getDEF() - def);
        System.out.println("Cloak of Darkness ถูกถอด: ลด ATK " + atk + " และ DEF " + def + "ลด MANA " + mana);
    }
}

class Artifact implements Accessory {
    private int hp = 200;   // เพิ่ม HP 100 ถาวร
    private int atk = 50;
    private int mana = 100;// เพิ่มพลังโจมตี 100 ถาวร

    @Override
    public void applyEffect(Character character) {
        character.setHP(character.getHP() + hp);
        character.setATK(character.getATK() + atk);
        System.out.println("Artifact สวมใส่: เพิ่ม HP " + hp + " และ ATK " + atk + "เพิ่ม MANA " + mana);
    }

    @Override
    public void removeEffect(Character character) {
        character.setHP(character.getHP() - hp);
        character.setATK(character.getATK() - atk);
        System.out.println("Artifact ถูกถอด: ลด HP " + hp + " และ ATK " + atk + "ลด MANA " + mana);
    }
}
