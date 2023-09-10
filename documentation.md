# Documentatie

## Enunt problema

Aplicatia permite inregistrarea si gestionarea echipelor de fotbal. Utilizatorii se pot inregistra si conecta, iar administratorii pot adauga, edita si sterge echipe. Fiecare echipa are nume, liga, stadion, data infiintarii, detalii si lista de jucatori.


## Observatii rezolvare

- Structura initiala continea doar functionalitatile de baza pentru utilizatori si echipe
- Am adaugat campuri relevante pentru echipe: liga, stadion, data infiintarii, detalii
- Utilizatorii pot vedea detaliile unei echipe si o pot modifica daca au drepturi de admin
- Detaliile echipei permit adaugarea de informatii extinse (palmares, galerie, etc)

## Entitatea Team

- are campuri pentru nume, liga, stadion, data infiintarii, detalii
- detaliile echipei stocheaza informatii extinse despre echipa
- poate avea o lista de jucatori alocati

## Entitatea Player

- are rol de utilizator sau admin

## Entitatea Jucator

- se poate aloca unei echipe

## Alte observatii

- Autentificarea se bazeaza pe username si parola criptata
- Rolurile utilizatorilor sunt gestionate cu ajutorul enumului PlayerRole
- Echipele pot fi cautate dupa nume folosind query parameters