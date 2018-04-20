
#include "complex.h"
#include <cmath>

using namespace std;

void compl_Menu()
{
    cout<<"\n 0. Print menu \n 1. Input 1st complex \n 2. Input 2nd complex \n";
    cout<<" 3. Display 1st complex \n 4. Display 2nd complex \n 5. To sum \n 6. To subduct \n 7. To Multiply \n 8. To divide \n 9. Exit \n";
}
void compl_Print(complex z)
{
    cout << "z= "<<z.Re<<" + "<<z.Im<<"i\n";
}
void compl_Input(complex *z)
{
    cin>>z->Re>>z->Im;
}
double compl_Abs(complex z)
{
    return sqrt(z.Re*z.Re+z.Im*z.Im);
}
complex compl_Add(complex z1,complex z2)
{
    complex zres;
    zres.Re = z1.Re+z2.Re;
    zres.Im = z1.Re+z2.Im;
    return zres;
}

complex compl_Sub(complex z1,complex z2)
{
    complex zres;
    zres.Re = z1.Re-z2.Re;
    zres.Im = z1.Re-z2.Im;
    return zres;
}
complex compl_Multiply(complex z1, complex z2){
    complex zres;
    zres.Re = z1.Re*z2.Re-z1.Im*z2.Im;
    zres.Im = z1.Re*z2.Im + z1.Im*z2.Re;
    return zres;
}
complex compl_Div(complex z1,complex z2)
{
    complex zres;
    zres.Re = (z1.Re*z2.Re + z1.Im*z2.Im)/(z2.Re*z2.Re+z2.Im*z2.Im);
    zres.Im = (z2.Re*z1.Im - z1.Re*z2.Im)/(z2.Re*z2.Re+z2.Im*z2.Im);
    return zres;
}

