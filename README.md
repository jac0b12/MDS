# *Medidor de salario (MDS)* 

## Nuestro proyecto esta conformado por la siguientes personas:

> * Simón Rojas Castaño
> * Jacobo Patiño Castro
> * Juan José Sénchez Ramirez

## Descripción
 La aplicación "Medidor de Salario" permite calcular el salario de un usuario en función de las horas trabajadas, incluyendo diferentes tipos de horas (ordinarias, nocturnas, dominicales, etc.), de esta manera generando mas claridad a la hora del pago como para el empleador como para el empleado. Este proyecto está desarrollado en **Android Studio** y utiliza **SQLite** para almacenar datos de usuarios y horas trabajadas.

## Características
- Registro de horas trabajadas clasificadas (ordinarias, nocturnas, dominicales).
- Cálculo del salario total basado en el tipo y cantidad de horas.
- Autenticación de usuarios.
- Interfaz intuitiva para el registro y visualización de horas trabajadas.

## Estructura del Proyecto
* Medidor de Salario/ 
* ├── app/ 
* │ ├── src/ 
* │ │ ├── main/ 
* │ │ │ ├── java/com/jacoo/medidordesalario/ 
* │ │ │ │ ├── Calendario.kt # Gestión del calendario para registrar horas trabajadas 
* │ │ │ │ ├── Centralpage.kt # Pantalla principal de la aplicación 
* │ │ │ │ ├── ConexionSQLite.java # Clase para gestionar la conexión con la base de datos SQLite 
* │ │ │ │ ├── Login.kt # Pantalla de inicio de sesión 
* │ │ │ │ ├── Modelo.kt # Modelos de datos de la aplicación 
* │ │ │ │ ├── Register.kt # Pantalla de registro de usuarios 
* │ │ │ │ ├── SalarioCalculado.kt # Pantalla que muestra el cálculo del salario 
* │ │ │ │ ├── UsuariosDTO.kt # Data Transfer Object para usuarios 
* │ │ │ │ └── WelcomePage.kt # Página de bienvenida con navegación al registro 
* │ │ │ ├── res/ 
* │ │ │ │ ├── layout/ 
* │ │ │ │ │ ├── activity_calendar.xml # Layout para el calendario 
* │ │ │ │ │ ├── activity_centralpage.xml # Layout de la página principal 
* │ │ │ │ │ ├── activity_login.xml # Layout del inicio de sesión 
* │ │ │ │ │ ├── activity_register.xml # Layout de registro de usuarios
* │ │ │ │ │ ├── activity_salariocalculado.xml # Layout para mostrar el salario calculado 
* │ │ │ │ └── drawable/ 
* │ │ └── AndroidManifest.xml # Manifesto de la aplicación 
* ├── README.md # Documentación del proyecto 
* └── build.gradle # Configuración de construcción

## Enfasis
 Nuestra idea principal es crear una aplicacion movil para medir el salario de una persona en base sus horas trabajadas y hacer una comparativa con el contrato de su empresa para asi saber si es rentable o no.

## Configuración de Base de Datos
 Este proyecto utiliza SQLite para almacenar la información de los usuarios y sus horas trabajadas. La clase `ConexionSQLite.java` se encarga de gestionar la conexión con la base de datos. 
 
## Orden

**1. Pantalla de Bienvenida**: Desde aquí, puedes navegar al registro de usuarios o al inicio de sesión.
**2. Registro de Usuario**: Completa el formulario de registro para crear un nuevo usuario.
**3. Inicio de Sesión**: Ingresa con tus credenciales para acceder a la aplicación.
**4. Página Principal**: Aquí puedes acceder al calendario para registrar las horas trabajadas.
**5. Registro de Horas**: Selecciona el tipo de horas trabajadas (ordinarias, nocturnas, dominicales) y guarda la información.
**6. Cálculo de Salario**: Dirígete a la pantalla de cálculo, donde se mostrará el salario total basado en las horas registradas.

## Archivos Clave
- **calendario.kt**: Define la lógica para registrar y almacenar las horas trabajadas en la base de datos.
- **salariocalculado.kt**: Calcula y muestra el salario total.
- **conexionsqlite.java**: Gestiona la conexión con la base de datos SQLite y las operaciones CRUD.
- **login.kt** y **register.kt**: Manejan la autenticación de usuarios.

## Errores Comunes y Soluciones
- Problema con el tamaño del toque en los campos `EditText`: La aseguracion de que los campos tienen un tamaño mínimo de 48dp para mejorar la accesibilidad.
- Opciones de `Image Asset` no disponibles: Cambia a la vista Android en el explorador de archivos para ver esta opción.
- Advertencias de contraste de color: Verifica que el color de fondo y el de texto tengan suficiente contraste para mejorar la accesibilidad.

## Licencia

Este proyecto está bajo la licencia MIT.

## Pagina usada

Este sitio web se creo desde: `https://github.com/jac0b12/MDS`.


---

Este archivo `README.md` ofrece una guía completa para entender y trabajar con tu proyecto. Puedes ajustar los detalles según las necesidades específicas o agregar más información sobre cómo calcular el salario si fuera necesario.
