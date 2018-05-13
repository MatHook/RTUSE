#include <iostream>
#include "lab5.h"

using namespace std;

int main()
{
    Vector v1(1,2,3);
    Vector v2(1,2,4);
    cout << "1st vector: " << v1 << " 2nd vector: " << v2 << endl;
    if (v1 != v2)
        cout << "Dicke!";
    return 0;
}
