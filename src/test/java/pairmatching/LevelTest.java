package pairmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Level;

public class LevelTest {

    @Test
    void levelTest() {
        Level result = Level.getValueOfLabel("레벨1");

        Assertions.assertThat(result).isEqualTo(Level.LEVEL1);
    }
}
