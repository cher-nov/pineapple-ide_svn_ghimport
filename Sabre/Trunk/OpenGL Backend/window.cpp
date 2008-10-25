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

#include "pineapple.h"
#include "SDL.h"
#include "SDL_opengl.h"

int _window_width;
int _window_height;
bool _window_fullscreen;
SDL_Surface *_sdl_screen;
string _window_title;

int pineapple::std::Window::getWidth() {
    return _window_width;
}

int pineapple::std::Window::getHeight() {
    return _window_height;
}

bool pineapple::std::Window::isFullscreen() {
    return _window_fullscreen;
}

void pineapple::std::Window::setSize(int width, int height) {
    _window_width = width;
    _window_height = height;
    updateVideoMode();
}

void pineapple::std::Window::setSize(int width, int height, bool fullscreen) {
    _window_width = width;
    _window_height = height;
    _window_fullscreen = fullscreen;
    updateVideoMode();
}

void pineapple::std::Window::setFullscreen(bool fullscreen) {
    _window_fullscreen = fullscreen;
    updateVideoMode();
}

void pineapple::std::Window::setTitle(string title) {
    _window_title = title;
    SDL_WM_SetCaption(title.c_str(), title.c_str());
}

string pineapple::std::Window::getTitle() {
    return _window_title;
}

void pineapple::std::Window::updateVideoMode() {
    Uint32 flags = SDL_OPENGL;
    if (isFullscreen())
        flags |= SDL_FULLSCREEN;

    SDL_GL_SetAttribute(SDL_GL_DOUBLEBUFFER, 1);
    SDL_GL_SetAttribute(SDL_GL_DEPTH_SIZE, 16);
    SDL_GL_SetAttribute(SDL_GL_RED_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_GREEN_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_BLUE_SIZE, 8);
    SDL_GL_SetAttribute(SDL_GL_ALPHA_SIZE, 8);

    _sdl_screen = SDL_SetVideoMode(getWidth(), getHeight(), 16, flags);
    if (_sdl_screen == NULL) {
        printf("Unable set SDL Video Mode: %s\n", SDL_GetError());
        Application::kill(1);
    }

    glEnable(GL_TEXTURE_2D);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    glShadeModel(GL_SMOOTH);
    glDepthFunc(GL_LEQUAL);
    glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    glViewport(0, 0, getWidth(), getHeight()); //Target
    glClear(GL_COLOR_BUFFER_BIT);
    glMatrixMode(GL_PROJECTION);
    glOrtho(0.0f, getWidth(), getHeight(), 0.0f, -1.0f, 1.0f); //Zoom
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

void pineapple::std::Window::run()
{
    SDL_Event event;
    while(Application::isRunning() && SDL_WaitEvent(&event))
    {
        switch(event.type)
        {
            case SDL_QUIT:
                Application::requestExit(); break;
        }
        redraw();
        SDL_GL_SwapBuffers();
        SDL_Delay(1000/Application::getPreferredSpeed());
    }
}

void pineapple::std::Window::redraw()
{
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
}
