package interfaces.problem_02.car_shop_extendet;

import java.io.Serializable;

public interface Car extends Serializable {

    public final int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();


}
