CREATE TABLE fee
(
    id               UUID NOT NULL,
    transaction_type VARCHAR(255),
    fee              DECIMAL,
    fee_currency     VARCHAR(255),
    created_at       TIMESTAMP WITH TIME ZONE,
    comment          VARCHAR(255),
    CONSTRAINT pk_fee PRIMARY KEY (id)
);