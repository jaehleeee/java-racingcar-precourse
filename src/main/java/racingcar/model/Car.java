package racingcar.model;

public class Car {
    private String name;
    private StringBuilder record;
    private static final String road = "-";

    public Car(String carName) {
        name = carName;
        record = new StringBuilder();
    }

    public void goRoad() {
        record.append(road);
    }

    public String getName() {
        return name;
    }

    public String getRecord() {
        return record.toString();
    }

}
