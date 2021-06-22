CREATE TABLE branch_office
(
    id             BIGSERIAL PRIMARY KEY,
    address        VARCHAR(255) NOT NULL,
    attention      VARCHAR(255) NOT NULL,
    latitude       numeric(8,6) NOT NULL,
    longitude      numeric(9,6) NOT NULL
);