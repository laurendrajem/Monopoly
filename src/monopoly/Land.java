package monopoly;

public class Land {
    private Player owner;
    private int num;
    private int level;
    private int type;
    private int price;

    public Land(int num, int level, int type) {
        this.num = num;
        this.level = level;
        this.type = type;
    }

    public int getPrice() {
        if (type == 1)
            price = 200;
        else if (type == 2)
            price = 500;
        else if (type == 3)
            price = 300;
        else
            return 0;
        return price;
    }

    public int getSellPrice() {
        return (price + price * level) * 2;
    }

    public void levelUp() {
        level += 1;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }
}
