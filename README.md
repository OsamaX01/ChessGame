# ChessGame

# Chess Game Report

## Table of contents:

1- [Introduction](#intro)

2- [Thinking in terms of OOD](#thinking)

3- [Explaining object-oriented design and Applying Design patterns](#explaining)

4- [Explaining Design Patterns](#DP)

5- [Defending Clean Code Principles](#cleanCode)

6- [Defending against SOLID Principles](#SOLID)

7- [Special moves](#specialMoves)


## **Introduction:** <a name="intro"></a>

The chess game project is a project that implements the standard chess game as a showcase for OOD design. The purpose of this project is to apply design patterns, SOLID principles, and clean code principles.

### **Software Design:**
**Here we start:**
I’ll start describing the design from the first moment I started thinking about it. I wanted to simplify the process of the game by dividing the problem into parts by thinking of what components the game has, what
are the states and the actions of each component, and how these components act with each other in the system.

Let's break your program down into layers:
1- The pieces. They only know what kind of piece they are, who owns them (Player), and where they are located.

2- Pieces Movements: Movements must be separate from pieces because each move can be valid to more than one
piece such as Bishop and Queen diagonal movement. Moreover, we might have new common movements in the future.

3- The board. It knows only about the pieces, and how they're arranged on it, and has the responsibility
 of changing this arrangement based on the game process needs.

4- Game Process. This can be thought of as a subsystem for simulating the game and its process,
it knows about the board and the players and their turns and movements. (I will call them later Simulators).

## **Thinking in terms of OOD and applying Design patterns** <a name="thinking"></a>

For me this part is about modularity, I don’t want to make a design for a static set of rules, and pieces, even the board can be changed. Programmers should be able to reuse my code if they want to extend my project with a new feature.

### 1- The pieces. 
They only need to know what kind of pieces they are, who owns them, and where they are located.

Generalization: Designing it should include having a base type with all common functionalities. 
Concrete pieces should extend this base.

Note: Some functionalities are common but differ from one piece to another, this can still be in the base
class and the concrete classes (children) will have the responsibility of deciding this functionality.

Examples of such functions:

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/fb73dc9a-20c0-435b-b6ad-b99155a2a1f7)

### **UML Diagram:**

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/1fbddd7f-b1da-47d5-9122-3b593fda2384)

### 2 - **Pieces Movements.**
To me, this was the hardest part of thinking, there are two main points:

A- Reusability of the movements: adding new Movements easily without Modification (Open-Closed principle).

B- Each Move has several rules in a particular order that must be checked. And these rules can be common to some set of rules.

### **Solution to point A:**
Here where I used Design Patterns; the first problem can be solved by **Strategy Pattern**. 
Each move will have a Move Strategy that does these multiple rules checking and returning if a piece can move or not to a particular square.

Each Piece will have a set of move strategies. The perfect point is whenever we add a new moving rule to a piece. It can be handled by just adding a move strategy to it (Open-Closed principle).
The The same applies to removing and adding a new feature to an old move strategy is also easy. Move strategies examples:
- BasicOneSquareForwardMoveStrategy
- HorizontalMoveStrategy

### **Solution to point B:**
Here I used the Chain of Responsibility pattern, which is essential to execute several handlers in a particular order.
These handlers can be reused in different move strategies.
Also, this applies to the Single Responsibility Principle.

- UML Diagram for both patterns:

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/132d8841-dd3e-4683-86b1-b47eed620cc5)
  
Note: If we wanted to add a new feature to an existing movement strategy such as promotion to one square forward strategy. (Generalization applies / Open Closed Principle)

We can add a new class called ```OneSquareForwardWithPromotionMoveStrategy ```

This class extends ```BasicOneSquareForward``` and all its validation and just adds a new validation for promotion.

### **Closer look at the Movements process:** 

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/955eefa2-28dc-48c7-bca1-37173dbfa733)

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/1fa1bd0c-5f61-4b71-89a1-cbe7156a5968)

Let’s see the Move Strategy Interface and One Square Forward Movement strategy class:

What we care about the most is ```validateMove()``` function. This function does multiple validations to see if we can apply a move.

The validation process can be done using the **Chain Of Responsibility** pattern with multiple handlers.

Function ```validateMove()``` is shown below.

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/e9b106ab-7d6a-4456-a746-96e8a067ad42)

Let’s see the ```VilidStartLocation()``` handler, it extends the baseHandler class. can handle checks isValid, if it is then we go to the next handler.

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/14687e5b-5700-4000-9e03-73c21721e4da)

This is common code so it’s in the base class and ```isValid()``` is implemented by the concrete classes.

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/ecc050a6-955a-46b9-9a15-41a308dda3f9)

**Important:**
Now each piece will have a set of move strategies. Whenever it wants to move, it tries to move from a square x to a square y within its strategies
(brute force all the strategies) and checks if the movement is valid.


### **3- The board**.

Also applied **generalization** here same as pieces since I might add a new type of board in the future. The board is responsible for knowing the pieces on it, and how they are arranged, and it’s responsible for changing the places (state) of these pieces on it. The responsibility of initializing the pieces is given to its subclasses because each board has a customized piece on it at the beginning of the game.

The initialization process uses a Piece Factory **(Factory Method pattern)** which keeps everything simple.

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/822d5bf0-bb65-4ca0-832b-2e23723e473f)

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/f9a52188-7d2a-41a3-b465-9cc9073d9b7b)

