

# Polynom![aaaaaa](https://user-images.githubusercontent.com/44754325/50425241-2cf89900-087b-11e9-867e-e08dd8eb3253.jpg)

## descreption
The project represents a polynomial of the form
```
   a*x1^b + a*x2^b + .... + a*xn^b
   a -> incomplete number
   b -> Integer  
```
 After creating a polynomial, many actions can be done which will be detailed later as part of the project.
The polynomial can be viewed graphically using OpenSource (gral).
Attached Image .
#### Polynom Graphically displayed
![a](https://user-images.githubusercontent.com/44754325/50425276-adb79500-087b-11e9-80cf-c1a4b29ace8b.png)
### Monom class
Use a monom from the format of a*x^b.
```
   Note: We assumed that the input is valid
   a*x^b
```
The class monom supports some functions as
- add
- derivative
- f(x)
- multiply
- is equal
- is zero
### Polynom class
Use a ploynom from the format of a*x1^b + a*x2^b + .... + a*xn^b.
```
   Note: We assumed that the input is valid
   a*x1^b + a*x2^b + .... + a*xn^b
```
The class polynom supports some functions as:
- add - there is two options to add function add Monom/Polynom(useing Polynom_able) . 
- derivative 
- f(x)
- multiply 
- subtract 
- root - Finds the point of intersection of the polynomial in the given range
- area - Returns the value of the area in the given range
- copy
- is equal 
- is zero
### Example run
In the RunningExample class there are examples of Polynom and Monom functions
,You can run and see the examples , you can plot a graph 2D with the RunningExampleGraph class(gral jar - there is a link to gral GitHub).
have fun .

### Sorces
gral plot 2D polynom https://github.com/eseifert/gral.git

Riemann_integral  - https://en.wikipedia.org/wiki/Riemann_integral 

Bisection method - https://en.wikipedia.org/wiki/Bisection_method

Iterator -https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html

