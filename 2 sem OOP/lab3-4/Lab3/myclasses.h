#ifndef MYCLASSES_H
#define MYCLASSES_H

using namespace std;

class Child{
private:
    string name_;
    string lastName_;
    int age_;
public:
    void setData(); // Input info
    void getData(); // Output info on display
};

class Tiles{
public:
    Tiles(string b, float h, float w);
    string brand;
    float size_h, size_w;

    void getData(); // Output info on display
};

class Complex{
private:
    double re_;
    double im_;

public:
    void setNumber(); // Input number
    void getNumber(); // Output number
    void getRe(); // Output Real part
    void getIm(); // Output Imaginary part
    void getAbs(); // Output Absolute 
    void getArg(); // Output Argument
;};

class Vector{
private:
    float x_,y_,z_;
public:
    void setVector(); // Input vector coord
    void getVector(); // Output vector
    void getAbs(); // Output Absoule of vector
    Vector addVector(Vector a, Vector b); // Summ of "a" and "b" vectors
    Vector substractVector(Vector a, Vector b); // Substraction of "a" and "b" vectors
};

void Childinfo(); 

void Tiles();

void Complex();

void Vector();

#endif // MYCLASSES_H