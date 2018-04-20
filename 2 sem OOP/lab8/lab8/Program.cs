using System; 
using System.Collections.Generic; 
using System.Collections; 
using System.Linq; 
using System.Text; 
using System.Threading.Tasks; 

namespace Lab8 
{ 
class Program 
{ 
static void Main(string[] args) 
{
            /* 
            Queue<string> washing = new Queue<string>(); 

            washing.Enqueue("Matvey"); 
            washing.Enqueue("Fil"); 
            washing.Enqueue("Masha"); 
            washing.Enqueue("Zorina"); 

            while(washing.Count!=0) 
            { 
            Console.WriteLine(washing.Peek()); 
            washing.Dequeue(); 
            } 
            */

            /* 
            List<Complex> Compl = new List<Complex>(); 
            Compl.Add(new Complex(0.5, 12)); 
            Compl.Add(new Complex(-5, -35.902)); 

            while(Compl.Count!=0) 
            { 
            Console.WriteLine(Compl.First().Re + " " + Compl.First().Im + "i"); 
            Compl.RemoveAt(0); 
            } 
            */
            Dictionary<string, int, int> student = new Dictionary<string, int, int>(); 
student.Add(new Student("Jopa", 20, 4)); 
student.Add(new Student("FILIP", 18, 1)); 
foreach(Object obj in student) 
{ 
Console.WriteLine(obj); 
}
Console.ReadKey(); 
} 

} 
public class Student 
{ 
public string name; 
public int age; 
public int degree; 

public void Write() 
{ 
Console.WriteLine("Name " + name + " Age " + age + " Degree " + degree); 
} 
public Student(string a,int b,int c) 
{ 
name = a; 
age = b; 
degree = c; 
} 
} 
public class Complex 
{ 
public double Re; 
public double Im; 

public Complex(double Real,double Imaginary) 
{ 
Re = Real; 
Im = Imaginary; 
} 

double mod() 
{ 
return Math.Sqrt(Re * Re + Im * Im); 
} 
double arg() 
{ 
return Math.Atan2(Math.Sin(Re / mod()), Math.Cos(Re / mod())); 
} 
Complex(Complex obj) 
{ 
Re = obj.Re; 
Im = obj.Im; 
} 
} 
}