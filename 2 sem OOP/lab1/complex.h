#ifndef COMPLEX_H
#define COMPLEX_H
#include <iostream>
typedef struct{
    double Re;
    double Im;
}complex;

void compl_Menu();

void compl_Print(complex z);

void compl_Input(complex *z);

complex compl_Add(complex z1, complex z2);

complex compl_Sub(complex z1, complex z2);

complex compl_Multiply(complex z1, complex z2);

complex compl_Div(complex z1, complex z2);

double compl_Abs(complex z);



#endif // COMPLEX_H
