package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class ResrictiedGeneric<T> {
    T obj;
    T[] objs;

    public ResrictiedGeneric(T obj, T[] objs) {
        this.obj = obj;
        this.objs = objs;
//        Первое ограничение
//        objs = new T[10];
    }
}
