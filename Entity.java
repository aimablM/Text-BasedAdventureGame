public class Entity
 {
        String name;
        String description;
    
        public Entity() {
        };
    
        public String getName() {
            return this.name;
        }
        public Entity(String n, String d) {
            name = n;
            description = d;
        }
    
        public String getDesc() {
            return description;
        }
    }
    
