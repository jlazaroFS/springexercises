# Ejercicios de Spring

Proyecto contenedor de ejercicios de Spring.  
Programa de Formación de Becarios de Future Space S.A. (febrero 2024).

## Ejercicio 3

![Captura de Postman con el resultado del apartado 1](https://github.com/jlazaroFS/springexercises/blob/exercise3/ex3_1.PNG?raw=true)
![Captura de Postman con el resultado del apartado 2](https://github.com/jlazaroFS/springexercises/blob/exercise3/ex3_2.PNG?raw=true)
![Captura de Postman con el resultado del apartado 3](https://github.com/jlazaroFS/springexercises/blob/exercise3/ex3_3.PNG?raw=true)

```bash
curl --location 'http://localhost:8080/persons/00000000T' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'
```

```bash
curl --location --request PUT 'http://localhost:8080/persons/00000000T' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "dni": "00000000T",
    "name": "Sobrescrito",
    "surname": "Sobrescrito",
    "secondSurname": "Sobrescrito",
    "dob": "2024-01-01",
    "sex": "X"
}
'
```
