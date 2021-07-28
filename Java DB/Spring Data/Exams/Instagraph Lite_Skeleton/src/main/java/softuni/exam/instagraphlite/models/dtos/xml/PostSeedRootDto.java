package softuni.exam.instagraphlite.models.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedRootDto {
    @XmlElement(name = "post")
    private List<PostSeedDto> posts;

    public PostSeedRootDto() {
    }

    public List<PostSeedDto> getPosts() {
        return posts;
    }

    public PostSeedRootDto setPosts(List<PostSeedDto> posts) {
        this.posts = posts;
        return this;
    }
}
