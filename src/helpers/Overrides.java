package helpers;

import java.util.Objects;

public class Overrides {

    private String field;
    private String field2;

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        Overrides overrides = (Overrides) object;
        return Objects.equals(this.field, overrides.field) &&
                Objects.equals(this.field2, overrides.field2);

    }

}

class Overrides_2 {

    private String field_1;
    private String field_2;

       @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Overrides_2 obj2 = (Overrides_2) obj;

        if (!this.field_1.equals(obj2.field_1)) return false;
        if (!this.field_2.equals(obj2.field_2)) return false;

        return true;
    }
}
