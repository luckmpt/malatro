# Tarea 1 | Entrega Parcial 1

## Proyecto

El objetivo de esta primera entrega, es **sentar las entidades y estructuras necesarias para
el videojuego**. Es decir, _no deberá crear interacciones entre estas_, sino que solo lo que
una instancia de alguna clase sea capaz de hacer por sí sola. Tampoco deberá preocuparse
por el momento sobre los casos excepcionales, pues serán solicitados en otro momento.

Para guiarles en este proceso, contará con una lista de requisitos a cumplir. Cada uno de
estos requisitos deberá estar reflejado en su proyecto al momento de realizar la entrega
final, tanto de manera funcional como testeada. El requisito en cuestión solo indica *qué*
es lo que debe hacer, sin embargo, el *cómo* hacerlo de la mejor manera recaerá en usted.

### Puntaje (Sección 2.1)

- Un puntaje debe tener chips y multiplicador.

### Cartas (Sección 2.2)

- Una carta debe tener un rango y una pinta.

#### Rango

- Un rango puede ser uno de los siguientes:
    - As
    - Dos
    - Tres
    - Cuatro
    - Cinco
    - Seis
    - Siete
    - Ocho
    - Nueve
    - Diez
    - Jota
    - Reina
    - Rey

- Un rango debe tener orden y valor.

- Un rango debe tener uno de los siguientes tipos de rango:
    - Impar
    - Par
    - Figura

#### Pinta

- Una pinta puede ser una de las siguientes:
    - Corazón
    - Pica
    - Diamante
    - Trébol

### Jokers (Sección 2.3)

- Un Joker puede ser uno de los siguientes:
    - Greedy Joker
    - Devious Joker
    - Even Steven
    - Scary Face

### Mano (Sección 2.4)

- Una mano debe tener un conjunto de Cartas y un conjunto de Jokers.

**Recuerde que debe testear todas las funcionalidades que implemente.**

## Git

El trabajo realizado para esta entrega se debe realizar en una nueva rama que deberá
llamar ``entrega-parcial-1``:

1. Asegúrese de estar en la rama más reciente de su trabajo. Puede usar el comando
``git checkout <last_branch>`` para cambiarse de rama, donde `<last_branch>` es la
rama de su última entrega.

2. Utilice el comando ``git branch <branch_name>`` para crear la rama. En este caso, sería
``git branch entrega-parcial-1``.

3. Recuerde que para que su progreso pueda ser almacenado en dicha rama, debe cambiarse de
rama utilizando el comando ``git checkout <branch_name>``. En este caso, sería
``git checkout entrega-parcial-1``.

*Tenga en cuenta que el cuerpo docente tiene acceso total a su repositorio.*

## Entrega

Para subir su Entrega Parcial, deberá crear un *pull request* desde la rama
``entrega-parcial-1`` a la rama ``master`` llamado ``Tarea 1 - Entrega Parcial 1``.

Es importante que **no hagan merge** de la rama ``entrega-parcial-1`` a la rama ``master`` 
para que el cuerpo docente pueda revisar su *pull request*.

Por *U-Cursos* debe entregar un único archivo llamado ``entrega-parcial-1.txt`` con el
siguiente contenido:

```
Nombre: <Nombre completo>
Pull Request: <Link del pull request>
```

No cumplir con el formato pedido de una Entrega Parcial podría llevar a no ser
considerada, y para una Entrega Final, tiene descuentos en su nota final.
