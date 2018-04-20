using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    class Program
    {
        static void Main(string[] args)
        {
            Child childName = new Child() { fName = Console.ReadLine(), sName = Console.ReadLine(), age = Convert.ToInt32(Console.ReadLine()) };

            Console.WriteLine("Name: " + childName.fName + " Last Name: " + childName.sName + " Age: " + childName.age);
            Console.ReadKey();
        }
    }
    class Child
    {
        private string Name;
        private string secName;
        private int Age;

        public int age
        {
            get { return Age; }
            set { Age = value; }
        }
        public string fName
        {
            get { return Name; }
            set { Name = value; }
        }
        public string sName
        {
            get { return secName; }
            set { secName = value; }
        }
    }
}