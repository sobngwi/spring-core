package com.sobngwi.entities;

import lombok.Cleanup;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.math.BigDecimal;

@Data
@Slf4j
public class Account {


    private Long id;
    private BigDecimal balance;
    
    public Account() {}

    public Account(Long id, BigDecimal balance) {
        log.info("Constructor is calling with id :[{}], balance :[{}]", id, balance);
        this.id = id;
        this.balance = balance;
    }

    public static void main(String[] args) throws IOException {
        @Cleanup  InputStream in = new FileInputStream("entry.txt") ;
        @Cleanup  OutputStream out = new FileOutputStream("out.txt");
    }
}
