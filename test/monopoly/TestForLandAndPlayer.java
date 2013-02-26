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

    @Test
    public void test_for_player_update_land(){
        Player player = new Player("name",1,1000);
        Land land = new Land(1,0,1);

        player.updateLand(land);

        assertThat(land.getSellPrice(),is(800));
    }

    @Test
    public void test_for_player_sell_land(){
        Player player = new Player("name",1,1000);
        Land land = new Land(1,1,1);

        player.buyLand(land);
        player.sellLand(land);

        assertThat(land.getOwner(),is((Player)null));
        assertThat(player.getMoney(),is(1600));
        assertThat(land.getSellPrice(),is(400));
        assertThat(player.getLandNum(),is(0));
    }

}
