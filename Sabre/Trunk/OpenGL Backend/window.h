/* 
 * File:   window.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 15:20
 */

#ifndef _WINDOW_H
#define	_WINDOW_H

#include "pineapple.h"

class pineapple::std::Window
{
    private:
        Window();
        static void updateVideoMode();
    public:
        static int getWidth();
        static int getHeight();
        static bool isFullscreen();
        static void setSize(int width, int height);
        static void setSize(int width, int height, bool fullscreen);
        static void setFullscreen(bool fullscreen);
        static void setTitle(string title);
        static string getTitle();
        static void run();
        static void redraw();
};

#endif	/* _WINDOW_H */

