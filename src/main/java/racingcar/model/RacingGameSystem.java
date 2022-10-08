package racingcar.model;

import java.util.Set;
import org.assertj.core.util.Sets;

public class RacingGameSystem {

    private String carNames;
    private String gameCount;

    public void init() {
        carNames = GameGuide.printAskRacingCarNames();
        validateCarNames(carNames);
        gameCount = GameGuide.printAskRacingGameCount();
        validateGameCount(gameCount);
    }

    public void run() {
        //TODO: 횟수만큼 레이싱 시작

    }

    public void validateCarNames(String carNames) {
        String [] carNameArray = carNames.split(",");
        Set<String> carNameSet = Sets.newHashSet();
        for(int i=0; i<carNameArray.length; i++) {
            String carName = carNameArray[i];
            validateCarNameSize(carName);
            validateCarNameDuplicate(carNameSet, carName, i+1);
        }
    }

    private void validateCarNameSize(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다. - wrong car name:" + carName);
        }
    }

    private void validateCarNameDuplicate(Set<String> carNameSet, String carName, int correctCarNameSize) {
        carNameSet.add(carName);
        if (carNameSet.size() != correctCarNameSize) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 중복이 있습니다. - wrong car name:" + carName);
        }
    }

    public void validateGameCount(String gameCount) {
        try {
            Integer.valueOf(gameCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자로 입력해야 합니다. - wrong car count:" + gameCount);
        }
    }
}
