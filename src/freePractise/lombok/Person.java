package freePractise.lombok;

import lombok.*;

@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(onlyExplicitlyIncluded = true, includeFieldNames = false)
public class Person {
    @Getter
    @ToString.Include
    @NonNull
    private String name;
    @ToString.Include
    private final Integer age;
    @ToString.Exclude
    private boolean gender;

    public String getName() {
        return name;
    }

    public static Person createPersin(String name, int age, boolean gender) {
        return new Person(name, age, true);
    }
}
