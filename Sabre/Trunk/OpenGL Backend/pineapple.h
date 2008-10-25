/* 
 * File:   pineapple.h
 * Author: luis
 *
 * Created on 25 de Outubro de 2008, 12:04
 */

#ifndef _PINEAPPLE_H
#define	_PINEAPPLE_H

#include <string>

typedef std::string string;

namespace pineapple
{
    namespace std
    {
        class Application;
        class Window;
    }
    namespace objects
    {
        class Texture;
    }
}

class pineapple::std::Application
{
    private:
        Application(); //Don't construct
    public:
        static void initialize(int* argc, char*** argv);
        static int getArgumentCount();
        static string getArgumentAt(int index);
        static bool isRunning(); //requestExit();
        static void requestExit();
        static void kill(int errorcode);
        static int getPreferredSpeed();
        static void setPreferredSpeed(int fps);
};

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

class pineapple::objects::Texture
{
    private:
        int width;
        int height;
    public:
        Texture(string file);
};

#endif	/* _PINEAPPLE_H */

