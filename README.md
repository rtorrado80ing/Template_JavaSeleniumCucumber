# Template_JavaSeleniumCucumber
Objetivo de este repositorio

Marco de plantilla para comenzar a automatizar con Selenium y Cucumber tanto en la interfaz de usuario como en la API (Java).

Índice

Tecnologías
Configuración
Modelo de objetos de página
Características y pepino
Página base
Ejecutando las pruebas
Informes
Tecnologías

Este proyecto fue creado con:

Selenium WebDriver: para interactuar con WebElements en la página web.
Java: Como lenguaje de programación.
Cucumber: para escribir escenarios de prueba como funciones de desarrollo impulsado por el comportamiento y colaborar con los analistas comerciales.
Informes de extensión: para generar informes HTML.
Gradle: como herramienta de construcción.
Configuración

Instale JDK (última versión estable).
Descarga los WebDrivers que usarás en tu proyecto.
Si usa Windows, especifique la ruta al controlador en BasePage.java como
System.setProperty("webdriver.chrome.driver", "/ruta/a/chromedriver");
Si está en MacOS:
Abre Terminal
Ejecute sudo nano /etc/paths
Ingresa tu contraseña
Vaya al final del archivo e ingrese la ruta que desea agregar (Mi RUTA se parece a: /Users/myname/Documents/WebDriver)
Control-x para salir
Y para guardar
Presiona enter para confirmar
Para volver a verificar, salga de Terminal y reinícielo. Ejecute echo $PATH. Debería ver su ruta recién agregada en el flujo de otras rutas que ya están allí.
¡Finalmente, actualice sus pruebas para que se ejecuten con Chrome y ejecute sus pruebas!
Instale el complemento Cucumber en el IDE de su elección.
Cree el proyecto para descargar las dependencias especificadas en Gradle.build.
## Page Object Model Este Framework utiliza el modelo de objetos de página, con una página base que se encarga de crear la instancia del controlador y los métodos heredados para interactuar con los elementos web en las clases dentro del directorio de páginas.

## Características y Cucumber

Las funciones con los escenarios que contienen las pruebas reales deben actuar como una documentación en vivo. Evite usar los escenarios para describir vagamente lo que están tratando de lograr. Haga una verificación cruzada o haga que un compañero revise el escenario, preferiblemente un analista comercial (aún mejor si puede escribir los escenarios y proporcionárselos a usted, el ingeniero de pruebas)

Página base

BasePage.java es la clase donde viven el controlador y los métodos para interactuar con las páginas web. La espera se establece una vez aquí y se usa de forma inteligente, procediendo con las acciones en caso de que se encuentre el elemento y esperando hasta el umbral establecido en esta clase. Puede cambiar esto para que se ajuste a sus necesidades.

## Ejecutando las pruebas Para ejecutar las pruebas, tiene dos opciones:

Ejecutando desde un Runner.java, especificando qué etiqueta ejecutar (usted configura las etiquetas en los Escenarios).
Ejecutando desde la línea de comando y usando:
prueba gradle -Dcucumber.options="--etiquetas @CucumberTag"
Observe que la tarea de "prueba" se crea en el archivo Gradle.Build.

Informes

Una vez ejecutado, encontrará los informes dentro del directorio Test-output, que contiene un archivo HTML que puede abrir con cualquier navegador y acceder al informe con los resultados.
