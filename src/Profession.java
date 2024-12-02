class ShadowMonarchCharacter implements Character {
    private String name = "จักรพรรดิเงา";
    private int hp = 1000;
    private int mana = 200;
    private int atk = 250;
    private int def = 150;
    private int level = 1;
    private Accessory equippedAccessory;// เพิ่มตัวแปรเพื่อเก็บเลเวล

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0; // ป้องกันไม่ให้ HP น้อยกว่า 0
        }
        System.out.println("ได้รับความเสียหาย " + damage + " เหลือ HP: " + this.hp);
    }

    // Getter and Setter methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void setHP(int hp) {
        this.hp = Math.max(hp, 0); // ป้องกันไม่ให้ HP ติดลบ
    }

    @Override
    public int getATK() {
        return atk;
    }

    @Override
    public void setATK(int atk) {
        this.atk = atk;
    }

    @Override
    public int getDEF() {
        return def;
    }

    @Override
    public void setDEF(int def) {
        this.def = def;
    }

    @Override
    public int getLevel() {
        return level;  // คืนค่าของ level
    }

    // การเลื่อนระดับของ Shadow Monarch
    @Override
    public void levelUp() {
        level++;  // เพิ่มเลเวลทุกครั้งที่เลื่อนระดับ

        // เพิ่มค่าต่างๆ เมื่อเลเวลอัป
        this.hp += 200;  // เพิ่ม HP
        this.atk += 50;  // เพิ่ม ATK
        this.def += 30;  // เพิ่ม DEF// เพิ่ม AGI

        // แสดงข้อความเมื่อเลเวลอัป พร้อมข้อมูลเลเวลใหม่
        System.out.println(name + " เลเวลอัพ " + "1" + "!\n");
        System.out.println("=== สเตตัสตัวละคร ===");
        System.out.println("-------------------");
        System.out.println("Level : " + level);
        System.out.println("HP    : " + hp);
        System.out.println("Mana  : " + mana);
        System.out.println("ATK   : " + atk);
        System.out.println("DEF   : " + def);
        System.out.println("=================================");

    }

    @Override
    public void attack(Monster monster) {
        int baseDamage = this.atk - monster.getDEF();
        if (baseDamage < 0) {
            baseDamage = 0;
        }
        int randomVariance = (int) (Math.random() * 20) - 10;
        baseDamage += randomVariance;

        if (baseDamage < 0) {
            baseDamage = 0;
        }

        monster.takeDamage(baseDamage);

        System.out.println(name + " โจมตี " + monster.getName() + " สร้างความเสียหาย " + baseDamage + " ดาเมจ!");
        System.out.println(monster.getName() + " ตอนนี้มี HP เหลืออยู๋ " + monster.getHP());
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory);
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this);
    }

    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory != null && equippedAccessory == accessory) {
            equippedAccessory.removeEffect(this);
            equippedAccessory = null;
        }
    }

    public void summonShadows() {
        if (mana >= 100) {
            this.hp += 100 + (50 * level);
            this.atk += 30 + (10 * level);
            this.def += 20 + (5 * level);
            this.mana -= 100;

            System.out.println("จงตื่น! เพิ่มพลังเงา: HP=" + hp + ", ATK=" + atk + ", DEF=" + def);
        } else {
            System.out.println("Mana ไม่เพียงพอ!");
        }
    }

    public void shadowEnhance(Monster monster) {
        if (mana >= 100) {
            this.mana -= 100;
            int enhancedDamage = this.atk * 2 + (level * 10);
            monster.takeDamage(enhancedDamage);

            System.out.println("ดาบเงาผ่า! " + monster.getName() + " ได้รับความเสียหาย " + enhancedDamage + "!");
        } else {
            System.out.println("Mana ไม่เพียงพอ!");
        }
    }
}

class AssassinCharacter implements Character {
    private String name = "นักฆ่าปีศาจ";
    private int hp = 700;
    private int mana = 200;
    private int atk = 350;
    private int def = 50;
    private int level = 1;
    private Accessory equippedAccessory;

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0; // ป้องกันไม่ให้ HP น้อยกว่า 0
        }
        System.out.println("ได้รับความเสียหาย " + damage + " เหลือ HP: " + this.hp);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHP(int hp) {
        this.hp = Math.max(hp, 0); // ป้องกันไม่ให้ HP ติดลบ
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getATK() {
        return atk;
    }

    @Override
    public void setATK(int atk) {
        this.atk = atk;
    }

    @Override
    public int getDEF() {
        return def;
    }

    @Override
    public void setDEF(int def) {
        this.def = def;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void attack(Monster monster) {
        int baseDamage = this.atk + (this.def / 2) - monster.getDEF();
        if (baseDamage < 0) {
            baseDamage = 0;
        }

        monster.takeDamage(baseDamage);

        System.out.println(name + " โจมตี " + monster.getName() + " ได้รับดาเมจ " + baseDamage + " ดาเมจ!");
        System.out.println(monster.getName() + " ตอนนี้มี HP เหลืออยู่ " + monster.getHP());
    }

    @Override
    public void levelUp() {
        level++;  // เพิ่มเลเวลทุกครั้งที่เลื่อนระดับ

        // เพิ่มค่าต่างๆ เมื่อเลเวลอัป
        this.hp += 200;  // เพิ่ม HP
        this.atk += 50;  // เพิ่ม ATK
        this.def += 30;  // เพิ่ม DEF// เพิ่ม AGI

        // แสดงข้อความเมื่อเลเวลอัป พร้อมข้อมูลเลเวลใหม่
        System.out.println(name + " เลเวลอัพ " + "1" + "!\n");
        System.out.println("=== สเตตัสตัวละคร ===");
        System.out.println("-------------------");
        System.out.println("Level : " + level);
        System.out.println("HP    : " + hp);
        System.out.println("Mana  : " + mana);
        System.out.println("ATK   : " + atk);
        System.out.println("DEF   : " + def);
        System.out.println("=================================");
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory);
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this);
    }

    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory != null && equippedAccessory == accessory) {
            equippedAccessory.removeEffect(this);
            equippedAccessory = null;
        }
    }

    public void stealth() {
        int evadeChance = 10 + (level * 5);
        System.out.println("เพิ่มโอกาสหลบหลีกเป็น " + evadeChance + "%!");
    }

    public void criticalHit(Monster monster) {
        int criticalDamage = this.atk * 2 + (level * 15);
        monster.takeDamage(criticalDamage);

        System.out.println("คริติคอล! " + monster.getName() + " ได้รับความเสียหาย " + criticalDamage + "!");
    }
}