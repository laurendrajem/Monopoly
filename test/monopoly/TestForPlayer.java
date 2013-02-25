package monopoly;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForPlayer {

    @Test
    public void test_for_player_move(){
        Player player = new Player("name",1);
        player.move(3);
        assertThat(player.getPosition(), is(4));
    }

    @Test
    public void test_for_player_move_circle(){
        Player player = new Player("name",68);
        player.move(3);
        assertThat(player.getPosition(), is(1));
    }

    @Test
    public  void test_for_player_pay_for_land(){
        Player player = new Player("name",1,1000);
        player.payForLand(200);
        assertThat(player.getMoney(),is(800));
        assertThat(player.getLandNum(),is(1));
    }

    @Test
    public void test_for_player_pay_for_others(){
        Player player1 = new Player("name1",1,1000);
        Player player2 = new Player("name2",1,1000);
        player1.payForOthers(300,player2);
        assertThat(player1.getMoney(),is(700));
        assertThat(player2.getMoney(),is(1300));
    }

    @Test
    public void test_for_player_earn_money(){
        Player player = new Player("name",1,1000);
        player.earnMoney(200);
        assertThat(player.getMoney(),is(1200));
    }
}
