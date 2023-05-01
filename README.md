<h2>Auto-Completion Dictionary</h2>

<h4>This program provides auto-completion for words, similar to the functionality found on on-screen keyboards of mobile phones.</h4>

The program consists of two steps:

Step 1: Building the Dictionary
The program allows you to build a dictionary by adding words to it. To get started quickly, a few sample words have 
been provided: "car", "carpet", "java", "javascript", and "internet" (if you want to change them visit InitialDictionary.txt file).
You can add more words to the dictionary as needed. After starting application, you can add words, until you type "EXIT".

Step 2: Finding Auto-Completion Candidates
Once the dictionary is prepared, the program provides a function to find auto-completion candidates based on a user's query.
The function takes the query as a parameter and returns a list of matching words. To try it out, after you finish first step,
you can type a word, and program will return a list of matching words, separated by comma.

Example Usage:
Suppose the dictionary contains the following words: "car", "carpet", "java", "javascript", and "internet".

a) If the user types "c" as the query, the function should return a list with two entries: "car" and "carpet".

b) If the user types "car" as the query, the function should still return the same list of entries as above.

c) If the user types "carp" as the query, the function should return a list with one entry: "carpet".

d) If the user types "jav" as the query, the function should return a list with two entries: "java" and "javascript".

e) If the user types "intern" as the query, the function should return a list with one entry: "internet".

f) If the user types "foo" as the query, the function should return an empty list since there are no words in the
dictionary that start with "foo".

Note: The order of the entries in the returned list does not matter.

<h4>Usage Instructions:</h4>

1. Program contains some example words after starting. You can add more words to the dictionary as needed. If you finish 
type "EXIT" to finish first step.

2. Call the auto-completion function with the user's query to retrieve the matching words, by typing a word. If you want 
to exit, type "EXIT".

Please refer to the program's source code for implementation details and additional methods that may be available.

