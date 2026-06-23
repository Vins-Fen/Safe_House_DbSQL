drop database if exists Piattaforma_Prenotazione_Camere;
Create Database Piattaforma_Prenotazione_Camere;
use Piattaforma_Prenotazione_Camere;

Create table Telefono(
                         Numero varchar(10) primary key,
                         Prefisso varchar(3) not null
);

Create table Stanze(
                        Codice varchar(4) primary key,
                        Stato char(20) not null,
                        Tipo varchar(20) not null,
                        Capienza int,
                        Giorno_Pre date,
                        Check_in datetime,
                        Check_out datetime,
                        Servizi_Offerti char(30),
                        Fascia_Oraria varchar(20)
);

Create table Clienti
(
    Nome char(20) not null,
    Cognome char(20) not null,
    CF varchar(20) primary key,
    Numero_Civico int,
    Via varchar(20),
    Cap int(5)
);

Create table Prenotazione(
                             N_Prenotazione int(4) primary key ,
                             C_CF varchar(20),
                             Data date,
                             Ora time,

                         foreign key (C_CF) references Clienti(CF)

);
CREATE TABLE Staff
(
    staff_id varchar(4) primary key,
    ruolo    varchar(10)

);

Create table Occupazione
(
    N_Prenotazione int(4),
    Codice varchar(4),

    primary key(N_Prenotazione,Codice),
    foreign key (N_Prenotazione) references Prenotazione(N_Prenotazione),
    foreign key (Codice) references Stanze(Codice)
);

CREATE TABLE Recapito
(
    Codice varchar(4),
    Numero varchar(10),

    primary key (Codice, Numero),
    foreign key(Codice) references Stanze(Codice)

);

CREATE TABLE Assegnamento
(
    Codice varchar(4),
    staff_id varchar(4),

    foreign key(Codice) references Stanze(Codice),
    foreign key(staff_id) references Staff(staff_id)
);

Insert into Clienti
values('Pietro', 'Smusi', 'ASMR00E3971QI', 40, 'Armando Maradona' , 81055);

use Piattaforma_Prenotazione_Camere;
SELECT *
from Stanze