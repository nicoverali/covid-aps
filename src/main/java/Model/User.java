package Model;

public class User {
    private int dni;
    private final String password;
    private String email;
    private String name;
    private String phonenumber;
    private String category; // podria ser un enum
    private int roleId;
    private boolean is_valid;

    public User(String name, String email, String password, String phonenumber, String category, int roleId, boolean is_valid) {
        this(-1, name, email, password, phonenumber, category, roleId, is_valid);
    }

    public User(int dni, String name, String email, String password, String phonenumber, String category, int roleId, boolean is_valid) {
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.category = category;
        this.roleId = roleId;
        this.is_valid = is_valid;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean is_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }
}
