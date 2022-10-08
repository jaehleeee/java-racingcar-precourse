package racingcar.model;

import static racingcar.constant.Message.ASK_RACING_CAR_NAMES;
import static racingcar.constant.Message.ASK_RACING_GAME_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class GameGuide {
    public static String printAskRacingCarNames() {
        System.out.printf(ASK_RACING_CAR_NAMES);
        return Console.readLine();
    }

    public static String printAskRacingGameCount() {
        System.out.printf(ASK_RACING_GAME_COUNT);
        return Console.readLine();
    }
}
