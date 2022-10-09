package racingcar.model;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    RacingGame racingGame;
    List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = Lists.newArrayList(
                new Car("socar"),
                new Car("uber"),
                new Car("bmw")
        );
        racingGame = new RacingGame(carList);
    }

    @Test
    @DisplayName("RacingGame 정상 동작 테스트")
    void test() {
        racingGame.start(10);
        for (Car car : carList) {
            car.printRecord();
        }
    }
}