#include "pineapple.h"

void pineapple::objects::DrawingPrimitives::drawRectangle(int x, int y, int width,
        int height, Color* c)
{
    
    glTranslatef(x, y, 0);
    
    glColor4f(c->getRed(), c->getGreen(), c->getBlue(), c->getAlpha());
    glBegin(GL_QUADS);
        glVertex3f(0, 0, 0);

        glVertex3f(0, height, 0);

        glVertex3f(width, height, 0);

        glVertex3f(width, 0, 0);
    glEnd();
    glLoadIdentity();
}

void pineapple::objects::DrawingPrimitives::drawRectangleGradient(int x, int y, int width,
        int height, Color* c1, Color* c2, Color* c3, Color* c4)
{
    
    glTranslatef(x, y, 0);
    
    glBegin(GL_QUADS);
        glColor4f(c1->getRed(), c1->getGreen(), c1->getBlue(), c1->getAlpha());
        glVertex3f(0, 0, 0);

        glColor4f(c2->getRed(), c2->getGreen(), c2->getBlue(), c2->getAlpha());
        glVertex3f(0, height, 0);

        glColor4f(c3->getRed(), c3->getGreen(), c3->getBlue(), c3->getAlpha());
        glVertex3f(width, height, 0);

        glColor4f(c4->getRed(), c4->getGreen(), c4->getBlue(), c4->getAlpha());
        glVertex3f(width, 0, 0);
    glEnd();
    glLoadIdentity();
}
