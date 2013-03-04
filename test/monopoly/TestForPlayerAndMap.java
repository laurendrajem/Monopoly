package monopoly;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForPlayerAndMap {
    @Test
    public void test_for_single_run() {
        Player player1 = new Player("name", 3, 1000);
        RichMap map = new RichMap();

        player1.move(4);
        Land currentNumber = map.getLandByNum(player1.getPosition());
        player1.buyLand(currentNumber);

        assertThat(currentNumber.getOwner(), is(player1));
        assertThat(player1.getMoney(), is(800));
    }
}
