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


package org.gcreator.project.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A implementation of {@link BasicFile} for using
 * {@link java.io.File java.io.File}.
 * 
 * @author Serge Humphrey
 */
public class FileFile implements BasicFile {
    
    protected File file;
    
    /**
     * Creates a new {@link FileFile} with a given {@link java.io.File}.
     * 
     * @param file The {@linl java.io.File} to use.
     */
    public FileFile(File file) {
        this.file = file;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return file.getName();
    }
    
    /**
     * {@inheritDoc}
     * 
     * <br/><br/>
     * 
     * <strong>Note:</strong><br/>
     * This may return 0L on some filesystems.
     * 
     * @see java.io.File#length() 
     */
    public long getLength() {
        return file.length();
    }
    
    /**
     * {@inheritDoc }
     * @see java.io.File#delete() 
     */
    public boolean delete() {
        if (file.isDirectory()) {
            recursiveDelete(file);
        }
        
        return file.delete();
    }
    
    private void recursiveDelete(File f) {
        if (f.exists()) {
            return;
        }
        if (!f.isDirectory()) {
            f.delete();
        } else {
            for (File sub : f.listFiles()) {
                recursiveDelete(f);
            }
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
    
    /**
     * {@inheritDoc}
     */
    public OutputStream getOutputStream() throws IOException {
        return new FileOutputStream(file);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isDirectory() {
        return file.isDirectory();
    }

    /**
     * {@inheritDoc}
     */
    public BasicFile[] list() {
        File[] ffiles = file.listFiles();
        if (ffiles == null) {
            return null;
        }
        
        FileFile[] files = new FileFile[ffiles.length];
        int i = 0;
        for (File f : ffiles) {
            files[i++] = new FileFile(f);
        }
        return files;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean exists() {
        return file.exists();
    }
    
    /**
     * {@inheritDoc}
     */
    public void rename(String newName) throws IOException{
        if(!file.renameTo(new File(newName))){
            throw new IOException("Renaming failed");
        }
    }
}
