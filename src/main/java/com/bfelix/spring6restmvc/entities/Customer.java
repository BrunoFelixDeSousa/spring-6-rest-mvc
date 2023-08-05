package com.bfelix.spring6restmvc.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {

    private String name;
    private UUID id;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
