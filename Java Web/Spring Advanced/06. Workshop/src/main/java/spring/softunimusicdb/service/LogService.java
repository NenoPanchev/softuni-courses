package spring.softunimusicdb.service;

import spring.softunimusicdb.model.service.LogServiceModel;

import java.util.List;

public interface LogService {
    void createLog(String action, Long albumId);

    List<LogServiceModel> findAllLogs();
}
