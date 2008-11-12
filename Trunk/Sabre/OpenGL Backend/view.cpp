#include "view.h"
#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"

using namespace SDLEngine;

View::View()
{
    px = 0;
    py = 0;
    pwidth = Window::getWidth();
    pheight = Window::getHeight();

    sx = 0;
    sy = 0;
    swidth = Window::getWidth();
    sheight = Window::getHeight();
}

void View::set()
{
    glViewport(px, py, pwidth, pheight);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(sx, sx + swidth, sy + sheight, sy, -1.0f, 1.0f);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}
