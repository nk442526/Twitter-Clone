package first_project.helix.entity;

public class Follower {
    public Long user_id;
    public Long following_id;

    public Follower(){

    }

    public Follower(long user_id , long following_id){
        this.user_id=user_id;
        this.following_id=following_id;
    }
}
