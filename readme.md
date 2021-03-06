j8051
=====

What is j8051?
--------------

j8051 is an assembler/IDE for 8051 asm files, written in Java.<br>
No it can't do C. No I won't add C support. There are plenty of C compilers for 8051 out there.

It can compile and decompile to and from hex files, while showing you the steps in between to allow easy debugging.

Features
--------

- Syntax highlighting
- Intel Hex file output
- Many debug options
    - Shows all used include files
    - Shows all defined symbols (labels, equs, ...)
    - Shows preprocessed text
    - Shows parsed components (and highlights non parcelable parts)
- Direct uploading to the µC via UART (just XC888 right now)

Why?
----

Because there are no programs with a modern, not cluttered, interface that meet my needs.<br>
I need the assembler to flawlessly read files written for Rigel51, as many of the files used in my school where written with that program.<br>
And I want to be able to use a different editor to edit the file, while j8051 just does the compiling and highlights errors without interrupting my workflow.<br>
Also, I like programming. Its a hobby. So no guaranties.

Written by Dries007, student ICT - Electonics @ [Campus De Nayer](http://www.thomasmore.be/nayer)<br>
Started in nov 2014

Documentation
-------------

There will be documentation once the project nears completion.<br>
The assembler is being written to mimic the capabilities of [Reads51](http://www.rigelcorp.com/__doc/8051/reads51.pdf).

License
-------

This project it under the Modified BSD License. Read the full license [here](/LICENSE.txt).
