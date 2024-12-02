import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ให้ผู้ใช้ป้อนชื่อ
        System.out.print("ป้อนชื่อผู้เล่น: ");
        String playerName = scanner.nextLine();

        // สร้าง Hunter ตัวละคร
        Hunter playerHunter = new Hunter(playerName);

        // ให้ผู้ใช้เลือกคลาส
        System.out.println("เลือกคลาสที่ต้องการ:");
        System.out.println("1. จักรพรรดิเงา");
        System.out.println("2. นักฆ่าปีศาจ");
        System.out.print("กรุณาเลือกคลาส (1-2): ");
        int classChoice = scanner.nextInt();

        // สร้างตัวละครตามที่ผู้ใช้เลือก
        Character player = null;
        switch (classChoice) {
            case 1:
                player = new ShadowMonarchCharacter();
                break;
            case 2:
                player = new AssassinCharacter();
                break;
            default:
                System.out.println("เลือกคลาสไม่ถูกต้อง!");
                return;
        }

        // ให้ Hunter เลือกอาชีพ
        playerHunter.chooseProfession(player);

        System.out.println("ยินดีต้อนรับ " + playerName + " อเวคเป็น " + player.getName());
        System.out.println("=== สเตตัสตัวละคร ===");
        System.out.println("เลเวล: " + player.getLevel());
        System.out.println("ชื่อ: " + playerName);
        System.out.println("คลาส: " + player.getName());
        System.out.println("HP: " + player.getHP());
        System.out.println("Mana: " + player.getMana());
        System.out.println("ATK: " + player.getATK());
        System.out.println("DEF: " + player.getDEF());
        System.out.println("=================================");

        // สร้างมอนสเตอร์
        Monster monster = new Monster("Goblin", 500, 300, 30);

        // สร้างอุปกรณ์
        Accessory cloakOfDarkness = new CloakOfDarkness();
        Accessory artifact = new Artifact();

        // ลูปให้ผู้ใช้ฟาร์มมอนสเตอร์
        boolean keepFarming = true;
        while (keepFarming) {
            System.out.println("\nมอนสเตอร์ " + monster.getName() + " ปรากฏขึ้น!");

            while (monster.getHP() > 0) {
                // แสดงตัวเลือกการกระทำ
                System.out.println("เลือกการกระทำ:");
                System.out.println("1. โจมตีมอนสเตอร์");
                System.out.println("2. ใส่อุปกรณ์");
                System.out.println("3. ถอดอุปกรณ์");
                System.out.println("4. ออก");
                System.out.print("กรุณาเลือกการกระทำ (1-4): ");
                int actionChoice = scanner.nextInt();

                // การกระทำตามที่เลือก
                switch (actionChoice) {
                    case 1:
                        handleAttack(scanner, player, monster);
                        break;
                    case 2:
                        handleEquipAccessory(scanner, playerHunter, cloakOfDarkness, artifact);
                        break;
                    case 3:
                        handleUnequipAccessory(scanner, playerHunter, cloakOfDarkness, artifact);
                        break;
                    case 4:
                        System.out.println("ออกจากเกม...");
                        keepFarming = false;
                        break;
                    default:
                        System.out.println("การเลือกไม่ถูกต้อง");
                }

                // ตรวจสอบสถานะของผู้เล่นและมอนสเตอร์
                if (monster.getHP() > 0) {
                    monsterAttack(player, monster);
                } else {
                    keepFarming = handleMonsterDefeated(scanner, player, monster);
                }
            }
        }

        scanner.close();
    }

    private static void handleAttack(Scanner scanner, Character player, Monster monster) {
        System.out.println("เลือกการโจมตี:");
        System.out.println("1. โจมตีปกติ");

        if (player instanceof AssassinCharacter) {
            System.out.println("2. ล่องหน");
            System.out.println("3. ดาบสังหารมาร");
        } else if (player instanceof ShadowMonarchCharacter) {
            System.out.println("2. เรียกเงา");
            System.out.println("3. ดาบผ่าเงา");
        }

        int skillChoice = scanner.nextInt();
        switch (skillChoice) {
            case 1 -> player.attack(monster);
            case 2 -> {
                if (player instanceof AssassinCharacter assassin) {
                    assassin.stealth();
                } else if (player instanceof ShadowMonarchCharacter monarch) {
                    monarch.summonShadows();
                }
            }
            case 3 -> {
                if (player instanceof AssassinCharacter assassin) {
                    assassin.criticalHit(monster);
                } else if (player instanceof ShadowMonarchCharacter monarch) {
                    monarch.shadowEnhance(monster);
                }
            }
            default -> System.out.println("การเลือกไม่ถูกต้อง");
        }
    }

    private static void handleEquipAccessory(Scanner scanner, Hunter playerHunter, Accessory cloakOfDarkness, Accessory artifact) {
        System.out.println("เลือกอุปกรณ์ที่จะใส่:");
        System.out.println("1. Cloak of Darkness");
        System.out.println("2. Artifact");
        int equipChoice = scanner.nextInt();
        switch (equipChoice) {
            case 1 -> playerHunter.equipAccessory(cloakOfDarkness);
            case 2 -> playerHunter.equipAccessory(artifact);
            default -> System.out.println("เลือกไม่ถูกต้อง");
        }
    }

    private static void handleUnequipAccessory(Scanner scanner, Hunter playerHunter, Accessory cloakOfDarkness, Accessory artifact) {
        System.out.println("เลือกอุปกรณ์ที่จะถอด:");
        System.out.println("1. Cloak of Darkness");
        System.out.println("2. Artifact");
        int unequipChoice = scanner.nextInt();
        switch (unequipChoice) {
            case 1 -> playerHunter.unequipAccessory(cloakOfDarkness);
            case 2 -> playerHunter.unequipAccessory(artifact);
            default -> System.out.println("เลือกไม่ถูกต้อง");
        }
    }

    private static void monsterAttack(Character player, Monster monster) {
        int monsterDamage = Math.max(0, monster.getATK() - player.getDEF());
        player.takeDamage(monsterDamage);
        System.out.println(monster.getName() + " โจมตีคุณ สร้างความเสียหาย " + monsterDamage + " ดาเมจ!");
        System.out.println("ตอนนี้คุณมี HP เหลือ: " + player.getHP());
    }

    private static boolean handleMonsterDefeated(Scanner scanner, Character player, Monster monster) {
        System.out.println(monster.getName() + " ตายแล้ว!");
        player.levelUp();

        System.out.print("ต้องการฟาร์มต่อหรือออกจากเกม? (1 = ฟาร์มต่อ / 2 = ออก): ");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            monster = new Monster("Goblin", monster.getHP() * 2, monster.getATK() * 2, monster.getATK() * 2);
            return true;
        } else {
            return false;
        }
    }
}
