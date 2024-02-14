package freePractise.lombok;

import lombok.*;

@Value
@ToString(includeFieldNames = false)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Box {
    int width;
    int height;
}
