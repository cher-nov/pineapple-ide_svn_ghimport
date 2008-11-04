package org.jedit.syntax;

/*
 * PineDLTokenMarker.java - Java token marker
 * Copyright (C) 2008 Luís Reis
 * Copyright (C) 1999 Slava Pestov
 *
 * You may use and modify this package for any purpose. Redistribution is
 * permitted, in both source and binary form, provided that this notice
 * remains intact in all source distributions of this package.
 */
import java.util.Vector;
import javax.swing.text.Segment;

/**
 * PineDL token marker.
 *
 * @author Slava Pestov, modified by Luís Reis
 */
public class PineDLTokenMarker extends CTokenMarker {

    public PineDLTokenMarker() {
        super(false);
        globalKeywords = new Vector<String>();
        contextKeywords = new Vector<String>();
        initializeGlobalKeywords();
    }

    public void initializeGlobalKeywords() {
        globalKeywords.add("package");
        globalKeywords.add("import");
        globalKeywords.add("class");
        globalKeywords.add("extends");
        globalKeywords.add("public");
        globalKeywords.add("private");
        globalKeywords.add("protected");
        globalKeywords.add("static");
        globalKeywords.add("const");
        globalKeywords.add("if");
        globalKeywords.add("elsif");
        globalKeywords.add("else");
        globalKeywords.add("return");
        globalKeywords.add("try");
        globalKeywords.add("throw");
        globalKeywords.add("catch");
        globalKeywords.add("while");
        globalKeywords.add("break");
        globalKeywords.add("continue");
        globalKeywords.add("int");
        globalKeywords.add("uint");
        globalKeywords.add("float");
        globalKeywords.add("double");
        globalKeywords.add("string");
        globalKeywords.add("void");
        globalKeywords.add("this");
        globalKeywords.add("super");
        globalKeywords.add("null");
        globalKeywords.add("true");
        globalKeywords.add("false");
    }

    @Override
    public KeywordMap getKeywords() {
        KeywordMap keywords = new KeywordMap(false);

        for (String s : globalKeywords) {
            keywords.add(s, Token.KEYWORD1);
        }
        for (String s : contextKeywords) {
            keywords.add(s, Token.KEYWORD2);
        }
        return keywords;
    }    // private members
    private Vector<String> globalKeywords;
    private Vector<String> contextKeywords;
}
