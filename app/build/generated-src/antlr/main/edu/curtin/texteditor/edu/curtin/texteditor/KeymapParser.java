// Generated from edu/curtin/texteditor/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KeymapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MODIFIER=8, COMMAND=9, 
		KEY=10, STRING=11, WHITESPACE=12, COMMENT=13;
	public static final int
		RULE_keymap = 0, RULE_keyBinding = 1, RULE_keyCombo = 2, RULE_startOfLine = 3, 
		RULE_atCaret = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"keymap", "keyBinding", "keyCombo", "startOfLine", "atCaret"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+'", "'at'", "'start'", "'of'", "'line'", "'caret'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MODIFIER", "COMMAND", 
			"KEY", "STRING", "WHITESPACE", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Keymap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KeymapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeymapContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KeymapParser.EOF, 0); }
		public List<KeyBindingContext> keyBinding() {
			return getRuleContexts(KeyBindingContext.class);
		}
		public KeyBindingContext keyBinding(int i) {
			return getRuleContext(KeyBindingContext.class,i);
		}
		public KeymapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keymap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterKeymap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitKeymap(this);
		}
	}

	public final KeymapContext keymap() throws RecognitionException {
		KeymapContext _localctx = new KeymapContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_keymap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MODIFIER) {
				{
				{
				setState(10);
				keyBinding();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyBindingContext extends ParserRuleContext {
		public Token command;
		public Token text;
		public KeyComboContext keyCombo() {
			return getRuleContext(KeyComboContext.class,0);
		}
		public TerminalNode COMMAND() { return getToken(KeymapParser.COMMAND, 0); }
		public TerminalNode STRING() { return getToken(KeymapParser.STRING, 0); }
		public StartOfLineContext startOfLine() {
			return getRuleContext(StartOfLineContext.class,0);
		}
		public AtCaretContext atCaret() {
			return getRuleContext(AtCaretContext.class,0);
		}
		public KeyBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterKeyBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitKeyBinding(this);
		}
	}

	public final KeyBindingContext keyBinding() throws RecognitionException {
		KeyBindingContext _localctx = new KeyBindingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_keyBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			keyCombo();
			setState(19);
			match(T__0);
			setState(20);
			((KeyBindingContext)_localctx).command = match(COMMAND);
			setState(21);
			((KeyBindingContext)_localctx).text = match(STRING);
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(22);
				startOfLine();
				}
				break;
			case 2:
				{
				setState(23);
				atCaret();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyComboContext extends ParserRuleContext {
		public Token MODIFIER;
		public List<Token> modifier = new ArrayList<Token>();
		public Token key;
		public TerminalNode KEY() { return getToken(KeymapParser.KEY, 0); }
		public List<TerminalNode> MODIFIER() { return getTokens(KeymapParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(KeymapParser.MODIFIER, i);
		}
		public KeyComboContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyCombo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterKeyCombo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitKeyCombo(this);
		}
	}

	public final KeyComboContext keyCombo() throws RecognitionException {
		KeyComboContext _localctx = new KeyComboContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyCombo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				((KeyComboContext)_localctx).MODIFIER = match(MODIFIER);
				((KeyComboContext)_localctx).modifier.add(((KeyComboContext)_localctx).MODIFIER);
				setState(27);
				match(T__1);
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MODIFIER );
			setState(32);
			((KeyComboContext)_localctx).key = match(KEY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartOfLineContext extends ParserRuleContext {
		public StartOfLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startOfLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterStartOfLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitStartOfLine(this);
		}
	}

	public final StartOfLineContext startOfLine() throws RecognitionException {
		StartOfLineContext _localctx = new StartOfLineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_startOfLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__2);
			setState(35);
			match(T__3);
			setState(36);
			match(T__4);
			setState(37);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtCaretContext extends ParserRuleContext {
		public AtCaretContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atCaret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).enterAtCaret(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KeymapListener ) ((KeymapListener)listener).exitAtCaret(this);
		}
	}

	public final AtCaretContext atCaret() throws RecognitionException {
		AtCaretContext _localctx = new AtCaretContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atCaret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\r+\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0002\u0001\u0002\u0004\u0002"+
		"\u001d\b\u0002\u000b\u0002\f\u0002\u001e\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006"+
		"\b\u0000\u0000(\u0000\r\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000"+
		"\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006\"\u0001\u0000\u0000"+
		"\u0000\b\'\u0001\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n"+
		"\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0010\u0001\u0000"+
		"\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0000\u0000"+
		"\u0001\u0011\u0001\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0004\u0002"+
		"\u0000\u0013\u0014\u0005\u0001\u0000\u0000\u0014\u0015\u0005\t\u0000\u0000"+
		"\u0015\u0018\u0005\u000b\u0000\u0000\u0016\u0019\u0003\u0006\u0003\u0000"+
		"\u0017\u0019\u0003\b\u0004\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018"+
		"\u0017\u0001\u0000\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0005\b\u0000\u0000\u001b\u001d\u0005\u0002\u0000\u0000\u001c\u001a"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 !\u0005\n\u0000\u0000!\u0005\u0001\u0000\u0000\u0000"+
		"\"#\u0005\u0003\u0000\u0000#$\u0005\u0004\u0000\u0000$%\u0005\u0005\u0000"+
		"\u0000%&\u0005\u0006\u0000\u0000&\u0007\u0001\u0000\u0000\u0000\'(\u0005"+
		"\u0003\u0000\u0000()\u0005\u0007\u0000\u0000)\t\u0001\u0000\u0000\u0000"+
		"\u0003\r\u0018\u001e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}