package racingcar.model;

public class Car {
    private String name;
    private StringBuilder record;
    private Integer goCount;
    private static final String road = "-";

    public Car(String carName) {
        name = carName;
        record = new StringBuilder();
        goCount = 0;
    }

    public void goRoad() {
        record.append(road);
        goCount++;
    }

    public void printRecord() {
        System.out.println(name + " : " + record.toString());
    }

    public String getName() {
        return name;
    }

    public Integer getGoCount() {
        return goCount;
    }
}
