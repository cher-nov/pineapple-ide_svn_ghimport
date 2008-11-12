#include "window.h"
#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"

using namespace SDLEngine;

int Window::width = 640;
int Window::height = 640;
char* Window::caption = "";
int Window::bpp = 32;
bool Window::fullscreen = false;
bool Window::resizable = false;

void Window::init(int width, int height, const char* caption, int bpp, bool fullscreen, bool resizable)
{
    Window::width = width;
    Window::height = height;
    Window::bpp = bpp;

    Window::caption = new char[strlen(caption)];
    strcpy(Window::caption, caption);

    Window::fullscreen = fullscreen;
    Window::resizable = resizable;

    update();

	SDL_WM_SetCaption(caption, NULL);

    glEnable(GL_TEXTURE_2D);
    glClearColor(0, 0, 0, 0);
    glColor4f(1, 1, 1, 1);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(0, 640, 480, 0, -1, 1);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();

    if (glGetError() != GL_NO_ERROR)
        throw "Could not initialize OpenGL";
}

void Window::setSize(int width, int height)
{
    Window::width = width;
    Window::height = height;
    update();
}

inline void Window::update()
{
    Uint8 flags = SDL_OPENGL;
    if (Window::fullscreen)
        flags |= SDL_FULLSCREEN;
    if (Window::resizable)
        flags |= SDL_RESIZABLE;

    SDL_SetVideoMode(width, height, bpp, flags);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    glOrtho(0.0f, getWidth(), getHeight(), 0.0f, -1.0f, 1.0f);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

void Window::run()
{
    SDL_Event event;
    Scene *s;

    do {
        while (SDL_PollEvent(&event))
        {
            switch (event.type)
            {
                case SDL_QUIT:
                    Application::exit();
                    break;
                case SDL_VIDEORESIZE:
                    setSize(event.resize.w, event.resize.h);
                    break;
            }
        }

        s = Application::getScene();
        if (s != NULL)
        {
            s->update();
            s->draw();
        }

        SDL_GL_SwapBuffers();
        SDL_Delay(1000 / Application::getSpeed());
    } while (Application::isRunning());
}
