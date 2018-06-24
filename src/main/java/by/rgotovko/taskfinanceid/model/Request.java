package by.rgotovko.taskfinanceid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "request")
    private String request;

    @Column(name = "bid")
    private BigDecimal bid;

    @Column(name = "due_date")
    @JsonProperty("due_date")
    private LocalDate dueDate;

    @Column(name = "status", columnDefinition = "varchar(10) default 'OPEN'")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
