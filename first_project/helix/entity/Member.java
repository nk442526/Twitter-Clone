package first_project.helix.entity;


public class Member extends MemberBase {

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getRole(){
        return role;
    }
    public String getPassword(){
        return password;
    }
    public String getImage(){
        return image;
    }
    public String getToken(){
        return token;
    }
    public Boolean getIs_verified(){
        return is_verified;
    }
    public long getId() {return id;}

    public long id;
    public String name;
    public String email;
    public String role;
    public String password;
    public String image;
    public String token;
    public Boolean is_verified;

}
