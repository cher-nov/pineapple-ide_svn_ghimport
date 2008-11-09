#ifndef APPLICATION_H
#define APPLICATION_H

#include "sdlengine.h"

class SDLEngine::Application
{
    static int speed;
    static bool running;
    static Scene* currentScene;

    static bool initGL();
public:
	static void init();
	static void exit();
	static bool isRunning();
	static int getSpeed();

	static void setScene(Scene* scene);
	static Scene* getScene();
};

#endif
