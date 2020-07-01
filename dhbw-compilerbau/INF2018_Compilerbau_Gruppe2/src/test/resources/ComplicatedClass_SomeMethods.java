class ComplicatedClass_SomeMethods
{
    int add(int a, int b)
    {
        return a+b;
    }

    int sub(int a, int b)
    {
        return a-b;
    }

    int loops(boolean b, int i)
    {
        while(i>5)
        {
            b = false;
            i = i--;
        }

        return i;
    }

}
