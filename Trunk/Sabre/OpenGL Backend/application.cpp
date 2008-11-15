#include "application.h"

using namespace Pineapple;

int Application::speed = 60;
bool Application::running = true;
Scene* Application::currentScene = NULL;

void Application::init()
{
	if (SDL_Init(SDL_INIT_VIDEO) < 0)
		throw "Could not initialize SDL";
    atexit(SDL_Quit);

    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    running = true;
}

void Application::setScene(Scene* scene)
{
    if (currentScene != NULL)
        delete currentScene;

    currentScene = scene;
}
