// $ANTLR 3.1 /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g 2008-10-22 17:21:18

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PineDLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "MOD", "LPAREN", "RPAREN", "LARRAY", "RARRAY", "BBLOCK", "EBLOCK", "BTWAND", "BTWOR", "BTWXOR", "LOGAND", "LOGOR", "STMTCUT", "DBLDOT", "BTWNOT", "LOGNOT", "INC", "DEC", "EQ", "CEQ", "NEQ", "BG", "BGE", "LT", "LTE", "WORD", "PRIVACY", "THIS", "SUPER", "NULL", "BOOLEAN", "STRING", "CHAR", "FLOAT", "DOUBLE", "INTEGER", "ALPHA", "DIGIT", "SLCOMMENT", "MLCOMMENT", "WHITESPACE", "'package'", "'import'", "'class'", "'static'", "'const'", "','", "'try'", "'catch'", "'if'", "'elsif'", "'else'", "'white'", "'.'"
    };
    public static final int DEC=25;
    public static final int LT=31;
    public static final int RARRAY=12;
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
    public static final int T__57=57;
    public static final int RPAREN=10;
    public static final int INC=24;
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
    public static final int T__50=50;
    public static final int BGE=30;
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
    public static final int MULT=6;
    public static final int MINUS=5;
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



    // $ANTLR start "doc"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:91:1: doc : pkgstmt ( impstmt )* clsstmt ;
    public final void doc() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:91:5: ( pkgstmt ( impstmt )* clsstmt )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:91:7: pkgstmt ( impstmt )* clsstmt
            {
            pushFollow(FOLLOW_pkgstmt_in_doc273);
            pkgstmt();

            state._fsp--;
            if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:92:3: ( impstmt )*
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
            	    pushFollow(FOLLOW_impstmt_in_doc277);
            	    impstmt();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            pushFollow(FOLLOW_clsstmt_in_doc282);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:95:1: pkgstmt : 'package' context STMTCUT ;
    public final void pkgstmt() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:95:9: ( 'package' context STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:95:11: 'package' context STMTCUT
            {
            match(input,49,FOLLOW_49_in_pkgstmt290); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_pkgstmt292);
            context();

            state._fsp--;
            if (state.failed) return ;
            match(input,STMTCUT,FOLLOW_STMTCUT_in_pkgstmt294); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:96:1: impstmt : 'import' context STMTCUT ;
    public final void impstmt() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:96:9: ( 'import' context STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:96:11: 'import' context STMTCUT
            {
            match(input,50,FOLLOW_50_in_impstmt301); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_impstmt303);
            context();

            state._fsp--;
            if (state.failed) return ;
            match(input,STMTCUT,FOLLOW_STMTCUT_in_impstmt305); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:98:1: clsstmt : 'class' WORD ( DBLDOT context ) BBLOCK classcontent EBLOCK ;
    public final void clsstmt() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:98:9: ( 'class' WORD ( DBLDOT context ) BBLOCK classcontent EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:98:11: 'class' WORD ( DBLDOT context ) BBLOCK classcontent EBLOCK
            {
            match(input,51,FOLLOW_51_in_clsstmt313); if (state.failed) return ;
            match(input,WORD,FOLLOW_WORD_in_clsstmt315); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:98:24: ( DBLDOT context )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:98:25: DBLDOT context
            {
            match(input,DBLDOT,FOLLOW_DBLDOT_in_clsstmt318); if (state.failed) return ;
            pushFollow(FOLLOW_context_in_clsstmt320);
            context();

            state._fsp--;
            if (state.failed) return ;

            }

            match(input,BBLOCK,FOLLOW_BBLOCK_in_clsstmt325); if (state.failed) return ;
            pushFollow(FOLLOW_classcontent_in_clsstmt330);
            classcontent();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_clsstmt334); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:103:1: classcontent : ( element )* ;
    public final void classcontent() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:104:2: ( ( element )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:104:4: ( element )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:104:4: ( element )*
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
            	    pushFollow(FOLLOW_element_in_classcontent345);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:106:1: element : ( method | field | constructor );
    public final void element() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:106:9: ( method | field | constructor )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PRIVACY) ) {
                switch ( input.LA(2) ) {
                case THIS:
                    {
                    alt3=3;
                    }
                    break;
                case 52:
                    {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==53) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==WORD) ) {
                        alt3=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 53:
                    {
                    alt3=2;
                    }
                    break;
                case WORD:
                    {
                    alt3=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:106:11: method
                    {
                    pushFollow(FOLLOW_method_in_element355);
                    method();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:106:18: field
                    {
                    pushFollow(FOLLOW_field_in_element357);
                    field();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:106:24: constructor
                    {
                    pushFollow(FOLLOW_constructor_in_element359);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:108:1: field : PRIVACY ( 'static' )? 'const' WORD WORD ;
    public final void field() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:108:7: ( PRIVACY ( 'static' )? 'const' WORD WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:108:9: PRIVACY ( 'static' )? 'const' WORD WORD
            {
            match(input,PRIVACY,FOLLOW_PRIVACY_in_field367); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:108:17: ( 'static' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==52) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: 'static'
                    {
                    match(input,52,FOLLOW_52_in_field369); if (state.failed) return ;

                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_field372); if (state.failed) return ;
            match(input,WORD,FOLLOW_WORD_in_field374); if (state.failed) return ;
            match(input,WORD,FOLLOW_WORD_in_field376); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:1: method : PRIVACY ( 'static' )? WORD WORD LPAREN ( argument ( ',' argument )* )? RPAREN BBLOCK code EBLOCK ;
    public final void method() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:8: ( PRIVACY ( 'static' )? WORD WORD LPAREN ( argument ( ',' argument )* )? RPAREN BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:10: PRIVACY ( 'static' )? WORD WORD LPAREN ( argument ( ',' argument )* )? RPAREN BBLOCK code EBLOCK
            {
            match(input,PRIVACY,FOLLOW_PRIVACY_in_method384); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:18: ( 'static' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==52) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: 'static'
                    {
                    match(input,52,FOLLOW_52_in_method386); if (state.failed) return ;

                    }
                    break;

            }

            match(input,WORD,FOLLOW_WORD_in_method389); if (state.failed) return ;
            match(input,WORD,FOLLOW_WORD_in_method391); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_method393); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:45: ( argument ( ',' argument )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WORD) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:46: argument ( ',' argument )*
                    {
                    pushFollow(FOLLOW_argument_in_method396);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:55: ( ',' argument )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==54) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:110:56: ',' argument
                    	    {
                    	    match(input,54,FOLLOW_54_in_method399); if (state.failed) return ;
                    	    pushFollow(FOLLOW_argument_in_method401);
                    	    argument();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_method407); if (state.failed) return ;
            match(input,BBLOCK,FOLLOW_BBLOCK_in_method411); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_method416);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_method420); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:115:1: constructor : PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK ;
    public final void constructor() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:2: ( PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:4: PRIVACY THIS LPAREN ( argument ( ',' argument )* )? RPAREN ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )? BBLOCK code EBLOCK
            {
            match(input,PRIVACY,FOLLOW_PRIVACY_in_constructor429); if (state.failed) return ;
            match(input,THIS,FOLLOW_THIS_in_constructor431); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_constructor433); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:24: ( argument ( ',' argument )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WORD) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:25: argument ( ',' argument )*
                    {
                    pushFollow(FOLLOW_argument_in_constructor436);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:34: ( ',' argument )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==54) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:35: ',' argument
                    	    {
                    	    match(input,54,FOLLOW_54_in_constructor439); if (state.failed) return ;
                    	    pushFollow(FOLLOW_argument_in_constructor441);
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

            match(input,RPAREN,FOLLOW_RPAREN_in_constructor447); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:59: ( DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==DBLDOT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:60: DBLDOT ( THIS | SUPER ) LPAREN ( WORD ( ',' WORD )* )? RPAREN
                    {
                    match(input,DBLDOT,FOLLOW_DBLDOT_in_constructor450); if (state.failed) return ;
                    if ( (input.LA(1)>=THIS && input.LA(1)<=SUPER) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,LPAREN,FOLLOW_LPAREN_in_constructor458); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:87: ( WORD ( ',' WORD )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WORD) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:88: WORD ( ',' WORD )*
                            {
                            match(input,WORD,FOLLOW_WORD_in_constructor461); if (state.failed) return ;
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:93: ( ',' WORD )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==54) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:116:94: ',' WORD
                            	    {
                            	    match(input,54,FOLLOW_54_in_constructor464); if (state.failed) return ;
                            	    match(input,WORD,FOLLOW_WORD_in_constructor466); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RPAREN,FOLLOW_RPAREN_in_constructor472); if (state.failed) return ;

                    }
                    break;

            }

            match(input,BBLOCK,FOLLOW_BBLOCK_in_constructor479); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_constructor484);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_constructor488); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:121:1: argument : WORD WORD ;
    public final void argument() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:121:9: ( WORD WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:121:11: WORD WORD
            {
            match(input,WORD,FOLLOW_WORD_in_argument497); if (state.failed) return ;
            match(input,WORD,FOLLOW_WORD_in_argument499); if (state.failed) return ;

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
    // $ANTLR end "argument"


    // $ANTLR start "code"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:123:1: code : ( codel )* ;
    public final void code() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:123:6: ( ( codel )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:123:8: ( codel )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:123:8: ( codel )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==STMTCUT||LA13_0==WORD||(LA13_0>=THIS && LA13_0<=SUPER)||LA13_0==55||LA13_0==57||LA13_0==60) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: codel
            	    {
            	    pushFollow(FOLLOW_codel_in_code507);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:125:1: codel : ( trycatch | assign | ifcase | whilecase | ( type2value STMTCUT ) | STMTCUT );
    public final void codel() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:125:7: ( trycatch | assign | ifcase | whilecase | ( type2value STMTCUT ) | STMTCUT )
            int alt14=6;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt14=1;
                }
                break;
            case WORD:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==EQ||LA14_2==WORD) ) {
                    alt14=2;
                }
                else if ( (LA14_2==LPAREN||LA14_2==LARRAY||LA14_2==STMTCUT||LA14_2==61) ) {
                    alt14=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                alt14=3;
                }
                break;
            case 60:
                {
                alt14=4;
                }
                break;
            case THIS:
            case SUPER:
                {
                alt14=5;
                }
                break;
            case STMTCUT:
                {
                alt14=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:125:9: trycatch
                    {
                    pushFollow(FOLLOW_trycatch_in_codel516);
                    trycatch();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:126:3: assign
                    {
                    pushFollow(FOLLOW_assign_in_codel522);
                    assign();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:127:3: ifcase
                    {
                    pushFollow(FOLLOW_ifcase_in_codel528);
                    ifcase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:128:3: whilecase
                    {
                    pushFollow(FOLLOW_whilecase_in_codel534);
                    whilecase();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:129:3: ( type2value STMTCUT )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:129:3: ( type2value STMTCUT )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:129:4: type2value STMTCUT
                    {
                    pushFollow(FOLLOW_type2value_in_codel541);
                    type2value();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,STMTCUT,FOLLOW_STMTCUT_in_codel543); if (state.failed) return ;

                    }


                    }
                    break;
                case 6 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:130:3: STMTCUT
                    {
                    match(input,STMTCUT,FOLLOW_STMTCUT_in_codel550); if (state.failed) return ;

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


    // $ANTLR start "assign"
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:1: assign : ( ( WORD WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT ;
    public final void assign() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:8: ( ( ( WORD WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:10: ( ( WORD WORD ( EQ expression )? ) | ( WORD EQ expression ) ) STMTCUT
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:10: ( ( WORD WORD ( EQ expression )? ) | ( WORD EQ expression ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==WORD) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==WORD) ) {
                    alt16=1;
                }
                else if ( (LA16_1==EQ) ) {
                    alt16=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:11: ( WORD WORD ( EQ expression )? )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:11: ( WORD WORD ( EQ expression )? )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:12: WORD WORD ( EQ expression )?
                    {
                    match(input,WORD,FOLLOW_WORD_in_assign566); if (state.failed) return ;
                    match(input,WORD,FOLLOW_WORD_in_assign568); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:22: ( EQ expression )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==EQ) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:23: EQ expression
                            {
                            match(input,EQ,FOLLOW_EQ_in_assign571); if (state.failed) return ;
                            pushFollow(FOLLOW_expression_in_assign573);
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:42: ( WORD EQ expression )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:42: ( WORD EQ expression )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:136:43: WORD EQ expression
                    {
                    match(input,WORD,FOLLOW_WORD_in_assign581); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_assign583); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assign585);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }


                    }
                    break;

            }

            match(input,STMTCUT,FOLLOW_STMTCUT_in_assign589); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:140:1: trycatch : 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK ;
    public final void trycatch() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:140:9: ( 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:140:11: 'try' BBLOCK code EBLOCK 'catch' LPAREN argument RPAREN BBLOCK code EBLOCK
            {
            match(input,55,FOLLOW_55_in_trycatch598); if (state.failed) return ;
            match(input,BBLOCK,FOLLOW_BBLOCK_in_trycatch600); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_trycatch602);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_trycatch604); if (state.failed) return ;
            match(input,56,FOLLOW_56_in_trycatch606); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_trycatch608); if (state.failed) return ;
            pushFollow(FOLLOW_argument_in_trycatch610);
            argument();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_trycatch612); if (state.failed) return ;
            match(input,BBLOCK,FOLLOW_BBLOCK_in_trycatch614); if (state.failed) return ;
            pushFollow(FOLLOW_code_in_trycatch616);
            code();

            state._fsp--;
            if (state.failed) return ;
            match(input,EBLOCK,FOLLOW_EBLOCK_in_trycatch618); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:142:1: ifcase : 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )? ;
    public final void ifcase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:142:8: ( 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:142:10: 'if' LPAREN expression RPAREN situation ( elsif )* ( elsecase )?
            {
            match(input,57,FOLLOW_57_in_ifcase626); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_ifcase628); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_ifcase630);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_ifcase632); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_ifcase634);
            situation();

            state._fsp--;
            if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:143:3: ( elsif )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==58) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred23_PineDL()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: elsif
            	    {
            	    pushFollow(FOLLOW_elsif_in_ifcase638);
            	    elsif();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:144:3: ( elsecase )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==59) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred24_PineDL()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:0:0: elsecase
                    {
                    pushFollow(FOLLOW_elsecase_in_ifcase643);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:146:1: elsif : 'elsif' LPAREN expression RPAREN situation ;
    public final void elsif() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:146:7: ( 'elsif' LPAREN expression RPAREN situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:146:9: 'elsif' LPAREN expression RPAREN situation
            {
            match(input,58,FOLLOW_58_in_elsif652); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_elsif654); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_elsif656);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_elsif658); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_elsif660);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:148:1: elsecase : 'else' situation ;
    public final void elsecase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:148:9: ( 'else' situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:148:11: 'else' situation
            {
            match(input,59,FOLLOW_59_in_elsecase667); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_elsecase669);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:150:1: whilecase : 'white' LPAREN expression RPAREN situation ;
    public final void whilecase() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:151:2: ( 'white' LPAREN expression RPAREN situation )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:151:4: 'white' LPAREN expression RPAREN situation
            {
            match(input,60,FOLLOW_60_in_whilecase678); if (state.failed) return ;
            match(input,LPAREN,FOLLOW_LPAREN_in_whilecase680); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_whilecase682);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,RPAREN,FOLLOW_RPAREN_in_whilecase684); if (state.failed) return ;
            pushFollow(FOLLOW_situation_in_whilecase686);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:153:1: situation : ( codel | ( BBLOCK code EBLOCK ) );
    public final void situation() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:154:2: ( codel | ( BBLOCK code EBLOCK ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STMTCUT||LA19_0==WORD||(LA19_0>=THIS && LA19_0<=SUPER)||LA19_0==55||LA19_0==57||LA19_0==60) ) {
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:154:4: codel
                    {
                    pushFollow(FOLLOW_codel_in_situation695);
                    codel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:154:12: ( BBLOCK code EBLOCK )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:154:12: ( BBLOCK code EBLOCK )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:154:13: BBLOCK code EBLOCK
                    {
                    match(input,BBLOCK,FOLLOW_BBLOCK_in_situation700); if (state.failed) return ;
                    pushFollow(FOLLOW_code_in_situation702);
                    code();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,EBLOCK,FOLLOW_EBLOCK_in_situation704); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:156:1: expression : ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )* ;
    public final void expression() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:2: ( ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:4: ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) ) ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:4: ( value | ( '(' value ')' ) | ( '(' sgloperation ')' ) )
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:5: value
                    {
                    pushFollow(FOLLOW_value_in_expression715);
                    value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:13: ( '(' value ')' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:13: ( '(' value ')' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:14: '(' value ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_expression720); if (state.failed) return ;
                    pushFollow(FOLLOW_value_in_expression722);
                    value();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RPAREN,FOLLOW_RPAREN_in_expression724); if (state.failed) return ;

                    }


                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:31: ( '(' sgloperation ')' )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:31: ( '(' sgloperation ')' )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:157:32: '(' sgloperation ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_expression730); if (state.failed) return ;
                    pushFollow(FOLLOW_sgloperation_in_expression732);
                    sgloperation();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RPAREN,FOLLOW_RPAREN_in_expression734); if (state.failed) return ;

                    }


                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:158:3: ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=PLUS && LA21_0<=MOD)||(LA21_0>=BTWAND && LA21_0<=LOGOR)||(LA21_0>=EQ && LA21_0<=LTE)) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred44_PineDL()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:158:4: ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression
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

            	    pushFollow(FOLLOW_expression_in_expression812);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:161:1: sgloperation : ( BTWNOT | LOGNOT ) expression ;
    public final void sgloperation() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:162:2: ( ( BTWNOT | LOGNOT ) expression )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:162:4: ( BTWNOT | LOGNOT ) expression
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

            pushFollow(FOLLOW_expression_in_sgloperation831);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:1: value : ( type1value | type2value | type3value );
    public final void value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:7: ( type1value | type2value | type3value )
            int alt22=3;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:9: type1value
                    {
                    pushFollow(FOLLOW_type1value_in_value839);
                    type1value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:22: type2value
                    {
                    pushFollow(FOLLOW_type2value_in_value843);
                    type2value();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:35: type3value
                    {
                    pushFollow(FOLLOW_type3value_in_value847);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:167:1: type1value : ( contextp | elemcontext ) ( INC | DEC )? ;
    public final void type1value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:2: ( ( contextp | elemcontext ) ( INC | DEC )? )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:4: ( contextp | elemcontext ) ( INC | DEC )?
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:4: ( contextp | elemcontext )
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:5: contextp
                    {
                    pushFollow(FOLLOW_contextp_in_type1value858);
                    contextp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:16: elemcontext
                    {
                    pushFollow(FOLLOW_elemcontext_in_type1value862);
                    elemcontext();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:168:29: ( INC | DEC )?
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:171:1: type2value : ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )* ;
    public final void type2value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:2: ( ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:4: ( ( THIS | SUPER | WORD ) '.' )? ( WORD ) ( acelem )* ( '.' WORD ( acelem )* )*
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:4: ( ( THIS | SUPER | WORD ) '.' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==WORD) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==61) ) {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==WORD) ) {
                        int LA25_5 = input.LA(4);

                        if ( (synpred53_PineDL()) ) {
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:5: ( THIS | SUPER | WORD ) '.'
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

                    match(input,61,FOLLOW_61_in_type2value889); if (state.failed) return ;

                    }
                    break;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:3: ( WORD )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:4: WORD
            {
            match(input,WORD,FOLLOW_WORD_in_type2value896); if (state.failed) return ;

            }

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:10: ( acelem )*
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
            	    pushFollow(FOLLOW_acelem_in_type2value899);
            	    acelem();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:18: ( '.' WORD ( acelem )* )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==61) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:19: '.' WORD ( acelem )*
            	    {
            	    match(input,61,FOLLOW_61_in_type2value903); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_type2value905); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:173:28: ( acelem )*
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
            	    	    pushFollow(FOLLOW_acelem_in_type2value907);
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:1: acelem : ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) ) ;
    public final void acelem() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:8: ( ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) ) )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:10: ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) )
            {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:10: ( ( LARRAY expression RARRAY ) | ( LPAREN ( expression ( ',' expression )* )? RPAREN ) )
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
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:11: ( LARRAY expression RARRAY )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:11: ( LARRAY expression RARRAY )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:12: LARRAY expression RARRAY
                    {
                    match(input,LARRAY,FOLLOW_LARRAY_in_acelem920); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_acelem922);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,RARRAY,FOLLOW_RARRAY_in_acelem924); if (state.failed) return ;

                    }


                    }
                    break;
                case 2 :
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:40: ( LPAREN ( expression ( ',' expression )* )? RPAREN )
                    {
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:40: ( LPAREN ( expression ( ',' expression )* )? RPAREN )
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:41: LPAREN ( expression ( ',' expression )* )? RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_acelem930); if (state.failed) return ;
                    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:48: ( expression ( ',' expression )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==LPAREN||LA30_0==WORD||(LA30_0>=THIS && LA30_0<=INTEGER)) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:49: expression ( ',' expression )*
                            {
                            pushFollow(FOLLOW_expression_in_acelem933);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;
                            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:60: ( ',' expression )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==54) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:175:61: ',' expression
                            	    {
                            	    match(input,54,FOLLOW_54_in_acelem936); if (state.failed) return ;
                            	    pushFollow(FOLLOW_expression_in_acelem938);
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

                    match(input,RPAREN,FOLLOW_RPAREN_in_acelem945); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:177:1: type3value : ( NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER );
    public final void type3value() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:178:2: ( NULL | BOOLEAN | STRING | CHAR | FLOAT | DOUBLE | INTEGER )
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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:180:1: elemcontext : ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+ ;
    public final void elemcontext() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:2: ( ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+ )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:4: ( THIS | SUPER ) ( '.' WORD ( LARRAY expression RARRAY )* )+
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

            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:17: ( '.' WORD ( LARRAY expression RARRAY )* )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==61) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:18: '.' WORD ( LARRAY expression RARRAY )*
            	    {
            	    match(input,61,FOLLOW_61_in_elemcontext997); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_elemcontext999); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:27: ( LARRAY expression RARRAY )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==LARRAY) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:181:28: LARRAY expression RARRAY
            	    	    {
            	    	    match(input,LARRAY,FOLLOW_LARRAY_in_elemcontext1002); if (state.failed) return ;
            	    	    pushFollow(FOLLOW_expression_in_elemcontext1004);
            	    	    expression();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    match(input,RARRAY,FOLLOW_RARRAY_in_elemcontext1006); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:1: contextp : WORD ( '.' WORD ( LARRAY expression RARRAY )* )+ ;
    public final void contextp() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:9: ( WORD ( '.' WORD ( LARRAY expression RARRAY )* )+ )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:11: WORD ( '.' WORD ( LARRAY expression RARRAY )* )+
            {
            match(input,WORD,FOLLOW_WORD_in_contextp1019); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:16: ( '.' WORD ( LARRAY expression RARRAY )* )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==61) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:17: '.' WORD ( LARRAY expression RARRAY )*
            	    {
            	    match(input,61,FOLLOW_61_in_contextp1022); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_contextp1024); if (state.failed) return ;
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:26: ( LARRAY expression RARRAY )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==LARRAY) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:183:27: LARRAY expression RARRAY
            	    	    {
            	    	    match(input,LARRAY,FOLLOW_LARRAY_in_contextp1027); if (state.failed) return ;
            	    	    pushFollow(FOLLOW_expression_in_contextp1029);
            	    	    expression();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    match(input,RARRAY,FOLLOW_RARRAY_in_contextp1031); if (state.failed) return ;

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
    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:185:1: context : WORD ( '.' WORD )* ;
    public final void context() throws RecognitionException {
        try {
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:185:9: ( WORD ( '.' WORD )* )
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:185:11: WORD ( '.' WORD )*
            {
            match(input,WORD,FOLLOW_WORD_in_context1044); if (state.failed) return ;
            // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:185:16: ( '.' WORD )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==61) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:185:17: '.' WORD
            	    {
            	    match(input,61,FOLLOW_61_in_context1047); if (state.failed) return ;
            	    match(input,WORD,FOLLOW_WORD_in_context1049); if (state.failed) return ;

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
        return ;
    }
    // $ANTLR end "context"

    // $ANTLR start synpred23_PineDL
    public final void synpred23_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:143:3: ( elsif )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:143:3: elsif
        {
        pushFollow(FOLLOW_elsif_in_synpred23_PineDL638);
        elsif();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_PineDL

    // $ANTLR start synpred24_PineDL
    public final void synpred24_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:144:3: ( elsecase )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:144:3: elsecase
        {
        pushFollow(FOLLOW_elsecase_in_synpred24_PineDL643);
        elsecase();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_PineDL

    // $ANTLR start synpred44_PineDL
    public final void synpred44_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:158:4: ( ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:158:4: ( PLUS | MINUS | MULT | DIV | MOD | BTWAND | BTWOR | BTWXOR | LOGAND | LOGOR | EQ | CEQ | NEQ | BG | BGE | LT | LTE ) expression
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

        pushFollow(FOLLOW_expression_in_synpred44_PineDL812);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_PineDL

    // $ANTLR start synpred46_PineDL
    public final void synpred46_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:9: ( type1value )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:9: type1value
        {
        pushFollow(FOLLOW_type1value_in_synpred46_PineDL839);
        type1value();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_PineDL

    // $ANTLR start synpred47_PineDL
    public final void synpred47_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:22: ( type2value )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:164:22: type2value
        {
        pushFollow(FOLLOW_type2value_in_synpred47_PineDL843);
        type2value();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_PineDL

    // $ANTLR start synpred53_PineDL
    public final void synpred53_PineDL_fragment() throws RecognitionException {   
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:5: ( ( THIS | SUPER | WORD ) '.' )
        // /home/luis/NetBeansProjects/Sabre/Trunk/PineDL/src/org/gcreator/pinedl/PineDL.g:172:5: ( THIS | SUPER | WORD ) '.'
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

        match(input,61,FOLLOW_61_in_synpred53_PineDL889); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_PineDL

    // Delegated rules

    public final boolean synpred24_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_PineDL_fragment(); // can never throw exception
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
    public final boolean synpred44_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_PineDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_PineDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\1\uffff\1\5\10\uffff";
    static final String DFA22_minS =
        "\1\41\1\4\1\75\1\uffff\1\41\1\uffff\1\41\2\0\1\uffff";
    static final String DFA22_maxS =
        "\1\53\2\75\1\uffff\1\41\1\uffff\1\41\2\0\1\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\3\1\uffff\1\2\3\uffff\1\1";
    static final String DFA22_specialS =
        "\7\uffff\1\0\1\1\1\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1\1\uffff\2\2\7\3",
            "\11\5\2\uffff\6\5\5\uffff\7\5\25\uffff\1\5\6\uffff\1\4",
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
            return "164:1: value : ( type1value | type2value | type3value );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_PineDL()) ) {s = 9;}

                        else if ( (synpred47_PineDL()) ) {s = 5;}

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_PineDL()) ) {s = 9;}

                        else if ( (synpred47_PineDL()) ) {s = 5;}

                         
                        input.seek(index22_8);
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
 

    public static final BitSet FOLLOW_pkgstmt_in_doc273 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_impstmt_in_doc277 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_clsstmt_in_doc282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_pkgstmt290 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_pkgstmt292 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_pkgstmt294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_impstmt301 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_impstmt303 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_impstmt305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_clsstmt313 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_clsstmt315 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DBLDOT_in_clsstmt318 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_context_in_clsstmt320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_clsstmt325 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_classcontent_in_clsstmt330 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_clsstmt334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_classcontent345 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_method_in_element355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_element357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructor_in_element359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_field367 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_52_in_field369 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_field372 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_field374 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_field376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_method384 = new BitSet(new long[]{0x0010000200000000L});
    public static final BitSet FOLLOW_52_in_method386 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_method389 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_method391 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_method393 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_argument_in_method396 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_method399 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_argument_in_method401 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_method407 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_method411 = new BitSet(new long[]{0x1280001A00104000L});
    public static final BitSet FOLLOW_code_in_method416 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_method420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVACY_in_constructor429 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_THIS_in_constructor431 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_constructor433 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_argument_in_constructor436 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_constructor439 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_argument_in_constructor441 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_constructor447 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_DBLDOT_in_constructor450 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_set_in_constructor452 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_constructor458 = new BitSet(new long[]{0x0000000200000400L});
    public static final BitSet FOLLOW_WORD_in_constructor461 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_constructor464 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_constructor466 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_constructor472 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_constructor479 = new BitSet(new long[]{0x1280001A00104000L});
    public static final BitSet FOLLOW_code_in_constructor484 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_constructor488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_argument497 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_argument499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codel_in_code507 = new BitSet(new long[]{0x1280001A00100002L});
    public static final BitSet FOLLOW_trycatch_in_codel516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_in_codel522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifcase_in_codel528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whilecase_in_codel534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_codel541 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_codel543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STMTCUT_in_codel550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_assign566 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_assign568 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_EQ_in_assign571 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_assign573 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_WORD_in_assign581 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_assign583 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_assign585 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STMTCUT_in_assign589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_trycatch598 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_trycatch600 = new BitSet(new long[]{0x1280001A00104000L});
    public static final BitSet FOLLOW_code_in_trycatch602 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_trycatch604 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_trycatch606 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_trycatch608 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_argument_in_trycatch610 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_trycatch612 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_BBLOCK_in_trycatch614 = new BitSet(new long[]{0x1280001A00104000L});
    public static final BitSet FOLLOW_code_in_trycatch616 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_trycatch618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ifcase626 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_ifcase628 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_ifcase630 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_ifcase632 = new BitSet(new long[]{0x1280001A00102000L});
    public static final BitSet FOLLOW_situation_in_ifcase634 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_elsif_in_ifcase638 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_elsecase_in_ifcase643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_elsif652 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_elsif654 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_elsif656 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_elsif658 = new BitSet(new long[]{0x1280001A00102000L});
    public static final BitSet FOLLOW_situation_in_elsif660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_elsecase667 = new BitSet(new long[]{0x1280001A00102000L});
    public static final BitSet FOLLOW_situation_in_elsecase669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_whilecase678 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_whilecase680 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_whilecase682 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_whilecase684 = new BitSet(new long[]{0x1280001A00102000L});
    public static final BitSet FOLLOW_situation_in_whilecase686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codel_in_situation695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BBLOCK_in_situation700 = new BitSet(new long[]{0x1280001A00104000L});
    public static final BitSet FOLLOW_code_in_situation702 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EBLOCK_in_situation704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_expression715 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_LPAREN_in_expression720 = new BitSet(new long[]{0x00000FFA00000000L});
    public static final BitSet FOLLOW_value_in_expression722 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_expression724 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_LPAREN_in_expression730 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_sgloperation_in_expression732 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_expression734 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_set_in_expression742 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_expression812 = new BitSet(new long[]{0x00000001FC0F81F2L});
    public static final BitSet FOLLOW_set_in_sgloperation823 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_sgloperation831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type1value_in_value839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_value843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type3value_in_value847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_contextp_in_type1value858 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_elemcontext_in_type1value862 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_type1value865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type2value881 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_type2value889 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_type2value896 = new BitSet(new long[]{0x2000000000000A02L});
    public static final BitSet FOLLOW_acelem_in_type2value899 = new BitSet(new long[]{0x2000000000000A02L});
    public static final BitSet FOLLOW_61_in_type2value903 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_type2value905 = new BitSet(new long[]{0x2000000000000A00L});
    public static final BitSet FOLLOW_acelem_in_type2value907 = new BitSet(new long[]{0x2000000000000A02L});
    public static final BitSet FOLLOW_LARRAY_in_acelem920 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_acelem922 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_acelem924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_acelem930 = new BitSet(new long[]{0x00000FFA00000600L});
    public static final BitSet FOLLOW_expression_in_acelem933 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_54_in_acelem936 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_acelem938 = new BitSet(new long[]{0x0040000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_acelem945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type3value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_elemcontext990 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_elemcontext997 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_elemcontext999 = new BitSet(new long[]{0x2000000000000802L});
    public static final BitSet FOLLOW_LARRAY_in_elemcontext1002 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_elemcontext1004 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_elemcontext1006 = new BitSet(new long[]{0x2000000000000802L});
    public static final BitSet FOLLOW_WORD_in_contextp1019 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_contextp1022 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_contextp1024 = new BitSet(new long[]{0x2000000000000802L});
    public static final BitSet FOLLOW_LARRAY_in_contextp1027 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_contextp1029 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RARRAY_in_contextp1031 = new BitSet(new long[]{0x2000000000000802L});
    public static final BitSet FOLLOW_WORD_in_context1044 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_context1047 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_WORD_in_context1049 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_elsif_in_synpred23_PineDL638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elsecase_in_synpred24_PineDL643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred44_PineDL742 = new BitSet(new long[]{0x00000FFA00000200L});
    public static final BitSet FOLLOW_expression_in_synpred44_PineDL812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type1value_in_synpred46_PineDL839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type2value_in_synpred47_PineDL843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred53_PineDL881 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_synpred53_PineDL889 = new BitSet(new long[]{0x0000000000000002L});

}