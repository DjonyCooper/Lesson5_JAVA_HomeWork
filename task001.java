// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции:
// 1) Добавление номера
// 2) Вывод всего

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;

public class task001 {
    static String scanOperations() {
        Scanner scan = new Scanner(System.in);
        String operations = scan.nextLine();
        return operations;
    }

    public static HashMap<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        addInPhoneBook();
        System.out.println("Телефонная книга:");
        System.out.println("* введите одну из команд:");
        System.out.println("1) введите: 'all' чтобы показать все номера");
        System.out.println("2) введите: 'add' чтобы добавить новый контакт");
        System.out.println("3) введите: 'exit' для выхода из справочника");
        String option = scanOperations();
        if (Objects.equals(option, "all")) {
            System.out.println("______________________________________________________________");
            System.out.println("Ваши контакты:");
            findInPhoneBook();
            System.out.println("______________________________________________________________");
            System.out.println("* введите одну из команд:");
            System.out.println("1) введите: 'back' чтобы вернуться в основное меню");
            System.out.println("2) введите: 'exit' для выхода из справочника");
            String step_one = scanOperations();
            if (Objects.equals(step_one, "back")) {
                System.out.println("______________________________________________________________");
                main(args);
            }
            if (Objects.equals(option, "exit")) {
                System.out.println("Возвращайтесь к нам снова!");
            }
        }
        if (Objects.equals(option, "add")) {
            System.out.println("______________________________________________________________");
            System.out.println("Добавление нового контакта:");
            System.out.println(
                    "Введите фамилию (если вы меняете уже существующий контакт, добавление номеров производите: старый(-ые), новый(-ые) номер(-а)):");
            String name = scanOperations();
            System.out.println("Введите номер:");
            String phone_num = scanOperations();
            addPhoneNum(name, phone_num);
            System.out.println("______________________________________________________________");
            System.out.println("Телефонный справочник обновлен:");
            findInPhoneBook();
            System.out.println("______________________________________________________________");
            System.out.println("* введите одну из команд:");
            System.out.println("1) введите: 'back' чтобы вернуться в основное меню");
            System.out.println("2) введите: 'exit' для выхода из справочника");
            String step_one = scanOperations();
            if (Objects.equals(step_one, "back")) {
                System.out.println("______________________________________________________________");
                main(args);
            }
            if (Objects.equals(option, "exit")) {
                System.out.println("Возвращайтесь к нам снова!");
            }
        }
        if (Objects.equals(option, "exit")) {
            System.out.println("Возвращайтесь к нам снова!");
        }
    }

    public static void addInPhoneBook() {
        phoneBook.put("Быков", List.of("8(800)555-35-35", "+7(222)222-22-22", "+7(919)700-80-90"));
        phoneBook.put("Ершов", List.of("+7(333)333-33-33", "+7(444)444-44-44"));
        phoneBook.put("Мальцев", List.of("+7(555)555-55-55", "+7(666)666-66-66"));

    }

    public static void findInPhoneBook() {
        phoneBook.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public static void addPhoneNum(String key, String value) {
        phoneBook.put(key, List.of(value));
        System.out.println("Данные успешно добавлены!");
    }
}