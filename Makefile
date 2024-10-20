# Exemplu de Makefile pentru soluții scrise în Java.

.PHONY: build clean

build: P1.class P2.class P3.class P4.class

# Nu compilați aici, nici măcar ca dependențe de reguli.
run-p1:
	java Numarare
run-p2:
	java Trenuri
run-p3:
	java Drumuri
run-p4:
	java -Xss2m Scandal

# Schimbați numele surselor și ale binarelor (peste tot).
P1.class: Numarare.java
	javac $^
P2.class: Trenuri.java
	javac $^
P3.class: Drumuri.java
	javac $^
P4.class: Scandal.java
	javac $^

# Vom șterge fișierele bytecode compilate.
clean:
	rm -f *.class
