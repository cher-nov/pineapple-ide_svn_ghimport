#include "application.h"
#include "SDL/SDL.h"
#include "SDL/SDL_opengl.h"

using namespace SDLEngine;

int Application::speed = 60;
bool Application::running = true;
Scene* Application::currentScene = NULL;

void Application::init()
{
	if (SDL_Init(SDL_INIT_VIDEO) < 0)
		throw "Could not initialize video";

    running = true;
}

void Application::exit()
{
    running = false;
}

bool Application::isRunning()
{
    return running;
}

int Application::getSpeed()
{
    return speed;
}

void Application::setScene(Scene* scene)
{
    if (currentScene != NULL)
        delete currentScene;

    currentScene = scene;
}

Scene* Application::getScene()
{
    return currentScene;
}
