package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        List<User> userList = userService.listUsers();
        for (User user : userList) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
        }

        Car car1 = new Car("BMW", 6);
        Car car2 = new Car("Lada", 2);
        Car car3 = new Car("Kia", 7);
        Car car4 = new Car("Audi", 8);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        User foundUser = carService.getUserByCarModelAndSeries("Kia", 7);
        if (foundUser != null) {
            System.out.println("Найден пользователь:");
            System.out.println("Id = " + foundUser.getId());
            System.out.println("First Name = " + foundUser.getFirstName());
            System.out.println("Last Name = " + foundUser.getLastName());
            System.out.println("Email = " + foundUser.getEmail());
            System.out.println("Car Model = " + foundUser.getCar().getModel());
            System.out.println("Car Series = " + foundUser.getCar().getSeries());
        } else {
            System.out.println("Пользователь не найден.");
        }

        context.close();
    }
}
