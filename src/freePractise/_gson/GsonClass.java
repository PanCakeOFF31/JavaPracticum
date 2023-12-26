package freePractise._gson;

import com.google.gson.*;
import helpers.coloredString.ColoredString;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.util.Arrays;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class GsonClass {
    public static void main(String[] args) {

//        Simple conversion toJson()
//        program_1();
//        JsonElement identification
//        program_2();
//        JsonSyntaxException
//        program_3();
//        Simple conversation fromJson()
//        program_4();
//        JsonPrimitive
//        program_5();
//        JsonArray
//        program_6();
//        JsonObject
//        program_7();
//        TypeAdapter
        program_8();
//        program_9();
    }


    private static void program_1() {
        printSection("Program_1. Json conversation, toJson()");

        Logger.printMessage("Simple conversion without null fields");
        {
            Gson gson = new Gson();
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

            Weapon weapon1 = Weapon.of();
            System.out.println(gson.toJson(weapon1));
            System.out.println(prettyGson.toJson(weapon1));
        }

        Logger.printMessage("Simple conversion with null fields");
        {
            Gson gson = new GsonBuilder().serializeNulls().create();
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

            Weapon weapon1 = Weapon.of();

            System.out.println(gson.toJson(weapon1));
            System.out.println(prettyGson.toJson(weapon1));
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. JSON identification");

        Logger.printMessage("json identification:");
        {
            String origin1 = "10";
            JsonElement jsonElement1 = JsonParser.parseString(origin1);
            jsonElementInfo(jsonElement1);

            String origin2 = "maxim";
            JsonElement jsonElement2 = JsonParser.parseString(origin2);
            jsonElementInfo(jsonElement2);

            String origin3 = "null";
            JsonElement jsonElement3 = JsonParser.parseString(origin3);
            jsonElementInfo(jsonElement3);

            String origin4 = "";
            System.out.println("origin4 = " + origin4);
            JsonElement jsonElement4 = JsonParser.parseString(origin4);
            jsonElementInfo(jsonElement4);

            String origin5 = "{}";
            JsonElement jsonElement5 = JsonParser.parseString(origin5);
            jsonElementInfo(jsonElement5);

            String origin6 = "[]";
            JsonElement jsonElement6 = JsonParser.parseString(origin6);
            jsonElementInfo(jsonElement6);
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. JsonSyntaxException");

        Logger.printMessage("JsonSyntaxException", Colors.RED);
        {
            String originJsonString = "{{a},{asdkmalskmd}}";
            try {
                JsonElement jsonElement = JsonParser.parseString(originJsonString);
                System.out.println(jsonElement);
            } catch (JsonSyntaxException e) {
                System.out.println("Возникло исключение при парсинге Json строки: " + originJsonString);
            }

        }

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Simple conversation fromJson()");

        Logger.printMessage("JsonParser and String with gson.fromJson()");
        {
            String origin = "[10, 20, 30]";
            JsonElement jsonElement = JsonParser.parseString(origin);

            Gson gson = new Gson();

            int[] arr1 = gson.fromJson(origin, int[].class);
            int[] arr2 = gson.fromJson(jsonElement, int[].class);

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            int[] originInt = {10, 20, 30};
            int[] arr3 = gson.fromJson(gson.toJson(originInt, int[].class), int[].class);
            System.out.println(Arrays.toString(arr3));
        }

        {
            Gson gson = new Gson();

            int[] originInt = {10, 20, 30};
            JsonElement element = gson.toJsonTree(originInt);
            System.out.println(element);

            gson.fromJson(element, int[].class);
            int[] arr = gson.fromJson(gson.toJson(originInt, int[].class), int[].class);
            System.out.println(Arrays.toString(arr));
        }

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. JsonPrimitive");

        String origin1 = "20";
        System.out.println("origin1 = " + origin1);
        JsonPrimitive primitive1 = JsonParser.parseString(origin1).getAsJsonPrimitive();
        System.out.println("primitive1 = " + primitive1);
        jsonPrimitiveInfo(primitive1);

        String origin2 = "true";
        System.out.println("origin2 = " + origin2);
        JsonPrimitive primitive2 = JsonParser.parseString(origin2).getAsJsonPrimitive();
        System.out.println("primitive2 = " + primitive2);
        jsonPrimitiveInfo(primitive2);

        String origin3 = "maximum";
        System.out.println("origin3 = " + origin3);
        JsonPrimitive primitive3 = JsonParser.parseString(origin3).getAsJsonPrimitive();
        System.out.println("primitive3 = " + primitive3);
        jsonPrimitiveInfo(primitive3);

        printSectionEnding();
    }

    private static void jsonElementInfo(JsonElement element) {
        System.out.println("element: " + element);

        if (element.isJsonNull()) {
            System.out.println(ColoredString.of("is null: ", Colors.BLUE).toString() + element.isJsonNull());
            return;
        }

        if (element.isJsonObject()) {
            System.out.println(ColoredString.of("is object: ", Colors.BLUE).toString() + element.isJsonObject());
            return;
        }

        if (element.isJsonArray()) {
            System.out.println(ColoredString.of("is array: ", Colors.BLUE).toString() + element.isJsonArray());
            return;
        }

        System.out.println(ColoredString.of("is primitive: ", Colors.BLUE).toString() + element.isJsonPrimitive());
    }

    private static void jsonPrimitiveInfo(JsonPrimitive primitive) {
        Logger.printMessage("primitive: " + primitive.toString());
        if (primitive.isString()) {
            System.out.println(ColoredString.of("is String: ", Colors.BLUE).toString() + primitive.isString());
            return;
        }

        if (primitive.isBoolean()) {
            System.out.println(ColoredString.of("is Boolean: ", Colors.BLUE).toString() + primitive.isBoolean());
            return;
        }

        if (primitive.isNumber()) {
            System.out.println(ColoredString.of("is Number: ", Colors.BLUE).toString() + primitive.isBoolean());
        }
    }

    private static void program_6() {
        printSection("Program_6. JsonArray");

        JsonArray jsonArray = new JsonArray(5);

        jsonArray.add(10);
        jsonArray.add("maxim");
        jsonArray.add(true);

        System.out.println("jsonArray = " + jsonArray);

        System.out.println(jsonArray.get(0).getAsInt());
        System.out.println(jsonArray.get(1).getAsString());
        System.out.println(jsonArray.get(2).getAsBoolean());

        Boolean b = null;
        jsonArray.add(b);

        System.out.println("jsonArray = " + jsonArray);

        Object[] objArr = new Gson().fromJson(jsonArray, Object[].class);
        System.out.println(Arrays.toString(objArr));

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. JsonObject from empty");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Logger.printMessage("Исходный пустой объект");
        JsonObject main = new JsonObject();
        System.out.println("main = " + main);

        JsonObject innerObj = new JsonObject();
        JsonArray innerArr = new JsonArray();
        Integer prim1 = 10;
        Boolean prim2 = true;

        {
            main.addProperty("power", prim1);
            innerArr.add(0);
            innerArr.add(15);
            innerArr.add(30);
            main.add("targets", innerArr);
            main.addProperty("hasBoost", prim2);
        }

        {
            innerObj.addProperty("title", "spider-wolf");
            innerObj.addProperty("name", "bogaga");
            main.add("additional", innerObj);
        }

        Logger.printMessage("Итоговый объект после добавления примитивов, объекта и массива");
        System.out.println(gson.toJson(main));

        System.out.println(main.get("power").getAsNumber());
        System.out.println(main.has("targets"));
        System.out.println(main.size());
        System.out.println(main.entrySet());
        System.out.println(main.keySet());
        main.remove("hasBoost");

        System.out.println(gson.toJson(main));

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. TypeAdapter<T>");

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        Logger.printMessage("JSON строка из объекта");
        {
            Weapon weapon = Weapon.of();
            weapon.title = "knife";
            weapon.length = 50;
            String jsonWeapon = gson.toJson(weapon);
            System.out.println(jsonWeapon);
        }

        Logger.printMessage("Создание Weapon из JsonObject");
        {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("title", "knife");
            jsonObject.addProperty("power", 15.5);

            Weapon weapon = gson.fromJson(jsonObject, Weapon.class);
            System.out.println(gson.toJson(weapon));
        }

        Logger.printMessage("Переходы между разными Gson");
        {
            String prettyJson = gson.toJson(Weapon.of());
            System.out.println(prettyJson);

            Gson notPretty = new Gson();
            String notPrettyJson = notPretty.toJson(gson.fromJson(prettyJson, Weapon.class));
            System.out.println("notPrettyJson = " + notPrettyJson);
        }

        printSectionEnding();
    }
}

class Weapon {
    String title;
    int length;
    double power;
    String options;

    private Weapon() {
        System.out.println("Был вызван приватный конструктор");
        length = 35;
    }

    public static Weapon of() {
        return new Weapon();
    }
}
