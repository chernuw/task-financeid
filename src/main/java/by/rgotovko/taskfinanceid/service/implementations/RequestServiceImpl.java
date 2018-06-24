package by.rgotovko.taskfinanceid.service.implementations;

import by.rgotovko.taskfinanceid.model.Request;
import by.rgotovko.taskfinanceid.model.Status;
import by.rgotovko.taskfinanceid.repository.RequestRepository;
import by.rgotovko.taskfinanceid.service.interfaces.RequestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request save(Request request) {
        return null;
    }

    @Override
    public Request getById(Integer id) {
        return null;
    }

    @Override
    public Request getByName(String request) {
        return null;
    }

    @Override
    public Request update(Request request, Integer id) {
        return null;
    }

    @Override
    public List<Request> getAllByStatus(Status status) {
        return null;
    }

    @Override
    public List<Request> getAll() {
        log.info("IN RequestServiceImpl getAll ()");
        return requestRepository.findAll();
    }
}
