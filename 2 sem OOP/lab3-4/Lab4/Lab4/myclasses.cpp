#include <iostream>
#include <cmath>

#include "myclasses.h"

using namespace std;

void Child(){
    cout << "\n Info about Child:\n" << endl;
    Child c("Andrey", "Trufanov", 30);
    c.getData();
}

void Tiles(){
    cout << "\n Info about Tiles:\n" << endl;
    Tiles t("KERAMA MARAZZI", 20, 30);
    t.getData();
}

void Complex(){
    cout << "\n Info about Complex class:\n" << endl;
    Complex z(0.7, 1.7);
    z.getNumber();
    z.getRe();
    z.getIm();
    z.getAbs();
    z.getArg();
}

void Vector(){
    cout << "\n Info about Vector class:\n" << endl;
    Vector v1(2), v2(2);
    cout << " First vector" << endl;
    v1.setVector();
    v1.getVector();
    v1.getAbs();
    cout << " Second vector" << endl;
    v2.setVector();
    v2.getVector();
    v2.getAbs();

    Vector res(2);
    res.addVector(v1,v2);
    cout << " -Summ of vectors: " << endl;
    v1.getVector();
    v2.getVector();
    res.addVector(v1,v2);
    cout << " -Summ of vectors: " << endl;
    res.getVector();
}

void Child::setData(){
    cout << " Input Child name: ";
    cin >> name_;
    cout << " Input Child second name: ";
    cin >> lastName_;
    cout << " Input Child age: ";
    cin >> age_;
}

void Child::getData(){
    cout << " Child info: " << endl;
    cout << "Name : " << name_ << " Second name : " << lastName_ << " Age " << age_ << endl;
}

Child::Child(string n, string sn, int a){
    name_ = n;
    lastName_ = sn;
    age_ = a;
}

Tiles::Tiles(string b, float h, float w){
    size_h = h;
    size_w = w;
    brand = b;
}

void Tiles::getData(){
    cout << " Tile: " << size_h << "cm height, " << size_w << "cm length ";
    cout << "by " << brand << endl;
}

void Complex::setNumber(){
    cout << " Input your number: ";
    cin >> re_ >> im_;
}

void Complex::getNumber(){
    cout << " You number is: " << re_ << " + " << im_ << 'i' << endl;
}

void Complex::getRe(){
    cout << " Real part: " << re_ << endl;
}

void Complex::getIm(){
    cout << " Imaginary part: " << im_ << endl;
}

void Complex::getAbs(){
    double result;
    result = sqrt(re_*re_ + im_*im_);
    cout << " Absolute value is: " << result << endl;
}

void Complex::getArg(){
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

void Vector::setVector(){
    cout << " Input vector coordinates(" << dimension_ <<" coordinates): " << endl;
    for(int i = 0; i < dimension_; i++)
        cin >> coordinates_[i];
}

void Vector::getVector(){
    cout << " Your vector is:" << endl;
    for(int i = 0; i < dimension_; i++)
        cout << coordinates_[i] << " ";

}

void Vector::getAbs(){
    double result;
    for(int i = 0; i < dimension_; i++)
        result += coordinates_[i]*coordinates_[i];
    result = sqrt(result);
    cout << " Absolute value is: " << result << endl;
}

void Vector::addVector(Vector a, Vector b){
    for(int i = 0; i < dimension_; i++){
        coordinates_[i] = a.coordinates_[i] + b.coordinates_[i];
    cout << " Coordinate: " << coordinates_[i] << endl;
}
}

void Vector::substractVector(Vector a, Vector b){
    for(int i = 0; i < dimension_; i++){
        coordinates_[i] = a.coordinates_[i] + b.coordinates_[i];
        cout << " Coordinate: " << coordinates_[i] << endl;
    }
}
