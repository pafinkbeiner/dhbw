class ComplicatedClass_SomeMath
{
    int a;
    int b;

    ComplicatedClass_SomeMath(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    int add()
    {
        return this.a + this.b;
    }

    int substract()
    {
        return this.a - this.b;
    }

    int multiply()
    {
        return this.a * this.b;
    }

    int divide()
    {
        return this.a / this.b;
    }

    void setA(int a)
    {
        this.a = a;
    }

    void setB(int b)
    {
        this.b = b;
    }
}
