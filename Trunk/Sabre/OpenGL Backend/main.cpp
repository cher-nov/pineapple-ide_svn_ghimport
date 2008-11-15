#include "sdlengine.h"
#include <iostream>

using namespace SDLEngine;

class TestActor : public Actor
{
public:
    TestActor(int x, int y, Texture* t)
    {
        this->x = x;
        this->y = y;
        this->t = t;
    }

    void onKeyDown(SDLKey key)
    {
        if (key == SDLK_UP)
        {
            speed = 4;
        }
    }

    void onKeyUp(SDLKey key)
    {
        if (key == SDLK_UP)
        {
            speed = 0;
        }
    }
};

class TestScene : public Scene
{
public:
    TestScene()
    {
        addActor(new TestActor(50, 50, new Texture("test.png")));
    }

    ~TestScene()
    {
        for (unsigned int i = 0; i < actors.size(); i++)
        {
            delete actors[i];
        }
        for (unsigned int i = 0; i < views.size(); i++)
        {
            delete views[i];
        }
    }
};

int main(int argc, char** argv)
{
    Application::init();
    Window::setSize(640, 480);
    Window::setCaption("Hello");
    Window::setFullscreen(true);

    Scene* s = new TestScene();
    Application::setScene(s);

    Window::run();

    return 0;
}
