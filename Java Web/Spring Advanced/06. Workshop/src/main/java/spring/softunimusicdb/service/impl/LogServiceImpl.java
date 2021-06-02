package spring.softunimusicdb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.entities.AlbumEntity;
import spring.softunimusicdb.model.entities.LogEntity;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.service.LogServiceModel;
import spring.softunimusicdb.repository.LogRepository;
import spring.softunimusicdb.service.AlbumService;
import spring.softunimusicdb.service.LogService;
import spring.softunimusicdb.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;
    private final AlbumService albumService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public LogServiceImpl(LogRepository logRepository, AlbumService albumService, UserService userService, ModelMapper modelMapper) {
        this.logRepository = logRepository;
        this.albumService = albumService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createLog(String action, Long albumId) {
        AlbumEntity albumEntity = modelMapper.map(albumService.findById(albumId), AlbumEntity.class);

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();
        UserEntity userEntity = userService.findByUsername(username);

        LogEntity logEntity = new LogEntity()
                .setAlbumEntity(albumEntity)
                .setUserEntity(userEntity)
                .setAction(action)
                .setDateTime(LocalDateTime.now());

        logRepository.saveAndFlush(logEntity);
    }

    @Override
    public List<LogServiceModel> findAllLogs() {
        return logRepository
                .findAll()
                .stream()
                .map(entity -> {
                    LogServiceModel serviceModel = modelMapper.map(entity, LogServiceModel.class);
                    return serviceModel.setAlbum(entity.getAlbumEntity().getName())
                            .setUser(entity.getUserEntity().getUsername());
                })
                .collect(Collectors.toList());
    }
}
