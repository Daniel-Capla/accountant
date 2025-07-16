package com.dgtfactory.accountant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;
import java.util.UUID;

@Entity
public class FixedFee extends Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @CreationTimestamp(source = SourceType.DB)
    Instant createdAt;
}
