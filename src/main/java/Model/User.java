package Model;

public class User {
    private int dni;
    private String email;
    private int tel;
    private String category; // podria ser un enum
    private String name;
    private boolean is_valid;

    public User(int dni, String email, int tel, String cat, String name, boolean is_valid) {
        this.dni = dni;
        this.email = email;
        this.tel = tel;
        this.category = cat;
        this.name = name;
        this.is_valid = is_valid;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
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

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }
}
