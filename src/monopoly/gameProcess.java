package monopoly;

import java.util.List;

public class gameProcess {
    Controller controller;
    List<Player> playerList;
    RichMap map;
    int initMoney;

    public gameProcess() {
        this.map = new RichMap();
        this.initMoney = 10000;
    }

    public void initPlayers(String input) {
        int playerNum ;
        for(int i=0;i<input.length();i++) {
            playerNum = input.charAt(i)-'0';
            playerList.add(new Player(playerNum,initMoney));
        }
        controller = new Controller(playerList.get(0),this.map);
    }

    public void action(String command){
        String[] wholeCommand = command.split(" ");
        String commandPart1 = wholeCommand[0];
        String commandPart2 = wholeCommand[1];

        if ("roll" == commandPart1){
            controller.currentPlayer.move(controller.currentPlayer.roll());
        }
        else if ("sell" == commandPart1){
            controller.currentPlayer.sellLand(map.getLandByNum(commandPart2.charAt(0) - '0'));
        }
        else if ("query" == commandPart1) {
            System.out.println("Query");
        }
        else if ("help" == commandPart1) {
            System.out.println("Help");
        }
        else
            System.out.println("error");

    }

    public void afterMove() {
        if (controller.currentLand.getOwner() != controller.currentPlayer ) {
            if (controller.currentLand.getOwner() != (Player)null) {
                if (getConfirmation()) {
                    controller.playerBuyLand();
                }
            }
            else {
                controller.playerPayOther();
            }
        }
        else {
            if (getConfirmation()) {
                    controller.upgradeLand();
                }
        }
    }

    private boolean getConfirmation() {
        return false;
    }
}
