package compilador;

import java.util.HashMap;	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class compiladorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CCHAR", "CFLOAT", "CHAR", "CINT", 
		"CLASS", "COMA", "DOUBLE", "FIN", "FLOAT", "ID", "INT", "LLAVEA", "LLAVEC", 
		"OPASIGN", "OPMAS", "OPMENOS", "OPMULT", "PARA", "PARC", "PRIVATE", "PROTECTED", 
		"PUBLIC", "PUNTOYCOMA", "STRING", "VOID", "WS"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public compiladorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public compiladorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

        private javax.swing.JTextArea salida;

        public void setSalida(javax.swing.JTextArea _salida)
        { salida=_salida; }
        
	@Override public String[] getTokenNames() { return compiladorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "compilador.g"; }

	//aqui decls de funciones/datos miembro del parser
	  HashMap tablaDeSimbolos = new HashMap();

	  public void varToST(String tipo, String id) {
	      salida.append("\n Var:"+tipo+" : "+id);
	      Integer verifica = (Integer) tablaDeSimbolos.get(id);
	       if (verifica==null){
	           if(tipo.compareTo("int")==0)    { Integer objTipo = Integer.valueOf(1);
	                                               tablaDeSimbolos.put(id,objTipo);      }
	           else if(tipo.compareTo("float")==0){ Integer objTipo = Integer.valueOf(2);
	                                               tablaDeSimbolos.put(id,objTipo);      }
	           }
	       else salida.append("\n ERROR, redeclaración de variable: "+id); 
	      }

	    public void error(String msg){salida.append("\n Error "+ msg);}  

	   public int verifyTypes(int t1, int t2, String arg1, String arg2)  { 
	       if(t1==t2) return t1;
	       else {  
	          error (" de tipo en la expresión: ("+ arg1+ " op "+ arg2+")");
	          return 0;
	               }
	    }

	    

	   public void displayRecognitionError(String[] tokenNames,
	           RecognitionException e) {
	          String hdr = getErrorHeader(e);
	          String msg = getErrorMessage(e, tokenNames);
	          salida.append("\n Que te fijes!!!: " + hdr + " " + msg);
	   }







	// $ANTLR start "inicio"
	// compilador.g:45:1: inicio : modific_acceso CLASS ID LLAVEA ( atributo | metodo )* LLAVEC ;
	public final void inicio() throws RecognitionException {
		try {
			// compilador.g:45:7: ( modific_acceso CLASS ID LLAVEA ( atributo | metodo )* LLAVEC )
			// compilador.g:45:9: modific_acceso CLASS ID LLAVEA ( atributo | metodo )* LLAVEC
			{
			pushFollow(FOLLOW_modific_acceso_in_inicio18);
			modific_acceso();
			state._fsp--;

			match(input,CLASS,FOLLOW_CLASS_in_inicio20); 
			match(input,ID,FOLLOW_ID_in_inicio22); 
			match(input,LLAVEA,FOLLOW_LLAVEA_in_inicio38); 
			// compilador.g:47:18: ( atributo | metodo )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= PRIVATE && LA1_0 <= PUBLIC)) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==CHAR||LA1_2==DOUBLE||LA1_2==FLOAT||LA1_2==INT||(LA1_2 >= STRING && LA1_2 <= VOID)) ) {
						int LA1_3 = input.LA(3);
						if ( (LA1_3==ID) ) {
							int LA1_4 = input.LA(4);
							if ( (LA1_4==PARA) ) {
								alt1=2;
							}
							else if ( (LA1_4==COMA||LA1_4==PUNTOYCOMA) ) {
								alt1=1;
							}

						}

					}

				}
				else if ( (LA1_0==CHAR||LA1_0==DOUBLE||LA1_0==FLOAT||LA1_0==INT||(LA1_0 >= STRING && LA1_0 <= VOID)) ) {
					int LA1_3 = input.LA(2);
					if ( (LA1_3==ID) ) {
						int LA1_4 = input.LA(3);
						if ( (LA1_4==PARA) ) {
							alt1=2;
						}
						else if ( (LA1_4==COMA||LA1_4==PUNTOYCOMA) ) {
							alt1=1;
						}

					}

				}

				switch (alt1) {
				case 1 :
					// compilador.g:47:19: atributo
					{
					pushFollow(FOLLOW_atributo_in_inicio58);
					atributo();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:47:30: metodo
					{
					pushFollow(FOLLOW_metodo_in_inicio62);
					metodo();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,LLAVEC,FOLLOW_LLAVEC_in_inicio82); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inicio"



	// $ANTLR start "atributo"
	// compilador.g:49:1: atributo : ( modific_acceso )? tipo ID ( COMA ID )* PUNTOYCOMA ;
	public final void atributo() throws RecognitionException {
		try {
			// compilador.g:49:10: ( ( modific_acceso )? tipo ID ( COMA ID )* PUNTOYCOMA )
			// compilador.g:49:12: ( modific_acceso )? tipo ID ( COMA ID )* PUNTOYCOMA
			{
			// compilador.g:49:12: ( modific_acceso )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= PRIVATE && LA2_0 <= PUBLIC)) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// compilador.g:49:12: modific_acceso
					{
					pushFollow(FOLLOW_modific_acceso_in_atributo99);
					modific_acceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_atributo102);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_atributo104); 
			// compilador.g:49:36: ( COMA ID )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMA) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// compilador.g:49:37: COMA ID
					{
					match(input,COMA,FOLLOW_COMA_in_atributo107); 
					match(input,ID,FOLLOW_ID_in_atributo109); 
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_atributo114); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atributo"



	// $ANTLR start "metodo"
	// compilador.g:50:1: metodo : ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC ;
	public final void metodo() throws RecognitionException {
		try {
			// compilador.g:50:10: ( ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC )
			// compilador.g:50:12: ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC
			{
			// compilador.g:50:12: ( modific_acceso )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= PRIVATE && LA4_0 <= PUBLIC)) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// compilador.g:50:12: modific_acceso
					{
					pushFollow(FOLLOW_modific_acceso_in_metodo124);
					modific_acceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_metodo127);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_metodo129); 
			match(input,PARA,FOLLOW_PARA_in_metodo131); 
			// compilador.g:50:41: ( decl_args )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==CHAR||LA5_0==DOUBLE||LA5_0==FLOAT||LA5_0==INT||(LA5_0 >= STRING && LA5_0 <= VOID)) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// compilador.g:50:41: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_metodo133);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,PARC,FOLLOW_PARC_in_metodo137); 
			match(input,LLAVEA,FOLLOW_LLAVEA_in_metodo153); 
			// compilador.g:52:17: ( sentencia )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==CHAR||LA6_0==DOUBLE||(LA6_0 >= FLOAT && LA6_0 <= INT)||(LA6_0 >= STRING && LA6_0 <= VOID)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// compilador.g:52:17: sentencia
					{
					pushFollow(FOLLOW_sentencia_in_metodo171);
					sentencia();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			match(input,LLAVEC,FOLLOW_LLAVEC_in_metodo188); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "metodo"



	// $ANTLR start "sentencia"
	// compilador.g:54:1: sentencia : ( asignacion | decl_local );
	public final void sentencia() throws RecognitionException {
		try {
			// compilador.g:54:11: ( asignacion | decl_local )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ID) ) {
				alt7=1;
			}
			else if ( (LA7_0==CHAR||LA7_0==DOUBLE||LA7_0==FLOAT||LA7_0==INT||(LA7_0 >= STRING && LA7_0 <= VOID)) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// compilador.g:54:13: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_sentencia196);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:54:26: decl_local
					{
					pushFollow(FOLLOW_decl_local_in_sentencia200);
					decl_local();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sentencia"



	// $ANTLR start "decl_args"
	// compilador.g:55:1: decl_args : tipo ID ( COMA tipo ID )* ;
	public final void decl_args() throws RecognitionException {
		try {
			// compilador.g:55:11: ( tipo ID ( COMA tipo ID )* )
			// compilador.g:55:13: tipo ID ( COMA tipo ID )*
			{
			pushFollow(FOLLOW_tipo_in_decl_args221);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_decl_args223); 
			// compilador.g:55:22: ( COMA tipo ID )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:55:23: COMA tipo ID
					{
					match(input,COMA,FOLLOW_COMA_in_decl_args227); 
					pushFollow(FOLLOW_tipo_in_decl_args229);
					tipo();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_decl_args231); 
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decl_args"



	// $ANTLR start "decl_local"
	// compilador.g:57:1: decl_local : tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA ;
	public final void decl_local() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo1 =null;

		try {
			// compilador.g:57:11: ( tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA )
			// compilador.g:57:13: tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA
			{
			pushFollow(FOLLOW_tipo_in_decl_local241);
			tipo1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_local245); 
			varToST ((tipo1!=null?input.toString(tipo1.start,tipo1.stop):null),(id1!=null?id1.getText():null));
			// compilador.g:58:12: ( COMA id2= ID )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// compilador.g:58:13: COMA id2= ID
					{
					match(input,COMA,FOLLOW_COMA_in_decl_local262); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_local266); 
					varToST ((tipo1!=null?input.toString(tipo1.start,tipo1.stop):null),(id2!=null?id2.getText():null));
					}
					break;

				default :
					break loop9;
				}
			}

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_decl_local273); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decl_local"



	// $ANTLR start "asignacion"
	// compilador.g:60:1: asignacion : ID OPASIGN expr_aritm PUNTOYCOMA ;
	public final void asignacion() throws RecognitionException {
		try {
			// compilador.g:60:34: ( ID OPASIGN expr_aritm PUNTOYCOMA )
			// compilador.g:60:36: ID OPASIGN expr_aritm PUNTOYCOMA
			{
			match(input,ID,FOLLOW_ID_in_asignacion303); 
			match(input,OPASIGN,FOLLOW_OPASIGN_in_asignacion305); 
			pushFollow(FOLLOW_expr_aritm_in_asignacion307);
			expr_aritm();
			state._fsp--;

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_asignacion309); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "asignacion"



	// $ANTLR start "expr_aritm"
	// compilador.g:63:1: expr_aritm returns [int vType] : m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )* ;
	public final int expr_aritm() throws RecognitionException {
		int vType = 0;


		ParserRuleReturnScope m1 =null;
		ParserRuleReturnScope m2 =null;

		try {
			// compilador.g:63:34: (m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )* )
			// compilador.g:64:13: m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr_aritm340);
			m1=multExpr();
			state._fsp--;

			vType =(m1!=null?((compiladorParser.multExpr_return)m1).vType:0);
			// compilador.g:65:24: ( ( OPMAS | OPMENOS ) m2= multExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= OPMAS && LA10_0 <= OPMENOS)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// compilador.g:65:26: ( OPMAS | OPMENOS ) m2= multExpr
					{
					if ( (input.LA(1) >= OPMAS && input.LA(1) <= OPMENOS) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr_aritm378);
					m2=multExpr();
					state._fsp--;


					                          vType =verifyTypes((m1!=null?((compiladorParser.multExpr_return)m1).vType:0),(m2!=null?((compiladorParser.multExpr_return)m2).vType:0),(m1!=null?input.toString(m1.start,m1.stop):null),(m2!=null?input.toString(m2.start,m2.stop):null));
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return vType;
	}
	// $ANTLR end "expr_aritm"


	public static class multExpr_return extends ParserRuleReturnScope {
		public int vType;
	};


	// $ANTLR start "multExpr"
	// compilador.g:70:1: multExpr returns [int vType] : a1= atom ( OPMULT a2= atom )* ;
	public final compiladorParser.multExpr_return multExpr() throws RecognitionException {
		compiladorParser.multExpr_return retval = new compiladorParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a1 =null;
		ParserRuleReturnScope a2 =null;

		try {
			// compilador.g:70:34: (a1= atom ( OPMULT a2= atom )* )
			// compilador.g:71:16: a1= atom ( OPMULT a2= atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr443);
			a1=atom();
			state._fsp--;

			retval.vType =(a1!=null?((compiladorParser.atom_return)a1).vType:0);
			// compilador.g:72:17: ( OPMULT a2= atom )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==OPMULT) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:72:18: OPMULT a2= atom
					{
					match(input,OPMULT,FOLLOW_OPMULT_in_multExpr464); 
					pushFollow(FOLLOW_atom_in_multExpr468);
					a2=atom();
					state._fsp--;


					                  retval.vType =verifyTypes((a1!=null?((compiladorParser.atom_return)a1).vType:0),(a2!=null?((compiladorParser.atom_return)a2).vType:0),(a1!=null?input.toString(a1.start,a1.stop):null),(a2!=null?input.toString(a2.start,a2.stop):null));
					}
					break;

				default :
					break loop11;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atom_return extends ParserRuleReturnScope {
		public int vType;
	};


	// $ANTLR start "atom"
	// compilador.g:76:1: atom returns [int vType] : ( CINT | CFLOAT | ID | PARA expr_aritm PARC );
	public final compiladorParser.atom_return atom() throws RecognitionException {
		compiladorParser.atom_return retval = new compiladorParser.atom_return();
		retval.start = input.LT(1);

		Token ID2=null;
		int expr_aritm3 =0;

		try {
			// compilador.g:76:28: ( CINT | CFLOAT | ID | PARA expr_aritm PARC )
			int alt12=4;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt12=1;
				}
				break;
			case CFLOAT:
				{
				alt12=2;
				}
				break;
			case ID:
				{
				alt12=3;
				}
				break;
			case PARA:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// compilador.g:77:16: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atom522); 
					retval.vType =1;
					}
					break;
				case 2 :
					// compilador.g:78:16: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_atom544); 
					retval.vType =2;
					}
					break;
				case 3 :
					// compilador.g:79:16: ID
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_atom563); 
					 
					                        Integer obj = (Integer) tablaDeSimbolos.get((ID2!=null?ID2.getText():null)); 
					                        if(obj==null){ error (" Variable "+(ID2!=null?ID2.getText():null)+" no declarada"); 
					                                       retval.vType =0;
					                                     }
					                        else{ retval.vType = obj.intValue(); } 
					                    
					}
					break;
				case 4 :
					// compilador.g:87:16: PARA expr_aritm PARC
					{
					match(input,PARA,FOLLOW_PARA_in_atom608); 
					pushFollow(FOLLOW_expr_aritm_in_atom610);
					expr_aritm3=expr_aritm();
					state._fsp--;

					retval.vType =expr_aritm3;
					match(input,PARC,FOLLOW_PARC_in_atom614); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"



	// $ANTLR start "fin"
	// compilador.g:103:1: fin : FIN ;
	public final void fin() throws RecognitionException {
		try {
			// compilador.g:103:7: ( FIN )
			// compilador.g:103:9: FIN
			{
			match(input,FIN,FOLLOW_FIN_in_fin641); 
			  salida.append("Cant total IDs "+ tablaDeSimbolos.size());
				           Integer test = (Integer) tablaDeSimbolos.get("a");
			               salida.append("El id 'a' ha aparecido "+test.intValue()+" veces");  
			            
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fin"


	public static class tipo_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "tipo"
	// compilador.g:108:1: tipo : ( INT | FLOAT | STRING | DOUBLE | CHAR | VOID );
	public final compiladorParser.tipo_return tipo() throws RecognitionException {
		compiladorParser.tipo_return retval = new compiladorParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// compilador.g:108:6: ( INT | FLOAT | STRING | DOUBLE | CHAR | VOID )
			// compilador.g:
			{
			if ( input.LA(1)==CHAR||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||(input.LA(1) >= STRING && input.LA(1) <= VOID) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tipo"



	// $ANTLR start "modific_acceso"
	// compilador.g:110:1: modific_acceso : ( PUBLIC | PRIVATE | PROTECTED );
	public final void modific_acceso() throws RecognitionException {
		try {
			// compilador.g:110:16: ( PUBLIC | PRIVATE | PROTECTED )
			// compilador.g:
			{
			if ( (input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "modific_acceso"



	// $ANTLR start "constantes"
	// compilador.g:111:1: constantes : ( CINT | CFLOAT | CCHAR );
	public final void constantes() throws RecognitionException {
		Token CCHAR4=null;

		try {
			// compilador.g:111:12: ( CINT | CFLOAT | CCHAR )
			int alt13=3;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt13=1;
				}
				break;
			case CFLOAT:
				{
				alt13=2;
				}
				break;
			case CCHAR:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// compilador.g:111:14: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_constantes706); 
					}
					break;
				case 2 :
					// compilador.g:111:21: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_constantes710); 
					}
					break;
				case 3 :
					// compilador.g:111:31: CCHAR
					{
					CCHAR4=(Token)match(input,CCHAR,FOLLOW_CCHAR_in_constantes715); 

						                    salida.append("Constante char:"+(CCHAR4!=null?CCHAR4.getText():null));
					                                     
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "constantes"

	// Delegated rules



	public static final BitSet FOLLOW_modific_acceso_in_inicio18 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLASS_in_inicio20 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_inicio22 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LLAVEA_in_inicio38 = new BitSet(new long[]{0x000000001B815440L});
	public static final BitSet FOLLOW_atributo_in_inicio58 = new BitSet(new long[]{0x000000001B815440L});
	public static final BitSet FOLLOW_metodo_in_inicio62 = new BitSet(new long[]{0x000000001B815440L});
	public static final BitSet FOLLOW_LLAVEC_in_inicio82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modific_acceso_in_atributo99 = new BitSet(new long[]{0x0000000018005440L});
	public static final BitSet FOLLOW_tipo_in_atributo102 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_atributo104 = new BitSet(new long[]{0x0000000004000200L});
	public static final BitSet FOLLOW_COMA_in_atributo107 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_atributo109 = new BitSet(new long[]{0x0000000004000200L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_atributo114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modific_acceso_in_metodo124 = new BitSet(new long[]{0x0000000018005440L});
	public static final BitSet FOLLOW_tipo_in_metodo127 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_metodo129 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_PARA_in_metodo131 = new BitSet(new long[]{0x0000000018405440L});
	public static final BitSet FOLLOW_decl_args_in_metodo133 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_PARC_in_metodo137 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LLAVEA_in_metodo153 = new BitSet(new long[]{0x0000000018017440L});
	public static final BitSet FOLLOW_sentencia_in_metodo171 = new BitSet(new long[]{0x0000000018017440L});
	public static final BitSet FOLLOW_LLAVEC_in_metodo188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asignacion_in_sentencia196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decl_local_in_sentencia200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args221 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_args223 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMA_in_decl_args227 = new BitSet(new long[]{0x0000000018005440L});
	public static final BitSet FOLLOW_tipo_in_decl_args229 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_args231 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_tipo_in_decl_local241 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_local245 = new BitSet(new long[]{0x0000000004000200L});
	public static final BitSet FOLLOW_COMA_in_decl_local262 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_local266 = new BitSet(new long[]{0x0000000004000200L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_decl_local273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion303 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_OPASIGN_in_asignacion305 = new BitSet(new long[]{0x00000000002020A0L});
	public static final BitSet FOLLOW_expr_aritm_in_asignacion307 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_asignacion309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr_aritm340 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_expr_aritm370 = new BitSet(new long[]{0x00000000002020A0L});
	public static final BitSet FOLLOW_multExpr_in_expr_aritm378 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_atom_in_multExpr443 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_OPMULT_in_multExpr464 = new BitSet(new long[]{0x00000000002020A0L});
	public static final BitSet FOLLOW_atom_in_multExpr468 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_CINT_in_atom522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atom544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARA_in_atom608 = new BitSet(new long[]{0x00000000002020A0L});
	public static final BitSet FOLLOW_expr_aritm_in_atom610 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_PARC_in_atom614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIN_in_fin641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CINT_in_constantes706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_constantes710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CCHAR_in_constantes715 = new BitSet(new long[]{0x0000000000000002L});
}
