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

import org.gcreator.pineapple.pinedl.Token;

/**
 *
 * @author luis
 */
public class StringConstant extends ConstantNode{
    public String value = "";

    public StringConstant(Token t){
        super(t);
        value = t.text;
    }
    
    @Override
    public String toString(){
        String s = "\"";
        
        for(char c : value.toCharArray()){
            if(c=='\n'){
                s += "\\n";
            }
            else if(c=='\r'){
                s += "\\r";
            }
            else if(c=='\t'){
                s += "\\t";
            }
            else if(c=='\\'){
                s += "\\\\";
            }
            else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='_'||(c>='0'&&c<='9')){
                s += c;
            }
            else{
                s += "\\" + (int) c;
            }
        }
        
        return s + "\"";
    }
}
