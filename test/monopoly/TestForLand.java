package monopoly;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForLand {

    @Test
    public void test_for_land_level_up(){
        Land land = new Land(1,0,1);
        assertThat(land.getPrice(), is(200));
        assertThat(land.getSellPrice(), is(400));
        land.levelUp();
        assertThat(land.getSellPrice(),is(800));
    }

}
