package hash;

import java.util.Objects;

/*
 * @author : rohan1.gupta
 * @created: 18/5/19
 */
public class SherlockAndAnagram {

}

class SubStr{
    String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubStr subStr = (SubStr) o;
        return s.equals(subStr.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}