JFLAGS = -g
JC = javac
ENTRYPOINT = TestingJFX
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
