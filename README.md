# guitar-api - Guitar API REST

## Requisitos
* Java 1.8

* Tomcat 8

* Maven 3

## Modelo

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