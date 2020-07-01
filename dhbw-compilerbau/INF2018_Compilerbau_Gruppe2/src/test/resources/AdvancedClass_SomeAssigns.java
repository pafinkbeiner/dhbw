class AdvancedClass_SomeAssigns
{
    void assign(int zahl1, int zahl2, int zahl3, boolean validator)
    {
        zahl1 = 100;
        if ( zahl2 < zahl1 )
        {
            zahl2 = zahl2 * 3;
            zahl1 = zahl2 + zahl1;
            zahl3 = 1000 - zahl1;
            validator = true;
        }
        else
        {
            zahl3 = 500 - zahl1;
            zahl2 = zahl1 * zahl3 - 30;
        }

    }
}