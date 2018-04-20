using System;
namespace lab6
{
    public abstract class Animal
    {
        public abstract int Age();
        public abstract string Type();
        public abstract string Gender();
        public static void Main()
        {
            Bird bird = new Bird(2,"попугай","женский");
            Console.WriteLine("Порода птицы: {0} \n Пол птицы: {1} \n Возраст птицы {2} \n",bird.type,bird.gender,bird.age);

            Fish fish = new Fish(3,"карасик","мужской");
            Console.WriteLine("Порода рыбы: {0} \n Пол рыбы: {1} \n Возраст рыбы {2} \n", fish.type, fish.gender, fish.age);

            Console.ReadKey();
        }
    }
    class Bird:Animal
    {
        public int age;
        public string type;
        public string gender;
        public Bird(int a, string r, string g)
        {
            age = a;
            type = r;
            gender = g;
        }
		public override int Age()
		{
            return age;
		}
		public override string Type()
		{
            return type;
		}
		public override string Gender()
		{
            return gender;
		}
	}
    class Fish:Animal
    {
        public int age;
        public string type;
        public string gender;
        public Fish(int a, string r, string g)
        {
            age = a;
            type = r;
            gender = g;
        }
        public override int Age()
        {
            return age;
        }
        public override string Type()
        {
            return type;
        }
        public override string Gender()
        {
            return gender;
        }
    }
}
