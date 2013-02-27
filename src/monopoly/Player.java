package monopoly;

import java.util.Random;

public class Player {
    private String name;
    private int position;
    private int money;
    private int landNum = 0;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Player(String name, int position, int money) {
        this.name = name;
        this.position = position;
        this.money = money;
    }

    public void move(int steps) {
        this.position = (steps + position) % 70;
    }

    public int getPosition() {
        return this.position;
    }

    private void payForLand(int price) {
        pay(price);
        this.landNum++;
    }

    public int getMoney() {
        return money;
    }

    public int getLandNum() {
        return landNum;
    }

    public void payForOthers(int money, Player anotherPlayer) {
        pay(money);
        anotherPlayer.earnMoney(money);
    }

    private void pay(int money) {
        this.money -= money;
    }

    public void earnMoney(int money) {
        this.money += money;
    }

    public void buyLand(Land land) {
        payForLand(land.getPrice());
        land.setOwner(this);
    }

    public void updateLand(Land land) {
        land.levelUp();
    }

    public void sellLand(Land land) {
        landNum -= 1;
        this.earnMoney(land.getSellPrice());
        land.sold();
    }

    public int roll() {
        Random random = new Random();
        int i = random.nextInt(6) % 6 + 1;
        return i;
    }
}
