package gerbertShieldBook.chapter_17.sealedClasses;

public sealed class MySealedClass permits Alpha, Betta {
}

final class Alpha extends MySealedClass {

}

final class Betta extends MySealedClass {

}
