package parser.adapter;

import abstrakteSyntax.statements.Block;
import abstrakteSyntax.statements.Statement;
import parser.JavaParser;

import java.util.ArrayList;

public class BlockAdapter {
    public static Block adapt(JavaParser.BlockContext ctx){
        Block block = new Block();
        if (ctx.statement() != null){
            block.block = new ArrayList<Statement>();
            for (JavaParser.StatementContext statement: ctx.statement())
            {
               block.block.add(StatementAdapter.adapt(statement));
            }
        }
        return block;
    }
}
