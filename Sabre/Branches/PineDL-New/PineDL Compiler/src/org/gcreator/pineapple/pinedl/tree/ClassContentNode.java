/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>

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

package org.gcreator.pineapple.pinedl.tree;

import java.util.List;
import java.util.Vector;
import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author luis
 */
public class ClassContentNode extends Node{
    public List<ConstructorNode> constructors;
    public List<MethodNode> methods;
    public List<FieldNode> fields;

    public ClassContentNode(Token t){
        super(t);
        constructors = new Vector<ConstructorNode>();
        methods = new Vector<MethodNode>();
        fields = new Vector<FieldNode>();
    }

    public void addConstructor(ConstructorNode constructor){
        constructors.add(constructor);
    }

    public void addMethod(MethodNode method){
        methods.add(method);
    }
    
    public void addField(FieldNode field) {
        fields.add(field);
    }
    
    @Override
    public String toString(){
        String s = "{\n";
        
        s += "Constructors:";
        for(ConstructorNode node : constructors){
            s += "\n\t" + node.toString();
        }
        
        s += "\nMethods:";
        for(MethodNode node : methods){
            s += "\n\t" + node.toString();
        }
        
        s += "\nFields:";
        for(FieldNode node : fields){
            s += "\n\t" + node.toString();
        }
        
        return s + "\n}";
    }
}
