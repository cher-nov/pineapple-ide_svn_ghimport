#include "pineapple.h"

pineapple::objects::Color::Color(int r, int g, int b)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = 1.0f;
}

pineapple::objects::Color::Color(int r, int g, int b, float a)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = a;
}

pineapple::objects::Color::Color(int r, int g, int b, int a)
{
    this->r = ((float) r)/255;
    this->g = ((float) g)/255;
    this->b = ((float) b)/255;
    this->a = ((float) a)/255;
}

pineapple::objects::Color::Color(float r, float g, float b)
{
    this->r = r;
    this->g = g;
    this->b = b;
    this->a = 1.0f;
}

pineapple::objects::Color::Color(float r, float g, float b, float a)
{
    this->r = r;
    this->g = g;
    this->b = b;
    this->a = a;
}

float pineapple::objects::Color::getRed()
{
    return r;
}

float pineapple::objects::Color::getGreen()
{
    return g;
}

float pineapple::objects::Color::getBlue()
{
    return b;
}

float pineapple::objects::Color::getAlpha()
{
    return a;
}
