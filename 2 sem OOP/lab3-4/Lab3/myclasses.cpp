#include <iostream>
#include <cmath>

#include "myclasses.h"

using namespace std;

void Childinfo() {
    cout << "\n Info about Child:\n" << endl;
    Child c;
    c.setData();
    c.getData();
}

void Tiles() {
    cout << "\n Info about Tiles:\n" << endl;
    Tiles t("KERAMA MARAZZI", 20, 30);
    t.getData();
}

void Complex() {
    cout << "\n Info about Complex class:\n" << endl;
    Complex z1;
    z.setNumber(); 
    z.getNumber();
    z.getRe();
    z.getIm();
    z.getAbs();
    z.getArg();
}

void Vector() {
    cout << "\n Info about Vector class:\n" << endl;
    Vector v1, v2;
    cout << " 1 vector" << endl;
    v1.setVector();
    v1.getVector();
    v1.getAbs();

    cout << " 2 vector" << endl;
    v2.setVector();
    v2.getVector();
    v2.getAbs();

    Vector res;
    res = res.addVector(v1,v2);
    cout << " Summ of vectors: " << endl;
    res.getVector();
    res = res.substractVector(v1,v2);
    cout << " Substraction of vectors: " << endl;
    res.getVector();
}

void Child::setData() {
    cout << " Input Child name: ";
    cin >> name_;
    cout << " Input Child second name: ";
    cin >> lastName_;
    cout << " Input Child age: ";
    cin >> age_;
}

void Child::getData() {
    cout << " Child info: " << endl;
    cout << "Name : "<< name_ << " Second name : " << lastName_ << " Age : " << age_ << endl;
}

Tiles::Tiles(string b, float h, float w){
    size_h = h;
    size_w = w;
    brand = b;
}

void Tiles::getData() {
    cout << " Tile: " << size_h << "cm height, " << size_w << "cm length ";
    cout << "by '" << brand << "'" << endl;
}

void Complex::setNumber() {
    cout << " Input your number: ";
    cin >> re_ >> im_;
}

void Complex::getNumber() {
    cout << " You number is: " << re_ << " + " << im_ << 'i' << endl;
}

void Complex::getRe() {
    cout << " Real part: " << re_ << endl;
}

void Complex::getIm() {
    cout << " Imaginary part: " << im_ << endl;
}

void Complex::getAbs() {
    double result;
    result = sqrt(re_*re_ + im_*im_);
    cout << " Absolute value is: " << result << endl;
}

void Complex::getArg() {
    double argument;
    if(re_ == 0){
        if(im_ < 0)
            argument = -M_PI/2;
        else argument = M_PI/2;
    }
    if (re_ > 0)
        argument = atan(im_/re_);
    if (re_ < 0){
        if(im_ >= 0)
            argument = M_PI + atan(im_/re_);
        else argument = -M_PI + atan(im_/re_);
    }
    cout << " Argument is: " << argument << endl;
}

void Vector::setVector() {
    cout << " Input vector coordinates x, y, z: ";
    cin >> x_ >> y_ >> z_;
}

void Vector::getVector() {
    cout << " Your vector is:" << " x: " << x_ << " y: " << y_ << " z: " << z_ << endl;
}

void Vector::getAbs() {
    double result = sqrt(x_*x_ + y_*y_ + z_*z_);
    cout << " Absolute value is: " << result << endl;
}

Vector Vector::addVector(Vector a, Vector b) {
    Vector res;
    res.x_ = a.x_ + b.x_;
    res.y_ = a.y_ + b.y_;
    res.z_ = a.z_ + b.z_;
    return res;
}

Vector Vector::substractVector(Vector a, Vector b) {
    Vector res;
    res.x_ = a.x_ - b.x_;
    res.y_ = a.y_ - b.y_;
    res.z_ = a.z_ - b.z_;
    return res;
}
