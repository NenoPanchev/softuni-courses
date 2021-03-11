package course.springdata.xmlprocessingex1.models.dtos.view;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListCountDto {
    @XmlAttribute(name = "count")
    private int usersCount;
    @XmlElement(name = "user")
    private List<UserFnLnAgeSoldPrDto> users;

    public UserListCountDto() {
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserFnLnAgeSoldPrDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserFnLnAgeSoldPrDto> users) {
        this.users = users;
    }
}
