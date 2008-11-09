#include "sdlengine.h"
#include <iostream>

using namespace SDLEngine;

class TestActor : public Actor
{
    void create() {}
    void destroy() {}
    void update() {}
    void draw() {}
};

class TestScene : public Scene
{
    Actor* a;
public:
    void create()
    {
        a = new TestActor;
    }
    void destroy()
    {
        delete a;
    }
    void update() {}
    void draw() {}
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
