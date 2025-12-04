# Tarea 1 | Entrega Parcial 2

## Proyecto

El objetivo de esta segunda entrega es generar la estructura/jerarquía base de las **Combinaciones de poker**.

**Recuerde que debe testear todas las funcionalidades que implemente.**

### Combinaciones de poker (Sección 2.5)
- Una Combinación de poker debe tener Puntaje propio.
- Debe existir una manera de que una Combinación de poker verifique si una lista de cartas cumple (O no) con la
condición de la combinación. Note que la lista de cartas jugadas tendrá mínimo 1 y máximo 5 cartas

Existen 9 combinaciones de poker:
- **Escalera de color (Straight Flush)**: Una escalera de cinco cartas consecutivas de la misma pinta.
Puntaje: 100 chips, multiplicador x8.
- **Póker (Four of a Kind)**: Cuatro cartas del mismo rango.
Puntaje: 60 chips, multiplicador x7.
- **Full House**: Una combinación de un trío y un par.
Puntaje: 40 chips, multiplicador x4.
- **Color (Flush)**: Cinco cartas de la misma pinta, sin importar el orden.
Puntaje: 35 chips, multiplicador x4.
- **Escalera (Straight)**: Cinco cartas en orden consecutivo, sin importar la pinta.
Puntaje: 30 chips, multiplicador x4.
- **Trío (Three of a Kind)**: Tres cartas del mismo rango.
Puntaje: 30 chips, multiplicador x3.
- **Doble Par (Two Pair)**: Dos pares de cartas del mismo rango.
Puntaje: 20 chips, multiplicador x2.
- **Par (Pair)**: Dos cartas del mismo rango.
Puntaje: 10 chips, multiplicador x2.
- **Carta Alta (High Card)**: Cualquier mano que no cumpla con las combinaciones anteriores. Solo cuenta
la carta de mayor valor.
Puntaje: 5 chips, multiplicador x1.

## Git

El trabajo realizado para esta entrega se debe realizar en una nueva rama que deberá
llamar ``entrega-parcial-2``:

1. Asegúrese de estar en la rama más reciente de su trabajo. Puede usar el comando
``git checkout <last_branch>`` para cambiarse de rama, donde `<last_branch>` es la
rama de su última entrega.

2. Utilice el comando ``git branch <branch_name>`` para crear la rama. En este caso, sería
``git branch entrega-parcial-2``.

3. Recuerde que para que su progreso pueda ser almacenado en dicha rama, debe cambiarse de
rama utilizando el comando ``git checkout <branch_name>``. En este caso, sería
``git checkout entrega-parcial-2``.

*Tenga en cuenta que el cuerpo docente tiene acceso total a su repositorio.*

## Entrega

Para subir su Entrega Parcial, deberá crear un *pull request* desde la rama
``entrega-parcial-2`` a la rama ``master`` llamado ``Tarea 1 - Entrega Parcial 2``.

Es importante que **no hagan merge** de la rama ``entrega-parcial-2`` a la rama ``master`` 
para que el cuerpo docente pueda revisar su *pull request*.

Por *U-Cursos* debe entregar un único archivo llamado ``entrega-parcial-2.txt`` con el
siguiente contenido:

```
Nombre: <Nombre completo>
Pull Request: <Link del pull request>
```

No cumplir con el formato pedido de una Entrega Parcial podría llevar a no ser
considerada, y para una Entrega Final, tiene descuentos en su nota final.
