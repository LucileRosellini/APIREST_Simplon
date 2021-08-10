import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.github.cliftonlabs.json_simple.Jsoner;

public class topicDao implements Dao<Topic> {
    
    private List<Topic> topics = new ArrayList<>();
    
    public topicDao() {
        topics.add(new Topic(0, "topic0"));
        topics.add(new Topic(1, "topic1"));
    }
    
    public Topic get(int id) {
        return topics.get((int) id);
    }
    
    public List<Topic> getAll() {
        return topics;
    }
    
    public void save(Topic topic) {
        topics.add(topic);
    }
    
    public void update(Topic topic, String[] params) {
        topic.setId(Objects.requireNonNull(Integer.parseInt(params[0]), "Id cannot be null"));
        topic.setLabel(Objects.requireNonNull(params[1], "Label cannot be null"));
        topics.add(topic);
    }
    
    public void delete(Topic topic) {
        topics.remove(topic);
    }
    
    public String serialize(Topic topic) {
        String json = Jsoner.serialize(topic);
        return json;
    }

    @Override
    public String serializeAll() {
        return null;
    }

    @Override
    public int getNextId() {
        return 0;
    }

}
