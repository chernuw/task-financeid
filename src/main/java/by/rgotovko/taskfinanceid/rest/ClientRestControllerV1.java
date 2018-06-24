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
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/client/requests")
public class ClientRestControllerV1 {

    private final RequestService requestService;

    @Autowired
    public ClientRestControllerV1(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Request> registerRequest(@RequestBody Request request) {
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        request.setStatus(Status.OPEN);
        request = this.requestService.save(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{requestId}/status", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Status>> getStatusOfRequest(@PathVariable Integer requestId) {
        if (requestId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Request request = requestService.getById(requestId);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Collections.singletonMap("status", request.getStatus()), HttpStatus.OK);
    }
}
