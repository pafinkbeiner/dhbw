class ComplicatedClass_MethodCall
{

    int i;

    ComplicatedClass_MethodCall(int a, int b){
        this.i = doMath(a,b);
    }

    int doMath(int zahl1, int zahl2)
    {
        return (zahl1 + zahl2)*3;
    }
}
