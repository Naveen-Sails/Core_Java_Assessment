package classes;

public class Guest {
    private int id;
    private String name;
    private String email;
    private String city;
    private int age;

    //Constructor 

    public Guest(int id, String name, String email, String city, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    //Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    //Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nGuest [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", age=" + age + "]\n";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    
    
    
}
