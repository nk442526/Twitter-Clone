package first_project.helix.entity;

public class LoginResponse {

    public LoginResponse(){

    }

    public Long id;
    public String message;
    public  Boolean is_logined;

    public LoginResponse(Long id, String message, Boolean is_logined)
    {
        this.id=id;
        this.is_logined=is_logined;
        this.message=message;
    }
}
