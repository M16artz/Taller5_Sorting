# Taller5_Sorting
Este proyecto implementa y compara tres algoritmos de ordenación básicos (in-place) en Java: Inserción, Selección y Burbuja. El objetivo es validar su funcionamiento en arreglos pequeños mediante trazas de ejecución y un conjunto de casos de prueba reproducibles.
# Algoritmos Implementados
InsertionSort (Ordenamiento por Inserción): Implementación estándar.
SelectionSort (Ordenamiento por Selección): Implementación estándar, optimizada para mínimos swaps.
BubbleSort (Ordenamiento de Burbuja): Implementación con optimización de corte temprano (finaliza si una pasada no produce intercambios).
# Cómo ejecutar la Demostración
RECOMENDACIÓN: Usar Netbeans como ide de ejecución para apreciar el cómo fué desarrollado la presentación en pantalla.
Link de demostracion de la presentación en consola: https://youtu.be/pY-PNSgeTYo
1. Clona este repositorio.
2. Asegúrate de tener el JDK de OpenJDK instalado.
3. Compila los archivos Java desde la raíz del proyecto (directorio src):
    javac ed/u2/sorting/*.java

4. Ejecuta la clase principal SortingDemo:
     java ed.u2.sorting.SortingDemo
# **Menú Interactivo**
El programa mostrará un menú principal para:
  **Seleccionar Datos:**
    1. Usar un caso de prueba predefinido (A, B, C, D, E).
    2. Generar un arreglo aleatorio de tamaño N.
    3. Ingresar un arreglo manualmente.
  **Ejecutar Ordenación:**
    1. Una vez seleccionado un arreglo, podrás elegir qué algoritmo ejecutar (Inserción, Selección o Burbuja).
    2. El sistema te preguntará si deseas ejecutarlo CON trazas (S/N). La traza es esencial para generar las evidencias de la práctica.
 Casos de Prueba (Datasets)
Se utilizan los siguientes datasets para la validación:
ID
Arreglo Original
Arreglo Ordenado Esperado
Notas
A
[8, 3, 6, 3, 9]
[3, 3, 6, 8, 9]
Caso general con duplicados
B
[5, 4, 3, 2, 1]
[1, 2, 3, 4, 5]
Peor caso (Orden inverso)
C
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 5]
Mejor caso (Ya ordenado)
D
[2, 2, 2, 2]
[2, 2, 2, 2]
Todos los elementos iguales
E
[9, 1, 8, 2]
[1, 2, 8, 9]
Caso general

