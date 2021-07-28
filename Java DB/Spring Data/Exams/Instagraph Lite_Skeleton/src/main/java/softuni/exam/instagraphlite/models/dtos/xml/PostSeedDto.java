package softuni.exam.instagraphlite.models.dtos.xml;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {
    @XmlElement
    private String caption;
    @XmlElement
    private UserUsernameDto user;
    @XmlElement
    private PicturePathDto picture;

    public PostSeedDto() {
    }

    @Length(min = 21)
    @NotNull
    public String getCaption() {
        return caption;
    }

    public PostSeedDto setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    @NotNull
    public UserUsernameDto getUser() {
        return user;
    }

    public PostSeedDto setUser(UserUsernameDto user) {
        this.user = user;
        return this;
    }

    @NotNull
    public PicturePathDto getPicture() {
        return picture;
    }

    public PostSeedDto setPicture(PicturePathDto picture) {
        this.picture = picture;
        return this;
    }
}
