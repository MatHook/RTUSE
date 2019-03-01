using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DayOfWeekExample
{
    class Program
    {
        static int zzz(string a)
        {
            return Convert.ToInt32(a);
        }
        static void Main(string[] args)
        {
            Console.Write("Введите день : ");
            string day = Console.ReadLine();
            Console.Write("Введите месяц : ");
            string month = Console.ReadLine();
            Console.Write("Введите год : ");
            string year = Console.ReadLine();

            DateTime ddd = new DateTime(zzz(year), zzz(month), zzz(day));
            DayOfWeek qqq = ddd.DayOfWeek;
            string dayOfWeekResult = "";
            switch (qqq)
            {
                case DayOfWeek.Sunday:
                    dayOfWeekResult = "Воскресенье";
                    break;
                case DayOfWeek.Monday:
                    dayOfWeekResult = "Понедельник";
                    break;
                case DayOfWeek.Tuesday:
                    dayOfWeekResult = "Вторник";
                    break;
                case DayOfWeek.Wednesday:
                    dayOfWeekResult = "Среда";
                    break;
                case DayOfWeek.Thursday:
                    dayOfWeekResult = "Четверг";
                    break;
                case DayOfWeek.Friday:
                    dayOfWeekResult = "Пятница";
                    break;
                case DayOfWeek.Saturday:
                    dayOfWeekResult = "Суббота";
                    break;
                default:
                    break;
            }
            Console.WriteLine("День недели : " + dayOfWeekResult);
            Console.ReadKey();
        }
    }
}
