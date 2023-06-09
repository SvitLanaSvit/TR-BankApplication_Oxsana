package com.example.bank_application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.security.Timestamp;

@Value
public class AccountDto {
    String id;
    String name;
    String type;
    String status;
    String balance;
    String currencyCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Timestamp createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Timestamp updatedAt;
}
