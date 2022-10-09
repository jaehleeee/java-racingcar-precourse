package racingcar.model;

import static racingcar.constant.Common.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private List<Car> carList;

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public void start(Integer racingCount) {
        for (int i = 0; i < racingCount; i++) {
            raceRound();
        }
    }

    private void raceRound() {
        for (Car car : carList) {
            racing(car);
        }
    }

    private void racing(Car car) {
        Integer raceNumber = Randoms.pickNumberInRange(RACE_START_IDX, RACE_LAST_IDX);
        if(raceNumber >= CAN_GO_MIN_NUMBER) {
            car.goRoad();
        }
    }
}
