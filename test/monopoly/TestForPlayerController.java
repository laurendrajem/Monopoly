package monopoly;

import org.junit.Test;

import javax.sound.midi.ControllerEventListener;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForPlayerController {
    @Test
    public void test_for_single_run() {
        Player player1 = new Player("name", 3, 1000);
        RichMap map = new RichMap();
        Controller controller = new Controller(player1,map);

        controller.playerMove(4);
        controller.playerBuyLand();
        Land currentLand = map.getLandByNum(player1.getPosition());

        assertThat(currentLand.getOwner(), is(player1));
        assertThat(player1.getMoney(), is(800));

        controller.upgradeLand();

        assertThat(player1.getMoney(),is(600));
        assertThat(currentLand.getToll(),is(200));
    }

    @Test
    public void test_for_tow_players_run() {
        Player player1 = new Player("name1", 3, 1000);
        Player player2 = new Player("name2", 3, 1000);
        RichMap map = new RichMap();
        Controller controller = new Controller(player1,map);

        controller.playerMove(4);
        controller.playerBuyLand();
        Land currentNumber = map.getLandByNum(player1.getPosition());

        assertThat(currentNumber.getOwner(), is(player1));
        assertThat(player1.getMoney(), is(800));

        controller.changePlayer(player2);
        controller.playerMove(4);
        controller.playerPayOther();

        assertThat(player1.getMoney(), is(900));
        assertThat(player2.getMoney(), is(900));
    }

}
