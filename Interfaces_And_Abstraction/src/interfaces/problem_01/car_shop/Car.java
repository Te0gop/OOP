package interfaces.problem_01.car_shop;

import java.io.Serializable;

public interface Car extends Serializable {

    public final int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();

}
