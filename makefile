#Author: Matthew Higgins
#makefile structure provided by swarthmore at: 
#https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html

JFLAGS = -g
JC = javac
ENTRYPOINT = ApplicationMain
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	$(ENTRYPOINT).java

default: compile

compile: $(CLASSES:.java=.class)

run: 
	java $(ENTRYPOINT)

clean:
	$(RM) *.class
