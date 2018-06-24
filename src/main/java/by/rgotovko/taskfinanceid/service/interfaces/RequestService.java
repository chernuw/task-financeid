package by.rgotovko.taskfinanceid.service.interfaces;

import by.rgotovko.taskfinanceid.model.Request;
import by.rgotovko.taskfinanceid.model.Status;

import java.util.List;

public interface RequestService {
    Request save(Request request);

    Request getById(Integer id);

    List<Request> getAllByStatus(Status status);

    List<Request> getAll();
}
