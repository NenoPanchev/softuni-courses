package spring.softunimusicdb.web;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.softunimusicdb.model.view.AlbumViewModel;
import spring.softunimusicdb.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumRestController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumRestController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api")
    public ResponseEntity<List<AlbumViewModel>> findAll() {
        List<AlbumViewModel> albumViewModels = albumService
                .showAllView();

        return ResponseEntity
                .ok()
                .body(albumViewModels);
    }
}
