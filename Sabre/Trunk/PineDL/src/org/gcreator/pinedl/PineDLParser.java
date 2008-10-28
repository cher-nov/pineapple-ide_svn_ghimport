// $ANTLR 3.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g 2008-10-26 16:48:28

/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.gcreator.pinedl;

import java.util.Vector;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PineDLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "LPAREN", "RPAREN", "LARRAY", "RARRAY", "BBLOCK", "EBLOCK", "BTWAND", "BTWOR", "BTWXOR", "LOGAND", "LOGOR", "STMTCUT", "DBLDOT", "BTWNOT", "LOGNOT", "INC", "DEC", "EQ", "CEQ", "NEQ", "BG", "BGE", "LT", "LTE", "WORD", "PRIVACY", "THIS", "SUPER", "NULL", "BOOLEAN", "STRING", "CHAR", "FLOAT", "DOUBLE", "INTEGER", "ALPHA", "DIGIT", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'extends'", "'static'", "','", "'return'", "'throw'", "'try'", "'catch'", "'if'", "'elsif'", "'else'", "'while'", "'.'", "'int'", "'float'", "'double'", "'uint'", "'char'", "'string'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int DEC=25;
    public static final int T__66=66;
    public static final int LT=31;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RARRAY=12;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int MOD=8;
    public static final int BTWOR=16;
    public static final int CHAR=40;
    public static final int SLCOMMENT=46;
    public static final int BTWNOT=22;
    public static final int FLOAT=41;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int LTE=32;
    public static final int BTWXOR=17;
    public static final int PRIVACY=34;
    public static final int BTWAND=15;
    public static final int LPAREN=9;
    public static final int WORD=33;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int INC=24;
    public static final int T__57=57;
    public static final int RPAREN=10;
    public static final int T__58=58;
    public static final int BOOLEAN=38;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int DBLDOT=21;
    public static final int T__59=59;
    public static final int THIS=35;
    public static final int DOUBLE=42;
    public static final int PLUS=4;
    public static final int DIGIT=45;
    public static final int SUPER=36;
    public static final int EQ=26;
    public static final int BGE=30;
    public static final int T__50=50;
    public static final int MLCOMMENT=47;
    public static final int INTEGER=43;
    public static final int LARRAY=11;
    public static final int STMTCUT=20;
    public static final int T__49=49;
    public static final int LOGAND=18;
    public static final int NULL=37;
    public static final int LOGOR=19;
    public static final int BG=29;
    public static final int WHITESPACE=48;
    public static final int MINUS=5;
    public static final int MULT=6;
    public static final int ALPHA=44;
    public static final int NEQ=28;
    public static final int CEQ=27;
    public static final int DIV=7;
    public static final int BBLOCK=13;
    public static final int EBLOCK=14;
    public static final int STRING=39;
    public static final int LOGNOT=23;

    // delegates
    // delegators


        public PineDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PineDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PineDLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g"; }


    	private SignalReceiver signal = new SignalReceiver(); //Empty signal receiver
    	
    	public void setSignalReceiver(SignalReceiver signal){
    		this.signal = signal;
    		if(signal==null)
    			this.signal = new SignalReceiver(); //Prevent NullPointerExceptions
    	}
    	
    	public SignalReceiver getSignalReceiver(){
    		return signal;
    	}



    // $ANTLR start "doc"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:107:1: doc : pkgstmt ( impstmt )* clsstmt ;
    public final void doc() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:107:5: ( pkgstmt ( impstmt )* clsstmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:107:7: pkgstmt ( impstmt )* clsstmt
            {
            pushFollow(FOLLOW_pkgstmt_in_doc278);
            pkgstmt();

            state._fsp--;
            if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:108:3: ( impstmt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==50) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: impstmt
            	    {
            	    pushFollow(FOLLOW_impstmt_in_doc282);
            	    impstmt();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_clsstmt_in_doc287);
            clsstmt();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "doc"


    // $ANTLR start "pkgstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:111:1: pkgstmt : 'package' c= context STMTCUT ;
    public final void pkgstmt() throws RecognitionException {
        String c = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:112:2: ( 'package' c= context STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:112:4: 'package' c= context STMTCUT
            {
            match(input,49,FOLLOW_49_in_pkgstmt296); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_pkgstmt300);
            c=context();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              signal.sendPackageSignal(c);
            }
            match(input,STMTCUT,FOLLOW_STMTCUT_in_pkgstmt304); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pkgstmt"


    // $ANTLR start "impstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:113:1: impstmt : 'import' c= context STMTCUT ;
    public final void impstmt() throws RecognitionException {
        String c = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:113:9: ( 'import' c= context STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:113:11: 'import' c= context STMTCUT
            {
            match(input,50,FOLLOW_50_in_impstmt311); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_impstmt315);
            c=context();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              signal.sendImportSignal(c);
            }
            match(input,STMTCUT,FOLLOW_STMTCUT_in_impstmt319); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "impstmt"


    // $ANTLR start "clsstmt"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:115:1: clsstmt : 'class' c= WORD ( 'extends' d= context ) BBLOCK classcontent EBLOCK ;
    public final void clsstmt() throws RecognitionException {
        Token c=null;
        String d = null;


        String cls = ""; String baseclass = null;
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:2: ( 'class' c= WORD ( 'extends' d= context ) BBLOCK classcontent EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:4: 'class' c= WORD ( 'extends' d= context ) BBLOCK classcontent EBLOCK
            {
            match(input,51,FOLLOW_51_in_clsstmt332); if (state.failed) return ;
            c=(Token)match(input,WORD,FOLLOW_WORD_in_clsstmt336); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              cls=c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:38: ( 'extends' d= context )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:39: 'extends' d= context
            {
            match(input,52,FOLLOW_52_in_clsstmt341); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_clsstmt345);
            d=context();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              baseclass=d;
            }

            }

            if ( state.backtracking==0 ) {
              signal.sendClassDeclaration(cls, baseclass);
            }
            match(input,BBLOCK,FOLLOW_BBLOCK_in_clsstmt356); if (state.failed) return ;
            pushFollow(FOLLOW_classcontent_in_clsstmt361);
            classcontent();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_clsstmt365); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              signal.endClass();
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "clsstmt"


    // $ANTLR start "classcontent"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:123:1: classcontent : ( element )* ;
    public final void classcontent() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:124:2: ( ( element )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:124:4: ( element )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:124:4: ( element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PRIVACY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: element
            	    {
            	    pushFollow(FOLLOW_element_in_classcontent380);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "classcontent"


    // $ANTLR start "element"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:1: element : ( method | field | constructor );
    public final void element() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:9: ( method | field | constructor )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:11: method
                    {
                    pushFollow(FOLLOW_method_in_element390);
                    method();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:18: field
                    {
                    pushFollow(FOLLOW_field_in_element392);
                    field();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:24: constructor
                    {
                    pushFollow(FOLLOW_constructor_in_element394);
                    constructor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "element"


    // $ANTLR start "field"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:128:1: field : a= PRIVACY (s= 'static' )? d= type n= WORD STMTCUT ;
    public final void field() throws RecognitionException {
        Token a=null;
        Token s=null;
        Token n=null;
        String d = null;



        String privacy = null;
        boolean isstatic = false;
        boolean isconst = false;
        String type = "";

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:134:3: (a= PRIVACY (s= 'static' )? d= type n= WORD STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:135:2: a= PRIVACY (s= 'static' )? d= type n= WORD STMTCUT
            {
            a=(Token)match(input,PRIVACY,FOLLOW_PRIVACY_in_field410); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              privacy=a.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:3: (s= 'static' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==53) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: s= 'static'
                    {
                    s=(Token)match(input,53,FOLLOW_53_in_field417); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              if(s!=null) isstatic = true;
            }
            pushFollow(FOLLOW_type_in_field428);
            d=type();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              type = d;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_field435); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              signal.sendFieldSignal(privacy, isstatic, isconst, type, n.getText());
            }
            match(input,STMTCUT,FOLLOW_STMTCUT_in_field440); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "field"


    // $ANTLR start "method"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:142:1: method : p= PRIVACY (s= 'static' )? t= type n= WORD LPAREN (a= argument ( ',' b= argument )* )? RPAREN BBLOCK code EBLOCK ;
    public final void method() throws RecognitionException {
        Token p=null;
        Token s=null;
        Token n=null;
        String t = null;

        Argument a = null;

        Argument b = null;



        String privacy = null;
        boolean isstatic = false;
        String type = "";
        String name = "";
        Vector<Argument> args = new Vector<Argument>();

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:149:3: (p= PRIVACY (s= 'static' )? t= type n= WORD LPAREN (a= argument ( ',' b= argument )* )? RPAREN BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:149:5: p= PRIVACY (s= 'static' )? t= type n= WORD LPAREN (a= argument ( ',' b= argument )* )? RPAREN BBLOCK code EBLOCK
            {
            p=(Token)match(input,PRIVACY,FOLLOW_PRIVACY_in_method454); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              privacy=p.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:150:3: (s= 'static' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==53) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:150:4: s= 'static'
                    {
                    s=(Token)match(input,53,FOLLOW_53_in_method463); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      isstatic = true;
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_in_method473);
            t=type();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              type=t;
            }
            n=(Token)match(input,WORD,FOLLOW_WORD_in_method481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              name=n.getText();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_method487); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:153:10: (a= argument ( ',' b= argument )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WORD||(LA7_0>=64 && LA7_0<=69)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:153:11: a= argument ( ',' b= argument )*
                    {
                    pushFollow(FOLLOW_argument_in_method492);
                    a=argument();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      args.add(a);
                    }
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:153:37: ( ',' b= argument )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==54) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:153:38: ',' b= argument
                    	    {
                    	    match(input,54,FOLLOW_54_in_method497); if (state.failed) return ;
                    	    pushFollow(FOLLOW_argument_in_method501);
                    	    b=argument();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      args.add(b);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_method509); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              signal.sendMethodSignal(privacy, isstatic, type, name, args); 
            }
            match(input,BBLOCK,FOLLOW_BBLOCK_in_method517); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_method522);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_method526); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "method"


    // $ANTLR start "constructor"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:159:1: constructor : PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK ;
    public final void constructor() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:2: ( PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:4: PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK
            {
            match(input,PRIVACY,FOLLOW_PRIVACY_in_constructor535); if (state.failed) return ;
            match(input,THIS,FOLLOW_THIS_in_constructor537); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_constructor539); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:24: ( argument ( ',' argument )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WORD||(LA9_0>=64 && LA9_0<=69)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:25: argument ( ',' argument )*
                    {
                    pushFollow(FOLLOW_argument_in_constructor542);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:34: ( ',' argument )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==54) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:35: ',' argument
                    	    {
                    	    match(input,54,FOLLOW_54_in_constructor545); if (state.failed) return ;
                    	    pushFollow(FOLLOW_argument_in_constructor547);
                    	    argument();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_constructor553); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:59: ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==DBLDOT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:60: DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN
                    {
                    match(input,DBLDOT,FOLLOW_DBLDOT_in_constructor556); if (state.failed) return ;
                    if ( (input.LA(1)>=THIS && input.LA(1)<=SUPER) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,LPAREN,FOLLOW_LPAREN_in_constructor564); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:87: ( WORD ( ',' WORD )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WORD) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:88: WORD ( ',' WORD )*
                            {
                            match(input,WORD,FOLLOW_WORD_in_constructor567); if (state.failed) return ;
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:93: ( ',' WORD )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==54) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:160:94: ',' WORD
                            	    {
                            	    match(input,54,FOLLOW_54_in_constructor570); if (state.failed) return ;
                            	    match(input,WORD,FOLLOW_WORD_in_constructor572); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_constructor578); if (state.failed) return ;

                    }
                    break;

            }

            match(input,BBLOCK,FOLLOW_BBLOCK_in_constructor585); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_constructor590);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_constructor594); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constructor"


    // $ANTLR start "argument"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:165:1: argument returns [Argument a = new Argument()] : c= type d= WORD ;
    public final Argument argument() throws RecognitionException {
        Argument a =  new Argument();

        Token d=null;
        String c = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:166:2: (c= type d= WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:166:4: c= type d= WORD
            {
            pushFollow(FOLLOW_type_in_argument611);
            c=type();

            state._fsp--;
            if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.type = c;
            }
            d=(Token)match(input,WORD,FOLLOW_WORD_in_argument617); if (state.failed) return a;
            if ( state.backtracking==0 ) {
              a.name = d.getText();
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "argument"


    // $ANTLR start "code"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:1: code : ( codel )* ;
    public final void code() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:6: ( ( codel )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:8: ( codel )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:8: ( codel )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==STMTCUT||LA13_0==WORD||(LA13_0>=THIS && LA13_0<=SUPER)||(LA13_0>=55 && LA13_0<=57)||LA13_0==59||LA13_0==62||(LA13_0>=64 && LA13_0<=69)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: codel
            	    {
            	    pushFollow(FOLLOW_codel_in_code627);
            	    codel();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "code"


    // $ANTLR start "codel"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:170:1: codel : ( trycatch | assign | ifcase | whilecase | ( type2value STMTCUT ) | returncase | throwcase | STMTCUT );
    public final void codel() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:170:7: ( trycatch | assign | ifcase | whilecase | ( type2value STMTCUT ) | returncase | throwcase | STMTCUT )
            int alt14=8;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:170:9: trycatch
                    {
                    pushFollow(FOLLOW_trycatch_in_codel636);
                    trycatch();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:171:3: assign
                    {
                    pushFollow(FOLLOW_assign_in_codel642);
                    assign();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:3: ifcase
                    {
                    pushFollow(FOLLOW_ifcase_in_codel648);
                    ifcase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:3: whilecase
                    {
                    pushFollow(FOLLOW_whilecase_in_codel654);
                    whilecase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:174:3: ( type2value STMTCUT )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:174:3: ( type2value STMTCUT )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:174:4: type2value STMTCUT
                    {
                    pushFollow(FOLLOW_type2value_in_codel661);
                    type2value();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,STMTCUT,FOLLOW_STMTCUT_in_codel663); if (state.failed) return ;

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:3: returncase
                    {
                    pushFollow(FOLLOW_returncase_in_codel670);
                    returncase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:176:3: throwcase
                    {
                    pushFollow(FOLLOW_throwcase_in_codel676);
                    throwcase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:177:3: STMTCUT
                    {
                    match(input,STMTCUT,FOLLOW_STMTCUT_in_codel682); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "codel"


    // $ANTLR start "returncase"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:179:1: returncase : 'return' expression STMTCUT ;
    public final void returncase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:180:2: ( 'return' expression STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:180:4: 'return' expression STMTCUT
            {
            match(input,55,FOLLOW_55_in_returncase693); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_returncase695);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,STMTCUT,FOLLOW_STMTCUT_in_returncase697); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "returncase"


    // $ANTLR start "throwcase"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:182:1: throwcase : 'throw' expression STMTCUT ;
    public final void throwcase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:2: ( 'throw' expression STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:4: 'throw' expression STMTCUT
            {
            match(input,56,FOLLOW_56_in_throwcase707); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_throwcase709);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,STMTCUT,FOLLOW_STMTCUT_in_throwcase711); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "throwcase"


    // $ANTLR start "assign"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:1: assign : ( ( type WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT ;
    public final void assign() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:8: ( ( ( type WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:10: ( ( type WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:10: ( ( type WORD ( EQ expression )? ) | ( WORD EQ expression ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=64 && LA16_0<=69)) ) {
                alt16=1;
            }
            else if ( (LA16_0==WORD) ) {
                int LA16_2 = input.LA(2);

                if ( (LA16_2==EQ) ) {
                    alt16=2;
                }
                else if ( (LA16_2==WORD||LA16_2==63) ) {
                    alt16=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:11: ( type WORD ( EQ expression )? )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:11: ( type WORD ( EQ expression )? )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:12: type WORD ( EQ expression )?
                    {
                    pushFollow(FOLLOW_type_in_assign725);
                    type();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,WORD,FOLLOW_WORD_in_assign727); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:22: ( EQ expression )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==EQ) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:23: EQ expression
                            {
                            match(input,EQ,FOLLOW_EQ_in_assign730); if (state.failed) return ;
                            pushFollow(FOLLOW_expression_in_assign732);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:42: ( WORD EQ expression )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:42: ( WORD EQ expression )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:189:43: WORD EQ expression
                    {
                    match(input,WORD,FOLLOW_WORD_in_assign740); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_assign742); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assign744);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }


                    }
                    break;

            }

            match(input,STMTCUT,FOLLOW_STMTCUT_in_assign748); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "assign"


    // $ANTLR start "trycatch"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:193:1: trycatch : 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK ;
    public final void trycatch() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:193:9: ( 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:193:11: 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK
            {
            match(input,57,FOLLOW_57_in_trycatch757); if (state.failed) return ;
            match(input,BBLOCK,FOLLOW_BBLOCK_in_trycatch759); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_trycatch761);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_trycatch763); if (state.failed) return ;
            match(input,58,FOLLOW_58_in_trycatch765); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_trycatch767); if (state.failed) return ;
            pushFollow(FOLLOW_argument_in_trycatch769);
            argument();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_trycatch771); if (state.failed) return ;
            match(input,BBLOCK,FOLLOW_BBLOCK_in_trycatch773); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_trycatch775);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_trycatch777); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "trycatch"


    // $ANTLR start "ifcase"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:195:1: ifcase : 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )? ;
    public final void ifcase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:195:8: ( 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:195:10: 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )?
            {
            match(input,59,FOLLOW_59_in_ifcase785); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifcase787); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_ifcase789);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_ifcase791); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_ifcase793);
            situation();

            state._fsp--;
            if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:196:3: ( elsif )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==60) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred25_PineDL()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: elsif
            	    {
            	    pushFollow(FOLLOW_elsif_in_ifcase797);
            	    elsif();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:197:3: ( elsecase )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==61) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred26_PineDL()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: elsecase
                    {
                    pushFollow(FOLLOW_elsecase_in_ifcase802);
                    elsecase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ifcase"


    // $ANTLR start "elsif"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:199:1: elsif : 'elsif' LPAREN expression RPAREN situation ;
    public final void elsif() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:199:7: ( 'elsif' LPAREN expression RPAREN situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:199:9: 'elsif' LPAREN expression RPAREN situation
            {
            match(input,60,FOLLOW_60_in_elsif811); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_elsif813); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_elsif815);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_elsif817); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_elsif819);
            situation();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "elsif"


    // $ANTLR start "elsecase"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:201:1: elsecase : 'else' situation ;
    public final void elsecase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:201:9: ( 'else' situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:201:11: 'else' situation
            {
            match(input,61,FOLLOW_61_in_elsecase826); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_elsecase828);
            situation();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "elsecase"


    // $ANTLR start "whilecase"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:203:1: whilecase : 'while' LPAREN expression RPAREN situation ;
    public final void whilecase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:204:2: ( 'while' LPAREN expression RPAREN situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:204:4: 'while' LPAREN expression RPAREN situation
            {
            match(input,62,FOLLOW_62_in_whilecase837); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_whilecase839); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_whilecase841);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_whilecase843); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_whilecase845);
            situation();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "whilecase"


    // $ANTLR start "situation"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:206:1: situation : ( codel | ( BBLOCK code EBLOCK ) );
    public final void situation() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:207:2: ( codel | ( BBLOCK code EBLOCK ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STMTCUT||LA19_0==WORD||(LA19_0>=THIS && LA19_0<=SUPER)||(LA19_0>=55 && LA19_0<=57)||LA19_0==59||LA19_0==62||(LA19_0>=64 && LA19_0<=69)) ) {
                alt19=1;
            }
            else if ( (LA19_0==BBLOCK) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:207:4: codel
                    {
                    pushFollow(FOLLOW_codel_in_situation854);
                    codel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:207:12: ( BBLOCK code EBLOCK )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:207:12: ( BBLOCK code EBLOCK )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:207:13: BBLOCK code EBLOCK
                    {
                    match(input,BBLOCK,FOLLOW_BBLOCK_in_situation859); if (state.failed) return ;
                    pushFollow(FOLLOW_code_in_situation861);
                    code();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,EBLOCK,FOLLOW_EBLOCK_in_situation863); if (state.failed) return ;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "situation"


    // $ANTLR start "expression"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:209:1: expression : ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )* ;
    public final void expression() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:2: ( ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:4: ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:4: ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==WORD||(LA20_0>=THIS && LA20_0<=INTEGER)) ) {
                alt20=1;
            }
            else if ( (LA20_0==LPAREN) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==WORD||(LA20_2>=THIS && LA20_2<=INTEGER)) ) {
                    alt20=2;
                }
                else if ( ((LA20_2>=BTWNOT && LA20_2<=LOGNOT)) ) {
                    alt20=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:5: value
                    {
                    pushFollow(FOLLOW_value_in_expression874);
                    value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:13: ( '(' value ')' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:13: ( '(' value ')' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:14: '(' value ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_expression879); if (state.failed) return ;
                    pushFollow(FOLLOW_value_in_expression881);
                    value();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RPAREN,FOLLOW_RPAREN_in_expression883); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:31: ( '(' sgloperation ')' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:31: ( '(' sgloperation ')' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:210:32: '(' sgloperation ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_expression889); if (state.failed) return ;
                    pushFollow(FOLLOW_sgloperation_in_expression891);
                    sgloperation();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RPAREN,FOLLOW_RPAREN_in_expression893); if (state.failed) return ;

                    }


                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:211:3: ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=PLUS && LA21_0<=MOD)||(LA21_0>=BTWAND && LA21_0<=LOGOR)||(LA21_0>=EQ && LA21_0<=LTE)) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred46_PineDL()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:211:4: ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression
            	    {
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MOD)||(input.LA(1)>=BTWAND && input.LA(1)<=LOGOR)||(input.LA(1)>=EQ && input.LA(1)<=LTE) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_expression_in_expression971);
            	    expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "sgloperation"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:214:1: sgloperation : ( BTWNOT | LOGNOT ) expression ;
    public final void sgloperation() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:215:2: ( ( BTWNOT | LOGNOT ) expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:215:4: ( BTWNOT | LOGNOT ) expression
            {
            if ( (input.LA(1)>=BTWNOT && input.LA(1)<=LOGNOT) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_expression_in_sgloperation990);
            expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sgloperation"


    // $ANTLR start "value"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:1: value : ( type1value | type2value | type3value );
    public final void value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:7: ( type1value | type2value | type3value )
            int alt22=3;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:9: type1value
                    {
                    pushFollow(FOLLOW_type1value_in_value998);
                    type1value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:22: type2value
                    {
                    pushFollow(FOLLOW_type2value_in_value1002);
                    type2value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:35: type3value
                    {
                    pushFollow(FOLLOW_type3value_in_value1006);
                    type3value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "value"


    // $ANTLR start "type1value"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:220:1: type1value : ( contextp | elemcontext ) ( INC | DEC )? ;
    public final void type1value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:2: ( ( contextp | elemcontext ) ( INC | DEC )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:4: ( contextp | elemcontext ) ( INC | DEC )?
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:4: ( contextp | elemcontext )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==WORD) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=THIS && LA23_0<=SUPER)) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:5: contextp
                    {
                    pushFollow(FOLLOW_contextp_in_type1value1017);
                    contextp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:16: elemcontext
                    {
                    pushFollow(FOLLOW_elemcontext_in_type1value1021);
                    elemcontext();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:221:29: ( INC | DEC )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=INC && LA24_0<=DEC)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:
                    {
                    if ( (input.LA(1)>=INC && input.LA(1)<=DEC) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type1value"


    // $ANTLR start "type2value"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:224:1: type2value : ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )* ;
    public final void type2value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:2: ( ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:4: ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:4: ( ( THIS | SUPER | WORD ) '.' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==WORD) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==63) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==WORD) ) {
                        int LA25_5 = input.LA(4);

                        if ( (synpred55_PineDL()) ) {
                            alt25=1;
                        }
                    }
                }
            }
            else if ( ((LA25_0>=THIS && LA25_0<=SUPER)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:5: ( THIS | SUPER | WORD ) '.'
                    {
                    if ( input.LA(1)==WORD||(input.LA(1)>=THIS && input.LA(1)<=SUPER) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,63,FOLLOW_63_in_type2value1048); if (state.failed) return ;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:3: ( WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:4: WORD
            {
            match(input,WORD,FOLLOW_WORD_in_type2value1055); if (state.failed) return ;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:10: ( acelem )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==LPAREN||LA26_0==LARRAY) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: acelem
            	    {
            	    pushFollow(FOLLOW_acelem_in_type2value1058);
            	    acelem();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:18: ( '.' WORD ( acelem )* )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==63) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:19: '.' WORD ( acelem )*
            	    {
            	    match(input,63,FOLLOW_63_in_type2value1062); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_type2value1064); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:226:28: ( acelem )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==LPAREN||LA27_0==LARRAY) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: acelem
            	    	    {
            	    	    pushFollow(FOLLOW_acelem_in_type2value1066);
            	    	    acelem();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop27;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type2value"


    // $ANTLR start "acelem"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:1: acelem : ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) ) ;
    public final void acelem() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:8: ( ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:10: ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:10: ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LARRAY) ) {
                alt31=1;
            }
            else if ( (LA31_0==LPAREN) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:11: ( LARRAY expression RARRAY )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:11: ( LARRAY expression RARRAY )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:12: LARRAY expression RARRAY
                    {
                    match(input,LARRAY,FOLLOW_LARRAY_in_acelem1079); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_acelem1081);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RARRAY,FOLLOW_RARRAY_in_acelem1083); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:40: ( LPAREN ( expression ( ',' expression )* )? RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:40: ( LPAREN ( expression ( ',' expression )* )? RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:41: LPAREN ( expression ( ',' expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_acelem1089); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:48: ( expression ( ',' expression )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==LPAREN||LA30_0==WORD||(LA30_0>=THIS && LA30_0<=INTEGER)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:49: expression ( ',' expression )*
                            {
                            pushFollow(FOLLOW_expression_in_acelem1092);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:60: ( ',' expression )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==54) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:228:61: ',' expression
                            	    {
                            	    match(input,54,FOLLOW_54_in_acelem1095); if (state.failed) return ;
                            	    pushFollow(FOLLOW_expression_in_acelem1097);
                            	    expression();

                            	    state._fsp--;
                            	    if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_acelem1104); if (state.failed) return ;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "acelem"


    // $ANTLR start "type3value"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:230:1: type3value : ( NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER );
    public final void type3value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:231:2: ( NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:
            {
            if ( (input.LA(1)>=NULL && input.LA(1)<=INTEGER) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
        }
        return ;
    }
    // $ANTLR end "type3value"


    // $ANTLR start "elemcontext"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:233:1: elemcontext : ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+ ;
    public final void elemcontext() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:2: ( ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+ )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:4: ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+
            {
            if ( (input.LA(1)>=THIS && input.LA(1)<=SUPER) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:17: ( '.' WORD ( LARRAY expression RARRAY )* )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==63) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:18: '.' WORD ( LARRAY expression RARRAY )*
            	    {
            	    match(input,63,FOLLOW_63_in_elemcontext1156); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_elemcontext1158); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:27: ( LARRAY expression RARRAY )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==LARRAY) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:234:28: LARRAY expression RARRAY
            	    	    {
            	    	    match(input,LARRAY,FOLLOW_LARRAY_in_elemcontext1161); if (state.failed) return ;
            	    	    pushFollow(FOLLOW_expression_in_elemcontext1163);
            	    	    expression();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    match(input,RARRAY,FOLLOW_RARRAY_in_elemcontext1165); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop32;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "elemcontext"


    // $ANTLR start "contextp"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:1: contextp : WORD ( '.' WORD ( LARRAY expression RARRAY )* )+ ;
    public final void contextp() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:9: ( WORD ( '.' WORD ( LARRAY expression RARRAY )* )+ )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:11: WORD ( '.' WORD ( LARRAY expression RARRAY )* )+
            {
            match(input,WORD,FOLLOW_WORD_in_contextp1178); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:16: ( '.' WORD ( LARRAY expression RARRAY )* )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==63) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:17: '.' WORD ( LARRAY expression RARRAY )*
            	    {
            	    match(input,63,FOLLOW_63_in_contextp1181); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_contextp1183); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:26: ( LARRAY expression RARRAY )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==LARRAY) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:236:27: LARRAY expression RARRAY
            	    	    {
            	    	    match(input,LARRAY,FOLLOW_LARRAY_in_contextp1186); if (state.failed) return ;
            	    	    pushFollow(FOLLOW_expression_in_contextp1188);
            	    	    expression();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    match(input,RARRAY,FOLLOW_RARRAY_in_contextp1190); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop34;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "contextp"


    // $ANTLR start "context"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:238:1: context returns [String result = \"\"] : c= WORD ( '.' t= WORD )* ;
    public final String context() throws RecognitionException {
        String result =  "";

        Token c=null;
        Token t=null;

        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:239:2: (c= WORD ( '.' t= WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:239:4: c= WORD ( '.' t= WORD )*
            {
            c=(Token)match(input,WORD,FOLLOW_WORD_in_context1210); if (state.failed) return result;
            if ( state.backtracking==0 ) {
              result += c.getText();
            }
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:239:37: ( '.' t= WORD )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==63) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:239:38: '.' t= WORD
            	    {
            	    match(input,63,FOLLOW_63_in_context1215); if (state.failed) return result;
            	    t=(Token)match(input,WORD,FOLLOW_WORD_in_context1219); if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	      result += "." + t.getText();
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "context"


    // $ANTLR start "type"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:242:1: type returns [String s = \"\"] : ( (t= ( 'int' | 'float' | 'double' | 'uint' | 'char' | 'string' ) ) | (g= context ) );
    public final String type() throws RecognitionException {
        String s =  "";

        Token t=null;
        String g = null;


        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:2: ( (t= ( 'int' | 'float' | 'double' | 'uint' | 'char' | 'string' ) ) | (g= context ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=64 && LA37_0<=69)) ) {
                alt37=1;
            }
            else if ( (LA37_0==WORD) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return s;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:4: (t= ( 'int' | 'float' | 'double' | 'uint' | 'char' | 'string' ) )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:4: (t= ( 'int' | 'float' | 'double' | 'uint' | 'char' | 'string' ) )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:5: t= ( 'int' | 'float' | 'double' | 'uint' | 'char' | 'string' )
                    {
                    t=(Token)input.LT(1);
                    if ( (input.LA(1)>=64 && input.LA(1)<=69) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return s;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    if ( state.backtracking==0 ) {
                      s=t.getText();
                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:73: (g= context )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:73: (g= context )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:243:74: g= context
                    {
                    pushFollow(FOLLOW_context_in_type1260);
                    g=context();

                    state._fsp--;
                    if (state.failed) return s;
                    if ( state.backtracking==0 ) {
                      s = g;
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred25_PineDL
    public final void synpred25_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:196:3: ( elsif )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:196:3: elsif
        {
        pushFollow(FOLLOW_elsif_in_synpred25_PineDL797);
        elsif();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_PineDL

    // $ANTLR start synpred26_PineDL
    public final void synpred26_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:197:3: ( elsecase )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:197:3: elsecase
        {
        pushFollow(FOLLOW_elsecase_in_synpred26_PineDL802);
        elsecase();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_PineDL

    // $ANTLR start synpred46_PineDL
    public final void synpred46_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:211:4: ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:211:4: ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression
        {
        if ( (input.LA(1)>=PLUS && input.LA(1)<=MOD)||(input.LA(1)>=BTWAND && input.LA(1)<=LOGOR)||(input.LA(1)>=EQ && input.LA(1)<=LTE) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_expression_in_synpred46_PineDL971);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_PineDL

    // $ANTLR start synpred48_PineDL
    public final void synpred48_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:9: ( type1value )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:9: type1value
        {
        pushFollow(FOLLOW_type1value_in_synpred48_PineDL998);
        type1value();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_PineDL

    // $ANTLR start synpred49_PineDL
    public final void synpred49_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:22: ( type2value )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:217:22: type2value
        {
        pushFollow(FOLLOW_type2value_in_synpred49_PineDL1002);
        type2value();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_PineDL

    // $ANTLR start synpred55_PineDL
    public final void synpred55_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:5: ( ( THIS | SUPER | WORD ) '.' )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:225:5: ( THIS | SUPER | WORD ) '.'
        {
        if ( input.LA(1)==WORD||(input.LA(1)>=THIS && input.LA(1)<=SUPER) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        match(input,63,FOLLOW_63_in_synpred55_PineDL1048); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_PineDL

    // Delegated rules

    public final boolean synpred26_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA3_eotS =
        "\13\uffff";
    static final String DFA3_eofS =
        "\13\uffff";
    static final String DFA3_minS =
        "\1\42\1\41\1\uffff\3\41\1\11\1\41\2\uffff\1\41";
    static final String DFA3_maxS =
        "\1\42\1\105\1\uffff\1\105\1\41\1\77\1\24\1\41\2\uffff\1\77";
    static final String DFA3_acceptS =
        "\2\uffff\1\3\5\uffff\1\2\1\1\1\uffff";
    static final String DFA3_specialS =
        "\13\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1",
            "\1\5\1\uffff\1\2\21\uffff\1\3\12\uffff\6\4",
            "",
            "\1\5\36\uffff\6\4",
            "\1\6",
            "\1\6\35\uffff\1\7",
            "\1\11\12\uffff\1\10",
            "\1\12",
            "",
            "",
            "\1\6\35\uffff\1\7"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "126:1: element : ( method | field | constructor );";
        }
    }
    static final String DFA14_eotS =
        "\16\uffff";
    static final String DFA14_eofS =
        "\16\uffff";
    static final String DFA14_minS =
        "\1\24\2\uffff\1\11\6\uffff\1\41\1\11\1\41\1\11";
    static final String DFA14_maxS =
        "\1\105\2\uffff\1\77\6\uffff\1\41\1\77\1\41\1\77";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff";
    static final String DFA14_specialS =
        "\16\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\11\14\uffff\1\3\1\uffff\2\6\22\uffff\1\7\1\10\1\1\1\uffff"+
            "\1\4\2\uffff\1\5\1\uffff\6\2",
            "",
            "",
            "\1\6\1\uffff\1\6\10\uffff\1\6\5\uffff\1\2\6\uffff\1\2\35\uffff"+
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\6\1\uffff\1\6\10\uffff\1\6\14\uffff\1\2\35\uffff\1\14",
            "\1\15",
            "\1\6\1\uffff\1\6\10\uffff\1\6\14\uffff\1\2\35\uffff\1\14"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "170:1: codel : ( trycatch | assign | ifcase | whilecase | ( type2value STMTCUT ) | returncase | throwcase | STMTCUT );";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\1\uffff\1\5\10\uffff";
    static final String DFA22_minS =
        "\1\41\1\4\1\77\1\uffff\1\41\1\uffff\1\41\2\0\1\uffff";
    static final String DFA22_maxS =
        "\1\53\2\77\1\uffff\1\41\1\uffff\1\41\2\0\1\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\3\1\uffff\1\2\3\uffff\1\1";
    static final String DFA22_specialS =
        "\7\uffff\1\1\1\0\1\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\uffff\2\2\7\3",
            "\11\5\2\uffff\6\5\5\uffff\7\5\25\uffff\1\5\10\uffff\1\4",
            "\1\6",
            "",
            "\1\7",
            "",
            "\1\10",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "217:1: value : ( type1value | type2value | type3value );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_PineDL()) ) {s = 9;}

                        else if ( (synpred49_PineDL()) ) {s = 5;}

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_PineDL()) ) {s = 9;}

                        else if ( (synpred49_PineDL()) ) {s = 5;}

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_pkgstmt_in_doc278 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_impstmt_in_doc282 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_clsstmt_in_doc287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_pkgstmt296 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_pkgstmt300 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_pkgstmt304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_impstmt311 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_impstmt315 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_impstmt319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_clsstmt332 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_clsstmt336 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_clsstmt341 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_clsstmt345 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_clsstmt356 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_classcontent_in_clsstmt361 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_clsstmt365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_classcontent380 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_method_in_element390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_element392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructor_in_element394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_field410 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_field417 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_field428 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_field435 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_field440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_method454 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_method463 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_type_in_method473 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_method481 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_method487 = new BitSet(new long[]{0x0020000200000400L,0x000000000000003FL});
    public static final BitSet FOLLOW_argument_in_method492 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_method497 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_argument_in_method501 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_method509 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_method517 = new BitSet(new long[]{0x4BA0001A00104000L,0x000000000000003FL});
    public static final BitSet FOLLOW_code_in_method522 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_method526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_constructor535 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_THIS_in_constructor537 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_constructor539 = new BitSet(new long[]{0x0020000200000400L,0x000000000000003FL});
    public static final BitSet FOLLOW_argument_in_constructor542 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_constructor545 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_argument_in_constructor547 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_constructor553 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_DBLDOT_in_constructor556 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_set_in_constructor558 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_constructor564 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_WORD_in_constructor567 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_constructor570 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_constructor572 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_constructor578 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_constructor585 = new BitSet(new long[]{0x4BA0001A00104000L,0x000000000000003FL});
    public static final BitSet FOLLOW_code_in_constructor590 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_constructor594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_argument611 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_argument617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codel_in_code627 = new BitSet(new long[]{0x4BA0001A00100002L,0x000000000000003FL});
    public static final BitSet FOLLOW_trycatch_in_codel636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_in_codel642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifcase_in_codel648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whilecase_in_codel654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_codel661 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_codel663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returncase_in_codel670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwcase_in_codel676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTCUT_in_codel682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_returncase693 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_returncase695 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_returncase697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_throwcase707 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_throwcase709 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_throwcase711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_assign725 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_assign727 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_EQ_in_assign730 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_assign732 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_WORD_in_assign740 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_assign742 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_assign744 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_assign748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_trycatch757 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_trycatch759 = new BitSet(new long[]{0x4BA0001A00104000L,0x000000000000003FL});
    public static final BitSet FOLLOW_code_in_trycatch761 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_trycatch763 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_trycatch765 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_trycatch767 = new BitSet(new long[]{0x0020000200000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_argument_in_trycatch769 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_trycatch771 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_trycatch773 = new BitSet(new long[]{0x4BA0001A00104000L,0x000000000000003FL});
    public static final BitSet FOLLOW_code_in_trycatch775 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_trycatch777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ifcase785 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_ifcase787 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_ifcase789 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_ifcase791 = new BitSet(new long[]{0x4BA0001A00102000L,0x000000000000003FL});
    public static final BitSet FOLLOW_situation_in_ifcase793 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_elsif_in_ifcase797 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_elsecase_in_ifcase802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_elsif811 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_elsif813 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_elsif815 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_elsif817 = new BitSet(new long[]{0x4BA0001A00102000L,0x000000000000003FL});
    public static final BitSet FOLLOW_situation_in_elsif819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_elsecase826 = new BitSet(new long[]{0x4BA0001A00102000L,0x000000000000003FL});
    public static final BitSet FOLLOW_situation_in_elsecase828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_whilecase837 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_whilecase839 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_whilecase841 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_whilecase843 = new BitSet(new long[]{0x4BA0001A00102000L,0x000000000000003FL});
    public static final BitSet FOLLOW_situation_in_whilecase845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codel_in_situation854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BBLOCK_in_situation859 = new BitSet(new long[]{0x4BA0001A00104000L,0x000000000000003FL});
    public static final BitSet FOLLOW_code_in_situation861 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_situation863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_expression874 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_LPAREN_in_expression879 = new BitSet(new long[]{0x00000FFA00000000L});
    public static final BitSet FOLLOW_value_in_expression881 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_expression883 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_LPAREN_in_expression889 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_sgloperation_in_expression891 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_expression893 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_set_in_expression901 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_expression971 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_set_in_sgloperation982 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_sgloperation990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type1value_in_value998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_value1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type3value_in_value1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_contextp_in_type1value1017 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_elemcontext_in_type1value1021 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_type1value1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type2value1040 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_type2value1048 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_type2value1055 = new BitSet(new long[]{0x8000000000000A02L});
    public static final BitSet FOLLOW_acelem_in_type2value1058 = new BitSet(new long[]{0x8000000000000A02L});
    public static final BitSet FOLLOW_63_in_type2value1062 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_type2value1064 = new BitSet(new long[]{0x8000000000000A00L});
    public static final BitSet FOLLOW_acelem_in_type2value1066 = new BitSet(new long[]{0x8000000000000A02L});
    public static final BitSet FOLLOW_LARRAY_in_acelem1079 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_acelem1081 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_acelem1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_acelem1089 = new BitSet(new long[]{0x00000FFA00000600L});
    public static final BitSet FOLLOW_expression_in_acelem1092 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_acelem1095 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_acelem1097 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_acelem1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type3value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_elemcontext1149 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_elemcontext1156 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_elemcontext1158 = new BitSet(new long[]{0x8000000000000802L});
    public static final BitSet FOLLOW_LARRAY_in_elemcontext1161 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_elemcontext1163 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_elemcontext1165 = new BitSet(new long[]{0x8000000000000802L});
    public static final BitSet FOLLOW_WORD_in_contextp1178 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_contextp1181 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_contextp1183 = new BitSet(new long[]{0x8000000000000802L});
    public static final BitSet FOLLOW_LARRAY_in_contextp1186 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_contextp1188 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_contextp1190 = new BitSet(new long[]{0x8000000000000802L});
    public static final BitSet FOLLOW_WORD_in_context1210 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_context1215 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_context1219 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_set_in_type1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_context_in_type1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elsif_in_synpred25_PineDL797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elsecase_in_synpred26_PineDL802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred46_PineDL901 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_synpred46_PineDL971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type1value_in_synpred48_PineDL998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_synpred49_PineDL1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred55_PineDL1040 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_synpred55_PineDL1048 = new BitSet(new long[]{0x0000000000000002L});

}