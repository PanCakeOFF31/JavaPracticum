package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_8;
// Дополните объявление класса Contact
public abstract class Contact {
    // Класс должен содержать одно поле - имя пользователя name
    private String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // И два метода - sendMessage() для отправки сообщения и print() для печати информации о контакте
    public abstract void sendMessage();

    public abstract void print();

    @Override
    public boolean equals(Object obj) {
        Contact contact = (Contact) obj;
        return this.getName().equals(contact.getName());
    }
}