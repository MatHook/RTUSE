#include <iostream>
#include <cmath>

#include "lab5.h"

using namespace std;

void Complex::setNumber() {
    cout << " Input your Real and Imaginary: ";
    cin >> Re >> Im;
}

void Complex::getNumber() {
    cout << " You number is: " << Re << " + " << Im << 'i' << endl;
}

void Complex::getRe() {
    cout << " Real part: " << Re << endl;
}

void Complex::getIm() {
    cout << " Imaginary part: " << Im << endl;
}

void Complex::getAbs() {
    double result;
    result = sqrt(Re*Re + Im*Im);
    cout << " Result is: " << result << endl;
}

void Complex::getArg() {
    double argument;
    if(Re == 0){
        if(Im < 0) argument = -M_PI/2;
        else argument = M_PI/2;
    }
    if (Re > 0) argument = atan(Im/Re);
    if (Re < 0){
        if(Im >= 0)
            argument = M_PI + atan(Im/Re);
        else argument = -M_PI + atan(Im/Re);
    }
    cout << " Argument is: " << argument << endl;
}

void Vector::setVector(){
    cout << " Input vector coordinates: ";
    cin >> x_ >> y_ >> z_;
}

void Vector::getVector(){
    cout << " Your vector is: (" << x_ << "," << y_ << "," << z_ << ")" << endl;
}

void Vector::getAbs(){
    double result = sqrt(x_*x_ + y_*y_ + z_*z_);
    cout << " Absolute value is: " << result << endl;
}

Vector Vector::addVector(Vector a, Vector b) {
    Vector res(0, 0, 0);
    res.x_ = a.x_ + b.x_;
    res.y_ = a.y_ + b.y_;
    res.z_ = a.z_ + b.z_;
    return res;
}

Vector Vector::substractVector(Vector a, Vector b){
    Vector res(0, 0, 0);
    res.x_ = a.x_ - b.x_;
    res.y_ = a.y_ - b.y_;
    res.z_ = a.z_ - b.z_;
    return res;
}

//Operators
bool operator==(const Complex& left, const Complex& right) {
    return (left.Im == right.Im && left.Re == right.Re);
}

bool operator!=(const Complex& left, const Complex& right) {
    return (left.Im != right.Im || left.Re != right.Re);
}

const Complex operator++(Complex& i, int) {
    Complex oldValue(i);
    i.Re++;
    i.Im++;
    return oldValue;
}

const Complex& operator++(Complex& i) {
    i.Re++;
    i.Im++;
    return i;
}

const Complex operator--(Complex& i, int) {
    Complex oldValue(i);
    i.Re--;
    i.Im--;
    return oldValue;
}

const Complex& operator--(Complex& i) {
    i.Re--;
    i.Im--;
    return i;
}

ostream& operator<<(ostream& os, const Complex& c) {
    os << c.Re << " + " << c.Im << "i";
    return os;
}

istream& operator>>(istream& is, Complex& c) {
    is >> c.Re >> c.Im;
    return is;
}

bool operator==(const Vector& l, const Vector& r) {
    return (l.x_ == r.x_ && l.y_ == r.y_ && l.z_ == r.z_);
}

bool operator!=(const Vector& l, const Vector& r) {
    return (l.x_ != r.x_ || l.y_ != r.y_ || l.z_ != r.z_);
}

ostream& operator<<(ostream& os, const Vector& v) {
    os << "(" << v.x_ << ", " << v.y_ << ", " << v.z_ << ")";
    return os;
}

istream& operator>>(istream& is, Vector& v) {
    is >> v.x_ >> v.y_ >> v.z_;
    return is;
}
