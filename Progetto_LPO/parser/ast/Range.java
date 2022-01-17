package progettoLPO.parser.ast;

import progettoLPO.visitors.Visitor;

public class Range extends BinaryOp {
  public Range(Exp left, Exp right) {
		super(left, right);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitRange(left, right);
	}
	
}
