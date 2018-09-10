using System;
namespace lab2
{
    public class Programm
    {
        public static void Main()
        {
            vivid[] array = new vivid[10] {1,2,3,4,5,6,7,8,9,0};
            int sum = 0;
            Console.WriteLine("Print massive elements: ");
            for (int i = 0; i < array.Length; i++)
            {
                sum += Convert.ToInt32(array[i]);
            }
            ravno(sum,array);
        }
        public delegate void vivid();

        public static vivid ravno(int s, vivid[] a)
        {
            if(s==Convert.ToInt32(a[0]))
            {
                Array.Reverse(array: a);
                Console.WriteLine("Reversed massive: ");
                foreach (vivid f in a)
                {
                    Console.WriteLine(f + " ");
                }
            }

            return a[10];
        }
        public static vivid bolsh(int s,vivid[] a)
        {
            if(s==Convert.ToInt32(a[0]))
            {
                for (int i = 0; i < a.Length-1; i++)
                {
                    if(Convert.ToInt32(a[i])>Convert.ToInt32(a[i+1]))
                    {
                        int j = Convert.ToInt32(a[i]);
                        a[i] = a[i + 1];
                        a[i + 1] = j;
                    }
                }
            }
            return a[10];
        }
        public static vivid mensh(int s, vivid[] a)
        {
            if (s == Convert.ToInt32(a[0]))
            {
                for (int i = 0; i < a.Length - 1; i++)
                {
                    if (Convert.ToInt32(a[i]) < Convert.ToInt32(a[i + 1]))
                    {
                        int j = Convert.ToInt32(a[i]);
                        a[i] = a[i + 1];
                        a[i + 1] = j;
                    }
                }
            }
            return a[10];
        }
	}
}
