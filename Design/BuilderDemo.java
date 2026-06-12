class User {
    private String name;
    private int rollNo;
    private int age;
    private String address;
    private String gender;
    
    //private Constructor
    private User(Builder builder) {
        this.name=builder.name;
        this.rollNo=builder.rollNo;
        this.age=builder.age;
        this.address=builder.address;
        this.gender=builder.address;
    }
    static class Builder {
        private String name;
        private int rollNo;
        private int age;
        private String address;
        private String gender;

        public Builder setName(String name) {
            this.name=name;
            return this;
        }
        public Builder setRoll(int rollNo) {
            this.rollNo=rollNo;
            return this;
        }
        public Builder setAge(int age) {
            this.age=age;
            return this;
        }
        public Builder setAddress(String address) {
            this.address=address;
            return this;
        }
        public Builder setGender(String gender) {
            this.gender=gender;
            return this;
        }
        public User build() {
            return new User(this);
        }

    }
}
public class BuilderDemo {
    public static void main(String[] args) {
        
    }
}
