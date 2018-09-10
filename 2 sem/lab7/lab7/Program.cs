using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    abstract public class Human
    {
        string name;
        string surname;
        string midname;
        int age;

        public Human(string name, string surname, string midname, int age)
        {
            this.name = name;
            this.surname = surname;
            this.midname = midname;
            this.age = age;
        }
        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        public string surName
        {
            get { return surname; }
            set { surname = value; }
        }
        public string midName
        {
            get { return midname; }
            set { midname = value; }
        }
        public int Age
        {
            get { return age; }
            set { age = value; }
        }
        public virtual string HumanInfo(Human obj)
        {
            string s = "Info about person: \n Name: " + Name + "SurName: " + surName + "MidName: " + midName + "\n";
            return s;
        }
    }
    class Student : Human
    {
        bool onLession;
        public Student(bool onLession, string name, string surname, string midname, int age)
        : base(name, surname, midname, age)
        {
            this.onLession = onLession;
        }
        public override string HumanInfo(Human obj)
        {
            return base.HumanInfo(obj) + "On Lession: " + onLession + "\n";
        }
    }
    class Boss : Human
    {
        int WorkersCount;
        public Boss(int WorkersCount, string name, string surname, string midname, int age)
        : base(name, surname, midname, age)
        {
            this.WorkersCount = WorkersCount;
        }
        public override string HumanInfo(Human obj)
        {
            return base.HumanInfo(obj) + "Count of workers: " + WorkersCount + "\n";
        }
    }
    class Program
    {
        static void Main()
        {
            Student student1 = new Student(onLession: false, name: "Matvey ", surname: "Kryuchkov ", midname: "Romanovich ", age: 17);
            Console.WriteLine(student1.HumanInfo(student1));

            Boss firstBoss = new Boss(WorkersCount: 3, name: "Fil ", surname: "Prilip ", midname: "Mutko ", age: 18);
            Console.WriteLine(firstBoss.HumanInfo(firstBoss));
            Console.ReadKey();
        }
    }
}