Note: Concrete classes of the board have the responsibility of implementing abstract functions such as initializing the board.

### 4 -**Game Simulators** :
I divided this into multiple classes Chess Game, Game States Checker, and Input Validator. Each has one main purpose:

**Chess Game**: the main class in the program, which simulates the game. It knows about players and Chess Board and simulates the game by making valid movements for both players.

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/47619afc-1534-43de-8240-241cc4a25a5d)

**Game States Checker**: This class provides the main class with the functionality of checking when the game ends. It checks for mate, checkmate, and draw.

Note: these functions are static (can be called without having an instance of their class)

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/acf06422-786c-4763-a5eb-64fe6858dafb)

**Input Validator class**: This class provides the main class with the functionality of input validation. Instead of implementing these in the main class (**Single Responsibility principle**).

![image](https://github.com/OsamaX01/ChessGame/assets/77506711/4720be6f-66d5-4531-bbeb-d55511c96bd1)

Note: if new validations are added this can be refactored using Chain Of responsibility. But for now, it’s ok.

## **Explaining Object-Oriented Design:** <a name="explaining"></a>

- **Abstraction**, **Encapsulation** :
    As I mentioned before I simplified the program into components each has subcomponents (breaking it down into simplified, high-level descriptions).
    And every class is hiding its implementation details while exposing an interface to the outside world.

- **Decomposition**:

    1- Association: is used more often to describe the relationship between components and can be viewed in handler classes, and move strategies classes example:

      ![image](https://github.com/OsamaX01/ChessGame/assets/77506711/09d95029-122c-4f02-8648-cb54cf9d2a5a)

    2- Composition: This can be shown in Chess Game class It aggregates the chessboard.

      ![image](https://github.com/OsamaX01/ChessGame/assets/77506711/82f73b15-a201-4e4a-a0e2-12704e049d89)

    3- Aggregation: This is rarely used in my code.

- **Generalization** is shown a lot as I mentioned in **” Thinking in terms of OOD section”** Such as Piece, Handler, and Board base classes with a lot of concrete classes.


## **Explaining Design patterns:** <a name="DP"></a>

1- **Strategy pattern**: used for all movements as mentioned before.
Reasons:
- A lot of pieces that only differ in the way they execute movements.
- Use different variants of movements within a piece object and be able to switch from one movement to another during runtime.

**2- Chain of Responsibility pattern:** 
used in the validation process for all the moves.
Reasons:
- The program requires processing different kinds of validation requests in various ways.
- It’s essential to execute several validations in a particular order.

These two patterns apply Single Responsibility + Open Closed principles (If we add new rules for any piece, we do not edit the current code, add new
classes to the system each has a single responsibility).

**UML for the two patterns:**


**3- Factory Method pattern**: 
I used this pattern in creating pieces in the Piece Factory class. Whenever you need to create a piece, you can pass its name.
Reasons:
- Single Responsibility: separate the responsibility of creating pieces from another class
- Code Reusability: factory can be used in multiple functions.

**4- Singleton pattern:**
I also used it in movement strategy classes since there’s no meaning of having multiple instances from the same movement strategy.

## **Defending Clean Code Principles:** <a name="cleanCode"></a>

- Functions do only one thing. e.g., getValidMove (Player player), makeMove(Player current layer)
- No massive conditional statements (polymorphism is used a lot)
- Rare Switch statements
- Create the correct abstractions: separate responsibilities.
    - e.g., Handler, MoveStrategy interfaces.
    - high-level abstraction describes that all the lower-level classes
- Arguments are at most 3
- No Boolean arguments
- Exception handling is highly included
    - Specially NullPointerException
- Try blocks to do only one thing
- DRY: (Don’t repeat yourself), no duplicate code (copy-pasting)
      - Abstraction, generalization, and polymorphism help a lot.
- Naming conventions are preserved
      - Small letter variables as names, functions as verbs
      - Classes capital / Packages small
      - Booleans starts with is/can except validate function
- Avoided returning null
- Used Fail fast and return early.
- Indentation: I use Google Style sheet indentation style.
    - Except for tab size: I use 4 spaces.


## **Defending On SOLID Principles:** <a name="SOLID"></a>

- **Single Responsibility**: is well applied in my code, every class has a clear responsibility and each function has only one main task to do.

- **Open Closed**: applied in many places such as adding new movements or a new handler or a new piece type, all that we must do is to make a new class that represents the new functionality and
    add this functionality (Generalization/interfaces help here).

- **Liskov Substitution**: I have no subclasses that change the functionality of base classes. But some subclasses have extra functions, I guess that this is wrong.
  
- **Interface Segregation:** I don’t violate this principle. All interfaces are used as they are supposed to be. (No dummy/unused functions).

- **Dependency Inversion:** applied in my code in Board class as it uses a general Piece (supertype) as a private member, and all its functions have a general piece.
  So, if I want to add a new piece in the future the board class will not be affected.

## **Special moves:** <a name="specialMoves"></a>

Special moves can be implemented as the same as normal moves. You need to make a suitable Movement strategy for this move. And the handlers required validation. 
The only difference is that this is a special move, so it does something special.

Examples:
Promotion: change a pawn into a new piece.
Castling: moving the rock alongside with king.

These special actions should have a separate class that does this special thing and this class will be added to the move strategy to make the required action.
