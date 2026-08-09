# Preguntas del Laboratorio

## 1. ¿Cuál es la diferencia entre git merge y git rebase?

Ambos comandos sirven para integrar cambios de una rama en otra, pero lo hacen de forma distinta:

- **`git merge`**: combina el historial de dos ramas creando un nuevo *commit de merge* que tiene dos padres. Conserva el historial real de cómo ocurrieron los cambios, pero puede generar un historial más "enredado" con muchos commits de merge.
- **`git rebase`**: mueve (reescribe) los commits de una rama para colocarlos justo encima de la punta de otra rama, como si se hubieran creado desde ahí. Genera un historial lineal y más limpio, pero reescribe los commits (cambia sus hashes), por lo que no se recomienda usarlo en ramas compartidas/públicas.

**En resumen:** `merge` preserva el historial tal cual pasó; `rebase` lo reescribe para que se vea lineal.

---

## 2. Si dos ramas modifican la misma línea de un archivo, ¿qué sucede al hacer merge?
Cuando dos ramas modifican la misma línea de un archivo, Git no puede decidir automáticamente cuál versión conservar, así que genera un conflicto de merge: marca el archivo con <<<<<<<, ======= y >>>>>>> mostrando ambas versiones, y es la persona quien debe editar manualmente el archivo eligiendo el contenido final, para luego hacer git add y git commit y así completar el merge.

---

## 3. ¿Cómo puedes ver gráficamente el historial de merges y ramas en consola? 
El comando correcto para ver todo el historial y las ramas desde consola es mediante el comando de "git log --oneline --graph --all --decorate", donde el git log muestra el historial de los commits, el --online muestra los commits linea a linea, --all muestra todas las ramas y el --decorate muestra nombres de ramas y etiquetas asociadas a los commits y finalmente el --graph dibuja graficamente las ramas y las uniones 

---

## 4. Explica la diferencia entre un commit y un push.

- **`git commit`**: guarda los cambios en el **repositorio local**. Crea un punto de guardado con un mensaje descriptivo, pero esos cambios solo existen en la maquina máquina.
- **`git push`**: envía los commits que tienes localmente al **repositorio remoto** (por ejemplo, en GitHub), para que otros integrantes del equipo puedan verlos y descargarlos.

**En resumen:** `commit` = guardar cambios localmente; `push` = subir esos cambios guardados al remoto.

---

## 5. ¿Para qué sirven git stash y git stash pop?
El git stash guarda los cambios que tenés sin commitear y deja la rama limpia, como si no hubieras tocado nada. git stash pop los trae de vuelta para seguir donde ibas. Sirve por ejemplo cuando necesitás cambiar de rama o hacer un pull rápido pero no querés perder lo que llevás sin terminar.

---

## 6. ¿Qué diferencia hay entre HashMap y HashTable?
Existen varias diferencias entre estos dos donde destacan principalmente que el hashMap no es sincronizado, permite una clave (key) null y varios valores null dentro de esta clave y finalmente este se destaca por su rapidez en los entornos de un solo hilo. El HashMap por otro lado si es sincronizado no permite claves (keys) ni valores (values) nulos haciendo que sea mas lento con respecto al HashMap 

---

## 7. ¿Qué ventajas tiene Collectors.toMap() frente a un bucle tradicional para llenar un mapa?

`Collectors.toMap()` se usa junto con Streams en Java para transformar una colección en un `Map` de forma declarativa. Sus ventajas frente a un bucle `for` tradicional son:

- **Código más conciso y legible**: se expresa en una sola línea la intención ("convertir esta lista en un mapa"), sin necesidad de declarar el mapa vacío y llenarlo manualmente.
- **Menos propenso a errores**: no hay que gestionar manualmente el `Map.put()` ni preocuparse por inicializar la colección.
- **Se integra con el resto del pipeline de Streams**: se puede combinar con `filter()`, `map()`, `sorted()`, etc. antes de recolectar, todo en una sola cadena de operaciones.
- **Permite manejar colisiones de claves fácilmente**: aceptando una función merge (`(v1, v2) -> ...`) como tercer argumento, algo que en un bucle tradicional hay que codificar manualmente con un `if`.
- **Favorece un estilo funcional/declarativo**: se enfoca en el "qué" se quiere obtener, no en el "cómo" iterar.

---

## 8. Si usas List con objetos y aplicas stream().map(), ¿qué tipo de operación estás haciendo?
Estás haciendo una operación de transformación (mapeo). stream().map() recorre cada elemento de la lista y lo convierte en otro valor u objeto, aplicando una función a cada uno, sin modificar la lista original. El resultado es un nuevo stream con los elementos ya transformados.

---

## 9. ¿Qué hace stream().filter() y qué retorna?
El comando filter() recorre todos los elementos de un stream() y filtra al quedarse solo con el que cumple con la condición y retorna un nuevo stream con los elementos filtrados. La función stream() es un metodo por el cual se convierten elementos en un flujo para poderse tratar de forma funcional y declarativa y asi al obtener el retorno se pueden ir encadenando con demas operaciones. 

---

## 10. Describe el paso a paso para crear una rama desde develop para una funcionalidad nueva.

1. Asegurarse de estar en la rama `develop` y que esté actualizada:
```bash
   git checkout develop
   git pull origin develop
```
2. Crear la nueva rama de tipo `feature/` a partir de `develop`:
```bash
   git checkout -b feature/nombre-de-la-funcionalidad
```
3. Verificar que se creó y que estás ubicado en ella:
```bash
   git branch
```
4. Trabajar normalmente en la nueva rama, haciendo los commits necesarios:
```bash
   git add .
   git commit -m "Descripción del cambio"
```
5. Subir la rama al repositorio remoto:
```bash
   git push origin feature/nombre-de-la-funcionalidad
```
6. Una vez terminada la funcionalidad, abrir un Pull Request para fusionarla de vuelta a `develop`.

---

## 11. ¿Cuál es la diferencia entre git branch y git checkout -b?
-git branch nombre solo crea una nueva rama, pero no te mueve a ella — te quedás trabajando en la rama en la que estabas.
-git checkout -b nombre hace las dos cosas en un solo paso: crea la rama y además te cambia a ella automáticamente.

---

## 12. ¿Por qué se recomienda usar ramas feature/ en lugar de trabajar directamente en main? 
Hay diferentes razones por las que se recomienda hacer el uso de ramas feature y trabajar en ellas y no directamente en el main. Entre ellas esta que se logra un aislamiento y estabilidad del main puesto que asi se puede hacer que cada persona o integrante que trabaja en el proyecto lo haga en su propia rama y no se afecte la de los demas y su codigo asi cada uno trabaja por separado para despues mezclar sin dañar el codigo o el repositorio. Como se dijo asi tambien se garantiza el trabajo en paralelo puesto que cada integrante puede ir trabajando por su parte para unir el trabajo posteriormente. Finalmente es mejor para control de errores y problemas pues al no cargar y trabajar sobre la rama principal se garantiza que se pueden solucionar errores antes de subirlos a la rama principal
