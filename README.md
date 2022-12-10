Synchronizing multiple processes using Simple locks Algorithm to handle Critical Section Problem
---------------------------------------------------------------
Summary:
-
this project was done by myself Mohammad Shweiki under the instruction Radwan Tahboub,PhD as the Operating Systems course project, the project aims to synchronize multiple processes that are conflicting and need to use the same variables at the same time in order to guarantee that the processes results will be as expected without any error fallacy in the result and compare thr synchronization result with the result of doing these processes without any synchronization, and the method used to do so is : Simple lock, the problem of conflicting processes in generally called Critical Section problem.
___________________________________________________________________________

Requirements
-
in order to run the code of the project correctly you need to have Java SDK version 8 or higher, and proper IDE to Run Java code such as Eclipse, netBeans, IntellijIdea.
___

Features
-
External Classes:
--
1- Threads: a class in Javs language that implements Runnable interface which means it can work in parallel with other process which exactly what we want in order to get the aim of the project.

2- ReentrantLock: a class in Java utilities library to use the lock for synchronizing the processes.
    Explaining code.

    Counter Class: a simple class I made to simplify working on the project and organize the code, it contains the following attributes and methods:
        -Attributes: 
            1- first: integer variable to manipulate.
            2- second: integer variable to manipulate also by the processes.
            3- lock: instance of the class ReentrantLock to use as a lock to handle the Problem that will result when trying to access and modify on the variables "first" and "second".
        Methods:
            1- empty constructor.
            2- constructor with to integers as arguments to assign values for "first" and "second".
            3- general setters and getters.
            4- simple toString method to return values of "first" and "second".
            5- firstProcessNotSynced: a void method that changes on "first" by adding 1 and subtracts 1 from "second".
            6- secondProcessNotSynced: a void method that changes on "second" by adding 1 and subtracts 1 from "first".
            7- firstProcessSynced: changes on the values of "first" and "second" like the method number 5 but the difference that lock is used with it therefore it's only will be used when the lock is released so problem is solved.
            8- secondProcessSynced: changes on the values  of "first" and "second" like the method number 6 but like the method 7 this method uses lock to make it syncronized.

    Main Class: this the class that is runned and contains the main methods of the project program as the it's name suggests.
        -Attribues: the only attribute for the class an instance of the class Counter named "c" and passes two random integers to the construcor to assign them for the attributes "first" and "second".
        
        Methods: 
            1- getRandom: a static method used to generate a random integer value, by calling the random function from the Math library and multiplying it by 10000 to make sure the resulting the number will be positive and then casting the result to make it integer instead of float.
            2- printInitialInfo: simple static void function used at the start of runnung the program to display the values before executing anything and also displays what are the expected correct values that must "first" and "second" become equal to after executing processes.
            3- operationWithoutSync: a static method that receives twop integers x and y as arguments, it creates two threads, the first loops for x time and keeps calling the 5th method from "c" which is not synced and the second thread runs a loop for y times and calls the 6th method from "c" which is also not synced, the join method used for both of threads is used to make them work simultanousely which what we need to prove that they will result in a wrong result due to the fact that they are not synced.
            4- operationWithSync: this method like the 3rd method but calls synced versions of the operations therefore it must end up with wanted results.
            5- main: this is the main function that runs the whole program, first initialize integers x and y and gives them random values, initialize integers default1 and default2 and store "first" and "second" in them respectively to use them letter, 
                2nd function is called to display inital information on the screen, calls 3rd method to use the unsynced threads and display the wrong result that occured due to not syncing processes,
                then re-assign the values of "first" and "second" of the object c to the values they were at the beginning of the method, lastly call the 4th method in order to execute the synchronized threads and then display the results that are expected to match the right answer.

____
Contact: for any further contact or questions regarding this project or other projects you are welcome to contact me on my personal E-mail: mohammadshwiki226@gmail.
