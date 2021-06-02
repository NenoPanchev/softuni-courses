package spring.softunimusicdb.service;

import spring.softunimusicdb.model.service.AlbumServiceModel;
import spring.softunimusicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    List<AlbumViewModel> showAllView();
    void create(AlbumServiceModel albumServiceModel);
    AlbumServiceModel findById(Long id);

    void delete(Long id);
}
