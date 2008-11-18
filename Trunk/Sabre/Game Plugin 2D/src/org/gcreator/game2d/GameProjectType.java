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


package org.gcreator.game2d;

import java.io.File;
import org.gcreator.project.DefaultProject;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectType;
import org.gcreator.project.io.DefaultProjectManager;

/**
 * The {@link ProjectType} for {@link DefaultProject}.
 * 
 * @author Serge Humphrey
 */
public final class GameProjectType implements ProjectType {
    
    /**
     * {@inheritDoc}
     */
    public Project create() {
        return new GameProject();
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "Game2D";
    }
    
    /**
     * {@inheritDoc}
     */
    public String getDescription() {
        return "Based on the default project, this project " +
                "allows you to create very nice 2D games";
    }
    
    /**
     * {@inheritDoc}
     */
    public Project create(File f) {
        return new DefaultProjectManager(f).getProject();
    }
    
    /**
     * {@inheritDoc}
     */
    public String[] getImportFileTypes() {
        return DefaultProjectManager.getImportFileTypes();
    }
    
    /**
     * {@inheritDoc}
     */
    public String[] getExportFileTypes() {
        return DefaultProjectManager.getExportFileTypes();
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean allowsImport(File f) {
        return DefaultProjectManager.allowsImport(f);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean allowsExport(File f) {
        return DefaultProjectManager.allowsExport(f);
    }
    
    /**
     * {@inheritDoc}
     */
    public String[] getProjectFileTypes() {
        return DefaultProjectManager.getProjectFileTypes();
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean allowsProject(File f) {
        return DefaultProjectManager.allowsProject(f);
    }

}
