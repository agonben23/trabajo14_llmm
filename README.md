# trabajo14_llmm


## Descripción de la aplicación

Esta aplicación realiza la gestión de notas almacenadas en archivos XML.

El archivo XML que usará se encuentra en *src\main\resources\notas.xml*

<a name="XML"></a>
~~~
<?xml version="1.0"?>
<notas>
   <nota id="nota1">
      <titulo>Cosas que hacer</titulo>
      <fechaDeCreacion>2021/04/02</fechaDeCreacion>
      <contenido>Ir a comprar comida</contenido>
   </nota>
   <nota id="nota2">
      <titulo>Películas por ver</titulo>
      <fechaDeCreacion>2021/04/02</fechaDeCreacion>
      <contenido>Star Trek, Spiderman</contenido>
   </nota>
</notas>
~~~

*Vista previa del documento XML utilizado*

---
## Guía para el acceso a la aplicación

El programa ha sido creado con el entorno gráfico IntelliJ IDEA, por lo cual se deberá ejecutar en dicho programa.

En caso de no conocer el funcionamiento de este entorno gráfico en estos enlaces encontrará información sobre ello:

[Guia de instalación de IntelliJ](https://www.jetbrains.com/help/idea/installation-guide.html)

[Como clonar un repositorio de GitHub en IntelliJ](https://danielme.com/2013/08/07/importar-repositorios-de-github-con-git-o-eclipse/)

---

## Guía para el uso de la aplicación

Una vez clonado el repositorio, ejecute el programa abriendo el archivo encontrado en *src\main\kotlin\main.kt* y clicando en el botón triangular que se encuentra al lado de la función *main*.

A continuación, se abrirá un ventana de comandos con la aplicación ejecutándose.

Aparecerá el menú con las opciones :

~~~
¿Qué deseas hacer?
-r Mostrar todos las notas
-r [id] Muestra la nota con la id elegida
-m [id] Modifica la nota seleccionada
-d [id] Elimina la nota seleccionada
-exit Salir del programa
~~~

En el caso de usar una id, la aplicación consultará el [atributo id de la etiqueta nota](#xml)

Seleccione la opción deseada, por ejemplo :

- Si quiere mostrar la nota con la id *nota1*, deberá usar el siguiente comando 
~~~
-r nota1
~~~
- Si prefiere modificar la nota con la id *nota2*, deberá usar el siguiente comando
~~~
-m nota2
~~~

El programa funcionará en bucle hasta que el usuario introduzca el comando de salida del programa
~~~
-exit
~~~