public class User {
    private int id;
    private String name;
    private String phone;
    private String position;
    public User(String name, String phone, String position){
        this.name = name;
        this.phone = phone;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }
}
