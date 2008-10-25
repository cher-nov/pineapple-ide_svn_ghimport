/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>

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

#ifndef _VIEW_H
#define	_VIEW_H

#include "pineapple.h"

class pineapple::objects::View
{
    private:
        int viewport_x = 0;
        int viewport_y = 0;
        int viewport_width = 0; //If>0, then absolute value
                                //If=0, then screen width
                                //If<0, then screen width - viewport_width
        int viewport_height = 0; //If>0, then absolute value
                                //If=0, then screen height
                                //If<0, then screen height - viewport_height
    public:
        View();
        int getViewportX();
        int getViewportY();
        int getViewportWidth();
        int getViewportHeight();
        void setViewportX(int x);
        void setViewportY(int y);
        void setViewportWidth(int width);
        void setViewportHeight(int height);
        
        void GLSetup();
};

#endif	/* _VIEW_H */

