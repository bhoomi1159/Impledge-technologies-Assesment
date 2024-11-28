# Impledge-technologies-Assesment
# Approach
We can use a combination of **Dynamic Programming (DP)** and a **recursive approach** to solve this problem. 
### Steps:
1. Take Input Files,read words from the file.
2. **Sort Words**:
  Sort the words in increasing order of their lengths.Sorting helps in processing smaller words first, which is beneficial for efficiently finding compound words.

3.**Recursive Function (`compoundword`)**:
  it check whether a word can be constructed by concatenating other words from the word list.this can split word into possible prefix and suffix that 
        - Check if the prefix exists in the word set.
     - If the prefix exists, check if the suffix is either a valid word in the word set or if it can be further broken down into compound words (recursive call).
   - If both prefix and suffix are valid, mark the word as a compound word.
4. **Memoization**:dynampic programming 
   - Use memoization (storing previously computed results) to avoid redundant calculations for the same word, improving efficiency and reducing time complexity,especially for larger files.
5.  maintain two variables to check the longest and second-longest compound words found.
6. we use System.nano function for the  time calculation of this program.

By combining **sorting** and **recursive DP with memoization**, this approach handles large datasets more efficiently and ensures the program can scale for files with a large number of words.
# steps to execute the code 
1. install java development kit in your system.
2. run the solution.java files in any code editor you have ike vs code,eclipse,etc.
3. Compile and run the program:
4. you can use also online compilers of java.
