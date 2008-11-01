/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

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

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import org.gcreator.xml.Node;
import org.gcreator.xml.SAXImporter;
import org.xml.sax.SAXException;

/**
 * A PineDL interface reader
 * @author Luís Reis
 */
public class PDI {
    public String pkg = "";
    public String clsname = "";
    public String bclass = "";
    public Vector<String> imports = new Vector<String>();
    public Vector<Field> fields = new Vector<Field>();
    
    public PDI(){
        
    }
    
    public PDI(File f) throws IOException, SAXException{
        SAXImporter imp = new SAXImporter(f);
        Node n = imp.getDocumentRoot();
        if(!n.getName().equals("pdi"))
            throw new SAXException("Invalid PDI file");
        double d = n.getAttributeValueAsDouble("version");
        if(d==Double.NaN)
            throw new SAXException("Unrecognized PDI version");
        clsname = n.getAttributeValue("name");
        if(clsname==null)
            throw new SAXException("Invalid format");
        bclass = n.getAttributeValue("extends");
        boolean hasPkg = false;
        for(Node node : n.getChildren()){
            if(node.getName().equals("package")){
                if(hasPkg)
                    throw new SAXException(
                            "Invalid format: Duplicated package statements.");
                pkg = node.getContent();
            }
            else if(node.getName().equals("import")){
                imports.add(node.getContent());
            }
        }
    }
}
