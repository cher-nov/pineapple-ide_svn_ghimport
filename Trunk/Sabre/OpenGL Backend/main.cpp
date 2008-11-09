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
    }
    void create() {}
    void destroy() {}
    void update() {}
    void draw()
    {
        t->draw(x, y);
    }
};

class TestScene : public Scene
{
public:
    void create()
    {
        actors.push_back(new TestActor(50, 50, new Texture("test.png")));
    }
    void destroy() {}
    void update() {}
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
