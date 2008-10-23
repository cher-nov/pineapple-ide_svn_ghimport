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

import java.io.IOException;
import java.io.OutputStream;

/**
 * This signal receiver outputs a PDI interface.
 * @author Luís Reis
 */
public class InterfaceSignalReceiver extends SignalReceiver{
    private OutputStream stream;
    
    public InterfaceSignalReceiver(OutputStream stream) throws IOException{
        stream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
        this.stream = stream;
    }
    
    public OutputStream getStream(){
        return stream;
    }
    
    @Override
    public void sendPackageSignal(String pkg){
        System.out.println("pkg="+pkg.toString());
    }
    
    @Override
    public void sendImportSignal(String cls){
        System.out.println("import="+cls.toString());
    }
    
    @Override
    public void sendClassDeclaration(String cls, String bcls){
        System.out.println("cls="+cls+"; bcls="+bcls);
    }
    
    @Override
    public void sendFieldSignal(String privacy, boolean isStatic, boolean isConst,
            String type, String name){
            
        System.out.println("privacy="+privacy+"; isStatic="+isStatic+"; isConst="+
                isConst + "; type="+type+"; name="+name);
    }
}
