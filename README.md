# Test task from Finance ID

Technologies:

* Java 8
* Maven
* Spring Boot
* MySQL
* Spring Data
* Tomcat (including in spring boot starter)
* Lombok (For getters/setters and logging)

# Requests

All http-requests produce and consume (which have request body) `MediaType.APPLICATION_JSON_UTF8_VALUE`

## Client `/api/v1/client/requests`

Task | Method | Path | Body
---- | ------ | ---- | ----
Register new request | `POST` | `/register`| ```{"request":"сделать тестовое по заявкам", "bid":123.321, "due_date":"2018-05-26"}```
Get status of request | `GET` | `/{requestId}/status`

## Admin `/api/v1/admin/requests`
Task | Method | Path 
---- | ------ | ---- 
Get all requests | `GET` | `/`
Set status DONE | `PATCH` | `/{requestId}/done`
Set status REJECTED | `PATCH` | `/{requestId}/reject`
Get count requests with status DONE | `GET` | `/statistics/done`
Get count requests with status REJECTED | `GET` | `/statistics/rejected`


