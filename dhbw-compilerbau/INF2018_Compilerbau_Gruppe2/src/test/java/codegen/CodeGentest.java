/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package codegen;

import static org.junit.jupiter.api.Assertions.fail;

import abstrakteSyntax.Klasse;
import helper.TypecheckObjects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CodeGentest
{
    TypecheckObjects helper;

    @BeforeAll
    public void setUp()
    {
        helper = new TypecheckObjects();
    }

    /**
     * class SimpleClass{}
     */
    @Test
    public void generateSimpleClassTest()
    {
        try
        {
            Klasse klasse = helper.simpleClass();
            klasse.codeGen();
        }
        catch(Exception e)
        {
            fail(e);
        }
    }

    /**
     * class SimpleClass_Params{ int i; char c; boolean b;}
     */
    @Test
    public void generateSimpleClassParamsTest()
    {
        try
        {
            Klasse klasse = helper.simpleClass_Params();
            klasse.codeGen();
        }
        catch(Exception e)
        {
            fail(e);
        }
    }

    /**
     * class SimpleClass_EmptyConstructor { SimpleClass_EmptyConstructor() { } }
     */
    @Test
    public void generateSimpleClassCharConstructorTest()
    {
        try
        {
            Klasse klasse = helper.simpleClass_CharConstructor();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_VoidMethod_Bool{ boolean b; void method(int i, boolean d){ i = i+1; d = !false; } }
     */
    @Test
    public void generateVoidMethodBool()
    {
        try
        {
            Klasse klasse = helper.advancedClass_VoidMethod_Bool();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyVoidMethod { void method(){ } }
     */
    @Test
    public void generateEmptyVoidMethod()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyVoidMethod();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail();
        }
    }

    /**
     * class AdvancedClass_EmptyCharMethod { char method(){ return 'B'; } }
     */
    @Test
    public void generateEmptyCharMethod()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyCharMethod();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyCharMethod_ParamChar { char method (char c, char a){ return c; } }
     */
    @Test
    public void generateCharMethodWithChar()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyCharMethod_ParamChar();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyIntMethod { int method(){ return 0; } }
     */
    @Test
    public void generateIntMethod()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyIntMethod();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyIntMethod_ParamInt { int method(int i){ return i; } }
     */
    @Test
    public void generateIntMethodParamInt()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyIntMethod_ParamInt();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    @Test
    public void generateComplicatedClassSomeMethodsTest()
    {

        try
        {
            Klasse klasse = helper.complicatedClass_SomeMethods();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyVoidMethod_ParamChar { char c; void method(char c){ this.c = c; } }
     */
    @Test
    public void generateAdvancedClass_VoidMethod_CharParams()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyVoidMethod_ParamChar();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_EmptyVoidMethod_ParamIntAdd { boolean b; void method(int i){ i = i++; } }
     */
    @Test
    public void generate_VoidMethod_IntParamsAdd()
    {
        try
        {
            Klasse klasse = helper.advancedClass_EmptyVoidMethod_ParamIntAdd();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_IfElseReturn { boolean condition(int i) { if ( (i % 3) == 0 ) { return true; } else if ( (i %
     * 3) == 1 ) { return false; } else { return false; } } }
     */
    @Test
    public void generate_IfElse_BoolReturn()
    {
        try
        {
            Klasse klasse = helper.advancedClass_IfElseReturn();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_VoidMethodCondition_IntParam { int controll; void condition(int i) { if ( i < 2 ) { controll
     * = 5; } } }
     */
    @Test
    public void generate_IfCondition_IntParam()
    {
        try
        {
            Klasse klasse = helper.advancedClass_VoidMethodCondition_IntParam();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_VoidMethodIfElseCondition_IntParam { char controll;
     * void condition(char c) { if ( c == 'a' ) { controll = 'y'; } else { controll = 'n'; } } }
     */
    @Test
    public void generate_IfElseCondition_IntParam()
    {
        try
        {
            Klasse klasse = helper.advancedClass_VoidMethodIfElseCondition_IntParam();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_WhileLoop { void whileloop(int i) { while ( i > 7 ) { i = i - 1; }
     * } }
     */
    @Test
    public void generate_WhileLoop()
    {
        try
        {
            Klasse klasse = helper.advancedClass_WhileLoop();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class ComplicatedClass_MethodCall {
     * ComplicatedClass_MethodCall(int a, int b){ doMath(a,b); }
     * int doMath(int zahl1, int zahl2) { return (zahl1 + zahl2)*3; } }
     */
    @Test
    public void generate_MethodCall()
    {
        try
        {
            Klasse klasse = helper.complicatedClass_MethodCall();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class ComplicatedClass_SomeMath { int a; int b;
     * ComplicatedClass_SomeMath(int a, int b) { this.a = a; this.b = b; }
     * int add() { return this.a + this.b; }
     * int substract() { return this.a - this.b; }
     * int multiply() { return this.a * this.b; }
     * int divide() { return this.a / this.b; }
     * void setA(int a) { this.a = a; }
     * void setB(int b) { this.b = b; } }
     */
    @Test
    public void generate_SomeMath()
    {
        try
        {
            Klasse klasse = helper.complicatedClass_SomeMath();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class ComplicatedClass_SomeMethods { int add(int a, int b) { return a+b; }
     * int sub(int a, int b) { return a-b; }
     * int loops(boolean b, int i) { while(i>5) { b = false; i = i--; }
     * return i; }
     * }
     */
    @Test
    public void generate_SomeMethods()
    {
        try
        {
            Klasse klasse = helper.complicatedClass_SomeMethods();
            klasse.codeGen();
        }
        catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_SomeAssigns { void assign(int zahl1, int zahl2, int zahl3, boolean validator) { zahl1 = 100;
     * if ( zahl2 < zahl1 ) { zahl2 = zahl2 * 3; zahl1 = zahl2 + zahl1; zahl3 = 1000 - zahl1; validator = true; } else {
     * zahl3 = 500 - zahl1; zahl2 = zahl1 * zahl3 - 30; } } }
     */
    @Test
    public void generate_SomeAssigns()
    {
        try
        {
            Klasse klasse = helper.advancedClass_SomeAssigns();
            klasse.codeGen();
        } catch ( Exception e )
        {
            fail(e);
        }
    }

    /**
     * class AdvancedClass_NestedCondition { char nesting(boolean controll, int calculator) { if(controll != true) { if
     * (calculator == 0) { calculator = 10; return 'n'; } else { calculator = 3; return 'y'; } } else { return 'n'; } }
     * }
     */
    @Test
    public void generate_NestedCondition()
    {
        try
        {
            Klasse klasse = helper.advancedClass_NestedCondition();
            klasse.codeGen();
        } catch ( Exception e )
        {
            fail(e);
        }
    }
}
