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

package org.gcreator.pinedl.statements;

import java.util.Vector;
import org.gcreator.pinedl.Leaf;
import org.gcreator.pinedl.Type;

/**
 * Represents a function call
 * @author Luís Reis
 */
public class NewCall extends Expression{
    public Type type = null;
    public Vector<Expression> arguments = new Vector<Expression>();
    
    public NewCall(){}
    public NewCall(Type type){this.type = type;}
    
    @Override
    public Leaf optimize(){
        Vector v = (Vector) arguments.clone();
        arguments.clear();
        for(Object leaf : v){
            if(leaf==null){ continue; }
            arguments.add((Expression) ((Expression) leaf).optimize());
        }
        return this;
    }
    
    @Override
    public String toString(){
        String s = "new " + type + "(";
        
        boolean first = true;
        for(Expression e : arguments){
            if(!first){
                s += ", ";
            }
            
            s += e.toString();
            
            first = false;
        }
        
        s += ")";
        return s;
    }
}
