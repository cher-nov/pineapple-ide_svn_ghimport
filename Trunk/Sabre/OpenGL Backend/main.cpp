#include "pineapple.h"
#include <iostream>

using namespace Pineapple;

class Ship : public Actor
{
public:
    Ship(int x, int y)
    {
        this->x = x;
        this->y = y;
        this->t = new Texture("test.png", 16, 16);

        this->friction = 1;
    }

    ~Ship()
    {
        delete this->t;
    }

    void update()
    {
        if (Keyboard::isKeyDown(KeyUp))
            speed += 2;
        if (Keyboard::isKeyDown(KeyDown))
            speed -= 2;

        speed = sign(speed) * min(abs(speed), 8.0f);

        if (Keyboard::isKeyDown(KeyLeft))
            direction += 4;
        if (Keyboard::isKeyDown(KeyRight))
            direction -= 4;

        angle = direction;

        if (x > Application::getScene()->getWidth() + t->getOriginX())
            x = -(t->getOriginX());
        if (x < -(t->getOriginX()))
            x = Application::getScene()->getWidth() + t->getOriginX();

        if (y > Application::getScene()->getHeight() + t->getOriginY())
            y = -(t->getOriginY());
        if (y < -(t->getOriginY()))
            y = Application::getScene()->getHeight() + t->getOriginY();
    }
};

class TestScene : public Scene
{
public:
    TestScene()
    {
        addActor(new Ship(50, 50));
        width = 640;
        height = 480;
    }
};

int main(int argc, char* argv[])
{
    Application::init();
    Window::setSize(640, 480);
    Window::setCaption("Hello");

    Scene* s = new TestScene();
    Application::setScene(s);

    Window::run();

    return 0;
}
