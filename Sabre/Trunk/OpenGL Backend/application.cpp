#include "pineapple.h"
#include <stdlib.h>
#include "SDL.h"

int* _argc;
char*** _argv;
bool _initialized = false;
bool _running = true;
int _preferred_fps = 60;

void pineapple::std::Application::initialize(int* argc, char*** argv)
{
    if(_initialized)
        throw string("Already initialized");
    
    _argc = argc;
    _argv = argv;
    
    if(SDL_Init(SDL_INIT_VIDEO)){
        printf("Unable to initialize SDL: %s\n", SDL_GetError());
        Application::kill(1);
    }
    atexit(SDL_Quit);
    
    _initialized = true;
}

int pineapple::std::Application::getArgumentCount()
{
    return (*_argc);
}

string pineapple::std::Application::getArgumentAt(int index)
{
    if(index>=getArgumentCount())
        return string("");
    char** argv = (*_argv);
    char* argbeg = argv[index];
    return string(argbeg);
}

bool pineapple::std::Application::isRunning()
{
    return _running;
}

void pineapple::std::Application::requestExit()
{
    _running = false;
}

void pineapple::std::Application::kill(int errorcode)
{
    exit(errorcode);
}

int pineapple::std::Application::getPreferredSpeed()
{
    return _preferred_fps;
}

void pineapple::std::Application::setPreferredSpeed(int fps)
{
    _preferred_fps = fps;
}
