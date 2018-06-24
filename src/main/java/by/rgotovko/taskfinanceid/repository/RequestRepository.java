package by.rgotovko.taskfinanceid.repository;

import by.rgotovko.taskfinanceid.model.Request;
import by.rgotovko.taskfinanceid.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> findAllByStatus(Status status);
}
