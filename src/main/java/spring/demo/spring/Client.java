package spring.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.spring.configuration.ApplicationConfig;
import spring.demo.spring.model.Cart;
import spring.demo.spring.model.ProductRepository;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);

        printMenu();
        while (true) {
            System.out.println("Введите команду: " + "\n");
            final String command = scanner.nextLine();
            if ("add".equals(command)) {
                System.out.println("Введите id товара:");
                String id = scanner.nextLine();
                int parsedId = Integer.parseInt(id);
                cart.addItem(parsedId);
            }
            if ("view".equals(command)) {
                cart.cartView();
            }

            if ("delete".equals(command)) {
                System.out.println("Введите id товара:");
                String id = scanner.nextLine();
                int intID = Integer.parseInt(id);
                cart.removeItem(intID);
            }

            if ("clear".equals(command)) {
                cart.clearCart();
            }

            if ("exit".equals(command)) {
                return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Команды");
        System.out.println("_________________________");
        System.out.println("view - содержание корзины");
        System.out.println("add - добавить товар");
        System.out.println("delete  - удалить товар");
        System.out.println("clear - очистить корзину");
        System.out.println("exit - очистить корзину");
        System.out.println("_________________________" + "\n");
    }
}


