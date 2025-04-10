
public class BigCar implements Car {

    private String carNo;
    private final String carType = "big";

    public BigCar(String carNo) {
        this.carNo = carNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

}
