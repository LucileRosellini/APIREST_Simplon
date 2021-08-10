import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.cliftonlabs.json_simple.Jsoner;


public class userDao implements Dao<User> {
    
    private List<User> users = new ArrayList<>();
    
    public userDao() {
        users.add(new User(getNextId(), "john@domain.com", "abc"));
        users.add(new User(getNextId(), "susan@domain.com", "def"));
    }
    
    public User get(int id) throws Exception {
        System.out.println("Trying to get user id " + id);
        for(int counter = 0; counter < users.size(); counter++) {
            if (users.get(counter).getId() == id) {
                return users.get(counter);
            }
        }
        throw new Exception("No user with id " + id);
    }
    
    public List<User> getAll() {        
        return this.users;
    }
    
    public void save(User user) {
        System.out.println("Trying to save user id " + user.getId());
        users.add(user);
    }
    
    public void update(User user, String[] params) {
        System.out.println("Trying to update user id " + user.getId());
        user.setId(Objects.requireNonNull(Integer.parseInt(params[0]), "Id cannot be null"));
        user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
        user.setPassword(Objects.requireNonNull(params[2],"Password cannot be null"));
        users.add(user);
    }
    
    public void delete(User user) {
        System.out.println("Trying to delete user id " + user.getId());
        users.remove(user);
    }

    public String serialize(User user) {
        String json = Jsoner.serialize(user);
        json = Jsoner.prettyPrint(json);
        return json;
    }

    public String serializeAll() {
        String json = Jsoner.serialize(users);
        return json;
    }

    public int getNextId() {
        int counter = 0;
        for (counter = 0; counter <= users.size(); counter++) { 	
            try {
                int id = users.get(counter).getId();
                System.out.println("existing id : " + id);
            } catch (Exception e) {
                return(counter);
            } 	      
        }
        return(counter + 1);
    }
    
}
