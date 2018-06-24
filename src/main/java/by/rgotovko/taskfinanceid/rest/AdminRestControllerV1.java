package by.rgotovko.taskfinanceid.rest;

import by.rgotovko.taskfinanceid.model.Request;
import by.rgotovko.taskfinanceid.model.Status;
import by.rgotovko.taskfinanceid.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/admin/requests")
public class AdminRestControllerV1 {

    private final RequestService requestService;

    @Autowired
    public AdminRestControllerV1(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> requests = this.requestService.getAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @RequestMapping(path = "/{requestId}/done", method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Request> setStatusDone(@PathVariable Integer requestId) {
        if (requestId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Request request = requestService.getById(requestId);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        request.setStatus(Status.DONE);
        this.requestService.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @RequestMapping(path = "/{requestId}/reject", method = RequestMethod.PATCH,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Request> setStatusRejected(@PathVariable Integer requestId) {
        if (requestId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Request request = requestService.getById(requestId);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        request.setStatus(Status.REJECTED);
        this.requestService.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @RequestMapping(path = "/statistics/done", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Integer>> getDoneRequestsCount() {
        return new ResponseEntity<>(Collections.singletonMap("done_requests",
                this.requestService.getAllByStatus(Status.DONE).size()), HttpStatus.OK);
    }

    @RequestMapping(path = "/statistics/rejected", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Integer>> getRejectedRequestsCount() {
        return new ResponseEntity<>(Collections.singletonMap("rejected_requests",
                this.requestService.getAllByStatus(Status.REJECTED).size()), HttpStatus.OK);
    }

}
