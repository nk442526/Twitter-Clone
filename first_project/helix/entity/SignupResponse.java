package first_project.helix.entity;

public class SignupResponse {
    public String message;
    public  Boolean user_created;

    public SignupResponse(String message , Boolean user_created){
        this.message=message;
        this.user_created=user_created;
    }

}
