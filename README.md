
# Challenge search app!!

Aplicación android para buscar productos y ver su detalle, la información se carga desde las API's que mercado libre tiene disponibles para la comunidad, desarrollada bajo la arquitectura MVVM.
 
 ## Instalación
 

### 1. Instalar Android Studio

Antes de comenzar, asegúrate de tener Android Studio instalado en tu máquina. Si no lo tienes, puedes descargarlo desde [aquí](https://developer.android.com/studio).

### 2. Clonar el repositorio de GitHub

1.  **Obtener el URL del repositorio:**
    -   Haz clic en el botón verde "Code" y copia la URL del repositorio.

2.  **Clonar el repositorio usando Android Studio:**
    
    -   Abre Android Studio.
    -   En la pantalla de bienvenida, selecciona "Get from VCS" (Get from Version Control).
    -   En el campo "URL", pega la URL del repositorio de GitHub.
    -   Selecciona el directorio en tu máquina donde quieres clonar el proyecto.
    -   Haz clic en "Clone".

### 3. Abrir el proyecto en Android Studio

1.  **Abrir proyecto:**
    
    -   Una vez que el proyecto se haya clonado, Android Studio debería abrir el proyecto automáticamente. Si no es así, selecciona "Open" en la pantalla de bienvenida y navega hasta el directorio donde clonaste el proyecto.
2.  **Permitir que Android Studio descargue las dependencias:**
    
    -   Android Studio debería empezar a descargar todas las dependencias del proyecto automáticamente. Esto puede tomar unos minutos.

3.  **Sincronizar el proyecto con Gradle:**
    
    -   Asegúrate de que el proyecto esté sincronizado con Gradle. Si ves un botón amarillo en la parte superior que dice "Sync Now", haz clic en él.

### 4. Ejecutar la aplicación

1.  **Ejecutar la aplicación:**
    -   Haz click Run en la barra de herramientas y la opción "Run app".
    -   Selecciona tu dispositivo físico o el emulador.
    -   Android Studio compilará y ejecutará la aplicación en el dispositivo seleccionado.
    
## Funcionalidades

La app cuenta con las siguientes funcionalidades:
 1. Campo de búsqueda. 
2. Visualización de resultados de la búsqueda con su detalle. 
3. Detalle total del un producto. 

Casos de uso:

[![casos-uso.png](https://i.postimg.cc/hjT5063j/casos-uso.png)](https://postimg.cc/WFp8NWVL)


## Estructura

Se desarrollo bajo la arquitectura MVVM que se compone por tres capas:

- **Modelo** : contiene los datos de la aplicación. No puede hablar directamente con la vista. Generalmente, se recomienda exponer los datos a ViewModel a través de Observables.

- **Vista** : representa la interfaz de usuario. Observa el ViewModel.

- **ViewModel** Actúa como enlace entre el Modelo y la Vista. Es responsable de transformar los datos del Modelo. Proporciona flujos de datos a la vista. También usa ganchos o devoluciones de llamada para actualizar la Vista.

[![estructura.png](https://i.postimg.cc/5tcGFfnG/estructura.png)](https://postimg.cc/PC4KgnGz)

Construida con el componente navigation, que utiliza un gráfico de navegación para administrar el aspecto de la app:

[![navigation.png](https://i.postimg.cc/QxQSncb6/navigation.png)](https://postimg.cc/Wh4MdFxr)

 
## Test

Resultado de pruebas:

[![test.png](https://i.postimg.cc/qqLh2BsG/test.png)](https://postimg.cc/JHszLLdy)

## Firebase crashlytics

Se implementa en el proyecto crashlytics para capturar los crash que tenga la app y poder tener una mayor información y control de los mismos.

Ejemplo:

[![Screenshot-2023-02-21-at-11-27-55-PM.png](https://i.postimg.cc/zf3VYp4x/Screenshot-2023-02-21-at-11-27-55-PM.png)](https://postimg.cc/Mc2Wy06B)


## Android Profiler

Resultado de pruebas en Android Profiler, que ayuda a identificar fugas y pérdidas de memoria que puedan generar inestabilidades, fallas e incluso bloqueos en la app:

[![memory.png](https://i.postimg.cc/YqQdj0Xm/memory.png)](https://postimg.cc/TpYV4dvR)


## Resumen

- Introducción.
- Instalación.
- Tipo de arquitectura utilizada.
- Resultados test.
- Firebase crashlytics.
-  Android Profiler.
