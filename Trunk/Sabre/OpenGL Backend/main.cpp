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
        this->angle = 0;
        this->t = t;
        gravity = 0;
        gravity_direction = 270;
    }
};

class TestScene : public Scene
{
public:
    TestScene()
    {
        addActor(new TestActor(50, 50, new Texture("test.png")));
        addView(new View());
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
    try {

        Application::init();
        Window::init(640, 480, "Test", 32, false, true);

        Scene* s = new TestScene();
        Application::setScene(s);

        Window::run();

    } catch (char *error) {
        std::cerr << "Error: " << error;
    }

    return 0;
}
