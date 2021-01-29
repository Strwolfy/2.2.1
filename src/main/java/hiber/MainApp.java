package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Юрий", "Алексеев", "user1@mail.ru", new Car("Lada", 21023) ));
      userService.add(new User("Дмитрий", "Бурлаков", "user2@mail.ru", new Car("Priora", 3103)));
      userService.add(new User("Петр", "Алексеев", "user3@mail.ru", new Car("Corolla", 32535)));
      userService.add(new User("Николай", "Мадуров", "user4@mail.ru", new Car("Tayota", 23951)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
