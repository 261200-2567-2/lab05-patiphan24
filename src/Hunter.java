public class Hunter {
    private String name;
    public Character profession;

    public Hunter(String name) {
        this.name = name;
    }

    public void chooseProfession(Character profession) {
        this.profession = profession;
    }

    public void equipAccessory(Accessory accessory) {
        profession.equipAccessory(accessory);
    }

    public void unequipAccessory(Accessory accessory) {
        profession.unequipAccessory(accessory);
    }

    public String getName() {
        return name;
    }

    public Character getProfession() {
        return profession;
    }
}