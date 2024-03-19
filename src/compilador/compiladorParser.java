// $ANTLR 3.5.2 compilador.g 2024-03-18 20:43:39
 // aqui van las declaraciones de imports
package compilador;

import java.util.HashMap;	


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

@SuppressWarnings("all")
public class compiladorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CCHAR", "CFLOAT", "CHAR", "CINT", 
		"CLASS", "COMA", "DOUBLE", "FIN", "FLOAT", "ID", "INT", "LLAVEA", "LLAVEC", 
		"NEW", "OPASIGN", "OPMAS", "OPMENOS", "OPMULT", "PARA", "PARC", "PRIVATE", 
		"PROTECTED", "PUBLIC", "PUNTOYCOMA", "STRING", "VOID", "WS"
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
	public static final int NEW=17;
	public static final int OPASIGN=18;
	public static final int OPMAS=19;
	public static final int OPMENOS=20;
	public static final int OPMULT=21;
	public static final int PARA=22;
	public static final int PARC=23;
	public static final int PRIVATE=24;
	public static final int PROTECTED=25;
	public static final int PUBLIC=26;
	public static final int PUNTOYCOMA=27;
	public static final int STRING=28;
	public static final int VOID=29;
	public static final int WS=30;
        private javax.swing.JTextArea salida;

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

	@Override public String[] getTokenNames() { return compiladorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "compilador.g"; }

	//aqui decls de funciones/datos miembro del parser
	  HashMap<String, Integer> tablaDeSimbolosGlobal = new HashMap<String, Integer>();
	//   Hashmap para los metodos locales
	  HashMap<String, Integer> tablaDeSimbolosLocal = null;

	  public void empiezaMetodo() {
	        tablaDeSimbolosLocal = new HashMap<String, Integer>();
	        salida.append("empieza metodo" + "\n");
	    }

	    public void terminaMetodo() {
	        tablaDeSimbolosLocal = null;
	        salida.append("salida del metodo" + "\n");
	    }

	  public void varToST(String tipo, String id) {
	      // Se recupera si estamos en la tabla global o local para manejar los metodos
	      HashMap<String, Integer> tablaActual = (tablaDeSimbolosLocal != null) ? tablaDeSimbolosLocal : tablaDeSimbolosGlobal;

	      // Verifica que el id no exista en la tabla y lo asigna o salta el error
	      if(tablaDeSimbolosLocal != null){
	       if (!tablaDeSimbolosLocal.containsKey(id)) {

	            // Manejo de asignacion 1 si es int o 2 si es float.
	            tablaActual.put(id, tipo.equals("int") ? 1 : 2);
	            salida.append("Var local:"+tipo+" : "+id + "\n");
	        } else {
	            salida.append("ERROR, redeclaración de variable local : " + id + "\n");
	        }
	      } else {
	         if (!tablaDeSimbolosGlobal.containsKey(id)) {

	            int valorTipo;
	            if (tipo.equals("int")) {
	                  valorTipo = 1; // Tipo int
	                  salida.append("Var global:"+tipo+" : "+id + "\n");
	            } else if (tipo.equals("float")) {
	                  valorTipo = 2; // Tipo float
	                  salida.append("Var global:"+tipo+" : "+id + "\n");
	            } else {
	                  valorTipo = 3; // Cualquier otro tipo se considera un objeto
	                  salida.append("Objeto:"+" : "+id + "\n");
	            }
	            tablaActual.put(id, valorTipo);
	        } else {
	            System.err.println("ERROR, redeclaración de variable global : " + id);
	        }
	      }
	      }

	   // Metodo para comprobar variables declaradas y regresa verdadero o falso

	   public boolean comprobarVariable(String id) {
	    if (tablaDeSimbolosLocal != null && tablaDeSimbolosLocal.containsKey(id)) {
	        return true; // La variable está declarada localmente
	    } else if (tablaDeSimbolosGlobal.containsKey(id)) {
	        return true; // La variable está declarada globalmente
	    } else {
	        error("Variable " + id + " no declarada");
	        return false;
	    }
	}

	    public void error(String msg){System.err.println("Error "+ msg);}  

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
	          System.out.println("Que te fijes!!!: " + hdr + " " + msg);
	   }



	// $ANTLR start "inicio"
	// compilador.g:87:1: inicio : modific_acceso CLASS ID LLAVEA ( atributo | metodo | declaracion_obj )* LLAVEC ;
	public final void inicio() throws RecognitionException {
		try {
			// compilador.g:87:7: ( modific_acceso CLASS ID LLAVEA ( atributo | metodo | declaracion_obj )* LLAVEC )
			// compilador.g:88:2: modific_acceso CLASS ID LLAVEA ( atributo | metodo | declaracion_obj )* LLAVEC
			{
			pushFollow(FOLLOW_modific_acceso_in_inicio21);
			modific_acceso();
			state._fsp--;

			match(input,CLASS,FOLLOW_CLASS_in_inicio23); 
			match(input,ID,FOLLOW_ID_in_inicio25); 
			match(input,LLAVEA,FOLLOW_LLAVEA_in_inicio27); 
			// compilador.g:88:33: ( atributo | metodo | declaracion_obj )*
			loop1:
			while (true) {
				int alt1=4;
				switch ( input.LA(1) ) {
				case PRIVATE:
				case PROTECTED:
				case PUBLIC:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==CHAR||LA1_2==DOUBLE||LA1_2==FLOAT||LA1_2==INT||(LA1_2 >= STRING && LA1_2 <= VOID)) ) {
						int LA1_3 = input.LA(3);
						if ( (LA1_3==ID) ) {
							int LA1_5 = input.LA(4);
							if ( (LA1_5==PARA) ) {
								alt1=2;
							}
							else if ( (LA1_5==COMA||LA1_5==PUNTOYCOMA) ) {
								alt1=1;
							}

						}

					}

					}
					break;
				case CHAR:
				case DOUBLE:
				case FLOAT:
				case INT:
				case STRING:
				case VOID:
					{
					int LA1_3 = input.LA(2);
					if ( (LA1_3==ID) ) {
						int LA1_5 = input.LA(3);
						if ( (LA1_5==PARA) ) {
							alt1=2;
						}
						else if ( (LA1_5==COMA||LA1_5==PUNTOYCOMA) ) {
							alt1=1;
						}

					}

					}
					break;
				case ID:
					{
					alt1=3;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// compilador.g:89:3: atributo
					{
					pushFollow(FOLLOW_atributo_in_inicio33);
					atributo();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:90:5: metodo
					{
					pushFollow(FOLLOW_metodo_in_inicio39);
					metodo();
					state._fsp--;

					}
					break;
				case 3 :
					// compilador.g:91:5: declaracion_obj
					{
					pushFollow(FOLLOW_declaracion_obj_in_inicio45);
					declaracion_obj();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,LLAVEC,FOLLOW_LLAVEC_in_inicio51); 
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



	// $ANTLR start "declaracion_obj"
	// compilador.g:93:1: declaracion_obj : tipo1= ID nombreobj= ID OPASIGN NEW tipo2= ID PARA ( args_objeto )? PARC PUNTOYCOMA ;
	public final void declaracion_obj() throws RecognitionException {
		Token tipo1=null;
		Token nombreobj=null;
		Token tipo2=null;

		try {
			// compilador.g:93:16: (tipo1= ID nombreobj= ID OPASIGN NEW tipo2= ID PARA ( args_objeto )? PARC PUNTOYCOMA )
			// compilador.g:94:2: tipo1= ID nombreobj= ID OPASIGN NEW tipo2= ID PARA ( args_objeto )? PARC PUNTOYCOMA
			{
			tipo1=(Token)match(input,ID,FOLLOW_ID_in_declaracion_obj62); 
			nombreobj=(Token)match(input,ID,FOLLOW_ID_in_declaracion_obj68); 
			match(input,OPASIGN,FOLLOW_OPASIGN_in_declaracion_obj70); 
			match(input,NEW,FOLLOW_NEW_in_declaracion_obj72); 
			tipo2=(Token)match(input,ID,FOLLOW_ID_in_declaracion_obj78); 
			match(input,PARA,FOLLOW_PARA_in_declaracion_obj80); 
			// compilador.g:94:56: ( args_objeto )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// compilador.g:94:56: args_objeto
					{
					pushFollow(FOLLOW_args_objeto_in_declaracion_obj82);
					args_objeto();
					state._fsp--;

					}
					break;

			}

			match(input,PARC,FOLLOW_PARC_in_declaracion_obj85); 
			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_declaracion_obj87); 
			varToST((tipo1!=null?tipo1.getText():null), (nombreobj!=null?nombreobj.getText():null));
					
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
	// $ANTLR end "declaracion_obj"



	// $ANTLR start "args_objeto"
	// compilador.g:96:1: args_objeto : ID ( COMA ID )* ;
	public final void args_objeto() throws RecognitionException {
		try {
			// compilador.g:96:12: ( ID ( COMA ID )* )
			// compilador.g:96:14: ID ( COMA ID )*
			{
			match(input,ID,FOLLOW_ID_in_args_objeto95); 
			// compilador.g:96:17: ( COMA ID )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMA) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// compilador.g:96:18: COMA ID
					{
					match(input,COMA,FOLLOW_COMA_in_args_objeto98); 
					match(input,ID,FOLLOW_ID_in_args_objeto100); 
					}
					break;

				default :
					break loop3;
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
	// $ANTLR end "args_objeto"



	// $ANTLR start "atributo"
	// compilador.g:97:1: atributo : ( modific_acceso )? tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA ;
	public final void atributo() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo1 =null;

		try {
			// compilador.g:97:9: ( ( modific_acceso )? tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA )
			// compilador.g:98:2: ( modific_acceso )? tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA
			{
			// compilador.g:98:2: ( modific_acceso )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= PRIVATE && LA4_0 <= PUBLIC)) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// compilador.g:98:2: modific_acceso
					{
					pushFollow(FOLLOW_modific_acceso_in_atributo109);
					modific_acceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_atributo112);
			tipo1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_atributo118); 
			varToST ((tipo1!=null?input.toString(tipo1.start,tipo1.stop):null),(id1!=null?id1.getText():null));
			// compilador.g:98:66: ( COMA id2= ID )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COMA) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// compilador.g:99:3: COMA id2= ID
					{
					match(input,COMA,FOLLOW_COMA_in_atributo126); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_atributo132); 
					varToST ((tipo1!=null?input.toString(tipo1.start,tipo1.stop):null),(id2!=null?id2.getText():null));
					}
					break;

				default :
					break loop5;
				}
			}

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_atributo140); 
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
	// compilador.g:101:1: metodo : ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC ;
	public final void metodo() throws RecognitionException {
		try {
			// compilador.g:101:7: ( ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC )
			// compilador.g:102:2: ( modific_acceso )? tipo ID PARA ( decl_args )? PARC LLAVEA ( sentencia )* LLAVEC
			{
			// compilador.g:102:2: ( modific_acceso )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= PRIVATE && LA6_0 <= PUBLIC)) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// compilador.g:102:2: modific_acceso
					{
					pushFollow(FOLLOW_modific_acceso_in_metodo147);
					modific_acceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_metodo150);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_metodo152); 
			match(input,PARA,FOLLOW_PARA_in_metodo154); 
			 empiezaMetodo();
			// compilador.g:102:51: ( decl_args )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==CHAR||LA7_0==DOUBLE||LA7_0==FLOAT||LA7_0==INT||(LA7_0 >= STRING && LA7_0 <= VOID)) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// compilador.g:102:51: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_metodo158);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,PARC,FOLLOW_PARC_in_metodo161); 
			match(input,LLAVEA,FOLLOW_LLAVEA_in_metodo163); 
			// compilador.g:102:74: ( sentencia )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==CHAR||LA8_0==DOUBLE||(LA8_0 >= FLOAT && LA8_0 <= INT)||(LA8_0 >= STRING && LA8_0 <= VOID)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:102:74: sentencia
					{
					pushFollow(FOLLOW_sentencia_in_metodo165);
					sentencia();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			match(input,LLAVEC,FOLLOW_LLAVEC_in_metodo168); 
			 terminaMetodo();
					
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
	// compilador.g:104:1: sentencia : ( asignacion | decl_local );
	public final void sentencia() throws RecognitionException {
		try {
			// compilador.g:104:10: ( asignacion | decl_local )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==CHAR||LA9_0==DOUBLE||LA9_0==FLOAT||LA9_0==INT||(LA9_0 >= STRING && LA9_0 <= VOID)) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// compilador.g:104:12: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_sentencia176);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:104:25: decl_local
					{
					pushFollow(FOLLOW_decl_local_in_sentencia180);
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
	// compilador.g:105:1: decl_args : arg ( COMA arg )* ;
	public final void decl_args() throws RecognitionException {
		try {
			// compilador.g:105:10: ( arg ( COMA arg )* )
			// compilador.g:105:12: arg ( COMA arg )*
			{
			pushFollow(FOLLOW_arg_in_decl_args186);
			arg();
			state._fsp--;

			// compilador.g:105:16: ( COMA arg )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==COMA) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// compilador.g:105:17: COMA arg
					{
					match(input,COMA,FOLLOW_COMA_in_decl_args189); 
					pushFollow(FOLLOW_arg_in_decl_args191);
					arg();
					state._fsp--;

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
	}
	// $ANTLR end "decl_args"



	// $ANTLR start "arg"
	// compilador.g:106:1: arg : tipo ID ;
	public final void arg() throws RecognitionException {
		Token ID3=null;
		ParserRuleReturnScope tipo2 =null;

		try {
			// compilador.g:106:4: ( tipo ID )
			// compilador.g:106:6: tipo ID
			{
			pushFollow(FOLLOW_tipo_in_arg199);
			tipo2=tipo();
			state._fsp--;

			ID3=(Token)match(input,ID,FOLLOW_ID_in_arg201); 
			varToST((tipo2!=null?input.toString(tipo2.start,tipo2.stop):null), (ID3!=null?ID3.getText():null));
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
	// $ANTLR end "arg"



	// $ANTLR start "decl_local"
	// compilador.g:108:1: decl_local : tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA ;
	public final void decl_local() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo4 =null;

		try {
			// compilador.g:108:11: ( tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA )
			// compilador.g:109:2: tipo id1= ID ( COMA id2= ID )* PUNTOYCOMA
			{
			pushFollow(FOLLOW_tipo_in_decl_local211);
			tipo4=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_local217); 
			varToST ((tipo4!=null?input.toString(tipo4.start,tipo4.stop):null),(id1!=null?id1.getText():null));
			// compilador.g:109:50: ( COMA id2= ID )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:110:3: COMA id2= ID
					{
					match(input,COMA,FOLLOW_COMA_in_decl_local225); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_local231); 
					varToST ((tipo4!=null?input.toString(tipo4.start,tipo4.stop):null),(id2!=null?id2.getText():null));
					}
					break;

				default :
					break loop11;
				}
			}

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_decl_local239); 
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
	// compilador.g:113:1: asignacion : ID OPASIGN expr_aritm PUNTOYCOMA ;
	public final void asignacion() throws RecognitionException {
		try {
			// compilador.g:113:11: ( ID OPASIGN expr_aritm PUNTOYCOMA )
			// compilador.g:113:13: ID OPASIGN expr_aritm PUNTOYCOMA
			{
			match(input,ID,FOLLOW_ID_in_asignacion246); 
			match(input,OPASIGN,FOLLOW_OPASIGN_in_asignacion248); 
			pushFollow(FOLLOW_expr_aritm_in_asignacion250);
			expr_aritm();
			state._fsp--;

			match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_asignacion252); 
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
	// compilador.g:115:1: expr_aritm returns [int vType] : m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )* ;
	public final int expr_aritm() throws RecognitionException {
		int vType = 0;


		ParserRuleReturnScope m1 =null;
		ParserRuleReturnScope m2 =null;

		try {
			// compilador.g:116:20: (m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )* )
			// compilador.g:117:2: m1= multExpr ( ( OPMAS | OPMENOS ) m2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr_aritm268);
			m1=multExpr();
			state._fsp--;

			vType =(m1!=null?((compiladorParser.multExpr_return)m1).vType:0);
			// compilador.g:117:36: ( ( OPMAS | OPMENOS ) m2= multExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= OPMAS && LA12_0 <= OPMENOS)) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// compilador.g:118:3: ( OPMAS | OPMENOS ) m2= multExpr
					{
					if ( (input.LA(1) >= OPMAS && input.LA(1) <= OPMENOS) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr_aritm288);
					m2=multExpr();
					state._fsp--;


					                          vType =verifyTypes((m1!=null?((compiladorParser.multExpr_return)m1).vType:0),(m2!=null?((compiladorParser.multExpr_return)m2).vType:0),(m1!=null?input.toString(m1.start,m1.stop):null),(m2!=null?input.toString(m2.start,m2.stop):null));
					}
					break;

				default :
					break loop12;
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

    void setSalida(JTextArea taSalida) {
        salida = taSalida;
    }


	public static class multExpr_return extends ParserRuleReturnScope {
		public int vType;
	};


	// $ANTLR start "multExpr"
	// compilador.g:122:1: multExpr returns [int vType] : a1= atom ( OPMULT a2= atom )* ;
	public final compiladorParser.multExpr_return multExpr() throws RecognitionException {
		compiladorParser.multExpr_return retval = new compiladorParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a1 =null;
		ParserRuleReturnScope a2 =null;

		try {
			// compilador.g:123:20: (a1= atom ( OPMULT a2= atom )* )
			// compilador.g:124:2: a1= atom ( OPMULT a2= atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr310);
			a1=atom();
			state._fsp--;

			retval.vType =(a1!=null?((compiladorParser.atom_return)a1).vType:0);
			// compilador.g:124:32: ( OPMULT a2= atom )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==OPMULT) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// compilador.g:125:3: OPMULT a2= atom
					{
					match(input,OPMULT,FOLLOW_OPMULT_in_multExpr318); 
					pushFollow(FOLLOW_atom_in_multExpr324);
					a2=atom();
					state._fsp--;


					                  retval.vType =verifyTypes((a1!=null?((compiladorParser.atom_return)a1).vType:0),(a2!=null?((compiladorParser.atom_return)a2).vType:0),(a1!=null?input.toString(a1.start,a1.stop):null),(a2!=null?input.toString(a2.start,a2.stop):null));
					}
					break;

				default :
					break loop13;
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
	// compilador.g:129:1: atom returns [int vType] : ( CINT | CFLOAT | ID | PARA expr_aritm PARC );
	public final compiladorParser.atom_return atom() throws RecognitionException {
		compiladorParser.atom_return retval = new compiladorParser.atom_return();
		retval.start = input.LT(1);

		Token ID5=null;
		int expr_aritm6 =0;

		try {
			// compilador.g:130:20: ( CINT | CFLOAT | ID | PARA expr_aritm PARC )
			int alt14=4;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt14=1;
				}
				break;
			case CFLOAT:
				{
				alt14=2;
				}
				break;
			case ID:
				{
				alt14=3;
				}
				break;
			case PARA:
				{
				alt14=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// compilador.g:131:2: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atom342); 
					retval.vType =1;
					}
					break;
				case 2 :
					// compilador.g:132:4: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_atom349); 
					retval.vType =2;
					}
					break;
				case 3 :
					// compilador.g:133:4: ID
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_atom356); 
					 
					                        if(comprobarVariable((ID5!=null?ID5.getText():null))){
					                           if(tablaDeSimbolosLocal != null) {
					                              Integer obj = (Integer) tablaDeSimbolosLocal.get((ID5!=null?ID5.getText():null));
					                              retval.vType = obj.intValue();
					                           } else{ 
					                              Integer obj = (Integer) tablaDeSimbolosGlobal.get((ID5!=null?ID5.getText():null));
					                              retval.vType = obj.intValue();
					                           } 
					                    }else{
					                        retval.vType =0; // O cualquier valor que represente un tipo inválido o variable no declarada
					                    }
					                    
					}
					break;
				case 4 :
					// compilador.g:146:4: PARA expr_aritm PARC
					{
					match(input,PARA,FOLLOW_PARA_in_atom363); 
					pushFollow(FOLLOW_expr_aritm_in_atom365);
					expr_aritm6=expr_aritm();
					state._fsp--;

					retval.vType =expr_aritm6;
					match(input,PARC,FOLLOW_PARC_in_atom369); 
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
	// compilador.g:148:1: fin : FIN ;
	public final void fin() throws RecognitionException {
		try {
			// compilador.g:148:4: ( FIN )
			// compilador.g:149:2: FIN
			{
			match(input,FIN,FOLLOW_FIN_in_fin377); 
			  salida.append("Cant total IDs "+ tablaDeSimbolosGlobal.size() + "\n");
				           Integer test = (Integer) tablaDeSimbolosGlobal.get("a");
			               salida.append("El id 'a' ha aparecido "+test.intValue()+" veces" + "\n");  
			            
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
	// compilador.g:154:1: tipo : ( INT | FLOAT | STRING | DOUBLE | CHAR | VOID );
	public final compiladorParser.tipo_return tipo() throws RecognitionException {
		compiladorParser.tipo_return retval = new compiladorParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// compilador.g:154:5: ( INT | FLOAT | STRING | DOUBLE | CHAR | VOID )
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
	// compilador.g:156:1: modific_acceso : ( PUBLIC | PRIVATE | PROTECTED );
	public final void modific_acceso() throws RecognitionException {
		try {
			// compilador.g:156:15: ( PUBLIC | PRIVATE | PROTECTED )
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
	// compilador.g:157:1: constantes : ( CINT | CFLOAT | CCHAR );
	public final void constantes() throws RecognitionException {
		Token CCHAR7=null;

		try {
			// compilador.g:157:11: ( CINT | CFLOAT | CCHAR )
			int alt15=3;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt15=1;
				}
				break;
			case CFLOAT:
				{
				alt15=2;
				}
				break;
			case CCHAR:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// compilador.g:158:2: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_constantes428); 
					}
					break;
				case 2 :
					// compilador.g:159:4: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_constantes433); 
					}
					break;
				case 3 :
					// compilador.g:160:4: CCHAR
					{
					CCHAR7=(Token)match(input,CCHAR,FOLLOW_CCHAR_in_constantes438); 

						                    salida.append("Constante char:"+(CCHAR7!=null?CCHAR7.getText():null) + "\n");
					                                     
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



	public static final BitSet FOLLOW_modific_acceso_in_inicio21 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_CLASS_in_inicio23 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_inicio25 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LLAVEA_in_inicio27 = new BitSet(new long[]{0x0000000037017440L});
	public static final BitSet FOLLOW_atributo_in_inicio33 = new BitSet(new long[]{0x0000000037017440L});
	public static final BitSet FOLLOW_metodo_in_inicio39 = new BitSet(new long[]{0x0000000037017440L});
	public static final BitSet FOLLOW_declaracion_obj_in_inicio45 = new BitSet(new long[]{0x0000000037017440L});
	public static final BitSet FOLLOW_LLAVEC_in_inicio51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_declaracion_obj62 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_declaracion_obj68 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPASIGN_in_declaracion_obj70 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_NEW_in_declaracion_obj72 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_declaracion_obj78 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_PARA_in_declaracion_obj80 = new BitSet(new long[]{0x0000000000802000L});
	public static final BitSet FOLLOW_args_objeto_in_declaracion_obj82 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_PARC_in_declaracion_obj85 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_declaracion_obj87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_args_objeto95 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMA_in_args_objeto98 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_args_objeto100 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_modific_acceso_in_atributo109 = new BitSet(new long[]{0x0000000030005440L});
	public static final BitSet FOLLOW_tipo_in_atributo112 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_atributo118 = new BitSet(new long[]{0x0000000008000200L});
	public static final BitSet FOLLOW_COMA_in_atributo126 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_atributo132 = new BitSet(new long[]{0x0000000008000200L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_atributo140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modific_acceso_in_metodo147 = new BitSet(new long[]{0x0000000030005440L});
	public static final BitSet FOLLOW_tipo_in_metodo150 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_metodo152 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_PARA_in_metodo154 = new BitSet(new long[]{0x0000000030805440L});
	public static final BitSet FOLLOW_decl_args_in_metodo158 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_PARC_in_metodo161 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LLAVEA_in_metodo163 = new BitSet(new long[]{0x0000000030017440L});
	public static final BitSet FOLLOW_sentencia_in_metodo165 = new BitSet(new long[]{0x0000000030017440L});
	public static final BitSet FOLLOW_LLAVEC_in_metodo168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asignacion_in_sentencia176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decl_local_in_sentencia180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_decl_args186 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMA_in_decl_args189 = new BitSet(new long[]{0x0000000030005440L});
	public static final BitSet FOLLOW_arg_in_decl_args191 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_tipo_in_arg199 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_arg201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_local211 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_local217 = new BitSet(new long[]{0x0000000008000200L});
	public static final BitSet FOLLOW_COMA_in_decl_local225 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_decl_local231 = new BitSet(new long[]{0x0000000008000200L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_decl_local239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion246 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPASIGN_in_asignacion248 = new BitSet(new long[]{0x00000000004020A0L});
	public static final BitSet FOLLOW_expr_aritm_in_asignacion250 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_PUNTOYCOMA_in_asignacion252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr_aritm268 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_expr_aritm276 = new BitSet(new long[]{0x00000000004020A0L});
	public static final BitSet FOLLOW_multExpr_in_expr_aritm288 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_atom_in_multExpr310 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_OPMULT_in_multExpr318 = new BitSet(new long[]{0x00000000004020A0L});
	public static final BitSet FOLLOW_atom_in_multExpr324 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_CINT_in_atom342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atom349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARA_in_atom363 = new BitSet(new long[]{0x00000000004020A0L});
	public static final BitSet FOLLOW_expr_aritm_in_atom365 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_PARC_in_atom369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FIN_in_fin377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CINT_in_constantes428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_constantes433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CCHAR_in_constantes438 = new BitSet(new long[]{0x0000000000000002L});
}
