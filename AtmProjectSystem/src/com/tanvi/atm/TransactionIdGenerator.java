package com.tanvi.atm;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TransactionIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return generateTransactionId();
    }

    private String generateTransactionId() {

        long timestamp = System.currentTimeMillis();
        int randomSuffix = new Random().nextInt(1000000); // Adjust the range based on your requirements

        String transactionId = String.valueOf(timestamp) + String.format("%06d", randomSuffix);

        return transactionId.substring(0, Math.min(transactionId.length(), 18)); // Trim to a maximum length of 18
    }
}
