using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace Lab8
{
    class Program
    {
        static void Main(string[] args)
        {
            Queue<string> washing = new Queue<string>();

            washing.Enqueue("Matvey");
            washing.Enqueue("Konstantin");
            washing.Enqueue("Masha");
            washing.Enqueue("Katya");

            while (washing.Count != 0)
            {
                Console.WriteLine(washing.Peek());
                washing.Dequeue();
            }


            /*
            var Compl = new List<Tuple<double, double>>() {
                Tuple.Create(0.5, 12.0),
                Tuple.Create(-5.0, -35.902)
            };

            foreach( Tuple<double, double> value in Compl) {
                Console.WriteLine(value.Item1 + "+(" + value.Item2 + ")i");
            }
            */

            /*
Dictionary<string, int, int> student = new Dictionary<string, int, int>(); 
student.Add(new Student("Andrey", 20, 4)); 
student.Add(new Student("Filip", 18, 1)); 

foreach(Object obj in student) { 
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

            public void Write() { 
                        Console.WriteLine("Name " + name + " Age " + age + " Degree " + degree); 
            } 
            public Student(string a,int b,int c) { 
                        name = a; 
                        age = b; 
                        degree = c; 
            } 
} 
            public class Complex 
{ 
            public double Re; 
            public double Im; 

            public Complex(double Real,double Imaginary) { 
                        Re = Real; 
                        Im = Imaginary; 
            } 

            double mod() { 
                        return Math.Sqrt(Re * Re + Im * Im); 
            } 
            double arg() { 
                        return Math.Atan2(Math.Sin(Re / mod()), Math.Cos(Re / mod())); 
            } 
            Complex(Complex obj) { 
                        Re = obj.Re; 
                        Im = obj.Im; 
            } */
        }
    }
}