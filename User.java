import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

public class User implements Jsonable {
    private int id;
    private String email;
    private String password;
    private ArrayList<Topic> topics;
    // private ArrayList<Post> posts;
    
    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String json) {
        try {
            JsonObject jsonobj = (JsonObject) Jsoner.deserialize(json);
            this.id = jsonobj.getInteger(Jsoner.mintJsonKey("id", -1));
            this.email = jsonobj.getString(Jsoner.mintJsonKey("email", 123));
            this.password = jsonobj.getString(Jsoner.mintJsonKey("password", 123));
            this.topics = jsonobj.getCollection(Jsoner.mintJsonKey("topics", 123));
        } catch (JsonException e) {
            e.printStackTrace();
        }
    }

    public User() {}

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList<Topic> getTopics() {
        return this.topics;
    }
    
    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }
    
    @Override
    public String toJson() {
        final StringWriter writable = new StringWriter();
        try {
            this.toJson(writable);
        } catch (final IOException e) {
        }
        return writable.toString();
    }
    
    @Override
    public void toJson(Writer writer) throws IOException {
        
        final JsonObject json = new JsonObject();
        json.put("id", this.getId());
        json.put("email", this.getEmail());
        json.put("password", this.getPassword());
        json.toJson(writer);
    }
    
}
