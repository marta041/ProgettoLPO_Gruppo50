package progettoLPO.parser.ast;

import progettoLPO.visitors.Visitor;

public class BoundExp extends UnaryOp{

    public BoundExp(Exp exp) {
		super(exp);
	}
    
    @Override
    public <T> T accept(Visitor<T> visitor) {
    	return visitor.visitBoundExp(exp);
	}
	
}