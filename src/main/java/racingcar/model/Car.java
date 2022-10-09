package racingcar.model;

public class Car {
    private String name;
    private StringBuilder record;

    public Car(String carName) {
        name = carName;
        record = new StringBuilder();
    }

}
