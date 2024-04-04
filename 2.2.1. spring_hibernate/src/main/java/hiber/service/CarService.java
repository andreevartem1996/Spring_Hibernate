package hiber.service;

import hiber.model.User;

public interface CarService {
    User getUserByCarModelAndSeries(String model, int series);
}
