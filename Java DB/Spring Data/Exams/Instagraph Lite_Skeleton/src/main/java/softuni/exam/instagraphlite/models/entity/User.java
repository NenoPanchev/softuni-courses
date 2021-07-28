package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String password;
    private Picture profilePicture;
    private Set<Post> posts;

    public User() {
    }

    @Column(nullable = false, unique = true, length = 18)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Picture getProfilePicture() {
        return profilePicture;
    }

    public User setProfilePicture(Picture picture) {
        this.profilePicture = picture;
        return this;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Set<Post> getPosts() {
        return posts;
    }

    public User setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }
}
