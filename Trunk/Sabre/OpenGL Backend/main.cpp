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
        gravity = 1;
        gravity_direction = 270;
    }
    void create() {}
    void destroy() {}
};

class TestScene : public Scene
{
public:
    void create()
    {
        actors.push_back(new TestActor(50, 50, new Texture("test.png")));
    }
    void destroy() {}
};

int main(int argc, char** argv)
{
    try {

        Application::init();
        Window::init(640, 480, "Test");

        Scene* s = new TestScene;
        Application::setScene(s);

        Window::run();

    } catch (char *error) {
        std::cerr << "Error: " << error;
    }

    return 0;
}
