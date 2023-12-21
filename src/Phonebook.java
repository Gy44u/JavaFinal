import java.util.*;

public class Phonebook {
    private Map<String, List<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        phonebook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }

    public void printPhonebook() {
        // Сортировка по убыванию числа телефонов
        phonebook.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        // Пример добавления контактов
        phonebook.addContact("John", "123-456-789");
        phonebook.addContact("Jane", "987-654-321");
        phonebook.addContact("John", "111-222-333");
        phonebook.addContact("Jane", "555-555-555");
        phonebook.addContact("Jane", "555-555-554");
        phonebook.addContact("Antony", "555-555");
        phonebook.addContact("Jane", "555-555-553");
        phonebook.addContact("Antony", "555-552");
        phonebook.addContact("Jane", "555-555-557");
        phonebook.addContact("Antony", "555-55564");

        // Вывод телефонной книги
        phonebook.printPhonebook();
    }
}