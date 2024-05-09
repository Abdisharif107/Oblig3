CREATE TABLE Billett
(
    id SERIAL NOT NULL ,
    film CHAR(255) NOT NULL,
    antall VARCHAR NOT NULL,
    fornavn VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    mobilnummer VARCHAR(255) NOT NULL,
    epost VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

