#
# Gererated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=build/Debug/GNU-Linux-x86

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/texture.o \
	${OBJECTDIR}/pineapple.o \
	${OBJECTDIR}/window.o \
	${OBJECTDIR}/application.o

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-lSDL -lGL -lSDL_image

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} dist/Debug/GNU-Linux-x86/opengl_backend

dist/Debug/GNU-Linux-x86/opengl_backend: ${OBJECTFILES}
	${MKDIR} -p dist/Debug/GNU-Linux-x86
	${LINK.cc} -o dist/Debug/GNU-Linux-x86/opengl_backend ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/texture.o: texture.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/texture.o texture.cpp

${OBJECTDIR}/pineapple.o: pineapple.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/pineapple.o pineapple.cpp

${OBJECTDIR}/window.o: window.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/window.o window.cpp

${OBJECTDIR}/application.o: application.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/application.o application.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	${RM} -r build/Debug
	${RM} dist/Debug/GNU-Linux-x86/opengl_backend

# Subprojects
.clean-subprojects:
