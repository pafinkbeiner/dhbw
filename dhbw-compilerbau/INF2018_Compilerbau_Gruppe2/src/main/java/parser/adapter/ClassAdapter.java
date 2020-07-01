package parser.adapter;

import abstrakteSyntax.Attribut;
import abstrakteSyntax.Klasse;
import abstrakteSyntax.Methode;
import abstrakteSyntax.Types;
import abstrakteSyntax.statements.Block;
import abstrakteSyntax.statements.Statement;
import abstrakteSyntax.statements.SuperStatement;
import parser.JavaParser;

import java.util.ArrayList;


public class ClassAdapter {

    public static Klasse adapt(JavaParser.KlasseContext ctx) {
        Klasse absSyntax = new Klasse();
        absSyntax.name = ctx.IDENTIFIER().get(0).getText();

        if(ctx.IDENTIFIER().size() == 2) {
            absSyntax.superklasse = new Klasse();
            absSyntax.superklasse.name = ctx.IDENTIFIER().get(1).getText();
        }
        ContentAdapter.adapt(absSyntax, ctx.content());
        addStandardConstructorIfNecessary(absSyntax);
        return absSyntax;
    }

    public static void addStandardConstructorIfNecessary(Klasse absSyntax) {
        for(Methode methode : absSyntax.methoden) {
            if(methode.rueckgabetyp.equals(Types.Standard)) {
                return;
            }
        }
        addStandardConstructor(absSyntax);
    }

    public static void addStandardConstructor(Klasse absSyntax) {
        Methode methode = new Methode();
        methode.name = absSyntax.name;
        methode.body = new Block();
        SuperStatement item = new SuperStatement();
        methode.body.block = new ArrayList<>();
        methode.body.block.add(item);
        methode.parameter = new ArrayList<>();
        methode.rueckgabetyp = Types.Standard;
        absSyntax.methoden.add(methode);
    }
}

