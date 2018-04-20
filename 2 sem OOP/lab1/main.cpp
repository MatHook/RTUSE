
#include "complex.h"
#include <fstream>

using namespace std;


#include "complex.h"
#include <fstream>

using namespace std;

double max_Abs(complex *zmas,int n)
{
    double max = -1;
    double x;
    
    for (int i =0; i<n; i++)
    {
        x = compl_Abs(zmas[i]);
        if(x>max)
        {
            max = x;
        }
    }
    return max;
}

int main()
{
    /* 1st Tusk
    int flag=-1;
    int i=0;
    complex z1,z2,zres;
    
    cout << "Choose paragraph: ";
    compl_Menu();
    
    while(flag!=9)
    {
        cin>>flag;
        switch(flag)
        {
            case 0:
                compl_Menu();
                break;
            case 1:
                cout << "Input Real and Imaginary parts of first complex number: ";
                compl_Input(&z1);
                i++;
                break;
            case 2:
                cout << "Input Real and Imaginary parts of second complex number: ";
                compl_Input(&z2);
                i++;
                break;
            case 3:
                if(i>0)
                {
                    cout << "First complex number: ";
                    compl_Print(z1);
                }
                else
                {
                    cout<<"Error: complex number is null";
                }
                break;
            case 4:
                if(i>1)
                {
                    cout << "Second complex number: ";
                    compl_Print(z1);
                }
                else
                {
                    cout<<"Error: complex number is null";
                }
                break;
            case 5:
                if(i>1)
                {
                    zres = compl_Add(z1,z2);
                    cout << "Result: ";
                    compl_Print(zres);
                }
                else
                {
                    cout<<"Error: one of the operands is absent";
                }
                break;
            case 6:
                if(i>1)
                {
                    zres = compl_Sub(z1,z2);
                    cout << "Result: ";
                    compl_Print(zres);
                }
                else
                {
                    cout<<"Error: one of the operands is absent";
                }
                break;
            case 7:
                if(i>1)
                {
                    zres = compl_Multiply(z1,z2);
                    cout << "Result: ";
                    compl_Print(zres);
                }
                else
                {
                    cout<<"Error: one of the operands is absent";
                }
                break;
            case 8:
                if(i>1)
                {
                    zres = compl_Div(z1,z2);
                    cout << "Result: ";
                    compl_Print(zres);
                }
                else
                {
                    cout<<"Error: one of the operands is absent";
                }
                break;
            case 9:
                cout << "End\n";
                break;
            default:
                cout<<"Error: Wrong paragraph\n";
                break;
        }
    }
    return 0;
     */
    int n;
    
    ifstream file("complex.txt");
    file >> n;
    
    if (n>0)
    {
        complex *zmas = new complex [n];
        
        cout << "Numbers are : ";
        for (int i = 0; i<n; i++)
        {
            file >> zmas[i].Re >> zmas[i].Im;
            compl_Print(zmas[i]);
        }
        cout<<"Maximum absolute value is: "<<max_Abs(zmas, n)<<"\n";
        delete [] zmas;
    }
    else
    {
        cout << "Error: number of complex numbers is incorrect \n";
    }
    return 0;
}
