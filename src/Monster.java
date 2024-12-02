public class Monster {
    private String name;
    private int hp;
    private int atk;
    private int def;

    public Monster(String name, int hp, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getATK() {
        return atk;
    }

    public int getDEF() {
        return def;
    }

    // ลดเลือดของมอนสเตอร์
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    // เช็คว่ามอนสเตอร์ตายหรือยัง
    public boolean isDead() {
        return hp <= 0;
    }
}
