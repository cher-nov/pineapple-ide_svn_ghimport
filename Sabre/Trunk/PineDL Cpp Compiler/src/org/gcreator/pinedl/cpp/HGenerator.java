/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge_1994@hotmail.com>

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

package org.gcreator.pinedl.cpp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.gcreator.pinedl.AccessControlKeyword;
import org.gcreator.pinedl.Argument;
import org.gcreator.pinedl.Constructor;
import org.gcreator.pinedl.Function;
import org.gcreator.pinedl.NativeType;
import org.gcreator.pinedl.PineClass;
import org.gcreator.pinedl.PineDLLexer;
import org.gcreator.pinedl.PineDLParser;
import org.gcreator.pinedl.Type;
import org.gcreator.pinedl.TypeCategory;
import org.gcreator.pinedl.Variable;

/**
 * Creates a H file from a PineDL context
 * @author Luís Reis
 */
public class HGenerator {
    OutputStream out = null;
    InputStream in = null;
    GameCompiler cmp = null;
    PineClass cls = null;
    String fname = "";
    private boolean successful = true;
    Vector<String> context = null;
    
    public HGenerator(InputStream in, OutputStream out, GameCompiler cmp, String fname,
            Vector<String> context){
        try{
            this.in = in;
            this.out = out;
            this.cmp = cmp;
            this.context = context;
            parse();
            this.fname = cls.clsName;
            if(!this.fname.equals(fname)){
                throw new Exception("Invalid class name!");
            }
            write();
        }
        catch(Exception e){
            e.printStackTrace();
            throwError("Parsing exception: " + e.getMessage());
        }
    }
    
    public boolean wasSuccessful(){
        return successful;
    }
    
    private void parse() throws Exception{
        PineDLLexer lexer = new PineDLLexer(new ANTLRInputStream(in));
        CommonTokenStream ts = new CommonTokenStream(lexer);
        PineDLParser parser = new PineDLParser(ts);
        cls = parser.doc();
    }
    
    private void write() throws Exception{
        String htitle = getHeaderTitle(fname);
        writeLine("#ifndef " + htitle);
        writeLine("#define " + htitle);
        
        writeLine("#include \"pineapple.h\"");
        writeImports();
        
        for(String pkg : cls.packageName){
            writeLine("package " + detokenize(pkg) + "{");
        }
        
        writeClass();
        
        for(String pkg : cls.packageName){
            writeLine("}");
        }
        
        writeLine("#endif");
        writeLine();
    }
    
    private void writeImports() throws Exception{        
        Vector<String> s = new Vector<String>();
        for(Type t : cls.importStmt){
            if(s.contains(t.type[t.type.length-1])){
                throwError("Found two import statements referencing same class name.");
                return;
            }
            if(context.contains(t.type[t.type.length-1])){
                throwWarning("Found import statement reference class name of same package");
                return;
            }
            s.add(t.type[t.type.length-1]);
            writeLine("#include \"" + t.type[t.type.length-1] + '"');
        }
    }
    
    private void writeClass() throws Exception{
        String s = "class ";
        s += detokenize(cls.clsName);
        if(cls.superClass!=null){
            s += " : public " + retrieveType(cls.superClass, false);
        }
        s += "{";
        writeLine(s);
        
        writeFields();
        writeMethods();
        writeConstructors();
        
        writeLine("}");
    }
    
    private void writeFields() throws Exception{
        for(Variable field : cls.variables){
            writeLine(accessToString(field.access) +
                    (field.isStatic?": static ":": ") +
                    retrieveType(field.type, true) + ' ' +
                    detokenize(field.name) + ";");
        }
    }
    
    private String retrieveType(Type t, boolean reference){
        if(t.typeCategory==TypeCategory.NATIVE){
            return typeToString(t, reference);
        }
        if(t.typeCategory==TypeCategory.ARRAY){
            return retrieveType(t.arrayType, reference) + "*";
        }
        if(t.type.length!=1){
            return typeToString(t, reference);
        }
        for(String s : context){
            if(s.equals(t.type[t.type.length-1])){
                return s;
            }
        }
        for(Type type : cls.importStmt){
            if(type.type[type.type.length-1].equals(t.type[0])){
                return typeToString(type, reference);
            }
        }
        throwError("Unknown type " + t.toString());
        return "---";
    }
    
