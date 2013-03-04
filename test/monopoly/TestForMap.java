package monopoly;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestForMap {
    @Test
    public void test_for_initialization_of_map(){
        RichMap map = new RichMap();

        assertThat(map.getLandByNum(5).getPrice(),is(200) );
        assertThat(map.getLandByNum(16).getPrice(),is(200) );
        assertThat(map.getLandByNum(31).getPrice(),is(500) );
        assertThat(map.getLandByNum(37).getPrice(),is(300) );
        assertThat(map.getLandByNum(55).getPrice(),is(300) );
    }
}
