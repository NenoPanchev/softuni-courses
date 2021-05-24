package spring.softunimusicdb.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.softunimusicdb.service.ArtistService;
import spring.softunimusicdb.service.UserRoleService;
import spring.softunimusicdb.service.UserService;

@Component
public class MusicDBAppInit implements CommandLineRunner {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final ArtistService artistService;

    @Autowired
    public MusicDBAppInit(UserService userService, UserRoleService userRoleService, ArtistService artistService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.artistService = artistService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.userRoleService.seedUserRoles();
        this.userService.seedUsers();
        this.artistService.seedArtists();
    }
}
