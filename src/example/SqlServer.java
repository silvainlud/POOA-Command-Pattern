package example;

import java.util.HashMap;

/**
 * Receiver
 */
public class SqlServer {

    /**
     * Variable pour l'auto incrémentation
     */
    private static int idCounter = 0;
    private HashMap<Integer, String> database = new HashMap<>();


    public SqlServer() {
        add("Valeur1");
        add("Valeur2");
    }

    /**
     * Ajout avec auto-incrémentation
     */
    public void add(String value) {
        database.put(idCounter, value);
        idCounter++;
    }

    /**
     * Lorsque l'on connait déjà l'id
     */
    public void add(int id, String value) {
        database.put(id, value);
    }

    public void set(int id, String value) {
        database.replace(id, value);
    }

    public void remove(int id) {
        database.remove(id);
    }

    public String get(int id) {
        return database.get(id);
    }

    @Override
    public String toString() {
        return database.toString();
    }
}
