package hiber.dao;

import hiber.model.User;

public interface CarDao {
    User getUserByCarModelAndSeries(String model, int series);
}
