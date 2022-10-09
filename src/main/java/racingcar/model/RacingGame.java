package racingcar.model;

import static racingcar.constant.Common.CAN_GO_MIN_NUMBER;
import static racingcar.constant.Common.RACE_LAST_IDX;
import static racingcar.constant.Common.RACE_START_IDX;
import static racingcar.constant.Message.RACE_FINAL_WINNER;
import static racingcar.constant.Message.RACE_ROUND_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.util.Lists;

public class RacingGame {
    private List<Car> carList;

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public void start(Integer racingCount) {
        System.out.println(RACE_ROUND_RESULT);
        for (int i = 0; i < racingCount; i++) {
            raceRound();
            printRecord();
        }
    }

    public void judgeWinner() {
        List<Car> winners = Lists.newArrayList();
        for (Car newCar : carList) {
            winners = findWinner(winners, newCar);
        }

        String winnerNames = convertWinnerNames(winners);
        System.out.println(RACE_FINAL_WINNER + winnerNames);
    }

    private String convertWinnerNames(List<Car> winners) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size() - 1; i++) {
            builder.append(winners.get(i).getName() + ", ");
        }

        builder.append(winners.get(winners.size() - 1).getName());

        return builder.toString();
    }

    private List<Car> findWinner(List<Car> winners, Car newCar) {
        if (winners.isEmpty()) {
            winners.add(newCar);
            return winners;
        }

        return findNewWinner(winners, newCar);
    }

    private List<Car> findNewWinner(List<Car> winners, Car newCar) {
        Car anyWinnerCar = winners.get(0);
        if (anyWinnerCar.getGoCount() < newCar.getGoCount()) {
            winners.clear();
        }

        winners.add(newCar);
        return winners;
    }

    private void raceRound() {
        for (Car car : carList) {
            racing(car);
        }
    }

    private void racing(Car car) {
        Integer raceNumber = Randoms.pickNumberInRange(RACE_START_IDX, RACE_LAST_IDX);
        if (raceNumber >= CAN_GO_MIN_NUMBER) {
            car.goRoad();
        }
    }

    private void printRecord() {
        for (Car car : carList) {
            car.printRecord();
        }
        System.out.println();
    }
}
