using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aufgabe_5
{
    public static class ExtensionString
    {
        public static int CountWords(this String str)
        {
            int count = 0;
            foreach (String s in str.Split(' ', '\t')) 
            {
                count++;
            }
            return count;
        }
    }
}
