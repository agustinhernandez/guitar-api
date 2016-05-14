# guitar-api - Guitar API REST

## Requisitos
* Java 1.8

* Tomcat 8

* Maven 3

# Modelo

### `Guitar`
| Campo        | Tipo            | Formato                | Obligatorio |
|------------------|-----------------|------------------------|-------------|
| id | Cadena de texto | *UUID* generado por el servidor | No |
| model | Cadena de texto | Máximo 50 caracteres  | Sí |
| year | Número entero | *yyyy*  | Sí |
| classification | Cadena de texto | `ELECTRIC`, `ACOUSTIC` o `CLASICAL` | Sí |
| manufacturerId | Cadena de texto | Campo `id` de `Manufacturer` | Sí |
| bodyType | Cadena de texto | Máximo 100 caracteres | No |
| neckJoint | Cadena de texto | Máximo 100 caracteres | No |
| scaleMm | Número entero | Milímetros | No |
| bodyWood | Cadena de texto | Máximo 100 caracteres | No |
| neckWood | Cadena de texto | Máximo 100 caracteres | No |
| fretboardWood | Cadena de texto | Máximo 100 caracteres | No |
| bridge | Cadena de texto | Máximo 100 caracteres | No |
| pickup | Cadena de texto | Máximo 100 caracteres | No |
| imageBase64 | Cadena de texto | Imagen en Base 64 | No |


**Ejemplo**:

    {
      "id": "550e8400-e29b-41d4-a716-446655440000",
      "model": "Fender Stratocaster",
      "year": 1954,
      "classification": "ELECTRIC",
      "manufacturerId": "38400000-8cf0-11bd-b23e-10b96e4ef00d",
      "bodyType": "Solid",
	  "neckJoint": "Bolt-on",
	  "scaleMm": 648,
	  "bodyWood": "Alder, Ash, Poplar, Basswood",
	  "neckWood": "Maple",
	  "fretboardWood": "Maple, Rosewood, Ebony, Pao Ferro",
	  "bridge": "Usually proprietary Tremolo Hardtail",
	  "pickup": "Usually 3 Single-coils or 2 Single-coils with Hot Bridge Humbucker on certain models",
	  "imageBase64": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="
	}


### `Manufacturer`
| Campo        | Tipo            | Formato                | Obligatorio |
|------------------|-----------------|------------------------|-------------|
| id | Cadena de texto | *UUID* generado por el servidor | No |
| name | Cadena de texto | Máximo 50 caracteres  | Sí |
| formerlyCalled | Cadena de texto | Máximo 100 caracteres  | No |
| foundedYear | Número entero | *yyyy*  | No |
| foundedPlace | Cadena de texto | Máximo 100 caracteres  | No |
| founder | Cadena de texto | Máximo 100 caracteres  | No |
| headquarters | Cadena de texto | Máximo 100 caracteres  | No |
| areaServed | Cadena de texto | Máximo 100 caracteres  | No |
| website | Cadena de texto | Máximo 100 caracteres  | No |
| logoBase64 | Cadena de texto | Imagen en Base 64 | No |


**Ejemplo**:

    {
      "id": "38400000-8cf0-11bd-b23e-10b96e4ef00d",
      "name": "Fender",
      "formerlyCalled": "Fender Electric Instrument Manufacturing Company",
      "foundedYear": 1946,
      "foundedPlace": "Fullerton, California, U.S.",
      "founder": "Clarence Leonidas Fender",
      "headquarters": "Scottsdale, Arizona, USA",
      "areaServed": "Worldwide",
      "website": "fender.com",
	  "logoBase64": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="
	}
	
	
	
# Métodos
Todos los métodos requieren autenticación *HTTP Basic*. Las credenciales son:

* username: *admin*
* password: *1234*

La API está disponible en:
`https://guitar-api.herokuapp.com`

---

### GET `/guitar`
#### Listar guitarras

**URL**: https://guitar-api.herokuapp.com/guitar

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**: Ninguna

**Parámetros de Request**:

| Parámetro | Descripción | Obligatorio |
|-----------|-------------|-------------|
| page | Número de página comenzando en 0. Para calcular el último número de página: `/guitar/lastPage/{count}` | No |
| count | Número de elementos | No |

**Response Body**: Listado de `Guitar`

---

### GET `/guitar/lastPage/{count}`
#### Calcular último número de página

**URL**: https://guitar-api.herokuapp.com/guitar/lastPage/{count}

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| count | Número de elementos |

**Parámetros de Request**: Ninguno

**Response Body**: Número entero

---

### GET `/guitar/orderByYear`
#### Listar guitarras ordenadas por año

**URL**: https://guitar-api.herokuapp.com/guitar/orderByYear

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**: Ninguna

**Parámetros de Request**:

| Parámetro | Descripción | Obligatorio |
|-----------|-------------|-------------|
| page | Número de página comenzando en 0 | No |
| count | Número de elementos | No |

**Response Body**: Listado de `Guitar`

---

### GET `/guitar/filterByManufacturer/{manufacturerId}`
#### Listar guitarras filtradas por marca

**URL**: https://guitar-api.herokuapp.com/guitar/filterByManufacturer/{manufacturerId}

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| manufacturerId | Campo `id` de `Manufacturer` |

**Parámetros de Request**:

| Parámetro | Descripción | Obligatorio |
|-----------|-------------|-------------|
| page | Número de página comenzando en 0 | No |
| count | Número de elementos | No |

**Response Body**: Listado de `Guitar`

