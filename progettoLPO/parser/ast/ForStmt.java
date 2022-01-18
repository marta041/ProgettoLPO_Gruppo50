package progettoLPO.parser.ast;

import progettoLPO.visitors.Visitor;

import static java.util.Objects.requireNonNull;

public class ForStmt implements Stmt {
	private final VarIdent varid;
	private final Exp exp;
	private final Block block;

	public ForStmt(VarIdent varid, Exp exp, Block block) {
		this.varid = requireNonNull(varid);
		this.exp = requireNonNull(exp);
		this.block = requireNonNull(block);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitForStmt(varid, exp, block);
	}

}
