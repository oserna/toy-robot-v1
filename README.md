# toy-robot-v1

The idea of this version is to make it quick and following the most simple OO approach

The main components are as it follows:

INPUT COMMAND LINE -> COMMAND PATTERN  ->  BUSINESS LOGIC  -> STATE

Approach:

    The main idea is:

     1) to get what it is wanted from the command line
     2) to interpret the intent using a command pattern
     3) the command will be used to execute the logic associated
     4) the business logic is encapsulated in the Game entity

Principles:

    1)  The commands gives us the flexibility to decouple the logic from the way we introduce the data in the application. Adding another protocol to get the commands would be easy

    2)  I have implemented the logic in services in the GAME entity but probably according to the result in subsequent refactorings the behaviour fits more in the Robot entity

    3)  I've tried not to use any additional library for example to read from command line, or utilities. Just the basic stuff

    In regards of the rest I think the code is easy to read and follow.

TODOs

    - The behaviour should be placed in Robot
    
