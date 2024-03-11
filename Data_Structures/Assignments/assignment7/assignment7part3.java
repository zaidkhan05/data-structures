
public class assignment7part3 {
    public static void main(String[] args) {

    }
}

/*
Part 3 - Objective of Part 3 is to reinforce understanding of binary tree data structures.

You are going to write a program that uses a binary tree to translate morse code into characters.
You may use the Java Libraries to solve this problem. We recommend using java.util.*

Morse code is a method used in telecommunication to encode text characters as standardized sequences 
of two different signal durations, called dots and dashes, or dits and dahs, respectively. Morse Code 
refers to a system for representing letters of the alphabet, numerals, and punctuation marks by an 
arrangement of dots, dashes, and spaces, known as the Morse Code Alphabet. A picture of the alphabet is 
shown below. In telecommunication a space is designated by “time units” between characters so for our purposes, 
we will designate a space with NULL.


Program Binary Tree

Create a binary tree to establish a morse-code table, and implement encode and decode methods.

Build the binary tree, by reading from the file morse.txt.

You will encode and decode messages by searching on THAT tree. Look at the morse-code alphabet image 
below with yellow background, and the image of the binary tree (what your binary tree should look like 
when you build it). Notice how if you search LEFT on the tree it registers a dot ? Notice how
h translated to morse code moves left 4 times on the tree, therefore h is represented as 4 dots  ….

Data

For your data you need letters and a Boolean (NULL), indicating that the node is empty, since not all 
nodes encode data. Here a sequence of dots " . " and dashes " - " are used to represent morse-code. Use spaces to separate morse-code 'letters'.

Read the morse-code data from a file called morse.txt . This file contains letters (lowercase), 
a space, and the morse code. While our images all show capital letters for morse code and the binary tree, 
for simplicity you may assume that all letters are lower case only.

Class and Methods

You need to define a class, MorsecodeTree. This class should contain the following methods:

String encode method - takes a string of characters and encodes it as morse-code. Letters in 
either upper or lowercase get translated to morse, and the dot " . " and dash " - " pass through 
unchanged. Any other character is not passed to the output string. Use the space to separate individual 
morse code letters. Hint: you may want to do one that encodes one character. To accomplish all of this you need to search the tree.

String decode method - takes a string of space-separated morse-code letters and produces a string 
with the corresponding alphabetical letters. The produced string has all lowercase letters spaces 
between words. You can safely assume the input string contains only dot " . " and dash " - " and 
spaces. If the combinations of dot " . " and dash " - " for a given character is not valid, no 
corresponding character should be put on the output string. Hint: To accomplish all of this you 
need to search the tree.

Program Input / Output

Your program should allow the user to select either encode or decode message option. Then, 
the program will ask for the appropriate message string and print the appropriate corresponding 
result. The program should then return to the option to select either encode or decode messages.

If user selects option to encode a message, user enters an alphabetic string and system prints the morse-code message result.

If user selects option to decode a message, user enters a morse-code message and system prints the result translated into an alphabetic message.

Getting Started
1.	Review the Morse code alphabet and binary tree images below.

2.	Review the attached file called morse.txt which represents the letters of the alphabet that 
you will use to build your binary tree. Your program should read this data from a file to build the tree.

3.	Once you build your binary tree, it would have the form shown in the binary tree image below.
 
4.	Allow users to select a message option (encode or decode) and have your program print the translated message out to the screen.

///////////////////////////////
Morse Code Alphabet
///////////////////////////////
a .-
b -...
c -.-.
d -..
e .
f ..-.
g --.
h ....
i ..
j .---
k -.-
l .-..
m --
n -.
o ---
p .--.
q --.-
r .-.
s ...
t -
u ..-
v ...-
w .--
x -..-
y -.--
z --..
1 .----
2 ..---
3 ...--
4 ....-
5 .....
6 -....
7 --...
8 ---..
9 ----.
0 -----
///////////////////////////////
Binary Tree
///////////////////////////////
h
/ \
v s
/ \ / \

 */