    private void writeMethods() throws Exception{
        for(Function method : cls.functions){
            String s = accessToString(method.access) +
                    (method.isStatic?": static ":": ") +
                    retrieveType(method.returnType, true) + ' ' +
                    detokenize(method.name) + '(';
            
            boolean isFirst = true;
            for(Argument a : method.arguments){
                if(!isFirst){
                    s += ", ";
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                isFirst = false;
            }
            
            s += ");";
            writeLine(s);
        }
    }
    
    private void writeConstructors() throws Exception{
        for(Constructor method : cls.constructors){
            String s = accessToString(method.access) + ": " +
                    detokenize(cls.clsName) + '(';
            
            boolean isFirst = true;
            for(Argument a : method.arguments){
                if(!isFirst){
                    s += ", ";
                }
                s += retrieveType(a.type, true);
                s += ' ';
                s += detokenize(a.name);
                isFirst = false;
            }
            
            s += ");";
            writeLine(s);
        }
    }
    
    private String accessToString(AccessControlKeyword k){
        if(k==AccessControlKeyword.PRIVATE){
            return "private";
        }
        if(k==AccessControlKeyword.PROTECTED){
            return "protected";
        }
        return "public";
    }
    
    private String typeToString(Type t, boolean reference){
        if(t.typeCategory==TypeCategory.ARRAY){
            return typeToString(t.arrayType, true) + "*";
        }
        if(t.typeCategory==TypeCategory.NATIVE){
            if(t.nativeType==NativeType.BOOL){
                return "bool";
            }
            if(t.nativeType==NativeType.CHAR){
                return "signed char";
            }
            if(t.nativeType==NativeType.DOUBLE){
                return "double";
            }
            if(t.nativeType==NativeType.FLOAT){
                return "float";
            }
            if(t.nativeType==NativeType.INT){
                return "int";
            }
            if(t.nativeType==NativeType.STRING){
                return "std::string";
            }
            if(t.nativeType==NativeType.UCHAR){
                return "unsigned char";
            }
            if(t.nativeType==NativeType.UDOUBLE){
                return "unsigned double";
            }
            if(t.nativeType==NativeType.UFLOAT){
                return "unsigned float";
            }
            if(t.nativeType==NativeType.UINT){
                return "unsigned int";
            }
        }
        String x = t.type[0];
        for(int i = 1; i < t.type.length; i++){
            x += "::";
            x += t.type[i];
        }
        if(reference){
            x += '*';
        }
        return x;
    }
    
    private String detokenize(String id){
        if(id.startsWith("_")){
            return "_P_" + id;
        }
        /*
         * The following aren't PineDL keywords, so the user
         * has the right to use them
         */
        if(id.equals("do")){
            throwWarning("'do' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_do";
        }
        if(id.equals("unsigned")){
            return "_K_unsigned";
        }
        if(id.equals("signed")){
            return "_K_signed";
        }
        if(id.equals("switch")){
            throwWarning("'switch' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_switch";
        }
        if(id.equals("case")){
            throwWarning("'case' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_case";
        }
        if(id.equals("default")){
            throwWarning("'default' is not a PineDL keyword, but may become in the future. Avoid using it");
            return "_K_default";
        }
        if(id.equals("NULL")){
            return "_K_NULL";
        }
        if(id.equals("FILE")){
            return "_K_FILE";
        }
        if(id.startsWith("SDL")){
            return "_K_" + id;
        }
        if(id.equals("default")){
            return "_K_default";
        }
        if(id.startsWith("GL")||id.startsWith("gl")){
            return "_K_" + id;
        }
        if(id.equals("lambda")){
            throwWarning("'lambda' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if(id.equals("repeat")){
            throwWarning("'repeat' is not a PineDL keyword, but may become in the future. Avoid using it");
            return id;
        }
        if(id.equals("std")){
            return "_K_" + id;
        }
        if(id.equals("virtual")){
            return "_K_" + id;
        }
        if(id.equals("using")){
            return "_K_" + id;
        }
        if(id.equals("namespace")){
            return "_K_" + id;
        }
        
        return id;
    }
    
    private String getHeaderTitle(String name){
        String s = "__";
        
        s += name.toUpperCase();
        
        s += "_H__";
        return s;
    }
    
    private void writeLine() throws IOException{
        out.write('\n');
    }
    
    private void writeLine(String line) throws IOException{
        out.write(line.getBytes());
        out.write('\n');
    }
    
    private void throwWarning(String warning){
        String message = "[WARNING] ";
        message += warning;
        
        cmp.compFrame.writeLine(message);
    }
    
    private void throwError(String error){
        String message = "[ERROR] ";
        message += error;
        successful = false;
        
        cmp.compFrame.writeLine(message);
    }
}
