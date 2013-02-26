package monopoly;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForLandAndPlayer {

    @Test
    public void test_for_player_buy_land(){
        Player player = new Player("name",1,1000);
        Land land = new Land(1,0,1);

        player.buyLand(land);

        assertThat(land.getOwner(),is(player));
        assertThat(player.getLandNum(),is(1));
    }


}
