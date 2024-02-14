package freePractise.lombok;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
//@AllArgsConstructor(staticName = "of", access = AccessLevel.PUBLIC)
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true, callSuper = true)
@Setter
@Getter
@With
@EqualsAndHashCode
public class Book {
    @ToString.Include(name = "Название книги", rank = 0)
    @NonNull
    public String title;
    @EqualsAndHashCode.Exclude
    @ToString.Include(rank = 1)
    public double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
