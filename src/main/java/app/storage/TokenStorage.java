package app.storage;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TokenStorage {

    private List<String> stringList = new ArrayList<>();

    public void save(String s) {
        stringList.add(s);
    }

    public boolean valid(String s) {
        return stringList.contains(s);
    }
}
