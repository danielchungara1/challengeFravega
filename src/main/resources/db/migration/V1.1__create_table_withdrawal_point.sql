CREATE TABLE withdrawal_point
(
    id             BIGSERIAL PRIMARY KEY,
    address        VARCHAR(255) NOT NULL,
    capacity_m3    numeric(9,2) NOT NULL,
    latitude       numeric(8,6) NOT NULL,
    longitude      numeric(9,6) NOT NULL
);