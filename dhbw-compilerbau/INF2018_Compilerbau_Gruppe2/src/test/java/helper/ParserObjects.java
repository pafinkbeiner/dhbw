package helper;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
import abstrakteSyntax.expression.BinaryBool;
import abstrakteSyntax.expression.BinaryInt;
import abstrakteSyntax.expression.Bool;
import abstrakteSyntax.expression.Char;
import abstrakteSyntax.expression.InstVar;
import abstrakteSyntax.expression.Integer;
import abstrakteSyntax.expression.LocalOrFieldVar;
import abstrakteSyntax.expression.StmtExprExpr;
import abstrakteSyntax.expression.This;
import abstrakteSyntax.expression.Unary;
import abstrakteSyntax.statements.Block;
import abstrakteSyntax.statements.If;
import abstrakteSyntax.statements.LocalVarDecl;
import abstrakteSyntax.statements.Return;
import abstrakteSyntax.statements.Statement;
import abstrakteSyntax.statements.StmtExprStmt;
import abstrakteSyntax.statements.SuperStatement;
import abstrakteSyntax.statements.While;
import abstrakteSyntax.stmtExpr.Assign;
import abstrakteSyntax.stmtExpr.MethodCall;
import abstrakteSyntax.stmtExpr.New;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ParserObjects implements Objects
{
    Klasse klasse;

    @Override
    public Klasse advancedClass_EmptyCharMethod()
    {

        //Create Block
        Block block = new Block();
        Block blockConstructor = new Block();

        //Create Return Statement
        ArrayList<Statement> statements = new ArrayList<>();
        Return statement = new Return();
        Unary returnExpr = new Unary();

        returnExpr.zahl = new Char()
        {{
            character = 'B';
            type = Types.Char;
        }};

        //Assign statements to block
        statement.expression = returnExpr;
        statements.add(statement);
        block.block = statements;

        //Create method and constructor
        ArrayList<Methode> methods = new ArrayList<>();
        Methode method = new Methode()
        {{
            name = "method";
            body = block;
            rueckgabetyp = Types.Char;
            parameter = new ArrayList<>();
        }};
        methods.add(method);

        //Constructor method block
        ArrayList<Statement> statements1 = new ArrayList<>();
        SuperStatement superStatement = new SuperStatement();
        statements1.add(superStatement);
        blockConstructor.block = statements1;

        //Method attributes
        Methode cons = new Methode()
        {{
            name="AdvancedClass_EmptyCharMethod";
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
            body = blockConstructor;
        }};

        methods.add(cons);

        //Create class and assign method
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyCharMethod";
            methoden = methods;
            attribute = new ArrayList<>();
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_IfElseReturn()
    {
        //Create main Block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        //If Statement
        If ifstat = new If();

        //if expression
        BinaryBool ifexpr = new BinaryBool();
        ifexpr.rechenzeichen = Types.equal;

        //BinaryBool zahl1
        BinaryInt ifexprzahl1 = new BinaryInt();

        Unary ifexprzahl1zahl1 = new Unary();
        ifexprzahl1zahl1.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        Unary ifexprzahl1zahl2 = new Unary();
        ifexprzahl1zahl2.zahl = new Integer()
        {{
            integer = 3;
            type = Types.Integer;
        }};

        ifexprzahl1.zahl1 = ifexprzahl1zahl1;
        ifexprzahl1.zahl2 = ifexprzahl1zahl2;
        ifexprzahl1.rechenzeichen = Types.Modulo;

        ifexpr.zahl1 = ifexprzahl1;

        //BinaryBool zahl2
        Unary ifexprzahl2 = new Unary();
        Integer ifexprzahl2zahl = new Integer()
        {{
            integer = 0;
            type = Types.Integer;
        }};
        ifexprzahl2.zahl = ifexprzahl2zahl;

        ifexpr.zahl2 = ifexprzahl2;
        ifstat.expression = ifexpr;

        //if statement
        Block ifstatement = new Block();
        ArrayList<Statement> ifstatementstats = new ArrayList<>();

        Return ifstatementstats_elem0 = new Return();
        Unary returnExpr = new Unary();
        returnExpr.zahl = new Bool()
        {{
            bool = true;
            type = Types.Boolean;
        }};
        ifstatementstats_elem0.expression = returnExpr;
        ifstatementstats.add( ifstatementstats_elem0);
        ifstatement.block = ifstatementstats;

        //if maybeStatement
        If maybeStat = new If();
        BinaryBool maybeStatexpr = new BinaryBool();
        BinaryInt maybeStatexprZahl1 = new BinaryInt();
        Unary binaryzahl1 = new Unary();
        binaryzahl1.zahl = new LocalOrFieldVar(){{
            name = "i";
        }};
        Unary binaryZahl2 = new Unary();
        binaryZahl2.zahl = new Integer()
        {{
            integer = 3;
            type = Types.Integer;
        }};
        maybeStatexprZahl1.zahl1 = binaryzahl1;
        maybeStatexprZahl1.zahl2 = binaryZahl2;
        maybeStatexprZahl1.rechenzeichen = Types.Modulo;

        Unary maybestatexprZahl2 = new Unary();
        maybestatexprZahl2.zahl = new Integer()
        {{
            integer = 1;
            type = Types.Integer;
        }};

        maybeStatexpr.zahl1 = maybeStatexprZahl1;
        maybeStatexpr.zahl2 = maybestatexprZahl2;
        maybeStatexpr.rechenzeichen = Types.equal;

        Block maybeStatStat = new Block();
        ArrayList<Statement> maybeStatStatStats = new ArrayList<>();
        Return returns = new Return();
        Unary returnEx = new Unary();
        returnEx.zahl = new Bool()
        {{
            bool = false;
            type = Types.Boolean;
        }};
        returns.expression = returnEx;
        maybeStatStatStats.add(returns);
        maybeStatStat.block = maybeStatStatStats;

        Block maybeStatmaybeStat = new Block();
        ArrayList<Statement> maybeStatmaybeStatStats = new ArrayList<>();
        Return returnst = new Return();
        Unary reutrnE = new Unary();
        reutrnE.zahl = new Bool()
        {{
            bool = false;
            type= Types.Boolean;
        }};
        returnst.expression = reutrnE;
        maybeStatmaybeStatStats.add(returnst);
        maybeStatmaybeStat.block = maybeStatmaybeStatStats;

        maybeStat.expression = maybeStatexpr;
        maybeStat.statement = maybeStatStat;
        maybeStat.maybeStatement = maybeStatmaybeStat;

        ifstat.statement = ifstatement;
        ifstat.maybeStatement = maybeStat;

        statements.add(ifstat);
        block.block = statements;

        //Create method params
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut param1 = new Attribut(){{
            name = "i";
            type = Types.Integer;
        }};
        params.add(param1);

        //Create Method
        ArrayList<Methode> methods = new ArrayList<>();

        Methode method = new Methode()
        {{
            name = "condition";
            parameter = params;
            body = block;
            rueckgabetyp = Types.Boolean;
        }};

        methods.add(method);

        //Create COnstructor
        Block blockCons = new Block();
        ArrayList<Statement> constsStats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        constsStats.add(supers);
        blockCons.block = constsStats;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_IfElseReturn";
            parameter = new ArrayList<>();
            body = blockCons;
            rueckgabetyp = "keiner";
        }};
        methods.add(constructor);

        //Create class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_IfElseReturn";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyIntMethod()
    {
        //Create Block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        Return returns = new Return();
        Unary returnExpr = new Unary();
        returnExpr.zahl = new Integer()
        {{
            integer = 0;
            type = Types.Integer;
        }};

        returns.expression = returnExpr;
        statements.add(returns);
        block.block = statements;

        //Create Method
        ArrayList<Methode> methods = new ArrayList<>();

        Methode method = new Methode()
        {{
            name = "method";
            parameter = new ArrayList<>();
            rueckgabetyp = Types.Integer;
            body = block;
        }};

        methods.add(method);

        //Create Constructor
        Block blockCOns = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        blockCOns.block = stats;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_EmptyIntMethod";
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
            body = blockCOns;
        }};

        methods.add(constructor);

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyIntMethod";
            methoden = methods;
            attribute = new ArrayList<>();
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_VoidMethodIfElseCondition_IntParam()
    {
        //method condition block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        If ifs = new If();
        BinaryBool ifexpr = new BinaryBool();
        Unary ifexprz1 = new Unary();
        ifexprz1.zahl = new LocalOrFieldVar()
        {{
            name = "c";
        }};

        Unary ifexprz2 = new Unary();
        ifexprz2.zahl = new Char()
        {{
            character = 'a';
            type = Types.Char;
        }};

        ifexpr.zahl1 = ifexprz1;
        ifexpr.zahl2 = ifexprz2;
        ifexpr.rechenzeichen = "==";

        Block ifmaybe = new Block();
        ArrayList<Statement> ifmaystats = new ArrayList<>();
        StmtExprStmt maystexpr = new StmtExprStmt();
        Assign mayas = new Assign();
        LocalOrFieldVar mayasziel = new LocalOrFieldVar()
        {{
            name = "controll";

        }};
        Unary maywert = new Unary();
        maywert.zahl = new Char()
        {{
            character = 'n';
            type = Types.Char;
        }};
        mayas.wert = maywert;
        mayas.ziel = mayasziel;
        maystexpr.stmtExpr = mayas;
        ifmaystats.add(maystexpr);
        ifmaybe.block = ifmaystats;

        Block ifstat = new Block();
        ArrayList<Statement> ifstats = new ArrayList<>();
        StmtExprStmt stexpr = new StmtExprStmt();
        Assign as = new Assign();
        LocalOrFieldVar asziel = new LocalOrFieldVar()
        {{
            name = "controll";

        }};
        Unary wert = new Unary();
        wert.zahl = new Char()
        {{
            character = 'y';
            type = Types.Char;
        }};
        as.wert = wert;
        as.ziel = asziel;
        stexpr.stmtExpr = as;
        ifstats.add(stexpr);
        ifstat.block = ifstats;

        ifs.expression = ifexpr;
        ifs.statement = ifstat;
        ifs.maybeStatement = ifmaybe;

        statements.add(ifs);
        block.block = statements;

        //Method params
        ArrayList<Attribut> params = new ArrayList<>();
        params.add(new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }});

        //Create Method
        ArrayList<Methode> methods = new ArrayList<>();
        methods.add(new Methode()
        {{
            name = "condition";
            parameter = params;
            body = block;
            rueckgabetyp = Types.Void;
        }});

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> consStats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        consStats.add(supers);
        consBlock.block = consStats;

        methods.add(new Methode()
        {{
            name = "AdvancedClass_VoidMethodIfElseCondition_IntParam";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }});

        //Class params
        ArrayList<Attribut> classattribs = new ArrayList<>();
        classattribs.add(new Attribut()
        {{
            name = "controll";
            type = Types.Char;
        }});

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_VoidMethodIfElseCondition_IntParam";
            methoden = methods;
            attribute = classattribs;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_VoidMethodCondition_IntParam()
    {
        //Create method condition
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        If ifstat = new If();

        //If expression
        BinaryBool ifexpr = new BinaryBool();
        Unary ifexprzahl1 = new Unary();
        ifexprzahl1.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};
        Unary ifexprzahl2 = new Unary();
        ifexprzahl2.zahl = new Integer()
        {{
            integer = 2;
            type = Types.Integer;
        }};
        ifexpr.zahl1 = ifexprzahl1;
        ifexpr.zahl2 = ifexprzahl2;
        ifexpr.rechenzeichen = "<";
        ifstat.expression = ifexpr;

        //If statement
        Block ifstate = new Block();
        ArrayList<Statement> ifstatstats = new ArrayList<>();
        StmtExprStmt ifstatselem0 = new StmtExprStmt();
        Assign a = new Assign();
        a.ziel = new LocalOrFieldVar()
        {{
            name = "controll";
        }};
        a.wert = new Unary()
        {{
            zahl = new Integer()
            {{
                integer = 5;
                type = Types.Integer;
            }};
        }};
        ifstatselem0.stmtExpr = a;
        ifstatstats.add(ifstatselem0);
        ifstate.block = ifstatstats;
        ifstat.statement = ifstate;

        statements.add(ifstat);
        block.block = statements;

        //Method params
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut p0 = new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }};
        params.add(p0);

        //Create method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode condition = new Methode()
        {{
            name = "condition";
            parameter = params;
            body = block;
            rueckgabetyp = Types.Void;
        }};
        methods.add(condition);

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> consstats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        consstats.add(supers);
        consBlock.block = consstats;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_VoidMethodCondition_IntParam";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }};
        methods.add(constructor);

        //Class attributes
        ArrayList<Attribut> attributes = new ArrayList<>();
        attributes.add(new Attribut(){{
            name = "controll";
            type = Types.Integer;
        }});

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_VoidMethodCondition_IntParam";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    @Override
    public Klasse simpleClass_Params()
    {
        //Create Empty Constructor
        ArrayList<Methode> methods = new ArrayList<>();
        Block block = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        block.block = stats;

        Methode methode = new Methode()
        {{
            name = "SimpleClass_Params";
            parameter = new ArrayList<>();
            body = block;
            rueckgabetyp = "keiner";
        }};

        methods.add(methode);

        //Create class attributes
        Attribut attribut1 = new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }};
        Attribut attribut2 = new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }};

        Attribut attribut3 = new Attribut()
        {{
            name = "b";
            type = Types.Boolean;
        }};

        //Add attributes to list
        ArrayList<Attribut> attributes = new ArrayList<>();
        attributes.add(attribut1);
        attributes.add(attribut2);
        attributes.add(attribut3);

        //Create class
        klasse = new Klasse()
        {{
            name = "SimpleClass_Params";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyVoidMethod_ParamChar()
    {

        //Create method block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        StmtExprStmt s = new StmtExprStmt();
        Assign a = new Assign();

        //Assign Assign ziel
        InstVar i = new InstVar();
        i.first = new This();
        i.second = new LocalOrFieldVar()
        {{
            name = "c";
        }};
        a.ziel = i;

        //Assign Assign wert
        Unary u = new Unary();
        u.zahl = new LocalOrFieldVar()
        {{
            name = "c";
        }};
        a.wert = u;
        s.stmtExpr = a;
        statements.add(s);
        block.block = statements;

        //Create method params
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut p0 = new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }};
        params.add(p0);

        //Create method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode method = new Methode()
        {{
            name = "method";
            parameter = params;
            body = block;
            rueckgabetyp = Types.Void;
        }};
        methods.add(method);

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        consBlock.block = stats;

        Methode constructor = new Methode(){{
            name = "AdvancedClass_EmptyVoidMethod_ParamChar";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }};
        methods.add(constructor);

        //Create class attributes
        ArrayList<Attribut> attributes = new ArrayList<>();
        Attribut a0 = new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }};

        attributes.add(a0);

        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyVoidMethod_ParamChar";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyVoidMethod()
    {
        //Create method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode method = new Methode()
        {{
            rueckgabetyp = Types.Void;
            name = "method";
            parameter = new ArrayList<Attribut>();
            body = new Block()
            {{
                block = new ArrayList<>();
            }};
        }};
        methods.add(method);

        //Constructor
        Methode constructor = new Methode();

        Block consBlock = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        statements.add(supers);
        consBlock.block = statements;

        constructor.name = "AdvancedClass_EmptyVoidMethod";
        constructor.rueckgabetyp = "keiner";
        constructor.parameter = new ArrayList<>();
        constructor.body = consBlock;

        methods.add(constructor);

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyVoidMethod";
            methoden = methods;
            attribute = new ArrayList<>();
        }};

        return klasse;
    }

    @Override
    public Klasse complicatedClass_SomeMath()
    {
        //Constructor
        Block consBlock = new Block();
        ArrayList<Statement> consstats = new ArrayList<>();

        //Statement 0
        StmtExprStmt conselem0 = new StmtExprStmt();
        Assign elem0assign = new Assign();

        //Assing ziel
        InstVar elem0assignziel = new InstVar();
        elem0assignziel.first = new This();
        elem0assignziel.second = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        elem0assign.ziel = elem0assignziel;

        //Assign wert
        Unary elem0assignwert = new Unary();
        elem0assignwert.zahl = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        elem0assign.wert = elem0assignwert;

        conselem0.stmtExpr = elem0assign;
        consstats.add(conselem0);

        //Statement 1
        StmtExprStmt conselem1 = new StmtExprStmt();
        Assign elem1assign = new Assign();

        //Assign ziel
        InstVar assignziel = new InstVar();
        assignziel.first = new This();
        assignziel.second = new LocalOrFieldVar()
        {{
            name = "b";
        }};
        elem1assign.ziel = assignziel;

        //Assign wert
        Unary elem1wert = new Unary();
        elem1wert.zahl = new LocalOrFieldVar()
        {{
            name = "b";
        }};
        elem1assign.wert = elem1wert;

        conselem1.stmtExpr = elem1assign;
        consstats.add(conselem1);
        consBlock.block = consstats;

        //Constructor parameter
        ArrayList<Attribut> consparam = new ArrayList<>();
        Attribut p0 = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }};
        Attribut p1 = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }};

        consparam.add(p0);
        consparam.add(p1);

        //Create constructor
        ArrayList<Methode> methods = new ArrayList<>();

        Methode constructor = new Methode()
        {{
            name = "ComplicatedClass_SomeMath";
            parameter = consparam;
            body = consBlock;
            rueckgabetyp = "keiner";
        }};

        methods.add(constructor);

        //Method add
        Block addBlock = new Block();
        ArrayList<Statement> addstats = new ArrayList<>();
        Return ret = new Return();
        BinaryInt retbin = new BinaryInt();

        //zahl1
        Unary unary = new Unary();
        InstVar unaryzahl = new InstVar();
        unaryzahl.first = new This();
        unaryzahl.second = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        unary.zahl = unaryzahl;
        retbin.zahl1 = unary;

        //zahl2
        Unary u = new Unary();
        InstVar uzahl = new InstVar();
        uzahl.first = new This();
        uzahl.second = new LocalOrFieldVar()
        {{
            name = "b";
        }};
        u.zahl = uzahl;
        retbin.zahl2 = u;
        retbin.rechenzeichen = "+";
        ret.expression = retbin;
        addstats.add(ret);
        addBlock.block = addstats;

        Methode add = new Methode()
        {{
            name = "add";
            parameter = new ArrayList<>();
            body = addBlock;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(add);

        //Method substract
        Block subBlock = new Block();
        ArrayList<Statement> substats = new ArrayList<>();
        Return subret = new Return();
        BinaryInt subretbin = new BinaryInt();
        subretbin.zahl1 = unary;
        subretbin.zahl2 = u;
        subretbin.rechenzeichen = "-";
        subret.expression = subretbin;
        substats.add(subret);
        subBlock.block = substats;

        Methode substract = new Methode()
        {{
            name ="substract";
            parameter = new ArrayList<>();
            body = subBlock;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(substract);

        //Method multiply
        Block multBlock = new Block();
        ArrayList<Statement> multstats = new ArrayList<>();
        Return multret = new Return();
        BinaryInt multretbin = new BinaryInt();
        multretbin.zahl1 = unary;
        multretbin.zahl2 = u;
        multretbin.rechenzeichen = "*";
        multret.expression = multretbin;
        multstats.add(multret);
        multBlock.block = multstats;

        Methode multiply = new Methode()
        {{
            name ="multiply";
            parameter = new ArrayList<>();
            body = multBlock;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(multiply);

        //Method divide
        Block divBlock = new Block();
        ArrayList<Statement> divstats = new ArrayList<>();
        Return divret = new Return();
        BinaryInt divretbin = new BinaryInt();
        divretbin.zahl1 = unary;
        divretbin.zahl2 = u;
        divretbin.rechenzeichen = "/";
        divret.expression = divretbin;
        divstats.add(divret);
        divBlock.block = divstats;

        Methode divide = new Methode()
        {{
            name ="divide";
            parameter = new ArrayList<>();
            body = divBlock;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(divide);

        //setA method
        Block setAblock = new Block();
        ArrayList<Statement> astats= new ArrayList<>();
        StmtExprStmt x = new StmtExprStmt();
        Assign a = new Assign();
        InstVar aziel = new InstVar();
        aziel.first = new This();
        aziel.second = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        a.ziel = aziel;
        Unary awert = new Unary();
        awert.zahl = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        a.wert = awert;
        x.stmtExpr = a;
        astats.add(x);
        setAblock.block = astats;

        ArrayList<Attribut> aparams = new ArrayList<>();
        Attribut ap0 = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }}        ;
        aparams.add(ap0);

        Methode setA = new Methode()
        {{
            name = "setA";
            parameter = aparams;
            body = setAblock;
            rueckgabetyp = Types.Void;
        }};

        methods.add(setA);

        //setB method
        Block setBblock = new Block();
        ArrayList<Statement> bstats= new ArrayList<>();
        StmtExprStmt xb = new StmtExprStmt();
        Assign b = new Assign();
        InstVar bziel = new InstVar();
        bziel.first = new This();
        bziel.second = new LocalOrFieldVar()
        {{
            name = "b";
        }};
        b.ziel = bziel;
        Unary bwert = new Unary();
        bwert.zahl = new LocalOrFieldVar()
        {{
            name = "b";
        }};
        b.wert = bwert;
        xb.stmtExpr = b;
        bstats.add(xb);
        setBblock.block = bstats;

        ArrayList<Attribut> bparams = new ArrayList<>();
        Attribut bp0 = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }}        ;
        bparams.add(bp0);

        Methode setb = new Methode()
        {{
            name = "setB";
            parameter = bparams;
            body = setBblock;
            rueckgabetyp = Types.Void;
        }};

        methods.add(setb);

        //Class params
        ArrayList<Attribut> classparams = new ArrayList<>();
        Attribut cp0 = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }};
        Attribut cp1 = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }};
        classparams.add(cp0);
        classparams.add(cp1);

        klasse = new Klasse()
        {{
            name = "ComplicatedClass_SomeMath";
            attribute = classparams;
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyVoidMethod_ParamIntAdd()
    {
        //Create method block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        Assign assign = new Assign();

        //Ziel für erstes Statement im Block
        LocalOrFieldVar ziel = new LocalOrFieldVar();
        ziel.name = "i";

        //Ziel für zweites Statement im Blcok
        Unary wert = new Unary();
        LocalOrFieldVar zahl2 = new LocalOrFieldVar();
        zahl2.name = "i";
        wert.zahl = zahl2;
        wert.postfix = Types.Inkrement;

        //Assign Ziel and Wert
        assign.ziel = ziel;
        assign.wert = wert;

        //Assign Assign to StmtExprStmt
        StmtExprStmt exprStatement = new StmtExprStmt();
        exprStatement.stmtExpr = assign;

        statements.add(exprStatement);
        block.block = statements;

        //create method params
        ArrayList<Attribut> parameters = new ArrayList<>();
        Attribut parameter = new Attribut();
        parameter.name = "i";
        parameter.type = Types.Integer;
        parameters.add(parameter);

        //create method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode method = new Methode();
        method.name = "method";
        method.rueckgabetyp = Types.Void;
        method.parameter = parameters;
        method.body = block;
        methods.add(method);

        //create constructor
        Block consBlock = new Block();
        ArrayList<Statement> constStats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();

        constStats.add(supers);
        consBlock.block = constStats;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_EmptyVoidMethod_ParamIntAdd";
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
            body = consBlock;
        }};

        methods.add(constructor);

        //Create class attributes
        ArrayList<Attribut> attributes = new ArrayList<>();
        Attribut attribute = new Attribut();
        attribute.name = "b";
        attribute.type = Types.Boolean;
        attributes.add(attribute);

        //Create class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyVoidMethod_ParamIntAdd";
            attribute = attributes;
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse simpleClass()
    {
        //Add Empty Constructor to methods
        ArrayList<Methode> methods = new ArrayList<>();

        Block block = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        block.block = stats;

        Methode methode = new Methode()
        {{
            name = "SimpleClass";
            parameter = new ArrayList<>();
            body = block;
            rueckgabetyp = "keiner";
        }};
        methods.add(methode);

        //Assign class
        klasse = new Klasse()
        {
            {
                name = "SimpleClass";
                methoden = methods;
                attribute = new ArrayList<>();
            }
        };

        return klasse;
    }

    @Override
    public Klasse advancedClass_WhileLoop()
    {
        //Create Block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        While whilestat = new While();

        //While expression
        BinaryBool whileExpr = new BinaryBool();
        Unary binaryBoZahl1 = new Unary();
        binaryBoZahl1.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        Unary binaryBoZahl2 = new Unary();
        binaryBoZahl2.zahl = new Integer()
        {{
            integer = 7;
            type = Types.Integer;
        }};

        whileExpr.zahl1 = binaryBoZahl1;
        whileExpr.zahl2 = binaryBoZahl2;
        whileExpr.rechenzeichen = ">";
        whilestat.expression = whileExpr;

        //While statement
        Block  whilestatements = new Block();
        ArrayList<Statement> whilestatstats = new ArrayList<>();

        StmtExprStmt kp = new StmtExprStmt();
        Assign kpAssign = new Assign();
        kpAssign.ziel = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        BinaryInt wert = new BinaryInt();

        //Assing wert
        Unary x = new Unary();
        x.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        Unary y = new Unary();
        y.zahl = new Integer()
        {{
            integer = 1;
            type = Types.Integer;
        }};
        wert.zahl1 = x;
        wert.zahl2 = y;
        wert.rechenzeichen = "-";
        kpAssign.wert = wert;
        kp.stmtExpr = kpAssign;
        whilestatstats.add(kp);
        whilestatements.block = whilestatstats;

        whilestat.statement = whilestatements;
        statements.add(whilestat);
        block.block = statements;

        //Method Params
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut param0 = new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }};
        params.add(param0);

        //Create Method
        ArrayList<Methode> methods = new ArrayList<>();

        Methode method = new Methode()
        {{
            name = "whileloop";
            parameter = params;
            body = block;
            rueckgabetyp = Types.Void;
        }};

        methods.add(method);

        //Create construcotr
        Block consBlock = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        consBlock.block = stats;

        Methode constructor = new Methode()
        {{
            name= "AdvancedClass_WhileLoop";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }};

        methods.add(constructor);

        //Create class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_WhileLoop";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse simpleClass_CharConstructor()
    {
        //Constructor
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        StmtExprStmt s = new StmtExprStmt();
        Assign a = new Assign();
        InstVar i = new InstVar();
        i.first = new This();
        i.second = new LocalOrFieldVar()
        {{
            name = "c";
        }};
        Unary u = new Unary();
        u.zahl = new LocalOrFieldVar()
        {{
            name = "c";
        }};
        a.ziel = i;
        a.wert = u;
        s.stmtExpr = a;
        statements.add(s);
        block.block = statements;

        //constructor parameter
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut p0 = new Attribut(){{
            name = "c";
            type = Types.Char;
        }};
        params.add(p0);

        //Constructor method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode constrcutor = new Methode()
        {{
            name = "SimpleClass_CharConstructor";
            parameter = params;
            body = block;
            rueckgabetyp = "keiner";
        }};
        methods.add(constrcutor);

        //Klassenattribute
        ArrayList<Attribut> attributes = new ArrayList<>();
        attributes.add(new Attribut(){{
            name = "c";
            type = Types.Char;
        }});

        klasse = new Klasse()
        {{
            name = "SimpleClass_CharConstructor";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    @Override
    public Klasse simpleClass_EmptyConstructor()
    {
        //Create empty block
        Block block = new Block()
        {{
            block = new ArrayList<>();
        }};

        //Create constructor
        ArrayList<Methode> methods = new ArrayList<>();
        Methode method = new Methode()
        {{
            name = "SimpleClass_EmptyConstructor";
            parameter = new ArrayList<>();
            body = block;
            rueckgabetyp = "keiner";
        }};
        methods.add(method);

        //Create class
        Klasse klasse = new Klasse()
        {{
            name = "SimpleClass_EmptyConstructor";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyCharMethod_ParamChar()
    {
        //Create Block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        //Create return statement
        Return returnStat = new Return();
        Unary returnExpr = new Unary();
        returnExpr.zahl = new LocalOrFieldVar()
        {{
            name = "c";
        }};
        returnStat.expression = returnExpr;
        statements.add(returnStat);
        block.block = statements;

        //Create parameters
        Attribut attrib0 = new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }};

        Attribut attrib1 = new Attribut()
        {{
            name = "a";
            type = Types.Char;
        }};

        ArrayList<Attribut> paramters = new ArrayList<>();
        paramters.add(attrib0);
        paramters.add(attrib1);

        //Create method
        ArrayList<Methode> methods = new ArrayList<>();

        Methode method = new Methode()
        {{
            name = "method";
            parameter = paramters;
            body = block;
            rueckgabetyp = Types.Char;
        }};

        methods.add(method);

        //Create Constructor
        Block blockCons = new Block();
        ArrayList<Statement> stas = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stas.add(supers);
        blockCons.block = stas;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_EmptyCharMethod_ParamChar";
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
            body = blockCons;
        }};
        methods.add(constructor);

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyCharMethod_ParamChar";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse complicatedClass_SomeMethods()
    {
        //Method add
        Block blockAdd = new Block();
        ArrayList<Statement> addstats = new ArrayList<>();
        Return addRet = new Return();
        BinaryInt addRetExpr = new BinaryInt();

        //Binary Int zahl1
        Unary addzahl1 = new Unary();
        addzahl1.zahl = new LocalOrFieldVar()
        {{
            name = "a";
        }};

        //binary Int zahl2
        Unary addzahl2 = new Unary();
        addzahl2.zahl = new LocalOrFieldVar()
        {{
            name = "b";
        }};

        addRetExpr.zahl1 = addzahl1;
        addRetExpr.zahl2 = addzahl2;
        addRetExpr.rechenzeichen = "+";

        addRet.expression = addRetExpr;
        addstats.add(addRet);
        blockAdd.block = addstats;

        ArrayList<Methode> methods = new ArrayList<>();

        //methode add parameters
        ArrayList<Attribut> addAttribs = new ArrayList<>();

        Attribut x = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }};

        Attribut y = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }};

        addAttribs.add(x);
        addAttribs.add(y);

        Methode add = new Methode()
        {{
            name = "add";
            rueckgabetyp = Types.Integer;
            parameter = addAttribs;
            body = blockAdd;
        }};

        methods.add(add);

        //method sub
        Block subBlock = new Block();
        ArrayList<Statement> substats = new ArrayList<>();
        Return subret = new Return();
        BinaryInt subbin = new BinaryInt();

        //binary zahl1
        Unary sub1 = new Unary();
        sub1.zahl = new LocalOrFieldVar()
        {{
            name = "a";
        }};

        //binary zahl2
        Unary sub2 = new Unary();
        sub2.zahl = new LocalOrFieldVar()
        {{
            name = "b";
        }};

        subbin.zahl1 = sub1;
        subbin.zahl2 = sub2;
        subbin.rechenzeichen = "-";
        subret.expression = subbin;
        substats.add(subret);
        subBlock.block = substats;

        //Create sub method params

        ArrayList<Attribut> subattrib = new ArrayList<>();
        Attribut suba0 = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }};
        Attribut suba1 = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }};

        subattrib.add(suba0);
        subattrib.add(suba1);

        Methode sub = new Methode()
        {{
            name = "sub";
            parameter = subattrib;
            rueckgabetyp = Types.Integer;
            body = subBlock;
        }};

        methods.add(sub);

        //Method loop
        Block loopsBlock = new Block();
        ArrayList<Statement> loopsstats = new ArrayList<>();
        While w = new While();
        BinaryBool wexpr = new BinaryBool();

        //Binary zahl1
        Unary wexprz1 = new Unary();
        wexprz1.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        //Binary zahl2
        Unary wexprz2 = new Unary();
        wexprz2.zahl = new Integer()
        {{
            integer = 5;
            type = Types.Integer;
        }};

        wexpr.zahl1 = wexprz1;
        wexpr.zahl2 = wexprz2;
        wexpr.rechenzeichen = ">";

        //While statement
        Block whilestatblock = new Block();
        ArrayList<Statement> whilestats = new ArrayList<>();
        StmtExprStmt elem0 = new StmtExprStmt();

        Assign elem0assign = new Assign();
        elem0assign.ziel = new LocalOrFieldVar()
        {{
            name = "b";
        }};

        Unary elem0assignwert = new Unary();
        elem0assignwert.zahl = new Bool()
        {{
            bool = false;
            type = Types.Boolean;
        }};

        elem0assign.wert = elem0assignwert;
        elem0.stmtExpr = elem0assign;

        StmtExprStmt elem1 = new StmtExprStmt();
        Assign elem1assign = new Assign();
        elem1assign.ziel = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        Unary elem1assignwert = new Unary();
        elem1assignwert.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};
        elem1assignwert.postfix = Types.Dekrement;

        elem1assign.wert = elem1assignwert;
        elem1.stmtExpr = elem1assign;

        whilestats.add(elem0);
        whilestats.add(elem1);

        whilestatblock.block = whilestats;
        w.expression = wexpr;
        w.statement = whilestatblock;

        //Return statement
        Return r = new Return();
        Unary rexpr = new Unary();
        rexpr.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};
        r.expression = rexpr;

        loopsstats.add(w);
        loopsstats.add(r);
        loopsBlock.block = loopsstats;

        //Create method params
        ArrayList<Attribut> a = new ArrayList<>();
        Attribut a0 = new Attribut()
        {{
            name = "b";
            type = Types.Boolean;
        }};
        Attribut a1 = new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }};
        a.add(a0);
        a.add(a1);

        Methode loops = new Methode()
        {{
            name = "loops";
            parameter = a;
            body = loopsBlock;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(loops);

        //Constructor
        Block consBlock = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        stats.add(supers);
        consBlock.block = stats;

        Methode constructor = new Methode()
        {{
            name = "ComplicatedClass_SomeMethods";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }};

        methods.add(constructor);

        //Create Class
        klasse = new Klasse()
        {{
            name = "ComplicatedClass_SomeMethods";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_EmptyIntMethod_ParamInt()
    {
        // Create Method Block
        Block block = new Block();

        //Create Return Statement
        ArrayList<Statement> statements = new ArrayList<>();
        Return statement = new Return();

        Unary returnExpr = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "i";
            }};
        }};

        statement.expression = returnExpr;

        //Add statement to list and to block
        statements.add(statement);
        block.block = statements;

        //Create Attribute List of method
        ArrayList<Attribut> attribute = new ArrayList<>();
        attribute.add(new Attribut()
        {
            {
                name = "i";
                type = Types.Integer;
            }
        });

        //Create List of methods and assign variables
        ArrayList<Methode> methods = new ArrayList<>();
        methods.add(new Methode()
        {{
            rueckgabetyp = Types.Integer;
            name = "method";
            parameter = attribute;
            body = block;
        }});

        //Constructor
        Block blocCon = new Block();
        ArrayList<Statement> statements1 = new ArrayList<>();

        SuperStatement supers = new SuperStatement();
        statements1.add(supers);
        blocCon.block = statements1;

        Methode cons = new Methode()
        {{
            name = "AdvancedClass_EmptyIntMethod_ParamInt";
            body = blocCon;
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
        }};

        methods.add(cons);

        //Create class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_EmptyIntMethod_ParamInt";
            methoden = methods;
            attribute = new ArrayList<>();
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_VoidMethod_Bool()
    {
        // Create Method Block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();

        // Create first Statement
        StmtExprStmt statements_elem0 = new StmtExprStmt();
        Assign assign = new Assign();

        //Assign target
        assign.ziel = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        //Assign value
        BinaryInt wert = new BinaryInt();
        Unary zahl1 = new Unary();
        zahl1.zahl = new LocalOrFieldVar()
        {{
            name = "i";
        }};

        Unary zahl2 = new Unary();
        zahl2.zahl = new Integer()
        {{
            integer = 1;
            type = Types.Integer;
        }};

        wert.zahl1 = zahl1;
        wert.zahl2 = zahl2;
        wert.rechenzeichen = Types.Addtition;

        assign.wert = wert;

        statements_elem0.stmtExpr = assign;

        //Create second statement
        StmtExprStmt statements_elem1 = new StmtExprStmt();
        Assign assign2 = new Assign();

        //assign target
        assign2.ziel = new LocalOrFieldVar()
        {{
            name = "d";
        }};

        //assign wert
        Unary wert2 = new Unary();
        wert2.vorzeichen = Types.Negation;

        Bool zahl3 = new Bool()
        {{
            bool = false;
            type = Types.Boolean;
        }};
        wert2.zahl = zahl3;

        assign2.wert = wert2;
        statements_elem1.stmtExpr = assign2;

        statements.add(statements_elem0);
        statements.add(statements_elem1);

        block.block = statements;

        //Create method
        ArrayList<Methode> methoden = new ArrayList<>();
        Methode methode = new Methode();

        //Create method parameter
        ArrayList<Attribut> attributes = new ArrayList<>();
        Attribut attribut1 = new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }};
        Attribut attribut2 = new Attribut()
        {{
            name = "d";
            type = Types.Boolean;
        }};
        attributes.add(attribut1);
        attributes.add(attribut2);

        methode.name = "method";
        methode.parameter = attributes;
        methode.rueckgabetyp = Types.Void;
        methode.body = block;

        methoden.add(methode);

        //Constructor
        Methode constructor = new Methode();

        Block consBlock = new Block();
        ArrayList<Statement> consStats = new ArrayList();
        SuperStatement supers = new SuperStatement();
        consStats.add(supers);
        consBlock.block = consStats;

        constructor.name = "AdvancedClass_VoidMethod_Bool";
        constructor.parameter = new ArrayList<>();
        constructor.rueckgabetyp = "keiner";
        constructor.body = consBlock;

        methoden.add(constructor);

        //Create class
        klasse = new Klasse();

        ArrayList<Attribut> klassenattribute = new ArrayList<>();
        Attribut klassenattrib = new Attribut()
        {{
            name = "b";
            type = Types.Boolean;
        }};
        klassenattribute.add(klassenattrib);

        klasse.name = "AdvancedClass_VoidMethod_Bool";
        klasse.methoden = methoden;
        klasse.attribute = klassenattribute;

        return klasse;
    }

    @Override
    public Klasse advancedClass_NestedCondition()
    {
        //Create method block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        If outerif = new If();
        BinaryBool outerIfExpression = new BinaryBool();
        outerIfExpression.zahl1 = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "controll";
            }};
        }};
        outerIfExpression.zahl2 = new Unary()
        {{
            zahl = new Bool()
            {{
                bool = true;
                type = Types.Boolean;
            }};
        }};

        outerIfExpression.rechenzeichen = "!=";

        Block outerIfStatBlock = new Block();
        ArrayList<Statement> outerIfStatementStats = new ArrayList<>();

        //Inner if
        If innerif = new If();
        BinaryBool innerIfExpression = new BinaryBool();
        innerIfExpression.zahl1 = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "calculator";
            }};
        }};
        innerIfExpression.zahl2 = new Unary()
        {{
            zahl = new Integer()
            {{
                integer = 0;
                type = Types.Integer;
            }};
        }};
        innerIfExpression.rechenzeichen = "==";

        Block innerIfStatBlock = new Block();
        ArrayList<Statement> innerIfStatStatements = new ArrayList<>();
        StmtExprStmt innerIfelem0 = new StmtExprStmt();
        innerIfelem0.stmtExpr = new Assign()
        {{
            ziel = new LocalOrFieldVar()
            {{
                name = "calculator";
            }};
            wert = new Unary()
            {{
                zahl = new Integer()
                {{
                    integer = 10;
                    type = Types.Integer;
                }};
            }};
        }};
        innerIfStatStatements.add(innerIfelem0);

        Return innerIfelem1 = new Return();
        innerIfelem1.expression = new Unary()
        {{
            zahl = new Char()
            {{
                character = 'n';
                type = Types.Char;
            }};
        }};
        innerIfStatStatements.add(innerIfelem1);
        innerIfStatBlock.block = innerIfStatStatements;

        Block innerIfMaybeBlock = new Block();
        ArrayList<Statement> innerIfMaybeStats = new ArrayList<>();
        StmtExprStmt mayelem0 = new StmtExprStmt();
        mayelem0.stmtExpr = new Assign()
        {{
            ziel = new LocalOrFieldVar()
            {{
                name = "calculator";
            }};
            wert = new Unary()
            {{
                zahl = new Integer()
                {{
                    integer = 3;
                    type = Types.Integer;
                }};
            }};
        }};
        innerIfMaybeStats.add(mayelem0);

        Return mayelem1 = new Return();
        mayelem1.expression = new Unary()
        {{
            zahl = new Char()
            {{
                character = 'y';
                type = Types.Char;
            }};
        }};
        innerIfMaybeStats.add(mayelem1);
        innerIfMaybeBlock.block = innerIfMaybeStats;
        innerif.expression = innerIfExpression;
        innerif.statement = innerIfStatBlock;
        innerif.maybeStatement = innerIfMaybeBlock;

        outerIfStatementStats.add(innerif);
        outerIfStatBlock.block = outerIfStatementStats;

        Block outerifMaybe = new Block();
        ArrayList<Statement> outerifMaybeStats = new ArrayList<>();
        Return outerelem0 = new Return()
        {{
            expression = new Unary()
            {{
                zahl = new Char()
                {{
                    character = 'n';
                    type = Types.Char;
                }};
            }};
        }};
        outerifMaybeStats.add(outerelem0);
        outerifMaybe.block = outerifMaybeStats;
        outerif.expression = outerIfExpression;
        outerif.statement = outerIfStatBlock;
        outerif.maybeStatement = outerifMaybe;
        statements.add(outerif);
        block.block = statements;

        //Create method params
        ArrayList<Attribut> parameters = new ArrayList<>();
        parameters.add(new Attribut()
        {{
            name = "controll";
            type = Types.Boolean;
        }});
        parameters.add(new Attribut()
        {{
            name = "calculator";
            type = Types.Integer;
        }});

        //Create method
        ArrayList<Methode> methods = new ArrayList<>();
        Methode nesting = new Methode()
        {{
            name = "nesting";
            parameter = parameters;
            body = block;
            rueckgabetyp = Types.Char;
        }};
        methods.add(nesting);

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> consStats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        consStats.add(supers);
        consBlock.block = consStats;

        Methode constructor = new Methode()
        {{
            name = "AdvancedClass_NestedCondition";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = "keiner";
        }};
        methods.add(constructor);

        //Create Class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_NestedCondition";
            attribute = new ArrayList<>();
            methoden = methods;
        }};

        return klasse;
    }

    @Override
    public Klasse complicatedClass_MethodCall()
    {
        //Constructor block
        Block consBlock = new Block();
        ArrayList<Statement> consstats = new ArrayList<>();
        StmtExprStmt expression = new StmtExprStmt();
        Assign a = new Assign();
        a.ziel = new InstVar()
        {{
            first = new This();
            second = new LocalOrFieldVar()
            {{
                name = "i";
            }};
        }};
        StmtExprExpr awert = new StmtExprExpr();
        MethodCall consstexpr = new MethodCall();
        consstexpr.methode = "doMath";
        consstexpr.parameter = new ArrayList<>();
        consstexpr.parameter.add(new LocalOrFieldVar()
        {{
            name = "a";
        }});
        consstexpr.parameter.add((new LocalOrFieldVar()
        {{
            name = "b";
        }}));
        awert.stmtExpr = consstexpr;
        a.wert = awert;
        expression.stmtExpr = a;
        consstats.add(expression);
        consBlock.block = consstats;

        //Cons parameter
        ArrayList<Attribut> params = new ArrayList<>();
        Attribut p0 = new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }};
        Attribut p1 = new Attribut()
        {{
            name = "b";
            type = Types.Integer;
        }};
        params.add(p0);
        params.add(p1);

        //Create method constructor
        ArrayList<Methode> methods = new ArrayList<>();
        Methode constructor = new Methode()
        {{
            name = "ComplicatedClass_MethodCall";
            parameter = params;
            body = consBlock;
            rueckgabetyp = "keiner";
        }};

        methods.add(constructor);

        //create do math
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        Return ret = new Return();
        BinaryInt bin = new BinaryInt();
        BinaryInt z1 = new BinaryInt();
        Unary zz1 = new Unary();
        zz1.zahl = new LocalOrFieldVar()
        {{
            name = "zahl1";
        }};
        Unary zz2 = new Unary();
        zz2.zahl = new LocalOrFieldVar()
        {{
            name = "zahl2";
        }};
        z1.zahl1 = zz1;
        z1.zahl2 = zz2;
        z1.rechenzeichen = "+";

        Unary z2 = new Unary();
        z2.zahl = new Integer()
        {{
            integer = 3;
            type = Types.Integer;
        }};

        bin.zahl1 = z1;
        bin.zahl2 = z2;
        bin.rechenzeichen = "*";

        ret.expression = bin;
        statements.add(ret);
        block.block = statements;

        //Method params
        ArrayList<Attribut> methodparams = new ArrayList<>();
        methodparams.add(new Attribut()
        {{
            name = "zahl1";
            type = Types.Integer;
        }});
        methodparams.add(new Attribut()
        {{
            name = "zahl2";
            type = Types.Integer;
        }});

        Methode method = new Methode()
        {{
            name = "doMath";
            parameter = methodparams;
            body = block;
            rueckgabetyp = Types.Integer;
        }};

        methods.add(method);
        //Create class params
        ArrayList<Attribut> attributes = new ArrayList<>();
        attributes.add(new Attribut()
        {{
            name = "i";
            type = Types.Integer;
        }});

        //Create Class
        klasse = new Klasse()
        {{
            name = "ComplicatedClass_MethodCall";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    public Klasse wrongAssing()
    {
        //Constructor Block
        Block block = new Block();
        ArrayList<Statement> stats = new ArrayList<>();
        StmtExprStmt s = new StmtExprStmt();
        Assign assign = new Assign();
        assign.ziel = new LocalOrFieldVar()
        {{
            name = "a";
        }};
        assign.wert = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "c";
            }};
        }};
        s.stmtExpr = assign;
        stats.add(s);
        block.block = stats;

        //Create constructor params
        ArrayList<Attribut> oarams = new ArrayList<>();
        oarams.add(new Attribut()
        {{
            name = "c";
            type = Types.Char;
        }});

        //Create Constructor
        ArrayList<Methode> methods = new ArrayList<>();
        Methode constructor = new Methode()
        {{
            name = "WrongAssign";
            parameter = oarams;
            body = block;
            rueckgabetyp = "keiner";
        }};
        methods.add(constructor);

        //Create class attributes
        ArrayList<Attribut> attributes = new ArrayList<>();
        attributes.add(new Attribut()
        {{
            name = "a";
            type = Types.Integer;
        }});

        klasse = new Klasse()
        {{
            name = "WrongAssign";
            methoden = methods;
            attribute = attributes;
        }};

        return klasse;
    }

    @Override
    public Klasse advancedClass_SomeAssigns()
    {
        //Create method block
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        StmtExprStmt elem0 = new StmtExprStmt();
        Assign elem0Assign = new Assign();
        elem0Assign.ziel = new LocalOrFieldVar()
        {{
            name = "zahl1";
        }};
        elem0Assign.wert = new Unary()
        {{
            zahl = new Integer()
            {{
                integer = 100;
                type = Types.Integer;
            }};
        }};
        elem0.stmtExpr = elem0Assign;
        statements.add(elem0);

        If ifs = new If();
        BinaryBool ifexpression = new BinaryBool();
        ifexpression.zahl1 = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "zahl2";
            }};
        }};
        ifexpression.zahl2 = new Unary()
        {{
            zahl = new LocalOrFieldVar()
            {{
                name = "zahl1";
            }};
        }};
        ifexpression.rechenzeichen = "<";

        Block ifstatement = new Block();
        ArrayList<Statement> ifstats = new ArrayList<>();
        StmtExprStmt element0 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "zahl2";
                }};
                wert = new BinaryInt()
                {{
                    zahl1 = new Unary()
                    {{
                        zahl = new LocalOrFieldVar()
                        {{
                            name = "zahl2";
                        }};
                    }};
                    zahl2 = new Unary()
                    {{
                        zahl = new Integer()
                        {{
                            integer = 3;
                            type = Types.Integer;
                        }};
                    }};
                    rechenzeichen = "*";
                }};
            }};
        }};

        StmtExprStmt element1 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "zahl1";
                }};
                wert = new BinaryInt()
                {{
                    zahl1 = new Unary()
                    {{
                        zahl = new LocalOrFieldVar()
                        {{
                            name = "zahl2";
                        }};
                    }};
                    zahl2 = new Unary()
                    {{
                        zahl = new LocalOrFieldVar()
                        {{
                            name = "zahl1";
                        }};
                    }};
                    rechenzeichen = "+";
                }};
            }};
        }};
        StmtExprStmt element2 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "zahl3";
                }};
                wert = new BinaryInt()
                {{
                    zahl1 = new Unary()
                    {{
                        zahl = new Integer()
                        {{
                            integer = 1000;
                            type = Types.Integer;
                        }};
                    }};
                    zahl2 = new Unary()
                    {{
                        zahl = new LocalOrFieldVar()
                        {{
                            name = "zahl1";
                        }};
                    }};
                    rechenzeichen = "-";
                }};
            }};
        }};

        StmtExprStmt element3 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "validator";
                }};
                wert = new Unary()
                {{
                    zahl = new Bool()
                    {{
                        bool = true;
                        type = Types.Boolean;
                    }};
                }};
            }};
        }};

        ifstats.add(element0);
        ifstats.add(element1);
        ifstats.add(element2);
        ifstats.add(element3);
        ifstatement.block = ifstats;

        Block maybestatement = new Block();
        ArrayList<Statement> maybestats = new ArrayList<>();

        StmtExprStmt e0 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "zahl3";
                }};
                wert = new BinaryInt()
                {{
                    zahl1 = new Unary()
                    {{
                        zahl = new Integer()
                        {{
                            integer = 500;
                            type = Types.Integer;
                        }};
                    }};
                    zahl2 = new Unary()
                    {{
                        zahl = new LocalOrFieldVar()
                        {{
                            name = "zahl1";
                        }};
                    }};
                    rechenzeichen = "-";
                }};
            }};
        }};

        StmtExprStmt e1 = new StmtExprStmt()
        {{
            stmtExpr = new Assign()
            {{
                ziel = new LocalOrFieldVar()
                {{
                    name = "zahl2";
                }};
                wert = new BinaryInt()
                {{
                    zahl1 = new BinaryInt()
                    {{
                        zahl1 = new Unary()
                        {{
                            zahl = new LocalOrFieldVar()
                            {{
                                name = "zahl1";
                            }};
                        }};
                        zahl2 = new Unary()
                        {{
                            zahl = new LocalOrFieldVar()
                            {{
                                name = "zahl3";
                            }};
                        }};
                        rechenzeichen = "*";

                    }};
                    zahl2 = new Unary()
                    {{
                        zahl = new Integer()
                        {{
                            integer = 30;
                            type = Types.Integer;
                        }};
                    }};
                    rechenzeichen = "-";
                }};
            }};
        }};

        maybestats.add(e0);
        maybestats.add(e1);
        maybestatement.block = maybestats;
        ifs.expression = ifexpression;
        ifs.statement = ifstatement;
        ifs.maybeStatement = maybestatement;

        statements.add(ifs);
        block.block = statements;

        //Create Method params
        ArrayList<Attribut> params = new ArrayList<>();
        params.add(new Attribut()
        {{
            name = "zahl1";
            type = Types.Integer;
        }});
        params.add(new Attribut()
        {{
            name = "zahl2";
            type = Types.Integer;
        }});
        params.add(new Attribut()
        {{
            name = "zahl3";
            type = Types.Integer;
        }});
        params.add(new Attribut()
        {{
            name = "validator";
            type = Types.Boolean;
        }});

        //Create method
        ArrayList<Methode> methods = new ArrayList<>();
        methods.add(new Methode()
        {{
            name = "assign";
            body = block;
            parameter = params;
            rueckgabetyp = Types.Void;
        }});

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> consStats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        consStats.add(supers);

        consBlock.block = consStats;
        methods.add(new Methode()
        {{
            name = "AdvancedClass_SomeAssigns";
            body = consBlock;
            parameter = new ArrayList<>();
            rueckgabetyp = "keiner";
        }});

        //Create class
        klasse = new Klasse()
        {{
            name = "AdvancedClass_SomeAssigns";
            methoden = methods;
            attribute = new ArrayList<>();
        }};

        return klasse;
    }

    @Override
    public ArrayList<Klasse> advancedClass_Objects()
    {
        ArrayList<Klasse> classes = new ArrayList<>();

        //First class in list
        classes.add(simpleClass());

        //Second class
        //Method creation
        Block block = new Block();
        ArrayList<Statement> statements = new ArrayList<>();
        LocalVarDecl elem0 = new LocalVarDecl()
        {{
            name = "object";
            type = "SimpleClass";
        }};
        statements.add(elem0);
        StmtExprStmt elem1 = new StmtExprStmt();
        Assign assign = new Assign();
        LocalOrFieldVar ziel = new LocalOrFieldVar()
        {{
            name = "object";
        }};
        StmtExprExpr wert = new StmtExprExpr();
        New news = new New()
        {{
            expressions = new ArrayList<>();
            className = "SimpleClass";
        }};
        wert.stmtExpr = news;
        assign.ziel = ziel;
        assign.wert = wert;
        elem1.stmtExpr = assign;
        statements.add(elem1);
        block.block = statements;

        ArrayList<Methode> methods = new ArrayList<>();
        methods.add(new Methode()
        {{
            name = "creation";
            parameter = new ArrayList<>();
            body = block;
            rueckgabetyp = Types.Void;
        }});

        //Create constructor
        Block consBlock = new Block();
        ArrayList<Statement> conststats = new ArrayList<>();
        SuperStatement supers = new SuperStatement();
        conststats.add(supers);
        consBlock.block = conststats;

        methods.add(new Methode()
        {{
            name = "AdvancedClass_Objects";
            parameter = new ArrayList<>();
            body = consBlock;
            rueckgabetyp = Types.Standard;
        }});

        //Create class
        classes.add(new Klasse()
        {{
            name = "AdvancedClass_Objects";
            attribute = new ArrayList<>();
            methoden = methods;
        }});

        return classes;
    }
}