---

### GET `/guitar/{id}`
#### Obtener guitarra

**URL**: https://guitar-api.herokuapp.com/guitar/{id}

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| id | Campo `id` de `Guitar` |

**Parámetros de Request**: Ninguno

**Response Body**: `Guitar`

---

### POST `/guitar`
#### Crear guitarra

**URL**: https://guitar-api.herokuapp.com/guitar

**HTTP method**: POST

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Variables de Path**: Ninguna

**Parámetros de Request**: Ninguno

**Request Body**: `Guitar`

**Response Body**: Mensajes de éxito o error

---

### PUT `/guitar/{id}`
#### Editar guitarra

**URL**: https://guitar-api.herokuapp.com/guitar/{id}

**HTTP method**: PUT

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| id | Campo `id` de `Guitar` |

**Parámetros de Request**: Ninguno

**Request Body**: `Guitar`

**Response Body**: Mensajes de éxito o error

---

### DELETE `/guitar/{id}`
#### Borrar guitarra

**URL**: https://guitar-api.herokuapp.com/guitar/{id}

**HTTP method**: DELETE

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| id | Campo `id` de `Guitar` |

**Parámetros de Request**: Ninguno

**Request Body**: Ninguno

**Response Body**: Mensajes de éxito o error

---

### GET `/manufacturer`
#### Listar marcas

**URL**: https://guitar-api.herokuapp.com/manufacturer

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**: Ninguna

**Parámetros de Request**: Ninguno

**Response Body**: Listado de `Manufacturer`

---

### GET `/manufacturer/{id}`
#### Obtener marca

**URL**: https://guitar-api.herokuapp.com/manufacturer/{id}

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| id | Campo `id` de `Manufacturer` |

**Parámetros de Request**: Ninguno

**Response Body**: `Manufacturer`

---

### POST `/manufacturer`
#### Crear marca

**URL**: https://guitar-api.herokuapp.com/manufacturer

**HTTP method**: POST

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Variables de Path**: Ninguna

**Parámetros de Request**: Ninguno

**Request Body**: `Manufacturer`

**Response Body**: Mensajes de éxito o error

---

### PUT `/manufacturer/{id}`
#### Editar marca

**URL**: https://guitar-api.herokuapp.com/manufacturer/{id}

**HTTP method**: PUT

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Variables de Path**:

| Variable | Descripción |
|----------|-------------|
| id | Campo `id` de `Manufacturer` |

**Parámetros de Request**: Ninguno

**Request Body**: `Manufacturer`

**Response Body**: Mensajes de éxito o error

---

# Ejemplos de uso

### Listar guitarras con paginación

**URL**: https://guitar-api.herokuapp.com/guitar?page=0&count=2

**HTTP method**: GET

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |

**Response Body**:

    [
        {
            "id": "550e8400-e29b-41d4-a716-446655440000",
            "model": "Fender Stratocaster",
            "year": 1954,
            "classification": "ELECTRIC",
            "manufacturerId": "38400000-8cf0-11bd-b23e-10b96e4ef00d",
            "bodyType": "Solid",
            "neckJoint": "Bolt-on",
            "scaleMm": 648,
            "bodyWood": "Alder, Ash, Poplar, Basswood",
            "neckWood": "Maple",
            "fretboardWood": "Maple, Rosewood, Ebony, Pao Ferro",
            "bridge": "Usually proprietary Tremolo Hardtail",
            "pickup": "Usually 3 Single-coils or 2 Single-coils with Hot Bridge Humbucker on certain models",
            "imageBase64": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="
        },
        {
            "id": "3b18219f-1a35-4030-b5a7-5d4d148aab0e",
            "model": "Fender Telecaster",
            "year": 1950,
            "classification": "ELECTRIC",
            "manufacturerId": "38400000-8cf0-11bd-b23e-10b96e4ef00d",
            "bodyType": "Solid",
            "neckJoint": "Bolt-on",
            "scaleMm": 650,
            "bodyWood": "Alder, Ash, Poplar, Pine, Basswood",
            "neckWood": "Maple",
            "fretboardWood": "Maple, Rosewood",
            "bridge": "Proprietary 'Ashtray' or modern style with string through or top load strings.",
            "pickup": "Traditionally two single-coils. Combinations with 1 to 3 pickups, including humbuckers have been produced",
            "imageBase64": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="
        }
    ]

---
    
### Crear guitarra

**URL**: https://guitar-api.herokuapp.com/guitar

**HTTP method**: POST

**Headers**:

| key | Value |
|-----|-------|
| Authorization | Basic YWRtaW46MTIzNA== |
| Content-Type | application/json |

**Request Body**:

    {
        "model": "Fender Jaguar",
        "year": 1962,
        "classification": "ELECTRIC",
        "manufacturerId": "38400000-8cf0-11bd-b23e-10b96e4ef00d",
        "bodyType": "Solid",
        "neckJoint": "Bolt-on",
        "scaleMm": 610,
        "bodyWood": "Usually Alder, Basswood",
        "neckWood": "Maple",
        "fretboardWood": "Usually Rosewood",
        "bridge": "'Floating' proprietary vibrato, unit, Tune-o-matic",
        "pickup": "Usually two Single-coil",
        "imageBase64": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAASABIAAD/4QBARXhpZgAATU0k3l8SoQwDEA85z9aMXjfa8to2jFWSLw2F9nzczvJ6tn//2Q=="
    }

**Response Body**:

    {
        "successMessage": "Guitar created successfully."
    }
