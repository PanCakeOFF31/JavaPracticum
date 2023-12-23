package yandexPracticum.javaCoreContinuation.theme_16.lesson_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import helpers.coloredString.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_2 {
    public static void practicum_2() {
        printSection("Practicum_2");

//        Gson
//        program_1();
//        GsonBuilder
        program_2();

//        GsonBuilder: TypeAdapter
        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Gson");

        Gson gson = new Gson();
        Owner owner = new Owner("name", "sername");
        Dog dog = new Dog("name",owner,10);

        String jsonString = gson.toJson(dog);
        System.out.println(jsonString);

        Dog dog2 = gson.fromJson(jsonString, Dog.class);
        System.out.println(dog2);

//        Dog dog3 = gson.fromJson("asd",Dog.class);


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. GsonBuilder: class");

        Logger.printMessage("GsonBuilder class");
        {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Owner owner = new Owner("Josh", "Black");

            Gson gson = new Gson();
            String serializedOwner = gson.toJson(owner);
            System.out.println("serializedOwner = " + serializedOwner);

            Gson prettyGson = builder.create();
            String serializedOwnerPretty = prettyGson.toJson(owner);
            System.out.println("serializedOwnerPretty = " + serializedOwnerPretty);
        }

        Logger.printMessage("serializeNulls()");
        {
            Owner owner = new Owner("Jim", null);

            Gson notNullGson = new GsonBuilder().setPrettyPrinting().create();
            String serializedOwner = notNullGson.toJson(owner);
            System.out.println("serializedOwner = " + serializedOwner);

            Gson nullGson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String serializedOwnerNull = nullGson.toJson(owner);
            System.out.println("serializedOwnerNull = " + serializedOwnerNull);
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. GsonBuilder: TypeAdapter");

        class LocalDateAdapter extends TypeAdapter<LocalDate> {
            private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            @Override
            public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                jsonWriter.value(localDate.format(formatter));
            }

            @Override
            public LocalDate read(JsonReader jsonReader) throws IOException {
                return LocalDate.parse(jsonReader.nextString(), formatter);
            }
        }

        UserPost post = new UserPost();
        post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
        post.setUserId(97_748);
        post.setDescription("Классное фото!");
        post.setLikesQuantity(753);
        LocalDate publicationDate = LocalDate.of(2020, 12, 25);
        post.setPublicationDate(publicationDate);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .registerTypeAdapter(LocalDate.class,new LocalDateAdapter())
                .create();

        String serialized = gson.toJson(post);
        System.out.println("serialized = " + serialized);

        printSectionEnding();
    }
}

class Dog {
    private String name;

    public Dog(String name, Owner owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Owner owner;
    private int age;

    @Override
    public String toString() {
        return "Dog{name: \"" + name + "\""
                + "owner: " + owner
                + ",age: " + age + "}";
    }
}

class Owner {
    public Owner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String name;
    private String surname;

    @Override
    public String toString() {
        return "Owner{name: \"" + name +
                "\",surname: \"" + surname + "\"}";
    }
}

class UserPost {
    // URL-адрес, по которому можно скачать фото
    private String photoUrl;

    // дата публикации
    private LocalDate publicationDate;

    // уникальный идентификатор автора поста
    private int userId;

    // текстовой комментарий к фото
    private String description;

    // сколько пользователей поставило лайк этому посту
    private int likesQuantity;


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikesQuantity() {
        return likesQuantity;
    }

    public void setLikesQuantity(int likesQuantity) {
        this.likesQuantity = likesQuantity;
    }


    @Override
    public String toString() {
        return "UserPost{" +
                "photoUrl='" + photoUrl + '\'' +
                ", publicationDate=" + publicationDate +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", likesQuantity=" + likesQuantity +
                '}';
    }
}