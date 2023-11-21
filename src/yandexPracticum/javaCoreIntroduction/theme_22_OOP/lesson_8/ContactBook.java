package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_8;

import java.util.ArrayList;
import java.util.List;

// Ограничьте класс ContactBook так, чтобы он мог хранить в себе только список контактов
public class ContactBook<Type extends Contact> {
    // Объявите поле класса contacts - список контактов книги
    private List<Type> contacts = new ArrayList<>();

    public void addContact(Type contact) {
        contacts.add(contact);
    }

    public void printList() {
        // Выведите на экран весь список контактов книги
        for (Type contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }

    public void congratulate(String name) {
        Contact contact;
        boolean contactPresented = false;

        int index = -1;
        for (Type c : contacts) {
            index++;
            if (c.getName().equals(name)) {
                contactPresented = true;
                break;
            }
        }

        if (contactPresented) {
            contact = contacts.get(index);
            System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
            contact.sendMessage();
        } else {
            // Если контакт не найден, выведите соответсвующее сообщение
            System.out.println("Не найден контакт с указанным именем.");
        }

        if (contacts.contains(new Phone("Иван", "+7-909-000-11-22"))) {
            System.out.println("Equals работает");
        }

    }

}