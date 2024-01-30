<h1>To Do List</h1>

   <p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
   </p>

To Do List es un proyecto realizado con fines educativos para practicar y aprender a realizar APIs sencillas en Spring Boot,
el proyecto solo constara de BackEnd, no se desarrollara ninguna capa de visualizacion. Se recomienda Postman para probar el proyecto.
Constara de un CRUD sencillo para las tareas.

## Índice
* [Funcionalidades del proyecto](#id1)
* [Tecnologias utilizadas](#id2)
* [Hoja de ruta](#id3)

## :hammer:Funcionalidades del proyecto <a name="id1"></a>
- Alta de tareas
- Listar tareas por Id
- Listar todas las tareas
- Modificar tareaas
- Eliminar tareas por Id

## Tecnologias Utilizadas<a name="id2"></a>
- Spring Boot 3.2.2
- Java 17
- Maven
- Base de datos H2 en memoria

## Hoja de ruta<a name="id3"></a>
- Elaboracion de CRUD basico :heavy_check_mark:
- Añadir DAO Y DTO :heavy_check_mark:
- Añadir ResponseEntity :heavy_check_mark:
- Añadir Controler Advice BadRequest IdNotFound :heavy_check_mark:
- Añadir DTO para error IdNotFound :heavy_check_mark:
- Añadir Validaciones con Jakarta 
    - POST TaskSinFechaModificacion -> Id: debe se nulo / status: debe ser un numero entre 1 y 4 ambos incluidos y no puede ser nulo
    - PUT Task -> Id: debe ser positivo y no nulo / status: debe ser un numero entre 1 y 4 ambos incluidos y no puede ser nulo
- Añadair documentacion con Open Api 
- Añadir Spring Security 
