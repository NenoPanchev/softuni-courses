package coursespringdata.jsonprocessingex1.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserListCountDto {
    @Expose
    private int usersCount;
    @Expose
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
