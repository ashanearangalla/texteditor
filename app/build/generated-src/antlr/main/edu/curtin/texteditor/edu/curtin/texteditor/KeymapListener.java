// Generated from edu/curtin/texteditor/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeymapParser}.
 */
public interface KeymapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void enterKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#keymap}.
	 * @param ctx the parse tree
	 */
	void exitKeymap(KeymapParser.KeymapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#keyBinding}.
	 * @param ctx the parse tree
	 */
	void enterKeyBinding(KeymapParser.KeyBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#keyBinding}.
	 * @param ctx the parse tree
	 */
	void exitKeyBinding(KeymapParser.KeyBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#keyCombo}.
	 * @param ctx the parse tree
	 */
	void enterKeyCombo(KeymapParser.KeyComboContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#keyCombo}.
	 * @param ctx the parse tree
	 */
	void exitKeyCombo(KeymapParser.KeyComboContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#startOfLine}.
	 * @param ctx the parse tree
	 */
	void enterStartOfLine(KeymapParser.StartOfLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#startOfLine}.
	 * @param ctx the parse tree
	 */
	void exitStartOfLine(KeymapParser.StartOfLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeymapParser#atCaret}.
	 * @param ctx the parse tree
	 */
	void enterAtCaret(KeymapParser.AtCaretContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeymapParser#atCaret}.
	 * @param ctx the parse tree
	 */
	void exitAtCaret(KeymapParser.AtCaretContext ctx);
}