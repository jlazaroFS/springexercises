# Ejercicios de Spring

Proyecto contenedor de ejercicios de Spring.  
Programa de Formación de Becarios de Future Space S.A. (febrero 2024).

## Ejercicio 1

![Captura de Postman con el resultado](https://github.com/jlazaroFS/springexercises/blob/exercise1/ex1.PNG?raw=true)

```bash
curl --location 'http://localhost:8080/persons' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Pepe",
    "surname": "Ramos",
    "secondSurname": "Saiz",
    "dob": "1990-01-01",
    "sex": "M"
}'
# ¡COPIA LA ID PARA LUEGO PODER RECUPERAR LOS DATOS!
```

```bash
curl --location 'http://localhost:8080/persons/<ID>' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'
```
