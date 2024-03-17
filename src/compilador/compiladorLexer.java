package compilador;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class compiladorLexer extends Lexer {
	public static final int EOF=-1;
	public static final int CCHAR=4;
	public static final int CFLOAT=5;
	public static final int CHAR=6;
	public static final int CINT=7;
	public static final int CLASS=8;
	public static final int COMA=9;
	public static final int DOUBLE=10;
	public static final int FIN=11;
	public static final int FLOAT=12;
	public static final int ID=13;
	public static final int INT=14;
	public static final int LLAVEA=15;
	public static final int LLAVEC=16;
	public static final int OPASIGN=17;
	public static final int OPMAS=18;
	public static final int OPMENOS=19;
	public static final int OPMULT=20;
	public static final int PARA=21;
	public static final int PARC=22;
	public static final int PRIVATE=23;
	public static final int PROTECTED=24;
	public static final int PUBLIC=25;
	public static final int PUNTOYCOMA=26;
	public static final int STRING=27;
	public static final int VOID=28;
	public static final int WS=29;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public compiladorLexer() {} 
	public compiladorLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public compiladorLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "compilador.g"; }

	// $ANTLR start "PUBLIC"
	public final void mPUBLIC() throws RecognitionException {
		try {
			int _type = PUBLIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:114:8: ( 'public' )
			// compilador.g:114:10: 'public'
			{
			match("public"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUBLIC"

	// $ANTLR start "PROTECTED"
	public final void mPROTECTED() throws RecognitionException {
		try {
			int _type = PROTECTED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:115:10: ( 'protected' )
			// compilador.g:115:12: 'protected'
			{
			match("protected"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROTECTED"

	// $ANTLR start "PRIVATE"
	public final void mPRIVATE() throws RecognitionException {
		try {
			int _type = PRIVATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:116:8: ( 'private' )
			// compilador.g:116:10: 'private'
			{
			match("private"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIVATE"

	// $ANTLR start "FIN"
	public final void mFIN() throws RecognitionException {
		try {
			int _type = FIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:118:7: ( 'fin' )
			// compilador.g:118:9: 'fin'
			{
			match("fin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIN"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:120:7: ( 'class' )
			// compilador.g:120:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:121:7: ( 'int' )
			// compilador.g:121:9: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:122:7: ( 'float' )
			// compilador.g:122:10: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:123:8: ( 'String' )
			// compilador.g:123:10: 'String'
			{
			match("String"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:124:8: ( 'double' )
			// compilador.g:124:11: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:125:6: ( 'char' )
			// compilador.g:125:9: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:126:6: ( 'void' )
			// compilador.g:126:8: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "LLAVEA"
	public final void mLLAVEA() throws RecognitionException {
		try {
			int _type = LLAVEA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:129:8: ( '{' )
			// compilador.g:129:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLAVEA"

	// $ANTLR start "LLAVEC"
	public final void mLLAVEC() throws RecognitionException {
		try {
			int _type = LLAVEC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:130:8: ( '}' )
			// compilador.g:130:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLAVEC"

	// $ANTLR start "CFLOAT"
	public final void mCFLOAT() throws RecognitionException {
		try {
			int _type = CFLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:135:8: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// compilador.g:135:10: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// compilador.g:135:10: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// compilador.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match('.'); 
			// compilador.g:135:24: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// compilador.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CFLOAT"

	// $ANTLR start "CINT"
	public final void mCINT() throws RecognitionException {
		try {
			int _type = CINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:136:8: ( ( '0' .. '9' )+ )
			// compilador.g:136:10: ( '0' .. '9' )+
			{
			// compilador.g:136:10: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// compilador.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CINT"

	// $ANTLR start "CCHAR"
	public final void mCCHAR() throws RecognitionException {
		try {
			int _type = CCHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:137:8: ( '\\'' ( 'A' .. 'z' ) '\\'' )
			// compilador.g:137:10: '\\'' ( 'A' .. 'z' ) '\\''
			{
			match('\''); 
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CCHAR"

	// $ANTLR start "OPASIGN"
	public final void mOPASIGN() throws RecognitionException {
		try {
			int _type = OPASIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:138:9: ( '=' )
			// compilador.g:138:11: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPASIGN"

	// $ANTLR start "PARA"
	public final void mPARA() throws RecognitionException {
		try {
			int _type = PARA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:139:6: ( '(' )
			// compilador.g:139:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARA"

	// $ANTLR start "PARC"
	public final void mPARC() throws RecognitionException {
		try {
			int _type = PARC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:140:6: ( ')' )
			// compilador.g:140:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARC"

	// $ANTLR start "OPMAS"
	public final void mOPMAS() throws RecognitionException {
		try {
			int _type = OPMAS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:141:8: ( '+' )
			// compilador.g:141:10: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPMAS"

	// $ANTLR start "OPMENOS"
	public final void mOPMENOS() throws RecognitionException {
		try {
			int _type = OPMENOS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:142:8: ( '-' )
			// compilador.g:142:10: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPMENOS"

	// $ANTLR start "OPMULT"
	public final void mOPMULT() throws RecognitionException {
		try {
			int _type = OPMULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:143:8: ( '*' )
			// compilador.g:143:10: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPMULT"

	// $ANTLR start "PUNTOYCOMA"
	public final void mPUNTOYCOMA() throws RecognitionException {
		try {
			int _type = PUNTOYCOMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:144:11: ( ';' )
			// compilador.g:144:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUNTOYCOMA"

	// $ANTLR start "COMA"
	public final void mCOMA() throws RecognitionException {
		try {
			int _type = COMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:145:5: ( ',' )
			// compilador.g:145:7: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMA"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:147:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* )
			// compilador.g:147:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// compilador.g:147:33: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// compilador.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// compilador.g:148:7: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
			// compilador.g:148:9: ( ' ' | '\\n' | '\\t' | '\\r' )+
			{
			// compilador.g:148:9: ( ' ' | '\\n' | '\\t' | '\\r' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// compilador.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// compilador.g:1:8: ( PUBLIC | PROTECTED | PRIVATE | FIN | CLASS | INT | FLOAT | STRING | DOUBLE | CHAR | VOID | LLAVEA | LLAVEC | CFLOAT | CINT | CCHAR | OPASIGN | PARA | PARC | OPMAS | OPMENOS | OPMULT | PUNTOYCOMA | COMA | ID | WS )
		int alt6=26;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// compilador.g:1:10: PUBLIC
				{
				mPUBLIC(); 

				}
				break;
			case 2 :
				// compilador.g:1:17: PROTECTED
				{
				mPROTECTED(); 

				}
				break;
			case 3 :
				// compilador.g:1:27: PRIVATE
				{
				mPRIVATE(); 

				}
				break;
			case 4 :
				// compilador.g:1:35: FIN
				{
				mFIN(); 

				}
				break;
			case 5 :
				// compilador.g:1:39: CLASS
				{
				mCLASS(); 

				}
				break;
			case 6 :
				// compilador.g:1:45: INT
				{
				mINT(); 

				}
				break;
			case 7 :
				// compilador.g:1:49: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 8 :
				// compilador.g:1:55: STRING
				{
				mSTRING(); 

				}
				break;
			case 9 :
				// compilador.g:1:62: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 10 :
				// compilador.g:1:69: CHAR
				{
				mCHAR(); 

				}
				break;
			case 11 :
				// compilador.g:1:74: VOID
				{
				mVOID(); 

				}
				break;
			case 12 :
				// compilador.g:1:79: LLAVEA
				{
				mLLAVEA(); 

				}
				break;
			case 13 :
				// compilador.g:1:86: LLAVEC
				{
				mLLAVEC(); 

				}
				break;
			case 14 :
				// compilador.g:1:93: CFLOAT
				{
				mCFLOAT(); 

				}
				break;
			case 15 :
				// compilador.g:1:100: CINT
				{
				mCINT(); 

				}
				break;
			case 16 :
				// compilador.g:1:105: CCHAR
				{
				mCCHAR(); 

				}
				break;
			case 17 :
				// compilador.g:1:111: OPASIGN
				{
				mOPASIGN(); 

				}
				break;
			case 18 :
				// compilador.g:1:119: PARA
				{
				mPARA(); 

				}
				break;
			case 19 :
				// compilador.g:1:124: PARC
				{
				mPARC(); 

				}
				break;
			case 20 :
				// compilador.g:1:129: OPMAS
				{
				mOPMAS(); 

				}
				break;
			case 21 :
				// compilador.g:1:135: OPMENOS
				{
				mOPMENOS(); 

				}
				break;
			case 22 :
				// compilador.g:1:143: OPMULT
				{
				mOPMULT(); 

				}
				break;
			case 23 :
				// compilador.g:1:150: PUNTOYCOMA
				{
				mPUNTOYCOMA(); 

				}
				break;
			case 24 :
				// compilador.g:1:161: COMA
				{
				mCOMA(); 

				}
				break;
			case 25 :
				// compilador.g:1:166: ID
				{
				mID(); 

				}
				break;
			case 26 :
				// compilador.g:1:169: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\7\24\2\uffff\1\41\13\uffff\12\24\2\uffff\3\24\1\60\3\24\1\64"+
		"\6\24\1\uffff\2\24\1\75\1\uffff\2\24\1\100\3\24\1\104\1\105\1\uffff\2"+
		"\24\1\uffff\1\110\2\24\2\uffff\1\113\1\114\1\uffff\1\24\1\116\2\uffff"+
		"\1\24\1\uffff\1\120\1\uffff";
	static final String DFA6_eofS =
		"\121\uffff";
	static final String DFA6_minS =
		"\1\11\1\162\1\151\1\150\1\156\1\164\2\157\2\uffff\1\56\13\uffff\1\142"+
		"\1\151\1\156\1\157\2\141\1\164\1\162\1\165\1\151\2\uffff\1\154\1\164\1"+
		"\166\1\60\1\141\1\163\1\162\1\60\1\151\1\142\1\144\1\151\1\145\1\141\1"+
		"\uffff\1\164\1\163\1\60\1\uffff\1\156\1\154\1\60\2\143\1\164\2\60\1\uffff"+
		"\1\147\1\145\1\uffff\1\60\1\164\1\145\2\uffff\2\60\1\uffff\1\145\1\60"+
		"\2\uffff\1\144\1\uffff\1\60\1\uffff";
	static final String DFA6_maxS =
		"\1\175\1\165\2\154\1\156\1\164\2\157\2\uffff\1\71\13\uffff\1\142\1\157"+
		"\1\156\1\157\2\141\1\164\1\162\1\165\1\151\2\uffff\1\154\1\164\1\166\1"+
		"\172\1\141\1\163\1\162\1\172\1\151\1\142\1\144\1\151\1\145\1\141\1\uffff"+
		"\1\164\1\163\1\172\1\uffff\1\156\1\154\1\172\2\143\1\164\2\172\1\uffff"+
		"\1\147\1\145\1\uffff\1\172\1\164\1\145\2\uffff\2\172\1\uffff\1\145\1\172"+
		"\2\uffff\1\144\1\uffff\1\172\1\uffff";
	static final String DFA6_acceptS =
		"\10\uffff\1\14\1\15\1\uffff\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1"+
		"\30\1\31\1\32\12\uffff\1\16\1\17\16\uffff\1\4\3\uffff\1\6\10\uffff\1\12"+
		"\2\uffff\1\13\3\uffff\1\7\1\5\2\uffff\1\1\2\uffff\1\10\1\11\1\uffff\1"+
		"\3\1\uffff\1\2";
	static final String DFA6_specialS =
		"\121\uffff}>";
	static final String[] DFA6_transitionS = {
			"\2\25\2\uffff\1\25\22\uffff\1\25\6\uffff\1\13\1\15\1\16\1\21\1\17\1\23"+
			"\1\20\2\uffff\12\12\1\uffff\1\22\1\uffff\1\14\3\uffff\22\24\1\5\7\24"+
			"\4\uffff\1\24\1\uffff\2\24\1\3\1\6\1\24\1\2\2\24\1\4\6\24\1\1\5\24\1"+
			"\7\4\24\1\10\1\uffff\1\11",
			"\1\27\2\uffff\1\26",
			"\1\30\2\uffff\1\31",
			"\1\33\3\uffff\1\32",
			"\1\34",
			"\1\35",
			"\1\36",
			"\1\37",
			"",
			"",
			"\1\40\1\uffff\12\12",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42",
			"\1\44\5\uffff\1\43",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"",
			"",
			"\1\55",
			"\1\56",
			"\1\57",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\61",
			"\1\62",
			"\1\63",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"",
			"\1\73",
			"\1\74",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"\1\76",
			"\1\77",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\101",
			"\1\102",
			"\1\103",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"\1\106",
			"\1\107",
			"",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\1\111",
			"\1\112",
			"",
			"",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"\1\115",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			"",
			"",
			"\1\117",
			"",
			"\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PUBLIC | PROTECTED | PRIVATE | FIN | CLASS | INT | FLOAT | STRING | DOUBLE | CHAR | VOID | LLAVEA | LLAVEC | CFLOAT | CINT | CCHAR | OPASIGN | PARA | PARC | OPMAS | OPMENOS | OPMULT | PUNTOYCOMA | COMA | ID | WS );";
		}
	}

}
