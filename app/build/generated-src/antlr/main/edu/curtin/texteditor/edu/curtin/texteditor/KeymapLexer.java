// Generated from edu/curtin/texteditor/Keymap.g4 by ANTLR 4.13.2
package edu.curtin.texteditor;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KeymapLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MODIFIER=8, COMMAND=9, 
		KEY=10, STRING=11, WHITESPACE=12, COMMENT=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "MODIFIER", "COMMAND", 
			"KEY", "STRING", "WHITESPACE", "COMMENT"
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


	public KeymapLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Keymap.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\rm\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007C\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bQ\b\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0005\nW\b\n\n\n\f\nZ\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000b_\b\u000b\u000b\u000b\f\u000b`\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0005\fg\b\f\n\f\f\fj\t\f\u0001\f\u0001\f\u0000\u0000\r\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0004"+
		"\u0001\u0000az\u0001\u0000\"\"\u0003\u0000\t\n\r\r  \u0001\u0000\n\nr"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001d"+
		"\u0001\u0000\u0000\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007\"\u0001"+
		"\u0000\u0000\u0000\t(\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000"+
		"\u0000\r0\u0001\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000\u0011"+
		"P\u0001\u0000\u0000\u0000\u0013R\u0001\u0000\u0000\u0000\u0015T\u0001"+
		"\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000\u0019d\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0005=\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005+\u0000\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001f"+
		" \u0005a\u0000\u0000 !\u0005t\u0000\u0000!\u0006\u0001\u0000\u0000\u0000"+
		"\"#\u0005s\u0000\u0000#$\u0005t\u0000\u0000$%\u0005a\u0000\u0000%&\u0005"+
		"r\u0000\u0000&\'\u0005t\u0000\u0000\'\b\u0001\u0000\u0000\u0000()\u0005"+
		"o\u0000\u0000)*\u0005f\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005"+
		"l\u0000\u0000,-\u0005i\u0000\u0000-.\u0005n\u0000\u0000./\u0005e\u0000"+
		"\u0000/\f\u0001\u0000\u0000\u000001\u0005c\u0000\u000012\u0005a\u0000"+
		"\u000023\u0005r\u0000\u000034\u0005e\u0000\u000045\u0005t\u0000\u0000"+
		"5\u000e\u0001\u0000\u0000\u000067\u0005c\u0000\u000078\u0005t\u0000\u0000"+
		"89\u0005r\u0000\u00009C\u0005l\u0000\u0000:;\u0005a\u0000\u0000;<\u0005"+
		"l\u0000\u0000<C\u0005t\u0000\u0000=>\u0005s\u0000\u0000>?\u0005h\u0000"+
		"\u0000?@\u0005i\u0000\u0000@A\u0005f\u0000\u0000AC\u0005t\u0000\u0000"+
		"B6\u0001\u0000\u0000\u0000B:\u0001\u0000\u0000\u0000B=\u0001\u0000\u0000"+
		"\u0000C\u0010\u0001\u0000\u0000\u0000DE\u0005i\u0000\u0000EF\u0005n\u0000"+
		"\u0000FG\u0005s\u0000\u0000GH\u0005e\u0000\u0000HI\u0005r\u0000\u0000"+
		"IQ\u0005t\u0000\u0000JK\u0005d\u0000\u0000KL\u0005e\u0000\u0000LM\u0005"+
		"l\u0000\u0000MN\u0005e\u0000\u0000NO\u0005t\u0000\u0000OQ\u0005e\u0000"+
		"\u0000PD\u0001\u0000\u0000\u0000PJ\u0001\u0000\u0000\u0000Q\u0012\u0001"+
		"\u0000\u0000\u0000RS\u0007\u0000\u0000\u0000S\u0014\u0001\u0000\u0000"+
		"\u0000TX\u0005\"\u0000\u0000UW\b\u0001\u0000\u0000VU\u0001\u0000\u0000"+
		"\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[\\\u0005"+
		"\"\u0000\u0000\\\u0016\u0001\u0000\u0000\u0000]_\u0007\u0002\u0000\u0000"+
		"^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0006\u000b"+
		"\u0000\u0000c\u0018\u0001\u0000\u0000\u0000dh\u0005#\u0000\u0000eg\b\u0003"+
		"\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000kl\u0006\f\u0000\u0000l\u001a\u0001\u0000\u0000"+
		"\u0000\u0006\u0000BPX`h\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}