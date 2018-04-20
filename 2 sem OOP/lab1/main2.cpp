
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
        
        cout<<"Maximum absolute value is: "<<max_Abs(zmas, n)<<"\n";
        delete [] zmas;
    }
    }
    else
    {
        cout << "Error: number of complex numbers is incorrect \n";
    }
    return 0;
}
