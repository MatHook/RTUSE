#ifndef LAB5_H
#define LAB5_H
#include <iostream>
using namespace std;

class Complex{
private:
    double Re;
    double Im;

public:
    Complex(double re, double im):
        Re(re),Im(im) {}

    Complex& operator=(const Complex& right){
        if(this == &right){
            return *this;
        }
        Re = right.re;
        Im = right.Im;
        return *this;
    }

    friend bool operator==(const Complex& left, const Complex& right);
    friend bool operator!=(const Complex& left, const Complex& right);
    friend const Complex& operator++(Complex& i);
    friend const Complex operator++(Complex& i, int);

    friend const Complex& operator--(Complex& i);
    friend const Complex operator--(Complex& i, int);

    friend ostream& operator<<(ostream& os, const Complex& c);
    friend istream& operator>>(istream& is, Complex& c);

    void setNumber();
    void getNumber();
    void getRe();
    void getIm();
    void getAbs();
    void getArg();
};

class Vector{
private:
    float x_,y_,z_;
public:
    Vector (float x, float y, float z):
        x_(x), y_(y), z_(z){}
    Vector& operator=(const Vector& right){
        if(this == &right){
            return *this;
        }
        x_ = right.x_;
        y_ = right.y_;
        z_ = right.z_;
        return *this;
    }

    friend bool operator==(const Vector& l, const Vector& r);
    friend bool operator!=(const Vector& l, const Vector& r);

    friend ostream& operator<<(ostream& os, const Vector& v);
    friend istream& operator>>(istream& is, Vector& v);

    void setVector();
    void getVector();
    void getAbs();
    Vector addVector(Vector a, Vector b);
    Vector substractVector(Vector a, Vector b);
};

#endif 