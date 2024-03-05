package com.coppel.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DataBaseDto {
    
    String ipAddress;

    String name;

    String password;

    String userName;

    String portNumber;
}
