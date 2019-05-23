# Coding Standards

## Variable Naming

* Use camelCase for naming your variables. E.g - `largestItem` instead of just x.

## Coding Formats 

Always use tabs to properly indent your methods and control statements. Also, please maintain the following standards for creating your methods and control statements. 

Methods shall be created with the following standard.

```
void doSomething() {
    //do something
}
```

Control statement (e.g if/else) shall be created with the following standard. 
```
if(condition) {
    //do something
}
else {
    //do another thing
}
```
Loops shall be created with the following standard.
 
```
for(int i = 0; i < 10 ; i++) {
    //do something
}

while(condition) {
    //do something
}
```
## Code Documentation
Your code should be self-explanatory most of the time. In case you need to comment any major blocks of code, please explain it minimally with a comment. Also please add comments for your classes and methods to describe their purpose. You should have a prologue comment describing the purpose of that class like the following.

```
/** 
Class: ClassName
Author: Your name
Purpose: What is the purpose of this class?
*/

public class ClassName {
    //fields

    //constructors

    //methods
}
```

You should have a prologue comment describing the purpose of the method like the following.

```
/** 
myMethod

Purpose: What is the purpose of this method?
Parameters: parameter 1, parameter 2
Returns: describe return value
*/

public void myMethod(parameter 1, parameter 2) {
    //do something
}
```
