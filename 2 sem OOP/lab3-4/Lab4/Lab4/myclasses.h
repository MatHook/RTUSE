#ifndef MYCLASSES_H
#define MYCLASSES_H

using namespace std;

class Child{
private:
    string name_;
    string lastName_;
    int age_;
public:
    Child(string n, string sn, int a);
    void setData();
    void getData();
};

class Tiles{
public:
    Tiles(string b, float h, float w);
    string brand;
    float size_h, size_w;

    void getData();
};

class Complex{
private:
    double re_;
    double im_;

public:
    Complex(double re, double im):
        re_(re),im_(im) {}

    void setNumber();
    void getNumber();
    void getRe();
    void getIm();
    void getAbs();
    void getArg();
};

class Vector{
private:
    float *coordinates_;
    int dimension_;
public:
    Vector (int dim):
        dimension_(dim) {
        coordinates_ = new float[sizeof(float)*dim];
    }
    void setVector();
    void getVector();
    void getAbs();
    void addVector(Vector a, Vector b);
    void substractVector(Vector a, Vector b);

    ~Vector(){
        delete [] coordinates_;
        cout << "Destr" << endl;
    }
};

void Childinfo();

void Tiles();

void Complex();

void Vector();

#endif // MYCLASSES_H