import java.util.List;

public interface Dao<T> {
    
    T get(int id) throws Exception;
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
    
    String serialize(T t);

    String serializeAll();

    int getNextId();
    
}
